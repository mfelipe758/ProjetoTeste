package tech.ada.projetoTestes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.projetoTestes.domain.LivroEntity;
import tech.ada.projetoTestes.domain.dto.LivroDTO;
import tech.ada.projetoTestes.service.LivroService;

import java.util.List;

@RestController
@RequestMapping(value = "/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;
    @PostMapping("/criar")
    public ResponseEntity<LivroEntity> save(@Valid @RequestBody LivroDTO livro){
        return new ResponseEntity<>(service.save(livro), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LivroEntity>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<LivroEntity> getId(@PathVariable Long id){
        return new ResponseEntity<>(service.getId(id), HttpStatus.OK);
    }
    @DeleteMapping("/excluir/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<LivroEntity> update(@RequestBody LivroDTO livro, @PathVariable Long id){
        return new ResponseEntity<>(service.update(livro, id), HttpStatus.OK);
    }

}
