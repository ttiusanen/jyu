package fi.jyu.issuetracker.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.jyu.issuetracker.security.model.User;

/**
 * Generic JPA repository implementation for fetching users from db.
 */
public interface UserRepository extends JpaRepository<User, Long> {		
    public User findByUsername(String username); 
}
