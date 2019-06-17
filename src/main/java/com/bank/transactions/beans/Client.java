 package com.bank.transactions.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8753002853575205448L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Client;
	
	@Column(name = "nom_Client", unique = false, nullable = false)
	private String nom_Client;
	
	@Column(name = "prenom_Client", unique = false, nullable = false)
	private String prenom_Client;
	
	@Column(name = "Status ", unique = false, nullable = false)
	private String Status;
	
	@Column(name = "email", unique = false, nullable = false)
	private String email;


	@Column(name = "address", unique = false, nullable = false)
	private String address;

	@Column(name = "phone_number", unique = false, nullable = false)
	private String phone_number;
	
	@Column(name = "Education", unique = false, nullable = false)
	private String Education;

	@Column(name = "Decision", unique = false, nullable = false)
	private String Decision;
	
	@Column(name = "DateofBirth", unique = false, nullable = false)
	private Date DateofBirth;
	
	@Column(name = "Zipcode", unique = false, nullable = false)
	private Integer Zipcode;

	@Column(name = "ConditionsAcceptance", unique = false, nullable = false)
	private Boolean ConditionsAcceptance;
	
	@Column(name = "iDNumber", unique = false, nullable = false)
	private String iDNumber;
	
	@OneToMany(mappedBy="client")
	private List<Compte> compte;


	 
	public Client() {
		super();
	}

	

	public String getiDNumber() {
		return iDNumber;
	}



	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}



	public Date getDateofBirth() {
		return DateofBirth;
	}



	public void setDateofBirth(Date dateofBirth) {
		DateofBirth = dateofBirth;
	}



	public Integer getZipcode() {
		return Zipcode;
	}



	public void setZipcode(Integer zipcode) {
		Zipcode = zipcode;
	}



	public Boolean getConditionsAcceptance() {
		return ConditionsAcceptance;
	}



	public void setConditionsAcceptance(Boolean conditionsAcceptance) {
		ConditionsAcceptance = conditionsAcceptance;
	}


	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}



	public String getEmail() {
		return email;
	} 



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone_number() {
		return phone_number;
	}



	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}



	public String getEducation() {
		return Education;
	}



	public void setEducation(String education) {
		Education = education;
	}



	public String getDecision() {
		return Decision;
	}



	public void setDecision(String decision) {
		Decision = decision;
	}



	public Long getId_Client() {
		return id_Client;
	}

	public void setId_Client(Long id_Client) {
		this.id_Client = id_Client;
	}

	public String getNom_Client() {
		return nom_Client;
	}

	public void setNom_Client(String nom_Client) {
		this.nom_Client = nom_Client;
	}

	public String getPrenom_Client() {
		return prenom_Client;
	}

	public void setPrenom_Client(String prenom_Client) {
		this.prenom_Client = prenom_Client;
	}



	public List<Compte> getCompte() {
		return compte;
	}


	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}
	
}
