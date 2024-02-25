package br.com.ero.servidopublico.model;

public record ServidorPublico(
        long matricula,
        String nome,
        String foto,
        String orgao,
        String vinculo,
        String cargo,
        String lotacao,
        String servico,
        String email,
        String telefone,
        String celular,
        String cpf,
        String naturalidade
) {
}
