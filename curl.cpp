#include <iostream>
#include <curl/curl.h>

// 콜백 함수 선언
size_t WriteCallback(void* contents, size_t size, size_t nmemb, std::string* output) {
    size_t total_size = size * nmemb;
    output->append((char*)contents, total_size);
    return total_size;
}

int main() {
    // libcurl 초기화
    CURL* curl;
    CURLcode res;
    curl_global_init(CURL_GLOBAL_DEFAULT);
    curl = curl_easy_init();

    if(curl) {
        const char* url = "http://localhost:8080/upload";
        const char* filepath = "/Users/sonchanho/CLionProjects/curl/file.txt";

        FILE* file = fopen(filepath, "rb");
        if (!file) {
            std::cerr << "Could not open file: " << filepath << std::endl;
            return 1;
        }

        curl_easy_setopt(curl, CURLOPT_URL, url);
        curl_easy_setopt(curl, CURLOPT_POST, 1L);

        curl_mime* mime = curl_mime_init(curl);

        curl_mimepart* part = curl_mime_addpart(mime);
        curl_mime_name(part, "file");
        curl_mime_filedata(part, filepath);

        std::string response;

        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, WriteCallback);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);
        curl_easy_setopt(curl, CURLOPT_MIMEPOST, mime);

        // 전송 실행
        res = curl_easy_perform(curl);

        curl_easy_cleanup(curl);
        curl_mime_free(mime);
        fclose(file);
        curl_global_cleanup();

        // 결과 확인
        if (res != CURLE_OK) {
            std::cerr << "curl_easy_perform() failed: " << curl_easy_strerror(res) << std::endl;
            return 1;
        }

        std::cout << "Server Response: " << response << std::endl;

        return 0;
    }

    return 1;
}
