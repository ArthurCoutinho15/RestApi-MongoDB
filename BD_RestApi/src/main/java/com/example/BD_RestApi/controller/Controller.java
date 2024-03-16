package com.example.BD_RestApi.controller;


import com.example.BD_RestApi.model.UserEntity;
import com.example.BD_RestApi.repository.UserRepository;
import com.example.BD_RestApi.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping
    public List<UserEntity> obterTodos(){return service.obterTodos();}

    @GetMapping("/{id}")
    public UserEntity obterPorId(@PathVariable String id){  return service.obterPorId(id);}
    @PostMapping
    public UserEntity inserir(@RequestBody UserEntity user){ return  service.inserir(user);}

    @PutMapping("/{id}")
    public UserEntity atualizar(@PathVariable String id, @RequestBody UserEntity user){
        return service.atualizar(id, user);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id ){service.excluir(id);}




}