/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastor11.modles;

/**
 *
 * @author islan
 */
public class Person {

    private final int idPerson;
    private final String firstName;
    private final String lastName;

    public Person(int id, String firstName, String lastName) {
        this.idPerson = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIDPerson() {
        return idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String ret() {
        return null;
    }
}
