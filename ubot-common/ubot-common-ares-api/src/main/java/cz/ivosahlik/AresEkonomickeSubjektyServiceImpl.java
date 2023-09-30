package cz.ivosahlik;

import cz.ivosahlik.model.AresEkonomickySubjekt;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AresEkonomickeSubjektyServiceImpl implements AresEkonomickeSubjektyService {

    private final AresEkonomickeSubjektyApi aresEkonomickeSubjektyApi;

    @Override
    public AresEkonomickySubjekt vratEkonomickySubjekt(String ico) {
        return aresEkonomickeSubjektyApi.vratEkonomickySubjekt(ico);
    }

}
