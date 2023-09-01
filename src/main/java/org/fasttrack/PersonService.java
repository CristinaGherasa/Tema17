package org.fasttrack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private List<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = persons;
    }

    public List<String> listAllNames() {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toList());
    }

    public List<Person> listAllMajorPersons() {
        return persons.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
    }

    public List<Person> listPersonsFromCity(String city) {
        return persons.stream()
                .filter(person -> person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Person> listPersonsFromCities(String... cities) {
        List<String> cityList = Arrays.asList(cities);
        return persons.stream()
                .filter(person -> cityList.contains(person.getCity().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<String> listCapitalizedFirstName() {
        return persons.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    public List<String> listPersonNamesWithInitial() {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName().charAt(0) + ".")
                .collect(Collectors.toList());
    }

    public List<Person> listPersonsAgeBetween(int minAge, int maxAge) {
        return persons.stream()
                .filter(person -> person.getAge() > minAge && person.getAge() < maxAge)
                .collect(Collectors.toList());
    }

    public List<Person> listPersonsFirstNameStartingWith(char letter) {
        return persons.stream()
                .filter(person -> person.getFirstName().toLowerCase().charAt(0) == Character.toLowerCase(letter))
                .collect(Collectors.toList());
    }

    public List<String> listUniqueFirstNames() {
        return persons.stream()
                .map(Person::getFirstName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> sortPersonsByFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    public List<Person> sortPersonsByLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    public List<Person> sortPersonsByFirstNameLastNameAge() {
        return persons.stream()
                .sorted(Comparator
                        .comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }


}
