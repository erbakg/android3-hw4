package com.example.android3_hw4;

public class Country {
    private String LocalizedName;
    private String EnglishName;
    private String ID;

    public Country(String localizedName, String englishName, String ID) {
        LocalizedName = localizedName;
        EnglishName = englishName;
        this.ID = ID;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public void setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
