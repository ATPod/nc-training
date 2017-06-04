package by.training.nc.dev5.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedQueries( {@NamedQuery(name = "Book.selectAll", query = "SELECT b FROM books b ")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="books")
public class Book  {

    @Id
    @Column(name = "id" ,nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "title" ,nullable = false)
    private String title;


}
