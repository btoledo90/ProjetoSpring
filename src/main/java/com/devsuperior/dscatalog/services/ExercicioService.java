package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.ExercicioDTO;
import com.devsuperior.dscatalog.dto.ExercicioDTO;
import com.devsuperior.dscatalog.entities.Exercicio;
import com.devsuperior.dscatalog.entities.Exercicio;
import com.devsuperior.dscatalog.repositories.ExercicioRepository;
import com.devsuperior.dscatalog.repositories.ExercicioRepository;
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
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    @Transactional(readOnly = true)
    public List<ExercicioDTO> findAll() {
        List<Exercicio> list = repository.findAll();
        return list.stream().map(x -> new ExercicioDTO(x)).collect(Collectors.toList());


    }

    @Transactional(readOnly = true)
    public ExercicioDTO findById(Long id) {
        Optional<Exercicio> obj = repository.findById(id);
        Exercicio entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ExercicioDTO(entity);
    }

    @Transactional
    public ExercicioDTO insert(ExercicioDTO dto) {
        Exercicio entity = new Exercicio();
        entity.setName(dto.getName());
        entity.setDescricao(dto.getDescricao());
        entity = repository.save(entity);
        return new ExercicioDTO(entity);
    }

    @Transactional
    public ExercicioDTO update(Long id, ExercicioDTO dto) {
        try {
            Exercicio entity = repository.getById(id);
            entity.setName(dto.getName());
            entity.setDescricao(dto.getDescricao());
            entity = repository.save(entity);
            return new ExercicioDTO(entity);
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
