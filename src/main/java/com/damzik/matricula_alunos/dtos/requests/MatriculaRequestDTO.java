package com.damzik.matricula_alunos.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MatriculaRequestDTO {

    @NotNull(message = "O ID do aluno é obrigatório")
    private Long alunoId;

    @NotBlank(message = "O nome do curso é obrigatório")
    private String nomeCurso;

    @NotNull(message = "A data de início é obrigatória")
    private LocalDate dataInicio;
}
