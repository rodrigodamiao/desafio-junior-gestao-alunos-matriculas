package com.damzik.matricula_alunos.repositories;

import com.damzik.matricula_alunos.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
