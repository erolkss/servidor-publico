package br.com.ero.servidopublico.service;

import br.com.ero.servidopublico.model.ServidorPublico;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class ServidorPublicoServiceImpl implements ServidorPublicoService {

    private final String SERVIDOR = "/data/servidorpublico.json";

    @Override
    public List<ServidorPublico> listAll() {
        try {
            TypeReference<List<ServidorPublico>> typeReference =
                    new TypeReference<List<ServidorPublico>>() {
                    };

            InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);

            List<ServidorPublico> servidoresPublicos = new ObjectMapper().readValue(inputStream, typeReference);

            return servidoresPublicos;
        } catch (Exception ex) {
            System.out.println("Exception " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Optional<ServidorPublico> listByMatricula(long matricula) {
        try {
            TypeReference<List<ServidorPublico>> typeReference =
                    new TypeReference<List<ServidorPublico>>() {
                    };

            InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);

            List<ServidorPublico> servidoresPublicos = new ObjectMapper().readValue(inputStream, typeReference);

            Optional<ServidorPublico> servidorEncontrado = servidoresPublicos.stream().filter(
                    servidor -> servidor.matricula().equals(matricula)).findFirst();

            return servidorEncontrado;

        } catch (Exception ex) {
            System.out.println("Exception " + ex.getMessage());
            return null;
        }
    }
}
