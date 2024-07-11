package com.challenge.forum.domain.topic;
import com.challenge.forum.domain.autor.Autor;
import com.challenge.forum.domain.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AutorRepository authorRepository;

    public Topic createTopic(TopicDTO topicDTO) {
        Autor autor = AutorRepository.findById(topicDTO.idAutor())
                .orElseThrow(() -> new RuntimeException("Autor not found"));
        System.out.println(autor);

        Topic topic = new Topic(null,TopicDTO.title(), TopicDTO.message(), true, LocalDateTime.now(), Autor, TopicDTO.nameCourse());
        if (topicRepository.existsByTitleAndMessage(topic.getTitle(), topic.getMessage())) {
            throw new RuntimeException("Error! It is not possible to have duplicate topics.");
        }
        topicRepository.save(topic);
        return topic;
    }
}