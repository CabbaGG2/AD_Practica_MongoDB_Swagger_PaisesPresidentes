package org.example;

import org.example.model.Pais;
import org.example.model.Presidente;
import org.example.service.PaisService;
import org.example.service.PresidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Secuencia {

    @Autowired
    PresidenteService presidenteService;

    @Autowired
    PaisService paisService;

    public void practicaSolucion() {


        //----------PRESIDENTE -----------------------------
        //Deserializar un presidente desde un archivo JSON

        Presidente presidente;

        presidente = presidenteService.deserializarPresidente("presidente2.json");
        System.out.println("Presidente deserializado: " + presidente.getNombre());

        //Guardar el presidente deserializado en la base de datos
        presidenteService.crearPresidente(presidente);
        System.out.println("Presidente guardado en la base de datos: " + presidente.getNombre());

        //Buscar el presidente por su ID
        Presidente presidenteBuscado = presidenteService.buscarPresidente(presidente.getId());
        System.out.println("Presidente buscado: " + presidenteBuscado.getNombre());

        //elimincar el presidente
        presidenteService.eliminarPresidente(presidente.getId());
        System.out.println("Presidente eliminado: " + presidente.getNombre());

        //----------------PAISES-----------------------------

        Pais pais;

        pais = paisService.deserializarPais("pais2.json");
        System.out.println("Pais deserializado: " + pais.getNombre());

        //Guardar el pais deserializado en la base de datos
        paisService.crearPais(pais);
        System.out.println("Pais guardado en la base de datos: " + pais.getNombre());

        //Buscar el pais por su ID
        Pais paisBuscado = paisService.buscarPais(pais.getId());
        System.out.println("Pais buscado: " + paisBuscado.getNombre());

        //elimincar el pais
        paisService.eliminarPais(pais.getId());
        System.out.println("Pais eliminado: " + pais.getNombre());


    }

}
