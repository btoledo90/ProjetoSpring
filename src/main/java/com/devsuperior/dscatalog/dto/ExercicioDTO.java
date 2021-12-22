package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Exercicio;

import java.io.Serializable;

public class ExercicioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String descricao;


    public ExercicioDTO() {
    }

    public ExercicioDTO(Long id, String name, String descricao) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
    }

    public ExercicioDTO(Exercicio entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.descricao = entity.getDescricao();

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
