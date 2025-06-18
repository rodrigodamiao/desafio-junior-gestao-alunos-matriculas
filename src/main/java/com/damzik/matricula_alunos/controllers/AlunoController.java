package com.damzik.matricula_alunos.controllers;

import com.damzik.matricula_alunos.dtos.requests.AlunoRequestDTO;
import com.damzik.matricula_alunos.dtos.responses.AlunoResponseDTO;
import com.damzik.matricula_alunos.entities.Aluno;
import com.damzik.matricula_alunos.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> getAlunos(){
        List<Aluno> alunos = alunoService.getAlunos();

        List<AlunoResponseDTO> alunosResponseDTO = alunos
                .stream()
                .map(aluno -> new AlunoResponseDTO(aluno))
                .collect(Collectors.toList());

        return ResponseEntity.ok(alunosResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> getAlunoById(@PathVariable Long id){
        AlunoResponseDTO alunoResponseDTO = new AlunoResponseDTO(alunoService.getAlunoById(id));

        return ResponseEntity.ok(alunoResponseDTO);
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> criarAluno(@RequestBody @Valid AlunoRequestDTO alunoRequestDTO){
        Aluno aluno = alunoService.criarAluno(alunoRequestDTO);
        AlunoResponseDTO alunoResponseDTO = new AlunoResponseDTO(aluno);

        return ResponseEntity.ok(alunoResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizarAluno(@PathVariable Long id, @RequestBody @Valid AlunoRequestDTO alunoRequestDTO){
        Aluno aluno = alunoService.atualizarAluno(id, alunoRequestDTO);
        AlunoResponseDTO alunoResponseDTO = new AlunoResponseDTO(aluno);

        return ResponseEntity.ok(alunoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id){
        Aluno aluno = alunoService.deletarAluno(id);
        String message = String.format("O aluno de id %s (Nome: %s) foi deletado com sucesso.", id, aluno.getNome());

        return ResponseEntity.ok(message);
    }
}
