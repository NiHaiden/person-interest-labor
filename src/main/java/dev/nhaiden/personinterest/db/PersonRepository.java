package dev.nhaiden.personinterest.db;

import dev.nhaiden.personinterest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
