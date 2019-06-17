package com.bank.transactions.controller;



import java.io.IOException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bank.transactions.beans.Compte;
import com.bank.transactions.repositories.CompteRepo;


	
	


@RestController
public class TransactionController {

	@Autowired
	private CompteRepo compterepo;
	
	
	@PostMapping("/creditercompte")
	public  ResponseEntity<Object> crediterCompte(@RequestBody Long numerodecompte, @RequestBody Long montant) throws JSONException, IOException{
//		JSONObject jsonObj=new JSONObject(jsonBody);
//		String iD_Number=jsonObj.get("num_compte").toString();
//		String montant=jsonObj.get("montant").toString();
//		
//		Compte compte=TransactionCommunicator.getInstance().getCompte(iD_Number);
//		Client client=TransactionCommunicator.getInstance().getClientCompte(iD_Number);
//		compte.setClient(client);
//			compte.setNum_compte(iD_Number);
//
//			TransactionCommunicator.getInstance().crediterCompte(compte, Double.valueOf(montant));

		Compte compte = compterepo.findByNumerodecompte(numerodecompte);
		Long soldecourant= Long.parseLong(compte.getSolde());
		compte.setSolde(Long.toString(soldecourant-montant));
		compterepo.save(compte);
		return ResponseEntity.noContent().build();
		 
	}
		
	
	@PostMapping("/debitercompte")
	public ResponseEntity<Object> debiterCompte(@RequestBody Long numerodecompte, @RequestBody Long montant) throws JSONException, IOException {
		
//		JSONObject jsonObj=new JSONObject(jsonBody);
//		String iD_Number=jsonObj.get("num_compte").toString();
//		String montant=jsonObj.get("montant").toString();
//		
//		Compte compte=TransactionCommunicator.getInstance().getCompte(iD_Number);
//		compte.setNum_compte(iD_Number);
//		Client client=TransactionCommunicator.getInstance().getClientCompte(iD_Number);
//		compte.setClient(client);
//		TransactionCommunicator.getInstance().debiterCompte(compte, Double.valueOf(montant));
		

		Compte compte = compterepo.findByNumerodecompte(numerodecompte);
	
		Long soldecourant= Long.parseLong(compte.getSolde());
		
		compte.setSolde(Long.toString(soldecourant+montant));
		compterepo.save(compte);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@PostMapping("/transaction")
	public void transaction(@RequestBody Long numerodecompteE, @RequestBody Long numerodecompteR, @RequestBody Long montant) throws JSONException, IOException {
	
//		System.out.println("Transaction");
//		JSONObject jsonObj=new JSONObject(jsonBody);
//		String iD_NumberE=jsonObj.get("num_compteE").toString();
//		String iD_NumberR=jsonObj.get("num_compteR").toString();
//		String montant=jsonObj.get("montant").toString();
//		
//		Compte compteE=TransactionCommunicator.getInstance().getCompte(iD_NumberE);
//		compteE.setNum_compte(iD_NumberE);
//		Client clientE=TransactionCommunicator.getInstance().getClientCompte(iD_NumberE);
//		compteE.setClient(clientE);
//		TransactionCommunicator.getInstance().crediterCompte(compteE, Double.valueOf(montant));
//		
//		Compte compteR=TransactionCommunicator.getInstance().getCompte(iD_NumberR);
//		compteR.setNum_compte(iD_NumberR);
//		Client clientR=TransactionCommunicator.getInstance().getClientCompte(iD_NumberR);
//		compteR.setClient(clientR);
//		TransactionCommunicator.getInstance().debiterCompte(compteR, Double.valueOf(montant));
		
		
		Compte compteE = compterepo.findByNumerodecompte(numerodecompteE);

		Compte compteR = compterepo.findByNumerodecompte(numerodecompteR);
		
		Long soldecourantE= Long.parseLong(compteE.getSolde());

		Long soldecourantR= Long.parseLong(compteR.getSolde());

		compteE.setSolde(Long.toString(soldecourantE-montant));

		compteR.setSolde(Long.toString(soldecourantR+montant));
		compterepo.save(compteE);
		compterepo.save(compteR);

	}
}
