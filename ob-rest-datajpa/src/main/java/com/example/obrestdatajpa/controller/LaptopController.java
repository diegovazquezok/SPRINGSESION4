package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Laptop;
import com.example.obrestdatajpa.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    //atributos
    private LaptopRepository laptopRepository;

    //constructor

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    // CRUD SOBRE LA ENTIDAD LAPTOP

    // METODO PARA BUSCAR TODOS LOS LAPTOP
    @GetMapping("/api/laptop/")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    //METODO PARA BUSCAR LAPTOP EN BASE ID
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();

    }


    //METODO CREAR UN NUEVO LIBRO
    @PostMapping("/api/laptop/")
    public Laptop create(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }


    //METODO ACTUALIZAR UN LIBRO EXISTENTE
}
