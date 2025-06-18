package com.damzik.matricula_alunos.repositories;

import com.damzik.matricula_alunos.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    boolean existsByCodigoMatricula(String codigoMatricula);
}
