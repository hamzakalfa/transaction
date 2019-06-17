package communicator;

import java.io.IOException;
import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.bank.transactions.beans.Compte;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class TransactionCommunicator {

	private static TransactionCommunicator communicatorInstance;
	private static String URI="http://localhost:5696";
	public static synchronized TransactionCommunicator getInstance() {
		if(communicatorInstance==null) {
			communicatorInstance=new TransactionCommunicator();
		}
		return communicatorInstance;
	}
	
	public Compte getCompte(String numCompte) throws IOException {
		Client client = Client.create(new DefaultClientConfig());
	    URI uri = UriBuilder.fromUri(URI).build();        
	    ClientResponse response = client.resource(uri).path("findaccountbyNC").path(numCompte)
	            .type(MediaType.APPLICATION_JSON)
	            .get(ClientResponse.class);
	    String httpresponse=response.getEntity(String.class);
	    ObjectMapper mapper = new ObjectMapper();
	    Compte compte=mapper.readValue(httpresponse, Compte.class);
	    
	    return compte;
	    }
	
	public com.bank.transactions.beans.Client getClientCompte(String numCompte) throws IOException {
		Client client = Client.create(new DefaultClientConfig());
	    URI uri = UriBuilder.fromUri(URI).build();        
	    ClientResponse response = client.resource(uri).path("findClient").path(numCompte)
	            .type(MediaType.APPLICATION_JSON)
	            .get(ClientResponse.class);
	    String httpresponse=response.getEntity(String.class);
	    ObjectMapper mapper = new ObjectMapper();
	    com.bank.transactions.beans.Client clientCompte=mapper.readValue(httpresponse, com.bank.transactions.beans.Client.class);
	    
	    return clientCompte;
	}
	
	public void crediterCompte(Compte compte, double montant) throws IOException {
		

	
          	//String httpresponse=response.getEntity(String.class);
          	
          	if (Double.valueOf(compte.getSolde())<montant) {
    			//return "transaction non validee";
    			System.out.println("transaction non validee");
    		}else {
    			System.out.println(compte.getClient().getId_Client());
    			double solde=Double.valueOf(compte.getSolde());
    			compte.setSolde(String.valueOf((solde-montant)));
    			ObjectMapper mapper = new ObjectMapper(); 
    	      	Client client = Client.create(new DefaultClientConfig());
    	          URI uri = UriBuilder.fromUri(URI).build();        
    	          	client.resource(uri).path("updateaccount")
    	          	.path(String.valueOf(compte.getId_compte()))
    	              .type(MediaType.APPLICATION_JSON)
    	              .put(ClientResponse.class, mapper.writeValueAsString(compte));
    			//return "transaction validee";
    			
    		}
          	
	}
	
	public void debiterCompte(Compte compte, double montant) throws IOException {
		double solde=Double.valueOf(compte.getSolde());
		compte.setSolde(String.valueOf((solde+montant)));
		ObjectMapper mapper = new ObjectMapper(); 
      	Client client = Client.create(new DefaultClientConfig());
          URI uri = UriBuilder.fromUri(URI).build();        
          	client.resource(uri).path("updateaccount")
          	.path(String.valueOf(compte.getId_compte()))
              .type(MediaType.APPLICATION_JSON)
              .put(ClientResponse.class, mapper.writeValueAsString(compte));
	}
	
}
