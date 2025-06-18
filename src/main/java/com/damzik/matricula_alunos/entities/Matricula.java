package com.damzik.matricula_alunos.entities;

import com.damzik.matricula_alunos.dtos.requests.MatriculaRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoMatricula;
    private String nomeCurso;
    private LocalDate dataInicio;
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Matricula(MatriculaRequestDTO matriculaRequestDTO) {
        this.nomeCurso = matriculaRequestDTO.getNomeCurso();
        this.dataInicio = matriculaRequestDTO.getDataInicio();
    }
}
