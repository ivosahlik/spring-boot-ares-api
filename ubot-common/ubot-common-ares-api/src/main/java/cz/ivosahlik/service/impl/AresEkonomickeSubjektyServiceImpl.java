package cz.ivosahlik.service.impl;

import cz.ivosahlik.api.AresEkonomickeSubjektyApi;
import cz.ivosahlik.model.AresEkonomickySubjekt;
import cz.ivosahlik.service.AresEkonomickeSubjektyService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AresEkonomickeSubjektyServiceImpl implements AresEkonomickeSubjektyService {

    private final AresEkonomickeSubjektyApi aresEkonomickeSubjektyApi;

    @Override
    public AresEkonomickySubjekt vratEkonomickySubjekt(String ico) {
        return aresEkonomickeSubjektyApi.vratEkonomickySubjekt(ico);
    }

}
