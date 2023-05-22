package tech.ada.projetoTestes.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double valor;
    private Integer numPaginas;
    private String isbn;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataPubli;

    public LivroEntity(String titulo, String resumo, String sumario, Double valor, Integer numPaginas, String isbn, LocalDate dataPubli) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.valor = valor;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPubli = dataPubli;
    }
}
