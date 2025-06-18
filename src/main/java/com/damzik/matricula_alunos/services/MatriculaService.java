package com.damzik.matricula_alunos.services;

import com.damzik.matricula_alunos.dtos.requests.MatriculaRequestDTO;
import com.damzik.matricula_alunos.entities.Aluno;
import com.damzik.matricula_alunos.entities.Matricula;
import com.damzik.matricula_alunos.exceptions.AlunoNotFoundException;
import com.damzik.matricula_alunos.exceptions.MatriculaNotFoundException;
import com.damzik.matricula_alunos.repositories.AlunoRepository;
import com.damzik.matricula_alunos.repositories.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<Matricula> matriculas(){
        return matriculaRepository.findAll();
    }

    public Matricula getMatriculaById(Long id){
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new MatriculaNotFoundException(id));
        return matricula;
    }

    public Matricula criarMatricula(MatriculaRequestDTO matriculaRequestDTO){
        Matricula matricula = new Matricula(matriculaRequestDTO);
        matricula.setAluno(alunoRepository.findById(matriculaRequestDTO.getAlunoId())
                .orElseThrow(() -> new AlunoNotFoundException(matriculaRequestDTO.getAlunoId())));
        matricula.setCodigoMatricula(gerarCodigoMatricula());
        matricula.setDataInclusao(LocalDateTime.now());

        return matriculaRepository.save(matricula);
    }

    public Matricula atualizarMatricula(Long id, MatriculaRequestDTO matriculaRequestDTO){
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new MatriculaNotFoundException(id));

        Aluno aluno = alunoRepository.findById(matriculaRequestDTO.getAlunoId())
                        .orElseThrow(() -> new AlunoNotFoundException(matriculaRequestDTO.getAlunoId()));

        matricula.setAluno(aluno);
        matricula.setNomeCurso(matriculaRequestDTO.getNomeCurso());
        matricula.setDataInicio(matriculaRequestDTO.getDataInicio());
        matricula.setDataAtualizacao(LocalDateTime.now());

        matriculaRepository.save(matricula);

        return matricula;
    }

    public Matricula deletarMatricula(Long id){
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new MatriculaNotFoundException(id));

        matriculaRepository.deleteById(id);

        return matricula;
    }

    public String gerarCodigoMatricula(){
        Random random = new Random();
        while(true) {
            StringBuilder codigo = new StringBuilder();
            for (int i = 0; i < 7; i++) {
                codigo.append(random.nextInt(10));
            }

            String codigoFinal = codigo.toString();

            if(!matriculaRepository.existsByCodigoMatricula(codigoFinal)){
                return codigoFinal;
            }
        }
    }

}
