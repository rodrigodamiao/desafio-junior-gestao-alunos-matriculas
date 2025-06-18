package com.damzik.matricula_alunos.dtos.responses;


import com.damzik.matricula_alunos.entities.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class AlunoResponseDTO {
    private Long id;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private List<MatriculaResponseDTO> matriculas;

    public AlunoResponseDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.telefone = aluno.getTelefone();
        this.dataNascimento = aluno.getDataNascimento();
        this.matriculas = aluno.getMatriculas()
                .stream()
                .map(MatriculaResponseDTO::new)
                .collect(Collectors.toList());
    }
}
