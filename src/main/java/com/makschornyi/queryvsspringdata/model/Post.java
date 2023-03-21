package com.makschornyi.queryvsspringdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ids;

    private String text;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @LastModifiedDate
    private LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
