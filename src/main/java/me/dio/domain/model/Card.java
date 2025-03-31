package me.dio.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_card") //Anotação para entidade
public class Card {

    //Atributos
    @Id //Anotação de chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação gera automaticamente
    private Long id;

    @Column(unique = true) //Anotação para dar característica a coluna, valor único
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public Long getId() {
        return id;
    } // Método getter para o atributo 'id', que retorna o valor do 'id'.
    public void setId(Long id) {
        this.id = id;
    } // Atribui o valor do parâmetro 'id' ao atributo 'id' da classe.

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }
    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

}
