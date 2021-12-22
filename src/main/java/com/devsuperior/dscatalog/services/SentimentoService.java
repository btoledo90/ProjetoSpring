package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.SentimentoDTO;
import com.devsuperior.dscatalog.entities.Sentimento;
import com.devsuperior.dscatalog.repositories.SentimentoRepository;
import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SentimentoService {

    @Autowired
    private SentimentoRepository repository;

    @Transactional(readOnly = true)
    public List<SentimentoDTO> findAll() {
        List<Sentimento> list = repository.findAll();
        return list.stream().map(x -> new SentimentoDTO(x)).collect(Collectors.toList());


    }

    @Transactional(readOnly = true)
    public SentimentoDTO findById(Long id) {
        Optional<Sentimento> obj = repository.findById(id);
        Sentimento entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new SentimentoDTO(entity);
    }

    @Transactional
    public SentimentoDTO insert(SentimentoDTO dto) {
        Sentimento entity = new Sentimento();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new SentimentoDTO(entity);
    }

    @Transactional
    public SentimentoDTO update(Long id, SentimentoDTO dto) {
        try {
            Sentimento entity = repository.getById(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new SentimentoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found" + id);

        }

    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found" + id);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");

        }

    }


}
