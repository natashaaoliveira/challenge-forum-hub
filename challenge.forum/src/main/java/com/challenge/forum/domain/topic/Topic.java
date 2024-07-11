package com.challenge.forum.domain.topic;

import com.challenge.forum.domain.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "topics")
@Entity(name = "Topic")

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private boolean status;
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Autor autor;

    private String courseName;

    public void update(TopicUpdateDTO topicUpdateDTO) {
        this.id = topicUpdateDTO.id();
        if (topicUpdateDTO.title() != null) {
            this.title = topicUpdateDTO.title();
        }
        if (topicUpdateDTO.message() != null) {
            this.message = topicUpdateDTO.message();
        }
        if (topicUpdateDTO.autorDTO() != null) {
            this.autor = new Autor(topicUpdateDTO.autorDTO());
        }
        if (topicUpdateDTO.nameCourse() != null) {
            this.courseName = topicUpdateDTO.nameCourse();
        }

    }
}
