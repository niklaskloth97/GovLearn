package com.unimuenster.govlearnapi.course.entity;

import com.unimuenster.govlearnapi.tags.entity.Tag;
import com.unimuenster.govlearnapi.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String description;

    @ManyToOne( fetch = FetchType.LAZY )
    @ToString.Exclude
    private UserEntity creator;
    protected Date createdAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name= "course_tag",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tag> tags = new HashSet<>();

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }

    public void removeTag(long tagId) {
        Tag tag = this.tags.stream().filter(t -> t.getId() == tagId).findFirst().orElse(null);
        if (tag != null) {
            this.tags.remove(tag);
            tag.getCourses().remove(this);
        }
    }
}
