package cz.ivosahlik.aresapi;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNull;

@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "feature.ares.enabled=false")
class AresDisabledTest {

    @Autowired(required = false)
    private AresEkonomickeSubjektyApi aresEkonomickeSubjektyApi;

    @Autowired(required = false)
    private AresService aresService;

    @Test
    @DisplayName("ares-api module GIVEN ares disabled flag SHOULD not configure Ares beans")
    void disabled() {
        assertNull(aresEkonomickeSubjektyApi);
        assertNull(aresService);
    }
}

