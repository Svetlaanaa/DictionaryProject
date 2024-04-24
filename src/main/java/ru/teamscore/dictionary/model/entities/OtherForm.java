package ru.teamscore.dictionary.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "other_form", schema = "words")
public class OtherForm {
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
