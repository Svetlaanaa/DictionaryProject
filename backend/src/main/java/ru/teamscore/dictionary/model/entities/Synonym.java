package ru.teamscore.dictionary.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "synonym", schema = "definitions")
@NamedQuery(name = "synonymsCount", query = "select count(*) from Synonym")
public class Synonym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "definition_id", nullable = false)
    @Getter
    @Setter
    private Definition definition;

    @ManyToOne
    @JoinColumn(name = "synonym", nullable = false)
    @Getter
    @Setter
    private Word synonymWord;
}
