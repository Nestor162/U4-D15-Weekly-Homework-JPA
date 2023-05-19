package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Book")
public class Book extends Publication {
	private String author;
	private String genre;

	public Book(String ISBN, String title, int publicationYear, int numPages,
			String author, String genre) {
		super(ISBN, title, publicationYear, numPages);
		this.author = author;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", genre=" + genre + "]";
	}

}
