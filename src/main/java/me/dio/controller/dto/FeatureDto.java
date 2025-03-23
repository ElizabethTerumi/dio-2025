package me.dio.controller.dto;

import me.dio.domain.model.Feature;

//Cria classe imutável usando record, sem setters apenas getters(acesso) com parâmetros
public record FeatureDto(Long id, String icon, String description) {

    // construtor cria instância de Feature em FeatureDto.
    public FeatureDto(Feature model) {
        this(model.getId(), model.getIcon(), model.getDescription());
    }

    // Cria metodo chamado to Model() -  converte o FeatureDto de volta para o modelo de feature.
    public Feature toModel() {

        // Cria objeto model da classe Feature
        Feature model = new Feature();

        // Atribui os valores do FeatureDto para os atributos do modelo Feature
        model.setId(this.id); // model usa metodo setId para atribuir o id de FeatureDto ao ID de Feature
        model.setIcon(this.icon);
        model.setDescription(this.description);

        // Retorna os valores atualizados.
        return model;
    }
}

