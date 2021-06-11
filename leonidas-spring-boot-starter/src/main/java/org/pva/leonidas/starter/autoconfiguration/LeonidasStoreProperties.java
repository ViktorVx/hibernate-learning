package org.pva.leonidas.starter.autoconfiguration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "leonidas.bh.starter")
@Getter
@Setter
public class LeonidasStoreProperties {
    private String host;
    private String port;
}
