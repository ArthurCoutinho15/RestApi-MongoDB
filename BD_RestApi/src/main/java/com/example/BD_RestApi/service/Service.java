package com.example.BD_RestApi.service;


import com.example.BD_RestApi.model.UserEntity;
import com.example.BD_RestApi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serial;
import java.security.SecureRandom;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> obterTodos(){ return userRepository.findAll();}
    public UserEntity obterPorId(String id){return userRepository.findById(id).orElse(null);}
    public UserEntity inserir(UserEntity user){return userRepository.save(user);}

    public UserEntity atualizar(String id, UserEntity newUser){
        UserEntity existingUser = userRepository.findById(id).orElse(null);

        if(existingUser != null){
            existingUser.setName(newUser.getName());
            existingUser.setEmail(newUser.getEmail());
            return  userRepository.save(existingUser);
        }
        else{
            throw new RuntimeException("Usuário com id: " + id + "Não encontrado");

        }
    }

    public void excluir (String id){ userRepository.deleteById(id);}
}