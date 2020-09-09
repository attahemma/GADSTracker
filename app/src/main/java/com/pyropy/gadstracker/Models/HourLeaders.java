package com.pyropy.gadstracker.Models;

import com.google.gson.annotations.SerializedName;

public class HourLeaders {
    @SerializedName("name")
    public String name;

    @SerializedName("hours")
    public String hours;

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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
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



    public HourLeaders(String name, String hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }
}
