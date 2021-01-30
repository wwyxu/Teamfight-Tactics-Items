package com.wwyx.a1v7.Adapters;

// Items singleton

public class Items {
    String name;
    String base;
    private String stats;
    private String description;
    private byte[] img;

    public Items(String name, String base, String stats, String description, byte[] img) {
        this.name = name;
        this.base = base;
        this.stats = stats;
        this.description = description;
        this.img = img;
    }

    public Items() { }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return this.base;
    }
    public void setBase() {
        this.base = base;
    }

    String getStats() {
        return this.stats;
    }
    public void setStats(String stats) {
        this.stats = stats;
    }

    String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    byte[] getImage() {
        return this.img;
    }
    public void setImage(byte[] img) {
        this.img = img;
    }
}

