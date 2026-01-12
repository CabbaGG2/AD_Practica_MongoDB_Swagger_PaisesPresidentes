package org.example;


import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan({"org.example"})
public class Main {

    private final Secuencia secuencia;

    public Main(Secuencia secuencia) {
        this.secuencia = secuencia;
    }

    @PostConstruct
    public void practicaSolucion() {
        secuencia.practicaSolucion();
        System.exit(500);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}