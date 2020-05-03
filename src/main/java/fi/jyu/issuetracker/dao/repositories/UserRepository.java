package fi.jyu.issuetracker.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fi.jyu.issuetracker.dao.models.UserDao;

public interface UserRepository extends JpaRepository<UserDao, Long> {
	
	@Query("SELECT u FROM UserDao u WHERE u.username = 1")
	Optional<UserDao> findByUsername(String username);
		
	
}
