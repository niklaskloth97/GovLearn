package com.unimuenster.govlearnapi.tags.entity;

import com.unimuenster.govlearnapi.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected String category;
    protected Date createdAt;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "tags")
    Set<UserEntity> users = new HashSet<>();

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }
    public String toString(){
        return "";
    }
}
