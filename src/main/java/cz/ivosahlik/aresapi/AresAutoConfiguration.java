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
    public AresEkonomickeSubjektyApi aresEkonomickySubjektApi(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .build();

        return new AresEkonomickeSubjektyApi(new ApiClient(restTemplate, aresServerUrl));
    }

    @Bean
    public AresEkonomickeSubjektyResApi aresEkonomickySubjektResApi(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .build();

        return new AresEkonomickeSubjektyResApi(new ApiClient(restTemplate, aresServerUrl));
    }
}
