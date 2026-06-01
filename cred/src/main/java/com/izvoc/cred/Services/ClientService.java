package com.izvoc.cred.Services;

import com.izvoc.cred.Dto.ClientDto;
import com.izvoc.cred.Entities.Client;
import com.izvoc.cred.Repository.ClientRepository;
import com.izvoc.cred.Services.execptions.ResourceNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;


    // novo client - pos
    public ClientDto InsertClient(ClientDto clientDto) {



        Client client = new Client();


        client.setName(clientDto.name());
        client.setCPF(clientDto.CPF());
        client.setIncome(clientDto.income());
        client.setBirthDate(clientDto.birthDate());
        client.setChildren(clientDto.children());

    clientRepository.save(client);

    return new ClientDto(client.getId(), client.getName(),client.getCPF(),client.getIncome(),client.getBirthDate(),client.getChildren());

    }


// buscar todos os client - guetall

    public Page<ClientDto> getAllClients(Pageable pages) {

        Page<Client> clients = clientRepository.findAll(pages);
        List<ClientDto> clientDtos = new ArrayList<>();

        for (Client client : clients.getContent()) {

            ClientDto clientDto = new ClientDto(
                    client.getId(),
                    client.getName(),
                    client.getCPF(),
                    client.getIncome(),
                    client.getBirthDate(),
                    client.getChildren()
            );

            clientDtos.add(clientDto);
        }

        return new PageImpl<>(
                clientDtos,
                pages,
                clients.getTotalElements()
        );
    }

    // get id
    @Transactional(readOnly=true)
    public ClientDto findByid( Long id){


        Optional<Client> result = Optional.of(clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException ("O que você procura não está aqui")
        ));

            Client client = result.get();
        return new ClientDto(client.getId(), client.getName(),client.getCPF(),
                client.getIncome(),client.getBirthDate(),client.getChildren());



    }

    // put
    public ClientDto UpdateClient(ClientDto clientDto, Long id) {

        Client client = clientRepository.getReferenceById(id);
        client.setName(clientDto.name());
        client.setCPF(clientDto.CPF());
        client.setIncome(clientDto.income());
        client.setBirthDate(clientDto.birthDate());
        client.setChildren(clientDto.children());
        clientRepository.save(client);

        return new ClientDto(client.getId(), client.getName(), client.getCPF(),client.getIncome(),client.getBirthDate(),client.getChildren());
    }


    // deletar
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Cliente não encontrado. Id cliente inexistente: " );
        }

        clientRepository.deleteById(id);
    }

}
