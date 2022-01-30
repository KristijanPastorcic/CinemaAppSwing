/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.models;

import hr.kpastorcic11.roles.enums.MovieRole;
import java.awt.datatransfer.DataFlavor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author islan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Comparable<Person>{

    public static final DataFlavor MOVIE_FLAVOR = new DataFlavor(Movie.class, "Movie");
    private static final DataFlavor[] SUPORTED_FLAVORS = {MOVIE_FLAVOR};

    @XmlAttribute
    private int id;
    private String firstName;
    private String lastName;
    private MovieRole movieRole;

    public Person() {
    }

    public MovieRole getMovieRole() {
        return movieRole;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMovieRole(MovieRole movieRole) {
        this.movieRole = movieRole;
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int id, String firstName, String lastName, MovieRole movieRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movieRole = movieRole;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(id, o.getId());
    }



}
