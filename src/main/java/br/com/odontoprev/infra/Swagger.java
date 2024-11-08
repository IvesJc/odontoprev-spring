package br.com.odontoprev.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().
                info(new Info().
                        title("OdontoPrev - Adaptive Dialogs").
                        version("v1").
                        description("RESTful API with Java and Spring Boot 3").
                        license(new License().
                                name("OdontoPrev").
                                url("https://www.odontoprev.com.br/")));
    }
}
