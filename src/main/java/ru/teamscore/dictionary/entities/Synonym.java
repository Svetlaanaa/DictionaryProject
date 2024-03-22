package ru.teamscore.dictionary.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "synonym", schema = "definitions")
@NamedQuery(name = "synonymsCount", query = "select count(*) from Synonym")
public class Synonym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "definition_id", nullable = false)
    private Definition definition;

    @ManyToOne
    @JoinColumn(name = "synonym", nullable = false)
    private Word synonymWord;
}
