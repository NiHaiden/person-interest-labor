package dev.nhaiden.personinterest.db;

import dev.nhaiden.personinterest.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Integer> {

}
