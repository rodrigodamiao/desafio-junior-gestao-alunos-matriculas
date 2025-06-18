package com.damzik.matricula_alunos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MatriculaRequestDTO {
    private Long alunoId;
    private String nomeCurso;
    private LocalDate dataInicio;
}
