package me.dio.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user") //Anotação para entidade
public class User {

    //Atributos
    @Id //Anotação de chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação gera automaticamente
    private Long id; //Modificador de acesso- type -nome da variável

    private String name;

    //Relacionamento entre tabelas
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // CascadeType.ALL- haverá mudança EAGER - aparece junto
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    //Métodos
    public Long getId() {
        return id;
    } // getId = acessa e retorna id
    public void setId(Long id) {
        this.id = id;
    }  // setId = Modifica - atributo id recebe o valor do id do parâmetro

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }
    public void setNews(List<News> news) {
        this.news = news;
    }

}
