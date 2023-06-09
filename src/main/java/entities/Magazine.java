package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Magazine")
public class Magazine extends Publication {
	public enum publicationFrequency {
		WEEKLY, MONTHLY, SEMIANNUAL
	}

	@Enumerated(EnumType.STRING)
	private publicationFrequency frequency;

	public Magazine(String ISBN, String title, int publicationYear,
			int numPages, publicationFrequency frequency) {

		super(ISBN, title, publicationYear, numPages);
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Magazine [frequency=" + frequency + "]";
	}

}
