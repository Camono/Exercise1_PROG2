package at.ac.fhcampuswien.fhmdb;


import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeControllerTest {

    @BeforeEach
    void setUp() {

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


}