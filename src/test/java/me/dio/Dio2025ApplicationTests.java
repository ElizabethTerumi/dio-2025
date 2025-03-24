package me.dio;

import me.dio.domain.model.Account;
import me.dio.domain.model.Card;
import me.dio.domain.model.Feature;
import me.dio.domain.model.News;
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceImplTest {

	@Mock //Anotação que será simulada
	private UserRepository userRepository;

	@InjectMocks //Anotação injeta o mock na simulação
	private UserServiceImpl userService;

	@Test //Anotação teste
	void testCreateUserWithCardAndAccount() {
		// Cria objeto Account -simulação
		Account account = new Account();
		account.setNumber("123456-1");
		account.setAgency("1234");
		account.setBalance(new BigDecimal("1000.00"));
		account.setLimit(new BigDecimal("1000.00"));

		// Cria objeto Feature -simulação
		Feature feature = new Feature();
		feature.setIcon("");
		feature.setDescription("PIX");

		// Cria objeto Card -simulação
		Card card = new Card();
		card.setNumber("1111 2222 3333 4444");
		card.setLimit(new BigDecimal("1000.00"));

		// Cria objeto News -simulação
		News news = new News();
		news.setIcon("");
		news.setDescription("Cartão de crédito Dio");

		// Cria objeto User -simulação
		User user = new User();
		user.setName("Maria");
		user.setAccount(account);
		user.setFeatures(Arrays.asList(feature));
		user.setCard(card);
		user.setNews(Arrays.asList(news));

		// Mocking o comportamento do repository
		when(userRepository.save(any(User.class))).thenReturn(user);

		// Teste de criação
		User createdUser = userService.create(user);

		// Verificação
		assertNotNull(createdUser);
		assertEquals("Maria", createdUser.getName());
		assertNotNull(createdUser.getAccount());
		assertEquals("123456-1", createdUser.getAccount().getNumber());
		assertEquals(0, createdUser.getAccount().getBalance().compareTo(new BigDecimal("1000.00")));
		assertEquals(0, createdUser.getAccount().getLimit().compareTo(new BigDecimal("1000.00")));

		assertNotNull(createdUser.getCard());
		assertEquals("1111 2222 3333 4444", createdUser.getCard().getNumber());
		assertEquals(0, createdUser.getCard().getLimit().compareTo(new BigDecimal("1000.00")));

		assertNotNull(createdUser.getFeatures());
		assertEquals(1, createdUser.getFeatures().size());
		assertEquals("PIX", createdUser.getFeatures().get(0).getDescription());

		assertNotNull(createdUser.getNews());
		assertEquals(1, createdUser.getNews().size());
		assertEquals("Cartão de crédito Dio", createdUser.getNews().get(0).getDescription());

		// Verificando se o save foi chamado corretamente
		verify(userRepository, times(1)).save(user);
	}
}
