package org.example.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.model.Presidente;
import org.example.service.PresidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(RestPresidente.MAPPING)
@Tag(name = "Presidente", description = "Operaciones relacionadas con los presidentes")
public class RestPresidente {

    public static final String MAPPING = "/mongodb/presidente";

    @Autowired
    private PresidenteService presidenteService;

    @PostMapping("/guardar")
    public ResponseEntity<Presidente> guardar(@RequestBody Presidente presidente) {
        presidenteService.crearPresidente(presidente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Presidente> buscar(@PathVariable String id) {
        Presidente presidente = presidenteService.buscarPresidente(id);
        if (presidente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(presidente);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Presidente>> listarColeccion() {
        List<Presidente> presidentes = presidenteService.buscarPresidentes();
        return new ResponseEntity<>(presidentes, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Presidente> eliminar(@PathVariable String id) {
        presidenteService.eliminarPresidente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @JsonDeserialize
    @GetMapping("/deserializar")
    public ResponseEntity<Presidente> deserializar() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Presidente presidente = mapper.readValue(new File("presidente.json"), Presidente.class);
        presidenteService.crearPresidente(presidente);
        return ResponseEntity.ok(presidente);
    }
}
