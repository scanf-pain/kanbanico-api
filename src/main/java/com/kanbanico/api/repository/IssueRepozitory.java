package com.kanbanico.api.repository;

import com.kanbanico.api.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepozitory extends JpaRepository<Issue, Integer> {
}
