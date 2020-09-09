package com.pyropy.gadstracker.Models;

import com.google.gson.annotations.SerializedName;

public class IQLeaders {

    @SerializedName("name")
    public String name;

    @SerializedName("score")
    public String score;

    @SerializedName("country")
    public String country;

    @SerializedName("badgeUrl")
    public String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public IQLeaders(String name, String score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }
}
