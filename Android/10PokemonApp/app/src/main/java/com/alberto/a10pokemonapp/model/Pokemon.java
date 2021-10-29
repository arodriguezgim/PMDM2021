package com.alberto.a10pokemonapp.model;

public class Pokemon {

    private String id;
    private String nombre;
    private Type type;

    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String nombre, Type type) {
        this.id = id;
        this.nombre = nombre;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Type getType() {
        return type;
    }
}
