package com.jefersonwvs.bsrchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jefersonwvs.bsrchallenge.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
