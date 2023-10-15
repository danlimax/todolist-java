package br.com.daniellima.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//Importações das anotations
import lombok.Data;

//Modelo de um usuário

//Lombok anotation para não usar getter e setter
//@Getter ou @Setter para colocar apenas um deles
//@Data coloca os dois.
@Data
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    // Para pegar só um atributo colocar @Getter ou @Setter em cima dele
    // @Getter ou @Setter

    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Metodos getters e setters

}
