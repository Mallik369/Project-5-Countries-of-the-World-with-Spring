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
    /**
     * @Autowired Indicates the Dependence Injection of countries Repository
    */
    @Autowired
    CountriesRepository countriesRepository;
    /**
     * Maps to User URI Request : http://localhost:8080/
     * @param modelMap is POJO Object Provided to  VIEW
     * @return index VIEW list all the countries in Repository
     */
    @RequestMapping("/")
    public String listCountries(ModelMap modelMap) {
        List<Country> worldCountries = countriesRepository.getWorldCountries();
        modelMap.put("countries",worldCountries);
        return "index";
    }
    /**
     * Maps to User URI Request: http://localhost:8080/country/Ecuador
     * @param slug slug of the coutry name and its count
     * @param modelMap is POJO Object Provided to VIEW
     * @return country VIEW detailed view of Country selected by User
     */
    @RequestMapping("/country/{slug}")
    public String country(@PathVariable String slug,ModelMap modelMap) {
        Country country = countriesRepository.findCountryBySlug(slug);
        modelMap.put("country",country);
        return "country";
    }
    /**
     * Sorts Countries by Name
     * Maps to User URI Request: http://localhost:8080/sort/country/name
     * @param modelMap is POJO Object Provided to VIEW
     * @return index VIEW displays sorted country list
     */
    @RequestMapping("/sort/country/name")
    public String countriesByName(ModelMap modelMap) {
        List<Country> sortedCountriesName = countriesRepository.getWorldCountries();
        Collections.sort(sortedCountriesName, Comparator.comparing(Country::getCountryName));
        modelMap.put("countries",sortedCountriesName);
        return "index";
    }
    /**
     * Sorts Countries by Population
     * Maps to User URI Request : http://localhost:8080/sort/country/population
     * @param modelMap is POJO Object Provided to VIEW
     * @return index VIEW display sorted country list
     */
    @RequestMapping("/sort/country/population")
    public String countriesByPopulation(ModelMap modelMap) {
        List<Country> sortedCountriesPopulation = countriesRepository.getWorldCountries();
        Collections.sort(sortedCountriesPopulation, Comparator.comparing(Country::getCountryPopulation));
        modelMap.put("countries",sortedCountriesPopulation);
        return "index";
    }


}
