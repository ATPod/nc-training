package by.training.nc.dev5.entity.jpa;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NamedQueries( {@NamedQuery(name = "Loan.selectAll", query = "SELECT l FROM loans l ")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "loans")
public class Loan {

    @Id
    @Column(name = "id" ,nullable = false, unique = true)
    private int id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book")
    private Book book;

    @Column(name = "loan_type")
    private String loanType;


}
