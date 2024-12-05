package com.kanbanico.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Issue extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IssueType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IssueStatus status;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private IssuePriority priority;

    @Column(nullable = false)
    private Double listPosition;

    private String description;

    private String descriptionText;

    private Integer estimate;

    private Integer timeSpent;

    private Integer timeRemaining;

    @Column(nullable = false)
    private Integer reporterId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(
            mappedBy = "issue",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "users_issues",
            joinColumns = {
                    @JoinColumn(name = "issue_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            }
    )
    private List<User> users;

}
