package br.com.daniellima.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/*
 * Modificadores
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /*
     * String (texto)
     * Integer (int) numeros inteiros
     * Double (double) Númeors reais 0.0000
     * Float (float) Números reais 0.000
     * char (A C)
     * Date (data)
     * void
     */

    // Anotation @Autowired serve para gerenciar o cilco de vida, instanciar.
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")

    /* vai vir dentro do body da requisição */
    public ResponseEntity create(@RequestBody UserModel userModel) {
        // System.out.println(userModel.getUsername());
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null) {
            System.out.println("Usuário já existe!");
            // Mensagem de erro
            // Status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        }

        // Cripitografar senhas
        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
