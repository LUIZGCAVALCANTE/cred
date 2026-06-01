package com.izvoc.cred.Controllers;

import com.izvoc.cred.Dto.ClientDto;
import com.izvoc.cred.Dto.CustomError;
import com.izvoc.cred.Services.ClientService;
import com.izvoc.cred.Services.execptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/clients")
@Validated

public class ClientController {



    @Autowired
    ClientService clientService;
    // insere novos
    @PostMapping
    public ClientDto InsertClient(@Valid  @RequestBody ClientDto clientDto) {

        return this.clientService.InsertClient( clientDto );

    }
    // busca geral
    @GetMapping("/all")
    public ResponseEntity<Page<ClientDto>> getAllClients(Pageable pages) {
        return  ResponseEntity.ok(this.clientService.getAllClients(pages));
    }
    //getid
    @GetMapping("/buscar/{id}")
    public ClientDto findByid(@PathVariable Long id) {

        return this.clientService.findByid(id);
    }


    // atualizar client
    @PutMapping("/att/{id}")
    public ClientDto UpdateClient(@RequestBody @Valid ClientDto clientDto,@PathVariable Long id) {
        return this.clientService.UpdateClient(clientDto, id);
    }

    // deletar
    @DeleteMapping("/del/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
