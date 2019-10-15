import java.util.ArrayList;


public class Movie {
	
	private String movieID;
	private String title;
	private String director;
	private String year;
	private ArrayList<String> genreList;
	private String rating;
	
	
	public Movie(String movieID, String title, String director, String year, ArrayList<String> genreList,
			String rating) {
		this.movieID = movieID;
		this.title = title;
		this.director = director;
		this.year = year;
		this.genreList = genreList;
		this.rating = rating;
	}
	
	

	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public ArrayList<String> getGenreList() {
		return genreList;
	}
	
	public void setGenreList(ArrayList<String> genreList) {
		this.genreList =  genreList;
	}



	@Override
	public String toString() {
		
		String genre ="";
		
		for(int i = 0; i< genreList.size(); i++){

			genre = genre.concat((genreList.get(i))+", ");

			}
		return "Movie"+" Title: " + title +", movieID: " + movieID +  ", Director: " + director + ", Released Year:" + year
				+ ", Genre: " + genre + " Rating:" + rating ;
	}



}
