import java.util.ArrayList;
import java.util.Hashtable;

public class MovieList {
	
	ArrayList<Movie> movieList;

	public MovieList() {
		movieList = new  ArrayList<Movie>();

	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
}
