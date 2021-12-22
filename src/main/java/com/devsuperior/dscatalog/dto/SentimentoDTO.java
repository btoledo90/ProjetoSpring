package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Sentimento;

import java.io.Serializable;

public class SentimentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public SentimentoDTO() {
    }

    public SentimentoDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SentimentoDTO(Sentimento entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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
