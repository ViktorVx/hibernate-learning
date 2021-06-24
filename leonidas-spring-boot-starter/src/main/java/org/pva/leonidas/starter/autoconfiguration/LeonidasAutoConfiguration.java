package org.pva.leonidas.starter.autoconfiguration;

import lombok.AllArgsConstructor;
import org.pva.leonidas.service.LeonidasBhService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(LeonidasStoreProperties.class)
@AllArgsConstructor
public class LeonidasAutoConfiguration {

    @Bean
    public LeonidasBhService leonidasBhService(WebClient webClient) {
        return new LeonidasBhService(webClient);
    }

    @Bean
    public WebClient webClient(LeonidasStoreProperties leonidasStoreProperties) {
        return WebClient.builder()
                .baseUrl(String.format("http://%s:%s", leonidasStoreProperties.getHost(), leonidasStoreProperties.getPort()))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
