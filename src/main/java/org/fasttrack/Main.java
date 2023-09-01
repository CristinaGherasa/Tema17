package org.fasttrack;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Doe", 25, "Oradea"));
        persons.add(new Person("Alice", "Smith", 35, "Cluj"));
        persons.add(new Person("Bob", "Johnson", 40, "Oradea"));
        persons.add(new Person("Gabriel", "Roman", 27, "Bucuresti"));
        persons.add(new Person("Alice", "Jameson", 33, "Cluj"));
        persons.add(new Person("James", "Pakinson", 41, "Bucuresti"));

        PersonService personService = new PersonService(persons);


        System.out.println("List of all names: " + personService.listAllNames());
        System.out.println("List of all major persons: " + personService.listAllMajorPersons());
        System.out.println("List of all persons from Oradea: " + personService.listPersonsFromCity("Oradea"));
        System.out.println("List of all persons from Oradea or Cluj: " + personService.listPersonsFromCities("Oradea", "Cluj"));
        System.out.println("List of all first names capitalized: " + personService.listCapitalizedFirstName());
        System.out.println("List of all person names with initials: " + personService.listPersonNamesWithInitial());
        System.out.println("List of all persons with age between 30 and 40: " + personService.listPersonsAgeBetween(30, 40));
        System.out.println("List of all persons with first name starting with 'A': " + personService.listPersonsFirstNameStartingWith('A'));
        System.out.println("List of all unique first names: " + personService.listUniqueFirstNames());
        System.out.println("Sorted by first name: " + personService.sortPersonsByFirstName());
        System.out.println("Sorted by last name: " + personService.sortPersonsByLastName());
        System.out.println("Sorted by first name, last name, and age: " + personService.sortPersonsByFirstNameLastNameAge());

    }
}