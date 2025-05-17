package br.com.odontoprev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class OdontoprevApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdontoprevApplication.class, args);
        // Tenta abrir o navegador na URL do Swagger
    }

}
