
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.fasttrack.Person;
import org.fasttrack.PersonService;
import org.junit.Before;
import org.junit.Test;

public class PersonServiceTest {

    private PersonService personService;

    @Before
    public void setUp() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Doe", 25, "Oradea"));
        persons.add(new Person("Alice", "Smith", 35, "Cluj"));
        persons.add(new Person("Bob", "Johnson", 40, "Oradea"));

        personService = new PersonService(persons);
    }

    @Test
    public void testListAllNames() {
        List<String> names = personService.listAllNames();
        assertEquals(3, names.size());
        assertTrue(names.contains("John Doe"));
        assertTrue(names.contains("Alice Smith"));
        assertTrue(names.contains("Bob Johnson"));
    }

    @Test
    public void testListAllMajorPersons() {
        List<Person> majorPersons = personService.listAllMajorPersons();
        assertEquals(3, majorPersons.size());
    }

    @Test
    public void testListPersonsFromCity() {
        List<Person> oradeaPersons = personService.listPersonsFromCity("Oradea");
        assertEquals(2, oradeaPersons.size());
        assertTrue(oradeaPersons.stream().allMatch(person -> person.getCity().equals("Oradea")));
    }

    @Test
    public void testListCapitalizedFirstNames() {
        List<String> capitalizedFirstNames = personService.listCapitalizedFirstName();
        assertEquals(3, capitalizedFirstNames.size());
        assertTrue(capitalizedFirstNames.contains("JOHN"));
        assertTrue(capitalizedFirstNames.contains("ALICE"));
        assertTrue(capitalizedFirstNames.contains("BOB"));
    }
}
