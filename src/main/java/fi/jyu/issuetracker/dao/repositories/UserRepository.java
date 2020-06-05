package fi.jyu.issuetracker.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.jyu.issuetracker.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {		
    public User findByUsername(String username); 
}
