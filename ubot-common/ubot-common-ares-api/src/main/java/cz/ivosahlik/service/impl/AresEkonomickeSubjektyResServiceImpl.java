package cz.ivosahlik.service.impl;

import cz.ivosahlik.api.AresEkonomickeSubjektyResApi;
import cz.ivosahlik.model.AresEkonomickySubjektRes;
import cz.ivosahlik.service.AresEkonomickeSubjektyResService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AresEkonomickeSubjektyResServiceImpl implements AresEkonomickeSubjektyResService {

    private final AresEkonomickeSubjektyResApi aresEkonomickeSubjektyResApi;

    @Override
    public AresEkonomickySubjektRes vratEkonomickySubjektRes(String ico) {
        return aresEkonomickeSubjektyResApi.vratEkonomickySubjektRes(ico);
    }

}
