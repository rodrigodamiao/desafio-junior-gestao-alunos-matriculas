package com.damzik.matricula_alunos.controllers;

import com.damzik.matricula_alunos.dtos.requests.MatriculaRequestDTO;
import com.damzik.matricula_alunos.dtos.responses.MatriculaResponseDTO;
import com.damzik.matricula_alunos.entities.Matricula;
import com.damzik.matricula_alunos.services.MatriculaService;
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
@RequestMapping("/matriculas")
public class MatriculaController {

    MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponseDTO>> getMatriculas(){
        List<Matricula> matriculas = matriculaService.matriculas();
        List<MatriculaResponseDTO> matriculasResponseDTO = matriculas
                .stream()
                .map(matricula -> new MatriculaResponseDTO(matricula))
                .collect(Collectors.toList());

        return ResponseEntity.ok(matriculasResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> getMatriculaById(@PathVariable Long id){
        Matricula matricula = matriculaService.getMatriculaById(id);
        MatriculaResponseDTO matriculaResponseDTO = new MatriculaResponseDTO(matricula);

        return ResponseEntity.ok(matriculaResponseDTO);
    }

    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> criarMatricula(@RequestBody MatriculaRequestDTO matriculaRequestDTO){
        Matricula matricula = matriculaService.criarMatricula(matriculaRequestDTO);
        MatriculaResponseDTO matriculaResponseDTO = new MatriculaResponseDTO(matricula);

        return ResponseEntity.ok(matriculaResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> atualizarMatricula(@PathVariable Long id, @RequestBody MatriculaRequestDTO matriculaRequestDTO){
        Matricula matricula = matriculaService.atualizarMatricula(id, matriculaRequestDTO);
        MatriculaResponseDTO matriculaResponseDTO = new MatriculaResponseDTO(matricula);

        return ResponseEntity.ok(matriculaResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMatricula(@PathVariable Long id){
        Matricula matricula = matriculaService.deletarMatricula(id);

        String message = String.format("A Matrícula de id %s foi deletado com sucesso.", id);

        return ResponseEntity.ok(message);
    }

}
