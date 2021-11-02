package com.alberto.a10pokemonapp.model;

public class Pokemon {

    private String id;
    private String nombre;
    //Le pongo un entero porque contiene el id de la imagen
    //private int imageId;
    private String imageUrl;
    private int soundId;
    private Type type;

    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String nombre, String imageUrl, int soundId, Type type) {
        this.id = id;
        this.nombre = nombre;
        this.imageUrl = imageUrl;
        this.soundId = soundId;
        this.type = type;
    }

    public int getSoundId() {
        return soundId;
    }

    public String getImageUrl() {
        return imageUrl;
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
