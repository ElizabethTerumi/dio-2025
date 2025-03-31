package me.dio.controller.dto;

import me.dio.domain.model.Account;

import java.math.BigDecimal;

//Classe imutável usando record, sem setters apenas getters(acesso) com parâmetros
public record AccountDto(Long id, String number, String agency, BigDecimal balance, BigDecimal limit) {

     // Construtor que instância de Account em AccountDto com nome do parâmetro model
    public AccountDto(Account model) {
        // Corpo do construtor, onde os dados de 'model' são usados para preencher o AccountDto
        this(model.getId(), model.getNumber(), model.getAgency(), model.getBalance(), model.getLimit());
    }

    //Metodo: toModel() =  Conversão AccountDto para Account.
    public Account toModel() {

        // Cria objeto model da classe Account.
        Account model = new Account();
        // Atribui os valores do AccountDto para Account.
        model.setId(this.id); // model usa metodo setId para atribuir o id de AccountDto ao ID de Account
        model.setNumber(this.number);
        model.setAgency(this.agency);
        model.setBalance(this.balance);
        model.setLimit(this.limit);
        // Retorna os valores atualizados.
        return model;
    }
}
