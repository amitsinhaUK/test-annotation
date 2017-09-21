package org.amitsinha; /**
 * Created by amit_sinha on 04/07/2017.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by amit_sinha on 20/06/2017.
 */
@SpringBootApplication
public class Application {
    public Application() {
        super();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
