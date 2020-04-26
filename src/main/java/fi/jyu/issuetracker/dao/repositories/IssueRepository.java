package fi.jyu.issuetracker.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.jyu.issuetracker.dao.models.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>{

}
