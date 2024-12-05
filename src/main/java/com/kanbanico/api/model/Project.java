package com.kanbanico.api.model;

import com.kanbanico.api.model.embeded.ProjectUser;
import com.kanbanico.api.util.AppConstants;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(length = AppConstants.MAX_URL_LENGTH)
    private String url;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectCategory category;

    @OneToMany(mappedBy = "project")
    private List<Issue> issues;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectUser> projectUsers;

}
