package org.pva.leonidas.starter.autoconfiguration;

import lombok.AllArgsConstructor;
import org.pva.leonidas.starter.service.LeonidasBhService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LeonidasStoreProperties.class)
@AllArgsConstructor
public class LeonidasAutoConfiguration {

    private final LeonidasStoreProperties leonidasStoreProperties;

    @Bean
    public LeonidasBhService leonidasBhService(LeonidasStoreProperties leonidasStoreProperties) {
        return new LeonidasBhService(leonidasStoreProperties);
    }
}
