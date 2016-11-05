# Project-5-Countries-of-the-World-with-Spring

## Countries of the World with Spring

### Technical

Java Ide : IntelliJ Idea   
Web FrameWork : Spring   
programming Language : Java   
Template and View : Thyme Leaf   
Mark Up Language : HTML5
Build Tool : Gradle
Design : MVC
Dependencies :  [SEO-Friendly URL'S with Slugify](https://github.com/slugify/slugify)

### Implementation

In this project will build a Spring web application that displays information about any 5 countries of the world. 
The site will have two views:

* An index view that lists all 5 countries
* A detail view that displays the details of a specific country.

#### User Stories to Implement the Functionlaity of Spring Web Application

* Add Dependencies to *build.gradle* file to build Web Application   

```
compile "com.github.slugify:slugify:2.1.7"
compile "org.springframework.boot:spring-boot-starter-thymeleaf"
runtime 'net.sourceforge.nekohtml:nekohtml:1.9.22'

```

•	Gather current, accurate information on the five countries you’ll be including in your application.   
File : Country.java

```
public class Country {
    private static int countriesCount = 0; //keeps track of no of Countries in Repository and to Generate Unique Slug
    private String slug;    // slug is computed combining countryName and countriesCount
    private Slugify slugify = new Slugify();
    private String countryName;
    private int population;
    private String capitalCity;
    private List<String> officialLanguages;
    private String flag; }
```


•	Write the application code, including a data repository and controller.   
Repository : CountryRepository.java   
Controller : CountryController.java

```
Repository
@Componenet is Indication of a Component or Repository
``` 
```
Controller 
@Controller is Indication of a Controller 
@Autowired Indicates the Dependence Injection of countries Repository
 @RequestMapping("/") - Maps to User URI Request : http://localhost:8080/
 @RequestMapping("/country/{slug}") - Maps to User URI Request: http://localhost:8080/country/Ecuador
 @RequestMapping("/sort/country/name") - Sorts Countries by Name
 @RequestMapping("/sort/country/population") - Sorts Countries by Population
 ```
•	Create the index view, which will serve as the homepage of the application. This view must contain the following:
-	A list of the countries you’ve chosen
-	A small thumbnail image of each country’s flag next to its name
-	A clickable link to each country’s detail page (could be the country name and/or flag image)

`File Name : index.html`

•	Create the detail view. This view must contain all required pieces of information for each country,    
presented in an easily-readable fashion.

`File Name : detail.html`

•	Add two ways of sorting the countries on the index page, for example by country name and by population.   

```
 Collections.sort(sortedCountriesName, Comparator.comparing(Country::getCountryName));
 Collections.sort(sortedCountriesPopulation, Comparator.comparing(Country::getCountryPopulation));
```

