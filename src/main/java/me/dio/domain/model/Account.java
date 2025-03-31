package me.dio.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_account") //Anotação entidade define a classe em entidade
public class Account {

    //Atributos
    @Id //Anotação de chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação gera automaticamente
    private Long id; //Modificador de acesso- type- nome da variável

    @Column(unique = true)//Anotação para dar característica a coluna, valor único
    private String number;

    private String agency;

    @Column(precision = 13, scale = 2) //13 números no total, incluindo 2 casas
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    //Métodos
    public Long getId() {
        return id;
    } // getId = acessa e retorna id
    public void setId(Long id) { this.id = id; } // setId = Modifica - atributo id recebe o valor do id do parâmetro

    public String getNumber() { return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }
    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }
    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

}