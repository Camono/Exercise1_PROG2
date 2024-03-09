package at.ac.fhcampuswien.fhmdb;


import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    Movie testmovie;
    @BeforeEach
    void setUp() {
        testmovie = new Movie("Scarface", "Tony Montana goes to Miami", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.CRIME));
    }

    @Test
    void shouldSetTitle(){
        String newTitle = "Updated Title";
        testmovie.setTitle(newTitle);
        assertEquals(testmovie.getTitle(), newTitle);
    }

    @Test
    void shouldSetDescription(){
        String newDescription = "Updated description";
        testmovie.setDescription(newDescription);
        assertEquals(testmovie.getDescription(), newDescription);
    }

    @Test
    void shouldSetGenres(){
        var newGenres = Arrays.asList(Genre.FAMILY);
        testmovie.setGenres(newGenres);
        assertEquals(testmovie.getGenres(), newGenres);
    }

    @Test
    void shouldThrowExceptionForInvalidTitleEmpty(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testmovie.setTitle("");
        });
        String message = "Invalid title";
        assertEquals(exception.getMessage(), message);
    }
    @Test
    void shouldThrowExceptionForInvalidTitleNull(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testmovie.setTitle(null);
        });
        String message = "Invalid title";
        assertEquals(exception.getMessage(), message);
    }

    @Test
    void shouldThrowExceptionForInvalidDescriptionEmpty(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testmovie.setDescription("");
        });
        String message = "Invalid description";
        assertEquals(exception.getMessage(), message);
    }
    @Test
    void shouldThrowExceptionForInvalidDescriptionNull(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testmovie.setDescription(null);
        });
        String message = "Invalid description";
        assertEquals(exception.getMessage(), message);
    }

    @Test
    void shouldThrowExceptionForInvalidGenreNull(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testmovie.setGenres(null);
        });
        String message = "Invalid genre";
        assertEquals(exception.getMessage(), message);
    }
    @Test
    void shouldThrowExceptionForInvalidGenreEmpty(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testmovie.setGenres(Arrays.asList());
        });
        String message = "Invalid genre";
        assertEquals(exception.getMessage(), message);
    }

    @Test
    void all_movies_are_displayed(){
        //Arrange
        List<Movie> allMovies = Movie.initializeMovies();
        //Act
        int actual = allMovies.size();
        //Assert
        assertEquals(24, actual);
    }

    @Test
    void comboBoxFilter_BIOGRAPHY_shows_filtered_content(){
        // Arrange
        List<Movie> allMovies = Movie.initializeMovies();
        Genre targetGenre = Genre.BIOGRAPHY;
        // Act
        List<Movie> filteredMovies = allMovies.stream()
                .filter(movie -> movie.getGenres().contains(targetGenre))
                .toList();
        // Assert
        assertEquals(4, filteredMovies.size(), "Expected 4 movies with BIOGRAPHY genre filter");
    }

    @Test
    void searchField_filter_checks_for_specific_title(){
        // Arrange
        List<Movie> allMovies = Movie.initializeMovies();
        String targetTitle = "Schin";
        // Act
        List<Movie> filteredMovies = allMovies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(targetTitle.toLowerCase()))
                .toList();
        // Assert
        assertEquals(1, filteredMovies.size(), "Expected 1 movies with 'Schin' in the title");
    }

    @Test
    void searchField_filter_checks_for_keywords_in_description(){
        // Arrange
        List<Movie> allMovies = Movie.initializeMovies();
        String targetDescriptionKeyword = "group";
        // Act
        List<Movie> filteredMovies = allMovies.stream()
                .filter(movie -> movie.getDescription().toLowerCase().contains(targetDescriptionKeyword.toLowerCase()))
                .toList();
        // Assert
        assertEquals(4, filteredMovies.size(), "Expected 4 movies with 'group' in the description");
    }

    @Test
    void check_if_search_is_case_sensitive(){
        // Arrange
        List<Movie> allMovies = Movie.initializeMovies();
        String targetDescriptionKeyword = "JOURNEY";
        // Act
        List<Movie> filteredMovies = allMovies.stream()
                .filter(movie -> movie.getDescription().toLowerCase().contains(targetDescriptionKeyword.toLowerCase()))
                .toList();
        // Assert
        assertEquals(1, filteredMovies.size(), "Expected 1 movie with 'JOURNEY' in the description with case-insensitive search");
        assertEquals("A clownfish embarks on a journey across the ocean to find his son, who has been captured by a diver.", filteredMovies.get(0).getDescription(), "Description mismatch");
    }

    @Test
    void check_if_title_is_case_sensitive(){
        // Arrange
        List<Movie> allMovies = Movie.initializeMovies();
        String targetDescriptionKeyword = "NaRnIA";
        // Act
        List<Movie> filteredMovies = allMovies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(targetDescriptionKeyword.toLowerCase()))
                .toList();
        // Assert
        assertEquals(1, filteredMovies.size(), "Expected 1 movie with 'Narnia' in the title with case-insensitive search");
        assertEquals("The Chronicles of Narnia: The Lion, the Witch and the Wardrobe", filteredMovies.get(0).getTitle(), "Title mismatch");
    }

    @Test
    void sortListAscending_check_if_sorted_correctly_equals() {
        // Arrange
        Comparator<Movie> sort = Comparator.comparing(Movie::getTitle);
        ObservableList<Movie> observableMovies = FXCollections.observableArrayList(new Movie("A", "asdf", List.of(Genre.ACTION)),
                new Movie("C", "ASD", List.of(Genre.COMEDY)),
                new Movie("B", "asd", List.of(Genre.BIOGRAPHY)));
        // Act with same logic from onAction
        ObservableList<Movie> sortedMovies = observableMovies.sorted(sort);
        // Assert
        assertEquals(observableMovies.get(0), sortedMovies.get(0), "Movie A is expected to be the first movie in the list.");
        assertEquals(observableMovies.get(1), sortedMovies.get(2), "Movie C is expected to be the last movie in the list.");
    }

    @Test
    void sortListAscending_check_if_sorted_correctly_notEquals() {
        // Arrange
        Comparator<Movie> sort = Comparator.comparing(Movie::getTitle);
        ObservableList<Movie> observableMovies = FXCollections.observableArrayList(new Movie("B", "asdf", List.of(Genre.BIOGRAPHY)),
                new Movie("C", "ASD", List.of(Genre.COMEDY)),
                new Movie("A", "asd", List.of(Genre.ACTION)));
        // Act with same logic from onAction
        ObservableList<Movie> sortedMovies = observableMovies.sorted(sort);
        // Assert
        assertNotEquals(observableMovies.get(2), sortedMovies.get(2), "Movie A is expected to not be the last movie in sorted list.");
        assertNotEquals(observableMovies.get(0), sortedMovies.get(0), "Movie B is expected to not be the first movie in sorted list.");
    }

    @Test
    void sortListDescending_check_if_sorted_correctly_equals() {
        // Arrange
        Comparator<Movie> sort = Comparator.comparing(Movie::getTitle).reversed();
        ObservableList<Movie> observableMovies = FXCollections.observableArrayList(new Movie("A", "asdf", List.of(Genre.ACTION)),
                new Movie("C", "ASD", List.of(Genre.COMEDY)),
                new Movie("B", "asd", List.of(Genre.BIOGRAPHY)));
        // Act with same logic from onAction
        ObservableList<Movie> sortedMovies = observableMovies.sorted(sort);
        // Assert
        assertEquals(observableMovies.get(0), sortedMovies.get(2), "Movie A is expected to be the last movie in the list.");
        assertEquals(observableMovies.get(1), sortedMovies.get(0), "Movie C is expected to be the first movie in the list.");
    }

    @Test
    void sortListDescending_check_if_sorted_correctly_notEquals() {
        // Arrange
        Comparator<Movie> sort = Comparator.comparing(Movie::getTitle).reversed();
        ObservableList<Movie> observableMovies = FXCollections.observableArrayList(new Movie("A", "asdf", List.of(Genre.ACTION)),
                new Movie("B", "ASD", List.of(Genre.BIOGRAPHY)),
                new Movie("C", "asd", List.of(Genre.COMEDY)));
        // Act with same logic from onAction
        ObservableList<Movie> sortedMovies = observableMovies.sorted(sort);
        // Assert
        assertNotEquals(observableMovies.get(0), sortedMovies.get(0), "Movie A is expected to not be the first movie in sorted list.");
        assertNotEquals(observableMovies.get(1), sortedMovies.get(2), "Movie B is expected to not be the last movie in sorted list.");
    }
}