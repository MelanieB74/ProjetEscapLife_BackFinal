package DaoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.SpringBootRunner;
import com.model.Client;
import com.model.Reservation;
import com.model.Utilisateur;
import com.dao.IClientDao;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = SpringBootRunner.class)
public class ClientDaoTest {
	
	// ===================== CONFIGURATION =====================
	@Autowired
	private IClientDao clientDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientDaoTest.class);

	
	// ===================== METHODE CREATE =====================
	@Test
	public void givenEntityRepository_whenSaving() {
		LOGGER.info("=========== Testing givenEntityrepository_WhenSaving Method ===========");
		
		Client addedClient = clientDao.save(new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login"));
		LOGGER.info("----------- Utilisateur saved -----------");
		
		LOGGER.info("----------- Searching for Utilisateur ------------");
		Client foundClient = clientDao.findById(addedClient.getId());
		LOGGER.info("----------- Utilisateur found -----------");
		
		LOGGER.info("----------- Verifying Utilisateur -----------");
		assertNotNull(foundClient);
		assertEquals(addedClient.getNom(), foundClient.getNom());
		LOGGER.info("-----------  Utilisateur verified -----------");
	}

	
	// ===================== METHODE UPDATE =====================
	@Test
	public void givenEntityRepository_whenUpdating() {
		LOGGER.info("=========== Testing givenEntityRepository_whenUpdating Method ===========");

		Client updatedClient = clientDao.save(new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login"));
		LOGGER.info("----------- Utilisateur saved -----------");

		LOGGER.info("----------- Update Client -----------");
		updatedClient.setNom("Dali");
		clientDao.save(updatedClient);
		LOGGER.info("----------- Client updated -----------");

		LOGGER.info("----------- Searching for Client -----------");
		Client foundClient = clientDao.findByNom(updatedClient.getNom());
		LOGGER.info("----------- Client found -----------");

		LOGGER.info("----------- Verifying Client -----------");
		assertEquals(updatedClient.getNom(), foundClient.getNom());
		LOGGER.info("----------- Client verified -----------");
	}
	
	
	// ===================== METHODE DELETE =====================
	@Test
	public void givenEntityRepository_whenDeleting() {
		LOGGER.info("=========== Testing givenEntityRepository_whenDeleting Method ===========");
		
		Client deletedClient = clientDao.save(new Client("Paul", 336070810, "eric@gmail.com", "etudiant", "mdp", "login"));

		LOGGER.info("----------- Client saved -----------");

		LOGGER.info("----------- Delete Client -----------");
		clientDao.delete(deletedClient);
		LOGGER.info("----------- Client deleted -----------");

		LOGGER.info("----------- Searching for Client -----------");
		Client foundClient = clientDao.findByNom(deletedClient.getNom());
		LOGGER.info("----------- Client found -----------");

		LOGGER.info("----------- Verifying Client -----------");
		assertNull(foundClient);
		LOGGER.info("----------- Client verified -----------");

	}
	
	
	// ===================== METHODE FIND ALL =====================
	@Test
	public void givenEntityRepository_whenRetrievingAll() {
		LOGGER.info("=========== Testing givenEntityRepository_whenRetrievingOneByNom Method ===========");
		
		clientDao.save(new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login"));
		LOGGER.info("----------- Client saved -----------");

		LOGGER.info("----------- Searching for Client -----------");
		List<Client> foundClient = clientDao.findAll();
		LOGGER.info("----------- Client found -----------");

		LOGGER.info("----------- Verifying Client -----------");
		assertNotNull(foundClient);
		assertEquals(foundClient.size() > 0, true);
		LOGGER.info("----------- Client verified -----------");

	}
	
	
	// ===================== METHODE FIND BY ID =====================
	@Test
	public void givenEntityRepository_whenRetrievingId() {
		LOGGER.info("=========== Testing givenEntityRepository_whenRetrievingOneByNom Method ===========");

		Client findById = clientDao.save(new Client("Eric", 336070810, "eric@gmail.com", "etudiant", "mdp", "login"));
		LOGGER.info("----------- Client saved -----------");

		LOGGER.info("----------- Searching for Client -----------");
		Client foundClient = clientDao.findById(findById.getId());
		LOGGER.info("----------- Client found -----------");

		LOGGER.info("----------- Verifying Client -----------");
		assertEquals(findById.getId(), foundClient.getId());
		LOGGER.info("----------- Client verified -----------");

	}
	
	
	// ===================== METHODE FIND BY NOM =====================
	@Test
	public void givenEntityRepository_whenRetrievingOneByNom() {
		LOGGER.info("=========== Testing givenEntityRepository_whenRetrievingOneByNom Method ===========");
		
		Client findByNom = clientDao.save(new Client("Jean", 336070810, "eric@gmail.com", "etudiant", "mdp", "login"));
		LOGGER.info("----------- Client saved -----------");

		LOGGER.info("----------- Searching for Client -----------");
		Client foundClient = clientDao.findByNom(findByNom.getNom());
		LOGGER.info("----------- Client found -----------");

		LOGGER.info("----------- Verifying Client -----------");
		assertEquals(findByNom.getNom(), foundClient.getNom());
		LOGGER.info("----------- Client verified -----------");
	}

}
