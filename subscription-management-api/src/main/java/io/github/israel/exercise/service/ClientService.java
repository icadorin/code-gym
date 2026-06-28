package io.github.israel.exercise.service;

import io.github.israel.exercise.dto.ClientRequestDTO;
import io.github.israel.exercise.dto.ClientResponseDTO;
import io.github.israel.exercise.entity.Client;
import io.github.israel.exercise.mapper.ClientMapper;
import io.github.israel.exercise.repository.ClientRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository,  ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Transactional
    public ClientResponseDTO create(ClientRequestDTO dto) throws IllegalAccessException {
        String emailLower = dto.email().trim().toLowerCase();

        if (clientRepository.existsByEmail(emailLower)) {
            throw new IllegalAccessException("Email já cadastrado");
        }

        Client client = clientMapper.toEntity(dto);
        client.setEmail(emailLower);

        clientRepository.save(client);
        System.out.println("id" + client.getId());
        return clientMapper.toResponse(client);
    }
}
