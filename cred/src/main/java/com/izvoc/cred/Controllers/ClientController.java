package com.izvoc.cred.Controllers;

import com.izvoc.cred.Dto.ClientDto;
import com.izvoc.cred.Services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Inserir cliente
    @PostMapping
    public ClientDto insert(@Valid @RequestBody ClientDto clientDto) {
        return clientService.InsertClient(clientDto);
    }

    // Busca paginada
    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(clientService.getAllClients(pageable));
    }

    // Busca por ID
    @GetMapping("/{id}")
    public ClientDto findById(@PathVariable Long id) {
        return clientService.findByid(id);
    }

    // Atualização
    @PutMapping("/{id}")
    public ClientDto update(
            @PathVariable Long id,
            @Valid @RequestBody ClientDto clientDto) {

        return clientService.UpdateClient(clientDto, id);
    }

    // Deleção
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clientService.deleteClient(id);

        return ResponseEntity.noContent().build();
    }
}