package io.swagger.api.shared.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class RestWebClient {
    private final HttpRequest.Builder request;

    public RestWebClient() {
        this.request = HttpRequest.newBuilder();
    }

    public RestWebClient uri(String uri) {
        request.uri(URI.create(uri));
        return this;
    }

    public RestWebClient headers(Map<String, String> headers) {
        for ( Map.Entry<String, String> header : headers.entrySet()) {
            request.header(header.getKey(), header.getValue());
        }
        return this;
    }

    public RestWebClient get() {
        request.method("GET", HttpRequest.BodyPublishers.noBody());
        return this;
    }

    public RestWebClient post(String body) {
        request.method("POST", HttpRequest.BodyPublishers.ofString(body));
        return this;
    }

    @SneakyThrows
    public HttpResponse<String> retrieve(){
        return HttpClient.newHttpClient().send(this.request.build(), HttpResponse.BodyHandlers.ofString());
    }
}
