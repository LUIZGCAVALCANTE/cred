package com.izvoc.cred.Repository;

import com.izvoc.cred.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    List<Client> id(Long id);
}
