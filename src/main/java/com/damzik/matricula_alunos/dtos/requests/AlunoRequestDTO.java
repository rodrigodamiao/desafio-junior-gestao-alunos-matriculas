package com.damzik.matricula_alunos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AlunoRequestDTO {
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
}
