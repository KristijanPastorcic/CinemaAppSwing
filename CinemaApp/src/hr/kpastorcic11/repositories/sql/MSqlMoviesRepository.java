/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.repositories.sql;

import hr.kpastorcic11.factories.DataSourceFactory;
import hr.kpastorcic11.models.Actor;
import hr.kpastorcic11.models.Director;
import hr.kpastorcic11.models.Movie;
import hr.kpastorcic11.models.Person;
import hr.kpastorcic11.repositories.interfaces.MoviesRepository;
import hr.kpastorcic11.roles.enums.MovieRole;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author islan
 */
public class MSqlMoviesRepository implements MoviesRepository {

    private static final String ID_PERSON = "IDPerson";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";

    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String PUB_DATETIME = "PublishedDateTime";
    private static final String DESCRIPTION = "Description";
    private static final String DURATION = "Duration";
    private static final String GENRE = "Genre";
    private static final String LINK = "Link";
    private static final String IN_THEATARS = "InTheatars";
    private static final String POSTER_PICTURE_PATH = "PosterPicturePath";

    private static final String IMPORT_MOVIES = "{ CALL importMovies (?,?,?,?,?,?,?,?,?) }";
    private static final String CREATE_PERSON_WITH_MOVIE_ROLE = "{ CALL createPersonWithMovieAndRole (?,?,?,?) }";
    private static final String GET_MOVIE_ROLE_PERSON = "{ CALL getMovieRolePerson (?,?) }";
    private static final String GET_MOVIES = "{ CALL getMovies }";

    @Override
    public boolean importMovies(List<Movie> movies) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmtMovie = conn.prepareCall(IMPORT_MOVIES)) {

            for (Movie movie : movies) {
                stmtMovie.setString(1, movie.getTitle());
                stmtMovie.setString(2,
                        movie.getPublishedDateTime()
                                .format(Movie.DATE_TIME_FORMATTER));
                stmtMovie.setString(3, movie.getDescription());
                stmtMovie.setInt(4, movie.getDuration());
                stmtMovie.setString(5, movie.getGenre());
                stmtMovie.setString(6, movie.getLink());
                stmtMovie.setString(7, movie.getInTheatars()
                        .format(Movie.DATE_FORMAT));
                stmtMovie.setString(8, movie.getPosterPicturePath());
                stmtMovie.registerOutParameter(9, Types.INTEGER);
                stmtMovie.executeUpdate();
                int idMovie = stmtMovie.getInt(9);

                if (movie.getDirectors() != null) {
                    try (CallableStatement stmt
                            = conn.prepareCall(CREATE_PERSON_WITH_MOVIE_ROLE)) {
                        for (Director director : movie.getDirectors()) {
                            stmt.setString(1, director.getFirstName());
                            stmt.setString(2, director.getLastName());
                            stmt.setInt(3, idMovie);
                            stmt.setString(4, MovieRole.DIRECTOR.toString());
                            stmt.addBatch();
                        }
                        stmt.executeBatch();
                    }

                }

                List<Actor> actors = movie.getActors();
                if (actors != null) {
                    try (CallableStatement stmt
                            = conn.prepareCall(CREATE_PERSON_WITH_MOVIE_ROLE)) {
                        for (Actor actor : movie.getActors()) {
                            stmt.setString(1, actor.getFirstName());
                            stmt.setString(2, actor.getLastName());
                            stmt.setInt(3, idMovie);
                            stmt.setString(4, MovieRole.ACTOR.toString());
                            stmt.addBatch();
                        }
                        stmt.executeBatch();
                    }
                }

            }
        }
        return true;
    }

    @Override
    public List<Movie> getMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_MOVIES);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int idMovie = rs.getInt(ID_MOVIE);

                List<Director> directors = (List<Director>) (List<?>) getPersonInMovieRole(conn, idMovie, MovieRole.DIRECTOR);
                List<Actor> actors = (List<Actor>) (List<?>) getPersonInMovieRole(conn, idMovie, MovieRole.ACTOR);

                movies.add(new Movie(
                        idMovie,
                        rs.getString(TITLE),
                        LocalDateTime.parse(rs.getString(PUB_DATETIME),
                                Movie.DATE_TIME_FORMATTER),
                        rs.getString(DESCRIPTION),
                        rs.getInt(DURATION),
                        directors, actors,
                        rs.getString(GENRE),
                        rs.getString(LINK),
                        LocalDate.parse(rs.getString(IN_THEATARS),
                                Movie.DATE_FORMAT),
                        rs.getString(POSTER_PICTURE_PATH)));

            }
        }

        return movies;
    }

    public List<Person> getPersonInMovieRole(final Connection conn, int idMovie, MovieRole role) throws SQLException {
        List<Person> persons = new ArrayList<>();
        try (CallableStatement stmt
                = conn.prepareCall(GET_MOVIE_ROLE_PERSON)) {
            stmt.setInt(1, idMovie);
            stmt.setString(2, role.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    persons.add(new Director(
                            rs.getInt(ID_PERSON),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)
                    ));
                }
            }
        }
        return persons;
    }

}
