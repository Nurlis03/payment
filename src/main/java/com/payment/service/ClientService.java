package com.payment.service;

import com.payment.entity.Client;
import com.payment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        if (client.getName() == null) {
            throw new IllegalArgumentException("Client name cannot be null");
        }
        return clientRepository.save(client);
    }

}
