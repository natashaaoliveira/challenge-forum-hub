package com.challenge.forum.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TopicDTO {
    @NotBlank
    String title;
    @NotBlank
    String message;
    @NotNull
    Long idAutor;
    @NotBlank
    String nameCourse;
}
