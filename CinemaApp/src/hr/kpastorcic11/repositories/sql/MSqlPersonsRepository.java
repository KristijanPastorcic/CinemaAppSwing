/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.repositories.sql;

import hr.kpastorcic11.factories.DataSourceFactory;
import hr.kpastorcic11.models.Movie;
import hr.kpastorcic11.models.Person;
import hr.kpastorcic11.repositories.interfaces.PersonsRepository;
import hr.kpastorcic11.roles.enums.MovieRole;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author islan
 */
public class MSqlPersonsRepository implements PersonsRepository {

    private static final String ID_PERSON = "IDPerson";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String MOVIE_ROLE = "MovieRole";

    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String PUB_DATETIME = "PublishedDateTime";
    private static final String DESCRIPTION = "Description";
    private static final String DURATION = "Duration";
    private static final String GENRE = "Genre";
    private static final String LINK = "Link";
    private static final String IN_THEATARS = "InTheatars";
    private static final String POSTER_PICTURE_PATH = "PosterPicturePath";

    private static final String GET_PERSON = "{ CALL getPerson (?) }";
    private static final String GET_PERSONS = "{ CALL getPersons }";
    private static final String CREATE_PERSON = "{ CALL createPerson (?,?,?) }";
    private static final String UPDATE_PERSON = "{ CALL updatePerson (?,?,?,?) }";
    private static final String DELETE_PERSON = "{ CALL deletePerson (?) }";
    private static final String GET_MOVIES = "{ CALL getMoviesForPerson (?) }";

    @Override
    public void createPerson(Person person) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(CREATE_PERSON)) {

            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getMovieRole().toString());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Person> getPersons() throws Exception {
        List<Person> persons = new ArrayList<>();
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_PERSONS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                persons.add(new Person(
                        rs.getInt(ID_PERSON),
                        rs.getString(FIRST_NAME),
                        rs.getString(LAST_NAME),
                        MovieRole.valueOf(rs.getString(MOVIE_ROLE).toUpperCase())
                ));
            }
        }
        return persons;
    }

    @Override
    public void updatePerson(Person person) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(UPDATE_PERSON)) {

            stmt.setInt(1, person.getId());
            stmt.setString(2, person.getFirstName());
            stmt.setString(3, person.getLastName());
            stmt.setString(4, person.getMovieRole().toString());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletePerson(int id) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(DELETE_PERSON)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Person> getPerson(int id) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_PERSON)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Person(
                            rs.getInt(ID_PERSON),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME),
                            MovieRole.valueOf(rs.getString(MOVIE_ROLE).toUpperCase())
                    ));
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    @Override
    public List<Movie> getMovies(int id) throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_MOVIES)) {

            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idMovie = rs.getInt(ID_MOVIE);

                    movies.add(new Movie(
                            idMovie,
                            rs.getString(TITLE),
                            LocalDateTime.parse(rs.getString(PUB_DATETIME),
                                    Movie.DATE_TIME_FORMATTER),
                            rs.getString(DESCRIPTION),
                            rs.getInt(DURATION),
                            new ArrayList<Person>(), new ArrayList<Person>(),
                            rs.getString(GENRE),
                            rs.getString(LINK),
                            LocalDate.parse(rs.getString(IN_THEATARS),
                                    Movie.DATE_FORMAT),
                            rs.getString(POSTER_PICTURE_PATH)));

                }
            }
        }

        return movies;
    }

}
