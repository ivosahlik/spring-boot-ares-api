package cz.ivosahlik.aresapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@ConditionalOnExpression("${feature.ares.enabled:true}")
@Configuration
public class AresAutoConfiguration {

    @Value("${ares.server:}")
    private String aresServerUrl;

    @Bean
    public AresEkonomickySubjektApi aresEkonomickySubjektApi(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .build();

        return new AresEkonomickySubjektApi(new ApiClient(restTemplate, aresServerUrl));
    }

    @Bean
    public AresEkonomickySubjektResApi aresEkonomickySubjektResApi(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .build();

        return new AresEkonomickySubjektResApi(new ApiClient(restTemplate, aresServerUrl));
    }
}
