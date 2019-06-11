package com.champix.admin.dao;

import com.champix.admin.errors.MonException;
import com.champix.admin.metier.ClientEntity;

import java.util.List;

public class ServiceClientDAO {

	Service monService = Service.getInstance();

	public List<ClientEntity> consulterListeClients() throws MonException {
		String marequete = "SELECT a FROM ClientEntity a ORDER BY a.idClient";
		List<Object> maliste = null;
		return (List<ClientEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public ClientEntity clientById(int numero) throws MonException {
		ClientEntity borne = new ClientEntity();
		String marequete ="SELECT a FROM ClientEntity a WHERE a.idClient="+numero;
		return (ClientEntity) monService.objectById(marequete);
	}

	public void insertClient(ClientEntity uneClient) throws MonException
	{
		monService.insert(uneClient);
	}

	public void deleteClient(ClientEntity uneClient) throws MonException
	{
		monService.execRequest("DELETE From ClientEntity WHERE idClient = "+uneClient.getIdClient());
	}

	public void updateClient(ClientEntity uneClient) throws MonException {
		monService.update(uneClient);
	}
}
