/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.repositories.sql;

import hr.kpastorcic11.factories.DataSourceFactory;
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
import java.util.Optional;
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

    private static final String CREATE_MOVIE = "{ CALL createMovie (?,?,?,?,?,?,?,?,?) }";
    private static final String UPDATE_MOVIE = "{ CALL updateMovie (?,?,?,?,?,?,?,?,?) }";
    private static final String CREATE_PERSON_WITH_MOVIE_ROLE = "{ CALL createPersonWithMovieAndRole (?,?,?,?) }";
    private static final String GET_MOVIE_ROLE_PERSON = "{ CALL getMovieRolePerson (?,?) }";
    private static final String GET_MOVIES = "{ CALL getMovies }";
    private static final String GET_MOVIE = "{ CALL getMovie (?) }";
    private static final String DELETE_ALL_ACTORS_DIRECTORS = "{ CALL deleteAllActorsAndDirectorsForMovie (?) }";
    private static final String GET_MOVIE_ROLE_PERSONSSS = "{ CALL getMovieRolePersonssss (?) }";
    private static final String DELETE_MOVIE = "{ CALL deleteMovie (?) }";

    @Override
    public boolean importMovies(List<Movie> movies) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmtMovie = conn.prepareCall(CREATE_MOVIE)) {

            for (Movie movie : movies) {
                stmtMovie.setString(1, movie.getTitle());
                stmtMovie.setString(2,
                        movie.getPublishedDateTime()
                                .format(Movie.DATE_TIME_FORMATTER));
                stmtMovie.setString(3, movie.getDescription());
                stmtMovie.setInt(4, movie.getDuration());
                stmtMovie.setString(5, movie.getGenre());
                stmtMovie.setString(6, movie.getLink());
                stmtMovie.setString(7, movie.getInTheaters()
                        .format(Movie.DATE_FORMAT));
                stmtMovie.setString(8, movie.getPosterPicturePath());
                stmtMovie.registerOutParameter(9, Types.INTEGER);
                stmtMovie.executeUpdate();
                int idMovie = stmtMovie.getInt(9);

                if (movie.getDirectors() != null) {
                    insertPersonsWithMovieRole(conn, movie.getDirectors(),
                            idMovie, MovieRole.DIRECTOR);
                }

                if (movie.getActors() != null) {
                    insertPersonsWithMovieRole(conn, movie.getActors(),
                            idMovie, MovieRole.ACTOR);
                }

            }
        }
        return true;
    }

    public void insertPersonsWithMovieRole(final Connection conn, List<Person> persons, int idMovie, MovieRole role) throws SQLException {
        try (CallableStatement stmt
                = conn.prepareCall(CREATE_PERSON_WITH_MOVIE_ROLE)) {
            for (Person actor : persons) {
                stmt.setString(1, actor.getFirstName());
                stmt.setString(2, actor.getLastName());
                stmt.setInt(3, idMovie);
                stmt.setString(4, role.toString());
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
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

                List<Person> directors = getPersonInMovieRole(conn, idMovie, MovieRole.DIRECTOR);
                List<Person> actors = getPersonInMovieRole(conn, idMovie, MovieRole.ACTOR);

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

    private List<Person> getPersonInMovieRole(final Connection conn, int idMovie, MovieRole role) throws Exception {
        List<Person> persons = new ArrayList<>();
        try (CallableStatement stmt
                = conn.prepareCall(GET_MOVIE_ROLE_PERSON)) {
            stmt.setInt(1, idMovie);
            stmt.setString(2, role.toString());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    persons.add(new Person(
                            rs.getInt(ID_PERSON),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)
                    ));
                }
            }
        }
        return persons;
    }

    @Override
    public Optional<Movie> getMovie(int id) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_MOVIE)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idMovie = rs.getInt(ID_MOVIE);

                    List<Person> directors = getPersonInMovieRole(conn, idMovie, MovieRole.DIRECTOR);
                    List<Person> actors = getPersonInMovieRole(conn, idMovie, MovieRole.ACTOR);

                    return Optional.of(new Movie(
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
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    @Override
    public List<Person> getMovieRolePersonssss(MovieRole role) throws Exception {
        List<Person> persons = new ArrayList<>();
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(GET_MOVIE_ROLE_PERSONSSS)) {
            stmt.setString(1, role.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    persons.add(new Person(
                            rs.getInt(ID_PERSON),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)));
                }
            }
        }
        return persons;
    }

    @Override
    public int createMovie(Movie movie) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmtMovie = conn.prepareCall(CREATE_MOVIE)) {

            stmtMovie.setString(1, movie.getTitle());
            stmtMovie.setString(2,
                    movie.getPublishedDateTime()
                            .format(Movie.DATE_TIME_FORMATTER));
            stmtMovie.setString(3, movie.getDescription());
            stmtMovie.setInt(4, movie.getDuration());
            stmtMovie.setString(5, movie.getGenre());
            stmtMovie.setString(6, movie.getLink());
            stmtMovie.setString(7, movie.getInTheaters()
                    .format(Movie.DATE_FORMAT));
            stmtMovie.setString(8, movie.getPosterPicturePath());
            stmtMovie.registerOutParameter(9, Types.INTEGER);
            stmtMovie.executeUpdate();
            int idMovie = stmtMovie.getInt(9);

            insertPersonsWithMovieRole(conn, movie.getDirectors(),
                    idMovie, MovieRole.DIRECTOR);

            insertPersonsWithMovieRole(conn, movie.getActors(),
                    idMovie, MovieRole.ACTOR);
            return idMovie;
        }
    }

    @Override
    public void deleteMovie(Movie movie) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmt = conn.prepareCall(DELETE_MOVIE)) {

            stmt.setInt(1, movie.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void updateMovie(Movie movie) throws Exception {
        DataSource ds = DataSourceFactory.getLocalHostDataSource();
        try (Connection conn = ds.getConnection();
                CallableStatement stmtMovie = conn.prepareCall(UPDATE_MOVIE)) {

            stmtMovie.setInt(1, movie.getId());
            stmtMovie.setString(2, movie.getTitle());
            stmtMovie.setString(3,
                    movie.getPublishedDateTime()
                            .format(Movie.DATE_TIME_FORMATTER));
            stmtMovie.setString(4, movie.getDescription());
            stmtMovie.setInt(5, movie.getDuration());
            stmtMovie.setString(6, movie.getGenre());
            stmtMovie.setString(7, movie.getLink());
            stmtMovie.setString(8, movie.getInTheaters()
                    .format(Movie.DATE_FORMAT));
            stmtMovie.setString(9, movie.getPosterPicturePath());

            stmtMovie.executeUpdate();
            deleteAllActorsAndDirectorsForMovie(conn, movie.getId());

            if (movie.getDirectors() != null && !movie.getDirectors().isEmpty()) {
                insertPersonsWithMovieRole(conn, movie.getDirectors(),
                        movie.getId(), MovieRole.DIRECTOR);
            }

            if (movie.getActors() != null && !movie.getActors().isEmpty()) {
                insertPersonsWithMovieRole(conn, movie.getActors(),
                        movie.getId(), MovieRole.ACTOR);
            }
        }
    }

    private void deleteAllActorsAndDirectorsForMovie(Connection conn, int id) throws Exception {
        try (CallableStatement stmt
                = conn.prepareCall(DELETE_ALL_ACTORS_DIRECTORS)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
