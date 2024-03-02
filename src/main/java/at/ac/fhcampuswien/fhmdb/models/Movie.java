package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres) {
        setTitle(title);
        setDescription(description);
        setGenres(genres);
    }

    public void setTitle(String title) {
        if(title != null) {
            this.title = title;
        }
    }

    public void setDescription(String description) {
        if(description != null) {
            this.description = description;
        }
    }

    public void setGenres(List<Genre> genres) {
        if(genres != null) {
            this.genres = genres;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }
    public static List<Movie> initializeMovies(){
        List<Movie> movies = Arrays.asList(
                new Movie("The Lord of the Rings", "A young hobbit, Frodo Baggins, embarks on a perilous journey to destroy a powerful ring and save Middle-earth from the Dark Lord Sauron.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)),
                new Movie("Inception",  "A thief who enters the dreams of others to steal secrets from their subconscious is tasked with planting an idea into the mind of a CEO.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.MYSTERY)),
                new Movie("The Matrix", "A computer programmer discovers that the world around him is a simulated reality created by sentient machines, and joins a rebellion against them.", Arrays.asList(Genre.ACTION, Genre.SCIENCE_FICTION)),
                new Movie("The Dark Knight", "Batman faces off against a criminal mastermind known as the Joker, who seeks to create chaos and anarchy in Gotham City.", Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.DRAMA)),
                new Movie("Jurassic Park", "A group of scientists and tourists visit a theme park populated by genetically engineered dinosaurs, but the park's security systems fail, leading to chaos.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION)),
                new Movie("Avatar",  "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)),
                new Movie("The Avengers", "Earth's mightiest heroes, including Iron Man, Captain America, Thor, and the Hulk, must come together to stop the villainous Loki and his army from enslaving humanity.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION)),
                new Movie("Pirates of the Caribbean", "Captain Jack Sparrow sets sail on a quest to find the legendary Black Pearl, encountering cursed pirates and supernatural forces along the way.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)),
                new Movie("The Lord of the Rings: The Fellowship of the Ring",  "Frodo Baggins sets out to destroy an ancient ring that threatens to plunge the world into darkness, accompanied by a fellowship of diverse allies.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)),
                new Movie("The Lion King",  "A young lion prince flees his kingdom only to learn the true meaning of responsibility and bravery.", Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.DRAMA))
        );
        return movies;
    }
}
