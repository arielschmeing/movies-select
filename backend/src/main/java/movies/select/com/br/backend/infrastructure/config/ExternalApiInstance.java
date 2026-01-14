package movies.select.com.br.backend.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ExternalApiInstance {

    @Value("${external-api-token}")
    private String token;

    @Value("${external-api-url}")
    private String url;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .defaultHeaders(headers -> {
                    headers.setBearerAuth(this.token);
                })
                .baseUrl(this.url)
                .build();
    }
}
