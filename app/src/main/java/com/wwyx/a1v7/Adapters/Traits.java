package com.wwyx.a1v7.Adapters;

// Traits singleton

public class Traits {
    private String tname;
    private String tdescription;
    private String benefit;
    private String type;
    private String tag;
    private byte[] icon;
    private byte[] champions;

    public Traits(String tname, String tdescription, String benefit, String type, String tag, byte[] icon, byte[] champions) {
        this.tname = tname;
        this.tdescription = tdescription;
        this.benefit = benefit;
        this.type = type;
        this.tag = tag;
        this.icon = icon;
        this.champions = champions;
    }

    public Traits() { }

    String getTname() { return this.tname; }
    public void setTname(String tname) { this.tname = tname; }

    String getTdescription() { return this.tdescription; }
    public void setTdescription(String tdescription) { this.tdescription = tdescription; }

    String getBenefit() { return this.benefit; }
    public void setBenefit(String benefit) { this.benefit = benefit; }

    String getType() { return this.type; }
    public void setType(String type) { this.type = type; }

    String getTag() { return this.tag; }
    public void setTag(String tag) { this.tag = tag; }

    byte[] getIcon() { return this.icon; }
    public void setIcon(byte[] icon) { this.icon = icon; }

    byte[] getChampions() { return this.champions; }
    public void setChampions(byte[] champions) { this.champions = champions; }
}

