package com.wwyx.a1v7.Adapters;

// Champions singleton

public class Champions {
    private String champion;
    private String traits;
    private String ability;
    private String abilityDescription;
    private String health;
    private String mana;
    private String armor;
    private String magicResist;
    private String attackDamage;
    private String attackSpeed;
    private String range;
    private String tag;
    private byte[] champIcon;
    private byte[] abilityIcon;

    public Champions( String champion, String traits, String ability, String abilityDescription, String health, String mana, String armor,
                      String magicResist, String attackDamage, String attackSpeed, String range, String tag, byte[] champIcon, byte[] abilityIcon ) {
        this.champion = champion;
        this.traits = traits;
        this.ability = ability;
        this.abilityDescription = abilityDescription;
        this.health = health;
        this.mana = mana;
        this.armor = armor;
        this.magicResist = magicResist;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.tag = tag;
        this.champIcon = champIcon;
        this.abilityIcon = abilityIcon;
    }

    public Champions() { }

    String getChampion() { return this.champion; }
    public void setChampion(String champion) { this.champion = champion; }

    String getTraits() { return this.traits; }
    public void setTraits(String traits) { this.traits = traits; }

    String getAbility() { return this.ability; }
    public void setAbility(String ability) { this.ability = ability; }

    String getAbilityDescription() { return this.abilityDescription; }
    public void setAbilityDescription(String abilityDescription) { this.abilityDescription = abilityDescription; }

    String getHealth() { return this.health; }
    public void setHealth(String health) { this.health = health; }

    String getMana() { return this.mana; }
    public void setMana(String mana) { this.mana = mana; }

    String getArmor() { return this.armor; }
    public void setArmor(String armor) { this.armor = armor; }

    String getMagicResist() { return this.magicResist; }
    public void setMagicResist(String magicResist) { this.magicResist = magicResist; }

    String getAttackDamage() { return this.attackDamage; }
    public void setAttackDamage(String attackDamage) { this.attackDamage = attackDamage; }

    String getAttackSpeed() { return this.attackSpeed; }
    public void setAttackSpeed(String attackSpeed) { this.attackSpeed = attackSpeed; }

    String getRange() { return this.range; }
    public void setRange(String range) { this.range = range; }

    String getTag() { return this.tag; }
    public void setTag(String tag) { this.tag = tag; }

    byte[] getChampIcon() { return this.champIcon; }
    public void setChampIcon(byte[] champIcon) { this.champIcon = champIcon; }

    byte[] getAbilityIcon() { return this.abilityIcon; }
    public void setAbilityIcon(byte[] abilityIcon) { this.abilityIcon = abilityIcon; }
}

