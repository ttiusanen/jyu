package fi.jyu.issuetracker.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.jyu.issuetracker.dao.models.Issue;

/**
 * Generic JPA repository implementation for fetching issues from db.
 */
public interface IssueRepository extends JpaRepository<Issue, Long>{

}
