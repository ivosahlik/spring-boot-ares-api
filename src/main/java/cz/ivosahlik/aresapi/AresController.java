package cz.ivosahlik.aresapi;

import cz.ivosahlik.robotization.aresapi.model.AresEkonomickySubjekt;
import cz.ivosahlik.robotization.aresapi.model.AresEkonomickySubjektRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AresController {
    private static final String REQUEST_ATTRIBUTE_ICO = "ico";

    private final AresService aresService;

//    http://localhost:8082/v1/ares-ekonomicke-subjekty?ico=XXXXXXXX
    @GetMapping("/v1/ares-ekonomicke-subjekt")
    public ResponseEntity<AresEkonomickySubjekt> getAresEkonomickySubjekt(
            @RequestParam(name = REQUEST_ATTRIBUTE_ICO, required = false) String ico) {
        AresEkonomickySubjekt response = aresService.vratEkonomickySubjekt(ico);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //    http://localhost:8082/v1/ares-ekonomicke-subjekty-res?ico=XXXXXXXX
    @GetMapping("/v1/ares-ekonomicke-subjekty-res")
    public ResponseEntity<AresEkonomickySubjektRes> getAresEkonomickySubjektRes(
            @RequestParam(name = REQUEST_ATTRIBUTE_ICO, required = false) String ico) {
        AresEkonomickySubjektRes response = aresService.vratEkonomickySubjektRes(ico);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
