package entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "publications")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "publicationType")
public abstract class Publication {
	@Id
	protected String ISBN;
	protected String title;
	protected int publicationYear;
	protected int numPages;

	protected Publication(String ISBN, String title, int publicationYear,
			int numPages) {
		this.ISBN = ISBN;
		this.title = title;
		this.publicationYear = publicationYear;
		this.numPages = numPages;
	}
}
