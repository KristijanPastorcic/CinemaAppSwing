/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastor11.modles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author islan
 */
public class Movie {
    
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
    private int id;
    private String title;
    private LocalDateTime publishedDateTime;
    private String description;
    private int duration;
    List<Actor> actors;
    private String genre;
    private String link;
    private LocalDate inTheatars;
    private String posterPicturePath;

    public Movie() {
    }

    public Movie(String title, LocalDateTime publishedDateTime, String description, int duration, List<Actor> actors, String genre, String link, LocalDate inTheatars, String posterPicturePath) {
        this.title = title;
        this.publishedDateTime = publishedDateTime;
        this.description = description;
        this.duration = duration;
        this.actors = actors;
        this.genre = genre;
        this.link = link;
        this.inTheatars = inTheatars;
        this.posterPicturePath = posterPicturePath;
    }

    public Movie(int id, String title, LocalDateTime publishedDateTime, String description, int duration, List<Actor> actors, String genre, String link, LocalDate inTheatars, String posterPicturePath) {
        this(title, publishedDateTime, description, duration, actors, genre, link, inTheatars, posterPicturePath);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishedDateTime() {
        return publishedDateTime;
    }

    public void setPublishedDateTime(LocalDateTime publishedDateTime) {
        this.publishedDateTime = publishedDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getInTheatars() {
        return inTheatars;
    }

    public void setInTheatars(LocalDate inTheatars) {
        this.inTheatars = inTheatars;
    }

    public String getPosterPicturePath() {
        return posterPicturePath;
    }

    public void setPosterPicturePath(String posterPicturePath) {
        this.posterPicturePath = posterPicturePath;
    }

    @Override
    public String toString() {
        return id + " " + title;
    }
    
    
    
}
