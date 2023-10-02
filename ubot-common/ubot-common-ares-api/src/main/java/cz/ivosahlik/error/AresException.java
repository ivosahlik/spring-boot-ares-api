package cz.ivosahlik.error;

import cz.ivosahlik.model.AresChyba;
import lombok.Getter;

@Getter
public class AresException extends RuntimeException {

    private final transient AresChyba aresChyba;

    public AresException(AresChyba aresChyba, Throwable cause) {
        super("Ares request returned an error", cause);
        this.aresChyba = aresChyba;
    }
}
