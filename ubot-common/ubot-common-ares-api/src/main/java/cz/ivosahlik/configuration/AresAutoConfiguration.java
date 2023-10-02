package cz.ivosahlik.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.ivosahlik.api.AresEkonomickeSubjektyApi;
import cz.ivosahlik.api.AresEkonomickeSubjektyResApi;
import cz.ivosahlik.client.ApiClient;
import cz.ivosahlik.error.AresErrorHandler;
import cz.ivosahlik.service.AresEkonomickeSubjektyResService;
import cz.ivosahlik.service.AresEkonomickeSubjektyService;
import cz.ivosahlik.service.impl.AresEkonomickeSubjektyResServiceImpl;
import cz.ivosahlik.service.impl.AresEkonomickeSubjektyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Slf4j
@ConditionalOnExpression("${feature.ares.enabled:true}")
@Configuration
public class AresAutoConfiguration {

    @Value("${ares.server:}")
    private String aresServerUrl;

    @Value("${ares.ip.proxy.host:#{null}}")
    protected String proxyUrl;

    @Value("${ares.ip.proxy.port:#{null}}")
    protected Integer proxyPort;

    private RestTemplate restTemplate;

    @Bean
    public AresEkonomickeSubjektyApi aresEkonomickySubjektApi(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        extracted(restTemplateBuilder, objectMapper);
        return new AresEkonomickeSubjektyApi(new ApiClient(restTemplate, aresServerUrl));
    }

    @Bean
    public AresEkonomickeSubjektyResApi aresEkonomickySubjektResApi(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        extracted(restTemplateBuilder, objectMapper);
        return new AresEkonomickeSubjektyResApi(new ApiClient(restTemplate, aresServerUrl));
    }

    @Bean
    public AresEkonomickeSubjektyService aresEkonomickeSubjektyService(AresEkonomickeSubjektyApi aresEkonomickeSubjektyApi) {
        return new AresEkonomickeSubjektyServiceImpl(aresEkonomickeSubjektyApi);
    }

    @Bean
    public AresEkonomickeSubjektyResService aresEkonomickeSubjektyResService(AresEkonomickeSubjektyResApi aresEkonomickeSubjektyResApi) {
        return new AresEkonomickeSubjektyResServiceImpl(aresEkonomickeSubjektyResApi);
    }

    private SimpleClientHttpRequestFactory getSimpleClientHttpRequestFactory() {
        var requestFactory = new SimpleClientHttpRequestFactory();
        var proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyUrl, proxyPort));
        requestFactory.setProxy(proxy);
        return requestFactory;
    }

    private void extracted(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        if (proxyUrl != null && proxyPort != null) {
            restTemplate = restTemplateBuilder
                    .requestFactory(this::getSimpleClientHttpRequestFactory)
                    .errorHandler(new AresErrorHandler(objectMapper))
                    .build();
        } else {
            restTemplate = restTemplateBuilder
                    .errorHandler(new AresErrorHandler(objectMapper))
                    .build();
        }
    }
}
