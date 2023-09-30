package cz.ivosahlik.controller;

import cz.ivosahlik.model.AresEkonomickySubjekt;
import cz.ivosahlik.model.AresEkonomickySubjektRes;
import cz.ivosahlik.service.AresEkonomickeSubjektyResService;
import cz.ivosahlik.service.AresEkonomickeSubjektyService;
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

    private final AresEkonomickeSubjektyService aresEkonomickeSubjektyService;
    private final AresEkonomickeSubjektyResService aresEkonomickeSubjektyResService;

    //    http://localhost:8082/v1/ares-ekonomicky-subjekty?ico=XXXXXXXX
    @GetMapping("/v1/ares-ekonomicky-subjekty")
    public ResponseEntity<AresEkonomickySubjekt> getAresEkonomickySubjekt(
            @RequestParam(name = REQUEST_ATTRIBUTE_ICO, required = false) String ico) {
        AresEkonomickySubjekt response = aresEkonomickeSubjektyService.vratEkonomickySubjekt(ico);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //    http://localhost:8082/v1/ares-ekonomicke-subjekty-res?ico=XXXXXXXX
    @GetMapping("/v1/ares-ekonomicke-subjekty-res")
    public ResponseEntity<AresEkonomickySubjektRes> getAresEkonomickySubjektRes(
            @RequestParam(name = REQUEST_ATTRIBUTE_ICO, required = false) String ico) {
        AresEkonomickySubjektRes response = aresEkonomickeSubjektyResService.vratEkonomickySubjektRes(ico);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
