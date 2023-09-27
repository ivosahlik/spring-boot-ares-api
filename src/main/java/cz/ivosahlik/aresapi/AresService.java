package cz.ivosahlik.aresapi;

import cz.ivosahlik.robotization.aresapi.model.AresEkonomickySubjekt;
import cz.ivosahlik.robotization.aresapi.model.AresEkonomickySubjektRes;

public interface AresService {

    AresEkonomickySubjekt vratEkonomickySubjekt(String ico);

    AresEkonomickySubjektRes vratEkonomickySubjektRes(String ico);

}
