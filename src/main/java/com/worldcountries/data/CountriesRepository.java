package com.worldcountries.data;

import com.worldcountries.model.Country;
import com.worldcountries.Exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CountriesRepository {
    private static final List<Country> WORLD_COUNTRIES = Arrays.asList(
            new Country("India",1293057000,"Delhi", Arrays.asList("Hindi","English"),"india"),
            new Country("India",45010056,"Nairobi", Arrays.asList("Kiswahili","English"),"kenya"),
            new Country("Ecuador",16144000,"Quito", Arrays.asList("Spanish"),"ecuador"),
            new Country("France",66736000,"Paris", Arrays.asList("French"),"france"),
            new Country("Italy",60674003,"Rome", Arrays.asList("Italian"),"italy")
    );

    public static List<Country> getWorldCountries() {
        return WORLD_COUNTRIES;
    }

    public Country findCountryByName(String name) {
        return WORLD_COUNTRIES.stream()
                .filter(Country -> Country.getCountryName().equals(name))
                .findFirst()
                .orElseThrow(NotFoundException::new);

    }

}
