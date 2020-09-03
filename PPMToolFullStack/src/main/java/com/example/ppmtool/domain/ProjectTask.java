package com.example.ppmtool.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(updatable = false)
    private String projectSequence;
    @NotBlank(message = "task summery cannot be black")
    private String summary;
}
