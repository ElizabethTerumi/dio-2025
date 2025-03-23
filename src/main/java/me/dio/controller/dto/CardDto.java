package me.dio.controller.dto;

import me.dio.domain.model.Card;

import java.math.BigDecimal;

//Cria record com parâmetros
public record CardDto(Long id, String number, BigDecimal limit) {

    // Construtor cria instância de Card em CardDto.
    public CardDto(Card model) {
        this(model.getId(), model.getNumber(), model.getLimit());
    }

    // Cria metodo chamado to Model()  - converte o CardDto de volta para o modelo de Card.
    public Card toModel() {

        //Cria objeto model da classe Card
        Card model = new Card();

        //Atribui os valores do CardDto para os atributos do modelo Card.
        model.setId(this.id); // model usa metodo setId para atribuir o id de CardDto ao ID de Card
        model.setNumber(this.number);
        model.setLimit(this.limit);

        // Retorna os valores atualizados.
        return model;
    }
}
