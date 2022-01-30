/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastorcic11.repositories.interfaces;

import hr.kpastorcic11.models.Movie;
import hr.kpastorcic11.models.Person;
import hr.kpastorcic11.roles.enums.MovieRole;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author islan
 */
public interface MoviesRepository {

    boolean importMovies(List<Movie> movies) throws Exception;

    public List<Movie> getMovies() throws Exception;

    public Optional<Movie> getMovie(int id) throws Exception;

    public List<Person> getMovieRolePersonssss(MovieRole role) throws Exception;

    public int createMovie(Movie movie) throws Exception;

    public void deleteMovie(Movie movie) throws Exception;

    public void updateMovie(Movie movie) throws Exception;
}
