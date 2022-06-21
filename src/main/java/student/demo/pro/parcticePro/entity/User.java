package student.demo.pro.parcticePro.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_table")
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private Date date;
}

