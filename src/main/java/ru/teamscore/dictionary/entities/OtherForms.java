package ru.teamscore.dictionary.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "other_form", schema = "words")
public class OtherForms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "other_form", nullable = false)
    @Getter
    @Setter
    private String form;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

}
