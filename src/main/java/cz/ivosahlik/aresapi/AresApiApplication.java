package cz.ivosahlik.aresapi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class AresApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AresApiApplication.class, args);
    }

}
