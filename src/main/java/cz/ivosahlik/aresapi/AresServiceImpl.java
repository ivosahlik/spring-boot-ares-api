package cz.ivosahlik.aresapi;

import cz.ivosahlik.robotization.aresapi.model.AresEkonomickySubjekt;
import cz.ivosahlik.robotization.aresapi.model.AresEkonomickySubjektRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AresServiceImpl implements AresService {

    private final AresEkonomickeSubjektyApi aresEkonomickeSubjektyApi;

    private final AresEkonomickeSubjektyResApi aresEkonomickeSubjektyResApi;

    @Override
    public AresEkonomickySubjekt vratEkonomickySubjekt(String ico) {
        return aresEkonomickeSubjektyApi.vratEkonomickySubjekt(ico);
    }

    @Override
    public AresEkonomickySubjektRes vratEkonomickySubjektRes(String ico) {
        return aresEkonomickeSubjektyResApi.vratEkonomickySubjektRes(ico);
    }
}
