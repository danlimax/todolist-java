package br.com.daniellima.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

//Interface é um contrato dentro na aplicação tem o metodos mas não tem as implementações dos métodos.
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
}
