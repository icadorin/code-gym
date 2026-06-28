package io.github.israel.exercise.mapper;

import io.github.israel.exercise.dto.ClientRequestDTO;
import io.github.israel.exercise.dto.ClientResponseDTO;
import io.github.israel.exercise.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientRequestDTO Client);

    ClientResponseDTO toResponse(Client client);
}
