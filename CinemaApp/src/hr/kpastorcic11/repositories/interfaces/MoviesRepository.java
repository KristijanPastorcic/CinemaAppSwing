/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastorcic11.repositories.interfaces;

import hr.kpastorcic11.models.Movie;
import java.util.List;

/**
 *
 * @author islan
 */
public interface MoviesRepository {
    
    boolean importMovies(List<Movie> movies) throws Exception;

    public List<Movie> getMovies() throws Exception;
}
