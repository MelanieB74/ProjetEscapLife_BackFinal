package ControllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.SpringBootRunner;
import com.controller.ClientController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Client;
import com.model.Utilisateur;
import com.service.ClientServiceImpl;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = SpringBootRunner.class)
public class ClientControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientControllerTest.class);
	private MvcResult mvcResult;
	private String uri;
	private MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Mock
	ClientServiceImpl clientServiceImpl;
	ClientController clientController;

	public ClientControllerTest() {
		this.uri = "/client";
	}

	@Before
	public final void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
		clientController = new ClientController(clientServiceImpl);
	}

	
	// ===================== TESTS DE LA METHODE CREATE =====================
	@Test
	public void should_have_200_status_when_createClient_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_createClient_is_called test Of ClientServiceImplTest ---------------");
		try {
			Client addedClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(addedClient);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/createClient")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_save_when_createClient_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_save_when_createClient_is_called test Of ClientServiceImplTest ---------------");
		Client addedClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");
		clientController.createClient(addedClient);
		verify(clientServiceImpl).save(addedClient);
	}

	
	// ===================== TESTS DE LA METHODE UPDATE =====================
	@Test
	public void should_have_200_status_when_updateClient_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_updateClient_is_called test Of ClientServiceImplTest ---------------");
		try {
			Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");

			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myClient);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/updateClient/1")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_update_when_updateClient_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_update_when_updateClient_is_called test Of ClientServiceImplTest ---------------");
		Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");
		clientController.updateClient(myClient);
		verify(clientServiceImpl).update(myClient);
	}

	
	// ============== TESTS DE LA METHODE DELETE BY ID =====================
	@Test
	public void should_have_200_status_when_deleteClientById_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_deleteClientById_is_called test Of ClientServiceImplTest ---------------");
		try {
			Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");

			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myClient);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/deleteById/1")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_delete_when_deleteClientById_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_update_when_deleteClientById_is_called test Of ClientServiceImplTest ---------------");
		Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant","mdp", "login");
		Client searchClient = clientServiceImpl.findById(1);
		assertEquals(searchClient, null);
	}
	

	// =============== TESTS DE LA METHODE DELETE BY NOM ==================
	@Test
	public void should_have_200_status_when_deleteClientByNom_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_deleteClientByNom_is_called test Of ClientServiceImplTest ---------------");
		try {
			Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");

			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myClient);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri + "/deleteByNom/Eric")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_delete_when_deleteClientByNom_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_update_when_deleteClientByNom_is_called test Of ClientServiceImplTest ---------------");
		Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");
		clientController.deleteClient(myClient.getNom());
		Client searchClient = clientServiceImpl.findByNom("Eric");
		assertEquals(searchClient, null);
	}

	
	// ===================== TESTS DE LA METHODE GETALL =====================
	@Test
	public void should_have_200_status_when_getAllClients_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_getAllClients_is_called test Of ClientServiceImplTest ---------------");
		try {
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/all").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_findAll_when_getAllClients_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findAll_when_getAllClients_is_called test Of ClientServiceImplTest ---------------");
		clientController.getAllClients();
		verify(clientServiceImpl).findAll();
	}
	

	// ================= TESTS DE LA METHODE FIND BY ID =====================
	@Test
	public void should_have_200_status_when_findClientById_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_findClientById_is_called test Of ClientServiceImplTest ---------------");
		try {
			Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");

			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myClient);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/getById/1")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_findById_when_findClientById_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findById_when_findClientById_is_called test Of ClientServiceImplTest ---------------");
		Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");
		clientController.createClient(myClient);
		clientController.findClientById(1);
		verify(clientServiceImpl).findById(1);
	}

	
	// ================ TESTS DE LA METHODE FIND BY NOM =====================
	@Test
	public void should_have_200_status_when_findClientByNom_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_findClientByNom_is_called test Of ClientServiceImplTest ---------------");
		try {
			Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");
			
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myClient);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/getByNom/Eric")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_findByNom_when_findClientByNom_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findByNom_when_findClientByNom_is_called test Of ClientServiceImplTest ---------------");
		Client myClient = new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login");
		clientController.createClient(myClient);
		clientController.findClientByNom("Eric");
		verify(clientServiceImpl).findByNom("Eric");
	}

}
