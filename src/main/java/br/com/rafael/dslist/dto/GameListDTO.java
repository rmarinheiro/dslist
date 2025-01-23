package br.com.rafael.dslist.dto;

import br.com.rafael.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public GameListDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
