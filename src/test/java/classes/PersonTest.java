package classes;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;
    private Address address;

    @Before
    public void setUp(){
        address = new Address(Orientation.CALLE,"66A", "55A-51", "Chagualo", "Medellín");
        person = new Person("1083555169", "Alexis Rafael del Carmen Ávila Ortiz",
                "Ávila Ortiz", "Ávila Ortiz", address);

    }



    @Test
    public void personNotFound(){
        Person updatedPerson =new Person("1083555168", "Alexis Rafael del Carmen Ávila Ortiz",
                "Chagualo", "Medellín", address);
        Assert.assertEquals(1,person.updatePerson(updatedPerson));
    }

    @Test
    public void addressNullNotAllowed(){
        Person updatedPerson =new Person("1083555169", "Alexis Rafael del Carmen",
                "Avilá Ortiz", "alexisavila1991@gmail.com", null);
        Assert.assertEquals(2,person.updatePerson(updatedPerson));
    }

    @Test
    public void firstNamesNullNotAllowed(){
        Person updatedPerson =new Person("1083555169", null,
                "Avilá Ortiz", "alexisavila1991@gmail.com", address);
        Assert.assertEquals(2,person.updatePerson(updatedPerson));
    }

    @Test
    public void lastNamesNullNotAllowed(){
        Person updatedPerson =new Person("1083555169", "Alexis Rafael del Carmen",
                null, "alexisavila1991@gmail.com", address);
        Assert.assertEquals(2,person.updatePerson(updatedPerson));
    }

    @Test
    public void ccNullNotAllowed(){
        Person updatedPerson =new Person(null, "Alexis Rafael del Carmen",
                "Avilá Ortiz", "alexisavila1991@gmail.com", address);
        Assert.assertEquals(2,person.updatePerson(updatedPerson));
    }

    @Test
    public void emailNullNotAllowed(){
        Person updatedPerson =new Person("1083555169", "Alexis Rafael del Carmen",
                "Avilá Ortiz", null, address);
        Assert.assertEquals(2,person.updatePerson(updatedPerson));
    }

    @Test
    public void updateSuccessValue(){
        Person updatedPerson =new Person("1083555169", "Alexis Rafael del Carmen",
                "Avilá Ortiz", "alexisavila1991@gmail.com", address);
        person.updatePerson(updatedPerson);
        Assert.assertThat(updatedPerson, CoreMatchers.is(person));
    }

    @Test
    public void updateSuccessReturn3(){
        Person updatedPerson =new Person("1083555169", "Alexis Rafael del Carmen",
                "Avilá Ortiz", "alexisavila1991@gmail.com", address);

        Assert.assertEquals(3, person.updatePerson(updatedPerson));
    }

    @Test(expected = IllegalStateException.class)
    public void deletedRelativeException() throws Exception {
        person.deleteRelative(0);

    }

    @Test()
    public void deletedRelativeIsNotFound() throws Exception {
        Address newAddress = new Address(Orientation.CALLE, "4", "13-07", "Cadillal", "Popayán");
        person.addRelative(new Person("34523190","Argenis","Ortiz de Ávila","", newAddress));
        Assert.assertEquals(1,person.deleteRelative(1));

    }

    @Test()
    public void deletedRelativeIsFoundValue() throws Exception {
        Address newAddress = new Address(Orientation.CALLE, "4", "13-07", "Cadillal", "Popayán");
        person.addRelative(new Person("34523190","Argenis","Ortiz de Ávila","", newAddress));
        Assert.assertEquals(2,person.deleteRelative(0));

    }

    @Test()
    public void deletedRelativeIsFoundTesting() throws Exception {
        Address newAddress = new Address(Orientation.CALLE, "4", "13-07", "Cadillal", "Popayán");
        person.addRelative(new Person("34523190","Argenis","Ortiz de Ávila","", newAddress));
        person.deleteRelative(0);
        Assert.assertEquals(0, person.getRelative().size());

    }

}