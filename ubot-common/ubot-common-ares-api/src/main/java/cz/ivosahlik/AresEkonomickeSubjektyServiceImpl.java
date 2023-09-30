package cz.ivosahlik;

import cz.ivosahlik.model.AresEkonomickySubjekt;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AresEkonomickeSubjektyServiceImpl implements AresEkonomickeSubjektyService {

    private final AresEkonomickeSubjektyApi aresEkonomickeSubjektyApi;

//    private final AresEkonomickeSubjektyResApi aresEkonomickeSubjektyResApi;

    @Override
    public AresEkonomickySubjekt vratEkonomickySubjekt(String ico) {
        return aresEkonomickeSubjektyApi.vratEkonomickySubjekt(ico);
    }

//    @Override
//    public AresEkonomickySubjektRes vratEkonomickySubjektRes(String ico) {
//        return aresEkonomickeSubjektyResApi.vratEkonomickySubjektRes(ico);
//    }
}
