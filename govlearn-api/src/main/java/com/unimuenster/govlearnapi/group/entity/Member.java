package com.unimuenster.govlearnapi.group.entity;

import com.unimuenster.govlearnapi.course.entity.Course;
import com.unimuenster.govlearnapi.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany()
    private List<Course> courses;

    protected Date createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }

    public String getMemberSince() {
        return createdAt.toString();
    }
}
