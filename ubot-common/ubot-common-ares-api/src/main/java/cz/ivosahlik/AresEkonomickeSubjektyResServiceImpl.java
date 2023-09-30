package cz.ivosahlik;

import cz.ivosahlik.model.AresEkonomickySubjektRes;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AresEkonomickeSubjektyResServiceImpl implements AresEkonomickeSubjektyResService {

    private final AresEkonomickeSubjektyResApi aresEkonomickeSubjektyResApi;

    @Override
    public AresEkonomickySubjektRes vratEkonomickySubjektRes(String ico) {
        return aresEkonomickeSubjektyResApi.vratEkonomickySubjektRes(ico);
    }

}
