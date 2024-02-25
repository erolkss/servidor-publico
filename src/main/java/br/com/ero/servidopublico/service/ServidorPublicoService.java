package br.com.ero.servidopublico.service;

import br.com.ero.servidopublico.model.ServidorPublico;

import java.util.List;
import java.util.Optional;

public interface ServidorPublicoService {
    List<ServidorPublico> listAll();
    Optional<ServidorPublico> listByMatricula(long matricula);
}
