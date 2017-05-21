package by.training.nc.dev5.entity.jdbc;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Loan {

    private int id;
    private User user;
    private Book book;
    private String loanType;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", book=" + book.getTitle() +
                ", loanType='" + loanType + '\'' +
                '}';
    }
}
