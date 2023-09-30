package cz.ivosahlik;

import cz.ivosahlik.api.AresEkonomickeSubjektyApi;
import cz.ivosahlik.service.AresEkonomickeSubjektyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "feature.ares.enabled=false")
class AresEkonomickeSubjektyTest {

    @Autowired(required = false)
    private AresEkonomickeSubjektyApi aresEkonomickeSubjektyApi;

    @Autowired(required = false)
    private AresEkonomickeSubjektyService aresEkonomickeSubjektyService;

    @Test
    @DisplayName("Ares module GIVEN ares disabled flag SHOULD not configure Ares beans")
    void disabled() {
        assertNull(aresEkonomickeSubjektyApi);
        assertNull(aresEkonomickeSubjektyService);
    }
}

