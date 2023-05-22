package tech.ada.projetoTestes.integration;

import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.ada.projetoTestes.domain.LivroEntity;
import tech.ada.projetoTestes.domain.dto.LivroDTO;
import tech.ada.projetoTestes.repository.LivroRepository;
import tech.ada.projetoTestes.service.LivroService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class LivroServiceAndLivroRepositoryIntegrationTest {

    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroRepository livroRepository;

    @Test
    public void testAtualizarLivroExistente() {
        LivroEntity livroExistente = new LivroEntity("Livro Existente", "Resumo do livro existente", null, 10.0, 200, "1234567890", LocalDate.now().plusDays(1));
        livroRepository.save(livroExistente);

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setTitulo("Novo Título");
        livroDTO.setResumo("Novo resumo");
        livroDTO.setValor(15.0);
        livroDTO.setNumPaginas(250);
        livroDTO.setIsbn("0987654321");
        livroDTO.setDataPubli(LocalDate.now().plusDays(2));

        LivroEntity livroAtualizado = livroService.update(livroDTO, livroExistente.getId());

        assertEquals(livroExistente.getId(), livroAtualizado.getId());
        assertEquals(livroDTO.getTitulo(), livroAtualizado.getTitulo());
        assertEquals(livroDTO.getResumo(), livroAtualizado.getResumo());
        assertEquals(livroDTO.getValor(), livroAtualizado.getValor());
        assertEquals(livroDTO.getNumPaginas(), livroAtualizado.getNumPaginas());
        assertEquals(livroDTO.getIsbn(), livroAtualizado.getIsbn());
        assertEquals(livroDTO.getDataPubli(), livroAtualizado.getDataPubli());
    }
}
