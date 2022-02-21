package dev.nhaiden.personinterest.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "interest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Interest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", unique = true)
    private String description;

   /* @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    */
}
