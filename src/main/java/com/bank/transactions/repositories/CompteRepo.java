package com.bank.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.transactions.beans.Client;
import com.bank.transactions.beans.Compte;


@Repository
public interface CompteRepo extends JpaRepository<Compte, Long>{

	
	public Compte findByNumerodecompte(Long numerodecompte);

	@Query("select c from Client c join c.compte a where a.numerodecompte=?1")
	public Client findClientByAccount(long numerodecompte);
}
