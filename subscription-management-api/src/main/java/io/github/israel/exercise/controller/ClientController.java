package io.github.israel.exercise.controller;

import io.github.israel.exercise.dto.ClientRequestDTO;
import io.github.israel.exercise.dto.ClientResponseDTO;
import io.github.israel.exercise.service.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/api/clients")
    public ClientResponseDTO create(@RequestBody ClientRequestDTO dto) throws IllegalAccessException {
        return clientService.create(dto);
    }

    @PostMapping("/hello")
    public Object hello() {
        return "Hello World";
    }
}