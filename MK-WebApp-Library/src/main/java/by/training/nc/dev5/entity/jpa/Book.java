package by.training.nc.dev5.entity.jpa;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
