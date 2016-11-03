package com.worldcountries.controller;

import com.worldcountries.data.CountriesRepository;
import com.worldcountries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class CountryController {
    @Autowired
    CountriesRepository countriesRepository;
    @RequestMapping("/")
    public String listCountries(ModelMap modelMap) {
        List<Country> worldCountries = countriesRepository.getWorldCountries();
        modelMap.put("countries",worldCountries);
        return "index";
    }
    @RequestMapping("/country/{name}")
    public String country(@PathVariable String name,ModelMap modelMap) {
        Country country = countriesRepository.findCountryByName(name);
        modelMap.put("country",country);
        return "country";
    }
    @RequestMapping("/sort/country/name")
    public String countriesByName(ModelMap modelMap) {
        List<Country> sortedCountriesName = countriesRepository.getWorldCountries();
        Collections.sort(sortedCountriesName, Comparator.comparing(Country::getCountryName));
        modelMap.put("countries",sortedCountriesName);
        return "index";
    }
    @RequestMapping("/sort/country/population")
    public String countriesByPopulation(ModelMap modelMap) {
        List<Country> sortedCountriesPopulation = countriesRepository.getWorldCountries();
        Collections.sort(sortedCountriesPopulation, Comparator.comparing(Country::getCountryPopulation));
        modelMap.put("countries",sortedCountriesPopulation);
        return "index";
    }


}
