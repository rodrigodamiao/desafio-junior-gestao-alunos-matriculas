package com.damzik.matricula_alunos.dtos.responses;


import com.damzik.matricula_alunos.entities.Aluno;
import com.damzik.matricula_alunos.entities.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class AlunoResponseDTO {
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;

    public AlunoResponseDTO(Aluno aluno) {
        this.nome = aluno.getNome();
        this.telefone = aluno.getTelefone();
        this.dataNascimento = aluno.getDataNascimento();
    }
}
