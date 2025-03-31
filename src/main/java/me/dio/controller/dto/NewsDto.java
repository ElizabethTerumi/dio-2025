package me.dio.controller.dto;

import me.dio.domain.model.News;

//Cria classe imutável usando record, sem setters apenas getters(acesso) com parâmetros
public record NewsDto(Long id, String icon, String description) {

    // Construtor cria instância de News em NewsDto.
    public NewsDto(News model) {
        this(model.getId(), model.getIcon(), model.getDescription());
    }

    //  metodo: to Model() = converte NewsDto para News.
    public News toModel() {

        // Cria objeto model da classe News
        News model = new News();

        // Atribui os valores do NewsDto para os atributos do modelo News
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);

        // Retorna os valores atualizados.
        return model;
    }
}

