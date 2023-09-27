package cz.ivosahlik.aresapi;

import cz.ivosahlik.robotization.aresapi.model.AresEkonomickySubjekt;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Disabled
@ExtendWith(MockitoExtension.class)
class AresServiceUnitTest {

    @Mock
    private AresEkonomickeSubjektyApi aresEkonomickeSubjektyApi;

    @InjectMocks
    private AresServiceImpl aresEkonomickySubjektService;

    @Test
    @DisplayName("vratEkonomickySubjekt() GIVEN ico param SHOULD return AresEkonomickySubjekt")
    void vratEkonomickySubjekt() {
        aresEkonomickySubjektService.vratEkonomickySubjekt("08990042");
        Mockito.verify(aresEkonomickeSubjektyApi).vratEkonomickySubjekt(Mockito.eq(new AresEkonomickySubjekt().getIco()));
    }

}