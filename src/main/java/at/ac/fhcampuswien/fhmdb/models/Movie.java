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
                new Movie("The Chronicles of Narnia: The Lion, the Witch and the Wardrobe", "Four siblings discover a magical wardrobe that leads them to the land of Narnia, where they must help the lion Aslan defeat the White Witch.", Arrays.asList(Genre.FANTASY, Genre.ADVENTURE, Genre.FAMILY)),
                new Movie("Inception", "A skilled thief enters the dreams of others to steal their secrets, but his latest mission involves planting an idea into someone's mind.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION)),
                new Movie("Toy Story", "A group of toys comes to life when their owner is not around, and they embark on exciting adventures while trying to avoid being replaced.", Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY)),
                new Movie("The Shawshank Redemption", "Two imprisoned men bond over several years, finding solace and eventual redemption through acts of common decency.", Arrays.asList(Genre.DRAMA, Genre.CRIME)),
                new Movie("Jurassic Park", "A billionaire invites a group of scientists to his theme park filled with genetically engineered dinosaurs, but things go awry when the creatures escape.", Arrays.asList(Genre.ADVENTURE, Genre.SCIENCE_FICTION, Genre.THRILLER)),
                new Movie("Forrest Gump", "The story of a man with a low IQ who accomplishes great things in his life despite facing many challenges.", Arrays.asList(Genre.COMEDY, Genre.DRAMA, Genre.ROMANCE)),
                new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", Arrays.asList(Genre.CRIME, Genre.DRAMA)),
                new Movie("Finding Nemo", "A clownfish embarks on a journey across the ocean to find his son, who has been captured by a diver.", Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY)),
                new Movie("Star Wars: Episode IV - A New Hope", "A young farm boy joins a group of rebels to save the galaxy from the evil Empire and its powerful Death Star.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)),
                new Movie("The Dark Knight", "Batman faces off against the Joker, a criminal mastermind determined to create chaos in Gotham City.", Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.DRAMA)),
                new Movie("The Lion King", "A young lion prince flees his kingdom only to learn the true meaning of responsibility and bravery.", Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.FAMILY)),
                new Movie("The Matrix", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", Arrays.asList(Genre.ACTION, Genre.SCIENCE_FICTION)),
                new Movie("Titanic", "A young couple's love blossoms on the ill-fated maiden voyage of the R.M.S. Titanic.", Arrays.asList(Genre.DRAMA, Genre.ROMANCE)),
                new Movie("Indiana Jones and the Raiders of the Lost Ark", "Archaeologist and adventurer Indiana Jones races against Nazis to find the Ark of the Covenant.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE)),
                new Movie("Avatar", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY)),
                new Movie("Schindler's List", "In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.", Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.HISTORY)),
                new Movie("Jiro Dreams of Sushi", "A documentary about 85-year-old Jiro Ono, considered by many to be the world's greatest sushi chef.", Arrays.asList(Genre.DOCUMENTARY)),
                new Movie("Braveheart", "A historical drama depicting the life of William Wallace, a Scottish warrior who led the Scots in the First War of Scottish Independence against King Edward I of England.", Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.HISTORY, Genre.WAR)),
                new Movie("The Shining", "A family heads to an isolated hotel for the winter where a sinister presence influences the father into violence, while his psychic son sees horrific forebodings from both past and future.", Arrays.asList(Genre.HORROR)),
                new Movie("The Sound of Music", "A woman leaves an Austrian convent to become a governess to the children of a Naval officer widower.", Arrays.asList(Genre.BIOGRAPHY, Genre.MUSICAL)),
                new Movie("Gone Girl", "With his wife's disappearance having become the focus of an intense media circus, a man sees the spotlight turned on him when it's suspected that he may not be innocent.", Arrays.asList(Genre.MYSTERY, Genre.THRILLER)),
                new Movie("Raging Bull", "The life of boxer Jake LaMotta, whose violence and temper that led him to the top in the ring destroyed his life outside of it.", Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.SPORT)),
                new Movie("Saving Private Ryan", "Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.", Arrays.asList(Genre.ACTION, Genre.DRAMA, Genre.WAR)),
                new Movie("Django Unchained", "With the help of a German bounty hunter, a freed slave sets out to rescue his wife from a brutal Mississippi plantation owner.", Arrays.asList(Genre.WESTERN, Genre.DRAMA))
        );
        return movies;
    }
}
