package org.example.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.model.Pais;
import org.example.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(RestPais.MAPPING)
@Tag(name = "Pais", description = "API REST para la gestión de paises")
public class RestPais {

    public static final String MAPPING = "/mongodb/pais";

    @Autowired
    private PaisService paisService;

    @PostMapping("/guardar")
    public ResponseEntity<Pais> guardar(@RequestBody Pais pais) {
        paisService.crearPais(pais);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pais> buscar(@PathVariable String id) {
        Pais pais = paisService.buscarPais(id);
        if (pais == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pais);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Pais>> listarColeccion() {
        List<Pais> paises = paisService.buscarPaises();
        return new ResponseEntity<>(paises, HttpStatus.OK);
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<Pais> actualizar(@RequestBody Pais pais) {
        paisService.actualizarPais(pais);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Pais> eliminar(@PathVariable String id) {
        paisService.eliminarPais(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @JsonDeserialize
    @GetMapping("/deserializar")
    public ResponseEntity<Pais> deserializar() throws IOException {
        // Lógica de deserialización aquí
        ObjectMapper mapper = new ObjectMapper();
        Pais pais = mapper.readValue(new File("pais.json"), Pais.class);
        paisService.crearPais(pais);
        return ResponseEntity.ok(pais);
    }

}
