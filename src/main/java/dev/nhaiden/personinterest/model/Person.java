package dev.nhaiden.personinterest.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "person")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 29)
    @Column(name = "firstname")
    @NotEmpty
    @Pattern(regexp = "^[A-Z].{0,29}$", message = "Firstname has to begin with uppercase letters and can only include at most 29 unicode characters.")
    private String firstName;

    @Length(max = 29)
    @Column(name = "lastname")
    @NotEmpty
    @Pattern(regexp = "^[A-Z].{0,29}$", message = "Lastname has to begin with uppercase letters and can only include at most 29 unicode characters.")
    private String lastName;

    @PastOrPresent(message = "Date can't be in the future!")
    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Size(max = 3, message = "Can't have more than 3 interests")
    @ManyToMany
    @JoinTable(name = "interest_person", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "interest_id"))
    @ToString.Exclude
    private Set<Interest> interests = new HashSet<>();

    @Column(name = "sex")
    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    public List<String> getInterestsDescription() {
        return interests.stream().map(Interest::getDescription).collect(Collectors.toList());
    }
}
