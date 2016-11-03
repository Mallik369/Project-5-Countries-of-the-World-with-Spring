package com.worldcountries.controller;

import com.worldcountries.data.CountriesRepository;
import com.worldcountries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "india";
    }
}
