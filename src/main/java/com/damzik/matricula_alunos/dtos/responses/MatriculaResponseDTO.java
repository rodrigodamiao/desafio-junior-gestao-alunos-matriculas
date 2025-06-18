package com.damzik.matricula_alunos.dtos.responses;

import com.damzik.matricula_alunos.entities.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MatriculaResponseDTO {
    private Long matriculaId;
    private String codigoMatricula;
    private String nomeCurso;
    private LocalDate dataInicio;
    private Long alunoId;

    public MatriculaResponseDTO(Matricula matricula){
        this.matriculaId = matricula.getId();
        this.codigoMatricula = matricula.getCodigoMatricula();
        this.nomeCurso = matricula.getNomeCurso();
        this.dataInicio = matricula.getDataInicio();
        this.alunoId = matricula.getAluno().getId();
    }
}
