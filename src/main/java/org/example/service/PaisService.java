package org.example.service;

import org.example.model.Pais;
import org.example.repository.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    private final PaisRepository paisRepo;

    public PaisService(PaisRepository paisRepo) {
        this.paisRepo = paisRepo;
    }

    public void crearPais(Pais p) {
        paisRepo.save(p);
    }

    public Pais buscarPais(String id) {
        return paisRepo.findById(id).orElse(null);
    }

    //buscamos todos los paises

    public List<Pais> buscarPaises() {
        return paisRepo.findAll();
    }

    public void eliminarPais(String id)  {
        paisRepo.deleteById(id);
    }

    public void actualizarPais(Pais p) {
        paisRepo.save(p);
    }

}
