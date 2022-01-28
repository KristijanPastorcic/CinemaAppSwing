/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.parsers.rss.cinestar;

import hr.algebra.factories.ParserFactory;
import hr.algebra.factories.URLConnectionFactory;
import hr.algebra.utilities.FileUtils;
import hr.kpastorcic11.models.Actor;
import hr.kpastorcic11.models.Director;
import hr.kpastorcic11.models.Movie;
import hr.kpastorcic11.models.Person;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author islan
 */
public class CinestarRSSParser {

    private static final String EXSTENSION = ".jpg";
    private static final String DIR = "assets";

    private static final String RSS_URL = "https://www.blitz-cinestar.hr/rss.aspx?najava=1";

    private CinestarRSSParser() {

    }

    public static List<Movie> getMovies(JProgressBar progresBarr, JLabel progers, boolean progresBarEnabled) throws IOException, XMLStreamException {
        List<Movie> movies = new ArrayList<>();

        HttpURLConnection http
                = URLConnectionFactory.createHttpURLConnection(RSS_URL);

        try (InputStream is = http.getInputStream()) {
            XMLEventReader reader = ParserFactory.createStaxParser(is);

            StartElement startElement = null;
            Movie movie = null;
            Optional<Tag> tagOptional = null;

            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        startElement = event.asStartElement();
                        String tagName = startElement.getName().getLocalPart();
                        tagOptional = Tag.from(tagName);
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (tagOptional.isPresent()) {
                            if (tagOptional.get() == Tag.ITEM) {
                                movie = new Movie();
                                movies.add(movie);
                                if (progresBarEnabled) {
                                    progresBarr.setValue(movies.size());
                                    long percent;
                                    percent = Math.round(
                                            progresBarr
                                                    .getPercentComplete() * 100);
                                    progers.setText(
                                            String.valueOf(percent) + "%"
                                    );
                                }
                                break;
                            }
                            if (movie != null) {
                                String data = event.asCharacters().getData().trim();
                                if (data.isEmpty() == false) {
                                    parse(tagOptional.get(), data, movie);
                                }
                            }

                        }
                        break;

                }
            }
        }
        return movies;
    }

    private static void parse(Tag tag, String data, Movie movie) {
        switch (tag) {
            case TITLE:
                movie.setTitle(data);
                break;
            case PUB_DATE:
                LocalDateTime dateTime = LocalDateTime.parse(data, DateTimeFormatter.RFC_1123_DATE_TIME);
                movie.setPublishedDateTime(dateTime);
                break;
            case DESCRIPTION:
                StringBuilder sb = new StringBuilder(data.replace("<br />", System.lineSeparator()));
                sb.delete(0, sb.indexOf(">") + 1);
                sb.delete(0, sb.indexOf(">") + 1);
                recursiveDeleteFromEndToLastIndex(sb, "<");
                String desc = sb.toString();
                movie.setDescription(desc);
                break;
            case REDATELJ:
                String[] directors = data.split(", ");
                List<Director> directorsList = new ArrayList<>();
                for (String person : directors) {
                    String[] split = person.split(" ");
                    if (split.length == 1) {
                        directorsList.add(new Director(
                                split[0], ""
                        ));
                        continue;
                    }
                    if (split.length > 1) {
                        String name = "";
                        for (int i = 0; i < split.length - 1; i++) {
                            name += split[i] + " ";
                        }
                        directorsList.add(new Director(name, split[split.length - 1]));
                        continue;
                    }
                    directorsList.add(new Director(
                            split[0], split[1]
                    ));
                }
                movie.setDirectors(directorsList);
                break;
            case GLUMCI:
                String[] actors = data.split(", ");
                List<Actor> actorsList = new ArrayList<>();
                for (String person : actors) {
                    String[] split = person.split(" ");
                    if (split.length == 1) {
                        actorsList.add(new Actor(
                                split[0], ""
                        ));
                        continue;
                    }
                    if (split.length > 1) {
                        String name = "";
                        for (int i = 0; i < split.length - 1; i++) {
                            name += split[i] + " ";
                        }
                        actorsList.add(new Actor(name, split[split.length - 1]));
                        continue;
                    }
                    actorsList.add(new Actor(
                            split[0], split[1]
                    ));
                }
                movie.setActors(actorsList);
                break;
            case TRAJANJE:
                movie.setDuration(Integer.parseInt(data));
                break;
            case ZANR:
                movie.setGenre(data);
                break;
            case PLAKAT_LINK:
                getPictureFromURL(movie, data);
                break;
            case LINK:
                movie.setLink(data);
                break;
            case POCETAK:
                String day = data.substring(0, data.indexOf("."));
                String year = data.substring(data.lastIndexOf(".") + 1, data.length());
                String month = data.substring(data.indexOf(".") + 1, data.lastIndexOf("."));
                LocalDate localDate = LocalDate.of(
                        Integer.parseInt(year),
                        Integer.parseInt(month),
                        Integer.parseInt(day));
                movie.setInTheatars(localDate);
                break;
        }
    }

    private static List<Person> getPersons(String[] data) {
        List<Person> list = new ArrayList<>();
        for (String person : data) {
            String[] split = person.split(" ");
            if (split.length == 1) {
                list.add(new Person(
                        split[0], ""
                ));
                continue;
            }
            if (split.length > 1) {
                String name = "";
                for (int i = 0; i < split.length - 1; i++) {
                    name += split[i] + " ";
                }
                list.add(new Person(name, split[split.length - 1]));
                continue;
            }
            list.add(new Person(
                    split[0], split[1]
            ));
        }
        return list;
    }

    private static void recursiveDeleteFromEndToLastIndex(StringBuilder sb, String s) {
        if (sb.toString().contains(s)) {
            sb.delete(sb.lastIndexOf(s), sb.length());
            recursiveDeleteFromEndToLastIndex(sb, s);
        }
    }

    private static void getPictureFromURL(Movie movie, String url) {
        try {
            String extension = url.substring(url.lastIndexOf(".")); //.jpg
            if (extension.length() > 5) {
                extension = EXSTENSION;
            }

            String pictureName = UUID.randomUUID() + extension;
            String picturePath = DIR + File.separator + pictureName;

            FileUtils.copyFromURL(url, picturePath);

            movie.setPosterPicturePath(picturePath);
        } catch (IOException ex) {
            movie.setPosterPicturePath("");
            ex.printStackTrace();
        }
    }

    private enum Tag {
        ITEM("item"),
        TITLE("title"),
        LINK("link"),
        DESCRIPTION("description"),
        PUB_DATE("pubDate"),
        REDATELJ("redatelj"),
        GLUMCI("glumci"),
        TRAJANJE("trajanje"),
        ZANR("zanr"),
        PLAKAT_LINK("plakat"),
        POCETAK("pocetak");

        private String tag;

        private Tag(String value) {
            this.tag = value;
        }

        public static Optional<Tag> from(String tagName) {
            for (Tag value : values()) {
                if (value.tag == tagName) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }

        @Override
        public String toString() {
            return tag;
        }

    }

}
