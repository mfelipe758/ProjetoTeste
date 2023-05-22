package tech.ada.projetoTestes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.projetoTestes.domain.LivroEntity;
import tech.ada.projetoTestes.domain.dto.LivroDTO;
import tech.ada.projetoTestes.exception.NotFoundException;
import tech.ada.projetoTestes.repository.LivroRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;

    public LivroEntity save(LivroDTO livroDTO){
        if (livroDTO.getDataPubli().isAfter(LocalDate.now())){
            return repository.save(livroDTO.toLivro());
        }else {
            throw new NotFoundException("Digite uma data correta.");
        }
    }

    public List<LivroEntity> getAll(){
        return repository.findAll();
    }

    public LivroEntity getId(Long id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("ID não encontrado."));
    }

    public void delete(Long id){
        repository.delete(getId(id));
    }

    public LivroEntity update(LivroDTO livroDTO, Long id){
        LivroEntity livroEntity = getId(id);
        livroEntity.setTitulo(livroDTO.getTitulo());
        livroEntity.setResumo(livroDTO.getResumo());
        livroEntity.setSumario(livroDTO.getSumario());
        livroEntity.setValor(livroDTO.getValor());
        livroEntity.setNumPaginas(livroDTO.getNumPaginas());
        livroEntity.setIsbn(livroDTO.getIsbn());
        livroEntity.setDataPubli(livroDTO.getDataPubli());
        return repository.save(livroEntity);
    }

}
