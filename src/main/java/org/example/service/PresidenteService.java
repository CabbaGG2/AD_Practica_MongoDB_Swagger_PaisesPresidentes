package org.example.service;

import org.example.model.Presidente;
import org.example.repository.PresidenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresidenteService {

    private final PresidenteRepository presidenteRepo;

    public PresidenteService(PresidenteRepository presidenteRepo) {
        this.presidenteRepo = presidenteRepo;
    }

    public void crearPresidente(Presidente p) {
        presidenteRepo.save(p);
    }

    public Presidente buscarPresidente(String id) {
        return presidenteRepo.findById(id).orElse(null);
    }

    //buscamos todos los presidentes

    public List<Presidente> buscarPresidentes() {
        return presidenteRepo.findAll();
    }

    public void eliminarPresidente(String id)  {
        presidenteRepo.deleteById(id);
    }

    public void actualizarPresidente(Presidente p) {
        presidenteRepo.save(p);
    }


}
