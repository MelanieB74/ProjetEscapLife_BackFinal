package ServiceTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.SpringBootRunner;
import com.model.Client;
import com.dao.IClientDao;
import com.service.ClientServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRunner.class)
public class ClientServiceImplTest {
	
	// ===================== CONFIGURATION =====================
	private ClientServiceImpl clientService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImplTest.class);

	@Mock
	private IClientDao clientDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		clientService = new ClientServiceImpl(clientDao);
	}
	
	
	// ===================== METHODE CREATE =====================
	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info(
				"--------------- Executing should_store_when_save_is_called test Of ClientServiceImplTest ---------------");
		Client myClient = new Client();
		clientService.save(myClient);
		Mockito.verify(clientDao).save(myClient);
	}
	
	
	// ===================== METHODE UPDATE =====================
	@Test
	public void should_update_when_update_is_called() {
		LOGGER.info(
				"--------------- Executing should_update_when_update_is_called test Of ClientServiceImplTest ---------------");
		Client myClient = new Client();
		clientService.update(myClient);
		Mockito.verify(clientDao).save(myClient);
	}

	
	// ===================== METHODE DELETE =====================
	@Test
	public void should_delete_when_delete_is_called() {
		LOGGER.info(
				"--------------- Executing should_delete_when_delete_is_called test Of ClientServiceImplTest ---------------");
		Client myClient = new Client();
		clientService.delete(myClient);
		Mockito.verify(clientDao).delete(myClient);
	}

	
	// ===================== METHODE FIND ALL =====================
	@Test
	public void should_search_all_when_findAll_is_called() {
		LOGGER.info(
				"--------------- Executing should_search_all_when_findAll_is_called test Of ClientServiceImplTest ---------------");
		clientService.findAll();
		Mockito.verify(clientDao).findAll();
	}

	
	// ===================== METHODE FIND BY ID =====================
	@Test
	public void should_search_by_id_when_findById_is_called() {
		LOGGER.info(
				"--------------- Executing should_search_by_id_when_findById_is_called test Of ClientServiceImplTest ---------------");
		Integer id = new Integer(1);
		clientService.findById(id);
		Mockito.verify(clientDao).findById(id);
	}

	
	// ===================== METHODE FIND BY NOM =====================
	@Test
	public void should_search_by_firstname_when_findByNom_is_called() {
		LOGGER.info(
				"--------------- Executing should_search_by_firstname_when_findByNom_is_called test Of ClientServiceImplTest ---------------");
		String nom = "John";
		clientService.findByNom(nom);
		Mockito.verify(clientDao).findByNom(nom);
	}

}
