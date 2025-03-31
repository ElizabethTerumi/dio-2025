package me.dio.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseItem {

    //Atributos
    @Id //Anotação de chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação gera automaticamente
    private Long id; //Modificador de acesso- type -nome da variável

    private String icon;

    private String description;

    //Métodos
    public Long getId() {
        return id;
    } // getId = acessa e retorna id
    public void setId(Long id) {
        this.id = id;
    } // setId = Modifica - atributo id recebe o valor do id do parâmetro

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
