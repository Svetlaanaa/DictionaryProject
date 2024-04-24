package ru.teamscore.dictionary;

import jakarta.persistence.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.teamscore.dictionary.model.entities.Definition;
import ru.teamscore.dictionary.model.entities.OtherForm;
import ru.teamscore.dictionary.model.entities.Synonym;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class DefinitionManager {

    private final EntityManager entityManager;
    EntityTransaction transaction = null;

    private final static Pattern pattern = Pattern.compile(
            "^(http|https)://([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/[\\w-./?%&=]*)?$");

    public static boolean isUrl(String source){
        Matcher matcher = pattern.matcher(source);
        return matcher.matches();
    }

    public void deleteSynonym(@NonNull Synonym synonym) {
        entityManager.getTransaction().begin();
        entityManager.remove(synonym);
        entityManager.getTransaction().commit();
    }

    public void addSource(long definitionId, String sourceText){
        transaction = entityManager.getTransaction();
        transaction.begin();
        String sql = "INSERT INTO definitions.source (source, definition_id) VALUES (:sourceText, :definitionId)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("sourceText", sourceText);
        query.setParameter("definitionId", definitionId);
        query.executeUpdate();
        transaction.commit();
    }


    public void deleteSource(long definitionId, String sourceText){
        transaction = entityManager.getTransaction();
        transaction.begin();
        String sql = "DELETE FROM definitions.source WHERE definition_id = :definitionId AND source = :sourceText";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("sourceText", sourceText);
        query.setParameter("definitionId", definitionId);
        query.executeUpdate();
        transaction.commit();
    }

    public void addForm(@NonNull OtherForm form) {
        entityManager.getTransaction().begin();
        entityManager.persist(form);
        entityManager.getTransaction().commit();
    }

    public void deleteForm(@NonNull OtherForm form) {
        entityManager.getTransaction().begin();
        entityManager.remove(form);
        entityManager.getTransaction().commit();
    }

    public void updateForm(@NonNull OtherForm form) {
        entityManager.getTransaction().begin();
        entityManager.merge(form);
        entityManager.getTransaction().commit();
    }

    public void addDefinition(@NonNull Definition definition){
        entityManager.getTransaction().begin();
        entityManager.persist(definition);
        entityManager.getTransaction().commit();
    }

    public Optional<Definition> getDefinition(long id){
        try{
            return Optional.of(entityManager.createNamedQuery("definitionById", Definition.class)
                    .setParameter("id", id)
                    .getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    public long getDefinitionsCount() {
        return entityManager
                .createNamedQuery("definitionsCount", Long.class)
                .getSingleResult();
    }

    public void deleteDefinition(long id){
        entityManager.getTransaction().begin();
        if(getDefinition(id).isPresent())
            entityManager.remove(getDefinition(id).get());
        entityManager.getTransaction().commit();
    }
}
