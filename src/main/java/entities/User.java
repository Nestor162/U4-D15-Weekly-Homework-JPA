package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String surname;
	private String addres;
	@Column(length = 319)
	private String email;
	private String phoneNumber;
	private LocalDate registrationDate;

	@OneToMany(mappedBy = "user")
	private Set<Loan> loans;

	public User(String name, String surname, String addres, String email,
			String phoneNumber, LocalDate registrationDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.addres = addres;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", addres=" + addres + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", registrationDate=" + registrationDate + "]";
	}

}
