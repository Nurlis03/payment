package com.payment.controller;

import com.payment.dto.ClientRequestDTO;
import com.payment.entity.Client;
import com.payment.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllCliens();
    }
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientRequestDTO clientRequestDto) {
        Client createdClient = clientService.createClient(clientRequestDto);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }
}
