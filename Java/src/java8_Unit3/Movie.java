package java8_Unit3;

public class Movie {

	String title;
	int likes;
	Genre genre;

	public Movie(String title, int likes, Genre genre) {
		super();
		this.title = title;
		this.likes = likes;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", likes=" + likes + ", genre=" + genre + "]";
	}

}