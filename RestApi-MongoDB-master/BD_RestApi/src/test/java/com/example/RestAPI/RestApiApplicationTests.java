package com.example.RestAPI;

import com.example.RestAPI.controller.UserController;
import com.example.RestAPI.model.UserEntity;
import com.example.RestAPI.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class RestApiApplicationTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testObterTodos() {
        //Simular dados do usuário
        List<UserEntity> userList = Arrays.asList(
                new UserEntity("1", "User1", "user1@example.com"),
                new UserEntity("2", "User2", "user2@example.com")

		);

        //Simular comportamento do serviço
        when(userService.obterTodos()).thenReturn(userList);
        //Chamar o método do controlador
        List<UserEntity> result = userController.obterTodos();
        //Verificar se o resultado é o esperado
        assertEquals(result, userList);
    }

    @Test
    void testObterPorId(){
        //Simular dados do usuário
        UserEntity user = new UserEntity("1", "User1", "user1@example.com");
        //Simular comportamento  do serviço
        when(userService.obterPorId("1")).thenReturn(user);
        //Chamar o método do controlador
        UserEntity result = userController.obterPorId("1");
        //Verificar se o resultado é esperado
        assertEquals(user,result);
    }

    @Test
    void testInserir(){
        //Simula dados do usuário
        UserEntity newUser = new UserEntity("1","User1","user1@example.com");
        //Simular comportamento do serviço
        when(userService.inserir(newUser)).thenReturn(newUser);
        //Chamar método do
    }

}
