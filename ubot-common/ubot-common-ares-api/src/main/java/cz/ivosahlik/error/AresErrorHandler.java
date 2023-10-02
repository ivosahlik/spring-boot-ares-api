package cz.ivosahlik.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.ivosahlik.model.AresChyba;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientResponseException;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class AresErrorHandler extends DefaultResponseErrorHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        try {
            super.handleError(response);
        } catch (RestClientResponseException restClientResponseException) {
            var aresChyba = tryDeserializeError(restClientResponseException.getResponseBodyAsByteArray());
            if (aresChyba == null) {
                throw restClientResponseException;
            } else {
                log.error("Ares error response - {}, {}",
                        aresChyba.getKod(),
                        aresChyba.getPopis());
                throw new AresException(aresChyba, restClientResponseException);
            }
        }
    }

    private AresChyba tryDeserializeError(byte[] errorBody) {
        try {
            var aresChyba = objectMapper.readValue(errorBody, AresChyba.class);
            if (aresChyba.getKod() == null) {
                log.trace("Ares error response is empty. {}", aresChyba);
                return null;
            } else {
                return aresChyba;
            }
        } catch (IOException e) {
            log.trace("Failed to deserialize error body", e);
            return null;
        }
    }
}
