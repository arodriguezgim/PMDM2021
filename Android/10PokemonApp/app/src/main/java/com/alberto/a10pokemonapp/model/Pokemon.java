package com.alberto.a10pokemonapp.model;

public class Pokemon {

    private String id;
    private String nombre;
    //Le pongo un entero porque contiene el id de la imagen
    private int imageId;
    private int soundId;
    private Type type;

    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String nombre, int imageId, int soundId, Type type) {
        this.id = id;
        this.nombre = nombre;
        this.imageId = imageId;
        this.soundId = soundId;
        this.type = type;
    }

    public int getSoundId() {
        return soundId;
    }

    public int getImageId() {
        return imageId;
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
