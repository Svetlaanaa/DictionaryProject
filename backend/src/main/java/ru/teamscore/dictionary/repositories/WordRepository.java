package ru.teamscore.dictionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.teamscore.dictionary.model.entities.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

}
