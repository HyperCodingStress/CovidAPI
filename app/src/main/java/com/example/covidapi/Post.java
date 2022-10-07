package com.example.covidapi;

public class Post {
        private String updated,deaths,recovered;

    public Post(String updated, String deaths, String recovered) {
        this.updated = updated;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }
}
