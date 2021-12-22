package com.devsuperior.dscatalog.resources;


import com.devsuperior.dscatalog.dto.SentimentoDTO;
import com.devsuperior.dscatalog.services.SentimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/sentimentos")
public class SentimentoResource {

    @Autowired
    private SentimentoService service;



    @GetMapping
    public ResponseEntity<List<SentimentoDTO>> findAll() {
        List<SentimentoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SentimentoDTO> findById(@PathVariable Long id) {
        SentimentoDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<SentimentoDTO> insert(@RequestBody SentimentoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SentimentoDTO> update(@PathVariable Long id, @RequestBody SentimentoDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SentimentoDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
