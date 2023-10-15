package br.com.daniellima.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller é um Componente.
//Camada de acesso para o usuário enviar a requisição

@RestController // Entregar uma API //Criar uma rota
@RequestMapping("/primeiraRota") // Responsável por estruturar uma rota
// http://localhost:8080/
public class MinhaPrimeiraController {

    /*
     * Metodos de requisições.
     * GET - Buscar uma informação
     * POST - Adicionar um dado/informação
     * PUT - Alterar uma dado/informação
     * DELETE - Remover um dado
     * PATCH - Alterar somente uma parte do dado/informação
     */

    // Método (Funcionalidade) de uma classe
    @GetMapping("/primeiroMetodo")
    public String primeiraMensagem() {
        return "Funcionou";
    }
}
