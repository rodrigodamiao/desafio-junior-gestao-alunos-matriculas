package com.damzik.matricula_alunos.exceptions;

public class MatriculaNotFoundException extends RuntimeException {
    public MatriculaNotFoundException(Long id) {
        super(String.format("Matrícula com o id %d não encontrada.", id));
    }
}
