package com.worldcountries.model;

import com.github.slugify.Slugify;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private static int countriesCount = 0; //keeps track of no of Countries in Repository and to Generate Unique Slug
    private String slug;    // slug is computed combining countryName and countriesCount
    private Slugify slugify = new Slugify();
    private String countryName;
    private int population;
    private String capitalCity;
    private List<String> officialLanguages;
    private String flag;

    public Country(String name, int population, String city, List<String> languages,String flag) {
        countriesCount++;
        this.countryName = name;
        this.population = population;
        this.capitalCity = city;
        this.officialLanguages = languages;
        this.flag = flag;
        slug = slugify.slugify(countryName+-countriesCount);
    }

    public String getCountryName() { return countryName; }

    public void setCountryName(String countryName) { this.countryName = countryName; }

    public String getPopulation() { return String.format("%,d", population); }

    public int getCountryPopulation() {return population;}

    public void setPopulation(int population) { this.population = population; }

    public String getCapitalCity() { return capitalCity; }

    public void setCapitalCity(String capitalCity) { this.capitalCity = capitalCity; }

    public List<String> getOfficialLanguages() { return officialLanguages; }

    public void setOfficialLanguages(List<String> Languages) {
        this.officialLanguages = Languages;
    }

    public String getFlag() { return flag; }

    public void setFlag(String flag) { this.flag = flag; }

    public String getSlug() { return slug; }

    public void setSlug(String slug) { this.slug = slug; }
}

