package com.abctreinamentos.servidorpublico.controller;

import com.abctreinamentos.servidorpublico.model.ServidorPublico;
import com.abctreinamentos.servidorpublico.service.ServidorPublicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ServidorPublicoController {

    private ServidorPublicoService servidorPublicoService;

    @Autowired
    public void setServidorPublicoService(ServidorPublicoService servidorPublicoService) {
        this.servidorPublicoService = servidorPublicoService;
    }

    @GetMapping("/listAll")
    public List<ServidorPublico> listAll() {
        List<ServidorPublico> servidoresPublicos = servidorPublicoService.listAll();
        return servidoresPublicos;

    }

    @GetMapping("/list/{matricula}")
    public ServidorPublico listByMatricula(@PathVariable Long matricula){
        Optional<ServidorPublico> servidorEncontrado = servidorPublicoService.listByMatricula(matricula);
        return servidorEncontrado.get();
    }

}
