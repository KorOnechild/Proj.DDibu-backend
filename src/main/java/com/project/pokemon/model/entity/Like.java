package com.project.pokemon.model.entity;

import javax.persistence.*;

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "pokemonId")
    private Pokemon pokemon;

    public Like(Users user, Pokemon pokemon){
        this.user = user;
        this.pokemon = pokemon;
    }
}

