package cz.ivosahlik;

import cz.ivosahlik.api.AresEkonomickeSubjektyResApi;
import cz.ivosahlik.service.AresEkonomickeSubjektyResService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "feature.ares.enabled=false")
class AresEkonomickeSubjektyResTest {

    @Autowired(required = false)
    private AresEkonomickeSubjektyResApi aresEkonomickeSubjektyResApi;

    @Autowired(required = false)
    private AresEkonomickeSubjektyResService aresEkonomickeSubjektyResService;

    @Test
    @DisplayName("Ares module GIVEN ares disabled flag SHOULD not configure Ares beans")
    void disabled() {
        assertNull(aresEkonomickeSubjektyResApi);
        assertNull(aresEkonomickeSubjektyResService);
    }
}

