/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.models;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author islan
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MoviesArchive {
    
    @XmlElementWrapper
    @XmlElement(name = "movie")
    private List<Movie> movies;

    public MoviesArchive(List<Movie> movies) {
        this.movies = movies;
    }

    public MoviesArchive() {
    }

    public List<Movie> getMovies() {
        return movies;
    }
    
    
}
