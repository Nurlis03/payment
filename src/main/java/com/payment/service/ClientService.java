package com.payment.service;

import com.payment.dto.ClientRequestDTO;
import com.payment.entity.Client;
import com.payment.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    public List<Client> getAllCliens() {
        return clientRepository.findAll();
    }
    public Client createClient(ClientRequestDTO clientRequestDto) {
        Client client = Client.builder()
                              .name(clientRequestDto.getName())
                              .build();
        return clientRepository.save(client);
    }
}
