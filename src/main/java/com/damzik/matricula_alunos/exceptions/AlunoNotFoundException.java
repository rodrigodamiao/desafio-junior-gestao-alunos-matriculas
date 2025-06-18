package com.damzik.matricula_alunos.exceptions;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(Long id) {
        super(String.format("Aluno com o id %d não encontrado.", id));
    }
}
