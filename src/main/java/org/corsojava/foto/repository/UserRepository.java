package org.corsojava.foto.repository;

import java.util.Optional;

import org.corsojava.foto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}