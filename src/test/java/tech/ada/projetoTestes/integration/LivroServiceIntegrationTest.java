package tech.ada.projetoTestes.integration;

import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.ada.projetoTestes.domain.LivroEntity;
import tech.ada.projetoTestes.domain.dto.LivroDTO;
import tech.ada.projetoTestes.service.LivroService;

import java.time.LocalDate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class LivroServiceIntegrationTest {

    @Autowired
    private LivroService livroService;

    @Test
    public void testCriarLivroValido() {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setTitulo("Livro Teste");
        livroDTO.setResumo("Resumo do livro teste");
        livroDTO.setValor(10.0);
        livroDTO.setNumPaginas(200);
        livroDTO.setIsbn("1234567890");
        livroDTO.setDataPubli(LocalDate.now().plusDays(1));

        LivroEntity livroSalvo = livroService.save(livroDTO);

        assertNotNull(livroSalvo.getId());
        assertEquals(livroDTO.getTitulo(), livroSalvo.getTitulo());
        assertEquals(livroDTO.getResumo(), livroSalvo.getResumo());
        assertEquals(livroDTO.getValor(), livroSalvo.getValor());
        assertEquals(livroDTO.getNumPaginas(), livroSalvo.getNumPaginas());
        assertEquals(livroDTO.getIsbn(), livroSalvo.getIsbn());
        assertEquals(livroDTO.getDataPubli(), livroSalvo.getDataPubli());
    }

}
