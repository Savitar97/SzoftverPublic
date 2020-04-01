package countries;

import java.io.*;

import java.lang.reflect.Type;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import util.ZoneIdAdapter;

public class Countries  {

    private List<Country> countries;

    public Countries() {
        this(Countries.class.getResourceAsStream("countries.json"));
    }

    private Countries(InputStream is) {
        Gson gson = new GsonBuilder().registerTypeAdapter(ZoneId.class, new ZoneIdAdapter()).create();
//        Country[] arrayOfCountries = gson.fromJson(new InputStreamReader(is), Country[].class);
//        countries = java.util.Arrays.asList(arrayOfCountries);
        Type type = new TypeToken<List<Country>>(){}.getType();
        countries = gson.fromJson(new InputStreamReader(is), type);
    }

    public List<Country> getAll() {
        return countries;
    }
    public long feladat1(){
        return getAll().stream()
                .count();
    };
    public void feladat2(){
        getAll().stream()
                .map(country -> country.getName())
                .sorted()
                .forEach(System.out::println);
    };

    public List<String> feladat3() {
        return getAll().stream()
                .map(Country::getName)
                .sorted()
                .collect(Collectors.toList());
    }
    //fordítva,régiókat csak egyszer
    public List<String> feladat4(){
        return getAll().stream()
                .map(Country::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    public List<Region> feladat5(){
        return getAll().stream()
                .map(Country::getRegion)
                .distinct()
                .collect(Collectors.toList());
    }
    public List<Country>feladat6()
    {
        return   getAll().stream()
                .filter(country -> country.getRegion()==Region.UNSPECIFIED)
                .collect(Collectors.toList());
    }
    public boolean feladat7(){
        return getAll().stream()
                .anyMatch(country -> country.getName().contains("Island"));
    }
    public Country feladat8()
    {
        return   getAll().stream()
                .filter(country -> country.getName().contains("Island"))
                .findFirst()
                .get();
    }
    public List<Country> feladat9()
    {
        List<BigDecimal> temp=getAll().stream()
                .filter(country -> country.getName().equals("France"))
                .map( country -> country.getArea())
                .collect(Collectors.toList());
        System.out.println(temp.get(0));
               return getAll().stream()
                .filter(country-> {
                    if (country.getArea()!=null) {
                        if (country.getArea().compareTo(temp.get(0)) > 0)
                            return true;
                        return false;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
    Countries ct=new Countries();
        System.out.println(ct.feladat9());
    }
}
