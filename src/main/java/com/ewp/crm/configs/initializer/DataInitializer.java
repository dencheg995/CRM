package com.ewp.crm.configs.initializer;

import com.ewp.crm.models.Client;
import com.ewp.crm.models.Status;
import com.ewp.crm.service.interfaces.ClientService;
import com.ewp.crm.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;

public class DataInitializer {

	@Autowired
	private StatusService statusService;
	@Autowired
	private ClientService clientService;

	private void init() {
		Status status1 = new Status("First status");
		Status status2 = new Status("Second status");
		Status status3 = new Status("Third status");
		Client client1 = new Client("Юрий", "Долгоруков", "89677745632", "u.dolg@mail.ru", (byte) 21, Client.Sex.MALE);
		Client client2 = new Client("Вадим", "Бойко", "89687745632", "vboyko@mail.ru", (byte) 33, Client.Sex.MALE);
		Client client3 = new Client("Александра", "Соловьева", "89677345632", "a.solo@mail.ru", (byte) 53, Client.Sex.FEMALE);
		Client client4 = new Client("Иван", "Федоров", "89637745632", "i.fiod@mail.ru", (byte) 20, Client.Sex.MALE);
		clientService.addClient(client1);
		clientService.addClient(client2);
		clientService.addClient(client3);
		clientService.addClient(client4);
		status1.setClients(clientService.getClientByEmail("u.dolg@mail.ru"));
		status1.setClients(clientService.getClientByEmail("i.fiod@mail.ru"));
		status2.setClients(clientService.getClientByEmail("vboyko@mail.ru"));
		status3.setClients(clientService.getClientByEmail("a.solo@mail.ru"));
		statusService.add(status1);
		statusService.add(status2);
		statusService.add(status3);
	}
}