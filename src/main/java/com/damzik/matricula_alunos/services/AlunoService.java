package com.damzik.matricula_alunos.services;

import com.damzik.matricula_alunos.dtos.requests.AlunoRequestDTO;
import com.damzik.matricula_alunos.entities.Aluno;
import com.damzik.matricula_alunos.exceptions.AlunoNotFoundException;
import com.damzik.matricula_alunos.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlunoService {

    AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException(id));
    }

    public Aluno criarAluno(AlunoRequestDTO alunoRequestDTO){
        Aluno aluno = new Aluno(alunoRequestDTO);
        aluno.setDataInclusao(LocalDateTime.now());

        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Long id, AlunoRequestDTO alunoRequestDTO){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException(id));

        aluno.setNome(alunoRequestDTO.getNome());
        aluno.setTelefone(alunoRequestDTO.getTelefone());
        aluno.setDataNascimento(alunoRequestDTO.getDataNascimento());
        aluno.setDataAtualizacao(LocalDateTime.now());

        alunoRepository.save(aluno);

        return aluno;
    }

    public Aluno deletarAluno(Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException(id));

        alunoRepository.deleteById(id);

        return aluno;
    }
}
