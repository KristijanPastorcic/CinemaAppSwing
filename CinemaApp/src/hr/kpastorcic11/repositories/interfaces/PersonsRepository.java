/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastorcic11.repositories.interfaces;


import hr.kpastorcic11.models.Movie;
import hr.kpastorcic11.models.Person;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author islan
 */
public interface PersonsRepository {

    void createPerson(Person person) throws Exception;
    
    List<Person> getPersons() throws Exception;
    
    void updatePerson(Person person) throws Exception;
    
    void deletePerson(int id) throws Exception;

    public Optional<Person> getPerson(int id) throws Exception;

    public List<Movie> getMovies(int id) throws Exception;
}
