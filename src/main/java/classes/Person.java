package classes;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String cc;
    private String firstNames;
    private String lastNames;
    private String email;
    private Address address;
    private int totalWalkedMeters;
    private ArrayList<Person> relative = new ArrayList<>();

    public String getCC() {
        return cc;
    }

    public void setCC(String CC) {
        this.cc = CC;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getTotalWalkedMeters() {
        return totalWalkedMeters;
    }

    public void setTotalWalkedMeters(int totalWalkedMeters) {
        this.totalWalkedMeters = totalWalkedMeters;
    }

    public ArrayList<Person> getRelative() {
        return relative;
    }

    public void setRelative(ArrayList<Person> relative) {
        this.relative = relative;
    }

    public Person(String CC, String firstNames, String lastNames, String email, Address address) {
        this.cc = CC;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.email = email;
        this.address = address;
        this.totalWalkedMeters = 0;
    }

    public int walkAround(int walkedMeters){
        this.totalWalkedMeters += walkedMeters;
        return this.totalWalkedMeters;
    }

    public int addRelative(Person person){
        this.relative.add(person);
        return this.relative.size()-1;
    }

    public int updatePerson(Person person){

       if(person.getAddress() == null || person.getCC() == null
               || person.getEmail() == null || person.getFirstNames() == null || person.getLastNames() == null  ){
          return 2;
       } else  if(person.cc !=this.cc){
           return 1;
       }

        this.cc = person.getCC();
        this.firstNames = person.getFirstNames();
        this.lastNames = person.getLastNames();
        this.email = person.getEmail();
        this.address = person.getAddress();
        return 3;
    }

    public int deleteRelative(int index) throws Exception {
        if(this.relative.isEmpty()){
            Exception IllegalStateException = new IllegalStateException();
            throw IllegalStateException;
        }else if(index >= this.relative.size()){
            return 1;
        }

        this.relative.remove(index);
        return 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return totalWalkedMeters == person.totalWalkedMeters && Objects.equals(cc, person.cc) && Objects.equals(firstNames, person.firstNames) && Objects.equals(lastNames, person.lastNames) && Objects.equals(email, person.email) && Objects.equals(address, person.address) && Objects.equals(relative, person.relative);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cc, firstNames, lastNames, email, address, totalWalkedMeters, relative);
    }
}
