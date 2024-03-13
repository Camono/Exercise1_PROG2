package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    @FXML
    public JFXButton clearBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // add dummy data to observable list
        observableMovies.addAll(allMovies);

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll(Genre.values());

        // add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        //case 1: only genre set via dropdown
        //case 2: only search via textbox
        //case 3: both are set
        //case 4: none is set

        searchBtn.setOnAction(actionEvent -> {
            String filterItem = genreComboBox.getValue() != null ? genreComboBox.getValue().toString() : "ALL";
            String filterSearch = searchField.getText().toLowerCase();
            movieListView.setItems(filter(filterItem, filterSearch, observableMovies));
        });

        // Clear button to clear filters:
        clearBtn.setOnAction(actionEvent -> clear(observableMovies));

        // Sort button:
        sortBtn.setOnAction(actionEvent -> {
            movieListView.setItems(sort(observableMovies, sortBtn.getText()));
            sortBtn.setText(getInvertedSortButtonText(sortBtn.getText()));
        });
    }

    public ObservableList<Movie> filter(String filterItem, String filterSearch, ObservableList<Movie> allMovies) {
        if (filterItem == null || "ALL".equals(filterItem)) {
            // If nothing is selected display all movies based on search
            return allMovies.filtered(a ->
                    a.getTitle().toLowerCase().contains(filterSearch) ||
                            a.getDescription().toLowerCase().contains(filterSearch));
        } else {
            // Filter based on the selected genre
            return  allMovies.filtered(a ->
                    a.getGenres().contains(Genre.valueOf(filterItem)) &&
                            (a.getTitle().toLowerCase().contains(filterSearch) ||
                                    a.getDescription().toLowerCase().contains(filterSearch)));
        }
    }

    public void clear(ObservableList<Movie> allMovies) {
        movieListView.setItems(allMovies);
        genreComboBox.getSelectionModel().clearSelection();
        searchField.clear();
    }

    public ObservableList<Movie> sort(ObservableList<Movie> allMovies, String sortBtnText) {
        Comparator<Movie> sort = Comparator.comparing(Movie::getTitle);
        if (sortBtnText.equals("Sort (desc)")) {
            // sort observableMovies ascending
            sort = sort.reversed();
        }
        return allMovies.sorted(sort);
    }

    public String getInvertedSortButtonText(String text) {
        if (text.equals("Sort (asc)")) {
            return ("Sort (desc)");
        } else {
            return ("Sort (asc)");
        }
    }
}