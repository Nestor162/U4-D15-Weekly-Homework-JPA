package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate loanDate;
	private LocalDate expectedReturnDate;
	private LocalDate returnedDate;

	@ManyToOne
	@JoinColumn(name = "publication_id")
	private Publication publication;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User users;

	@Override
	public String toString() {
		return "Loan [id=" + id + ", loanDate=" + loanDate
				+ ", expectedReturnDate=" + expectedReturnDate
				+ ", returnedDate=" + returnedDate + "]";
	}

	public Loan(LocalDate loanDate, LocalDate returnedDate) {

		this.loanDate = loanDate;
		this.expectedReturnDate = loanDate.plusDays(30);
		this.returnedDate = returnedDate;
	}

}
