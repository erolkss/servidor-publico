package br.com.ero.servidopublico;

import br.com.ero.servidopublico.model.ServidorPublico;
import br.com.ero.servidopublico.service.ServidorPublicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Configuration
public class ServidorpublicoApplicationRunner implements CommandLineRunner {
    private ServidorPublicoService servidorPublicoService;

    @Autowired
    public void setServidorPublicoService(ServidorPublicoService servidorPublicoService) {
        this.servidorPublicoService = servidorPublicoService;
    }

    public void listAll() {
        List<ServidorPublico> servidoresPublicos = servidorPublicoService.listAll();
        if (servidoresPublicos.size() != 0) {
            System.out.println("########################################");
            servidoresPublicos.forEach(
                    servidor -> {
                        System.out.println(servidor.matricula());
                        System.out.println(servidor.nome());
                        System.out.println(servidor.foto());
                        System.out.println(servidor.orgao());
                    }
            );
        } else {
            System.out.println("Arquivo JSON vazio");
        }
    }

    public void listByMatricula() {
        long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a Matrícula"));
        Optional<ServidorPublico> servidorPublicoEncontrado = servidorPublicoService.listByMatricula(matricula);

        if (servidorPublicoEncontrado.isPresent()) {
            System.out.println("########################################");
            System.out.println(servidorPublicoEncontrado.get().matricula());
            System.out.println(servidorPublicoEncontrado.get().nome());
            System.out.println(servidorPublicoEncontrado.get().foto());
            System.out.println(servidorPublicoEncontrado.get().orgao());
        } else {
            System.out.println("Não existe o servidor público com a matrícula informada.");
        }
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
