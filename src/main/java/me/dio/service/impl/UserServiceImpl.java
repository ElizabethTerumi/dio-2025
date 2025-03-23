package me.dio.service.impl;

import me.dio.domain.model.*;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import me.dio.service.exception.BusinessException;
import me.dio.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    /**
     * ID de usuário utilizado na Santander Dev Week 2023.
     * Por isso, vamos criar algumas regras para mantê-lo integro.
     */
    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public User create(User userToCreate) {
        ofNullable(userToCreate).orElseThrow(() -> new BusinessException("User to create must not be null."));
        ofNullable(userToCreate.getAccount()).orElseThrow(() -> new BusinessException("User account must not be null."));
        ofNullable(userToCreate.getCard()).orElseThrow(() -> new BusinessException("User card must not be null."));

        this.validateChangeableId(userToCreate.getId(), "created");
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new BusinessException("This account number already exists.");
        }
        if (userRepository.existsByCardNumber(userToCreate.getCard().getNumber())) {
            throw new BusinessException("This card number already exists.");
        }
        return this.userRepository.save(userToCreate);
    }

    @Transactional
    public User update(Long id, User userToUpdate) {
        this.validateChangeableId(id, "updated");
        User dbUser = this.findById(id);
        if (!dbUser.getId().equals(userToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbUser.setName(userToUpdate.getName());
        dbUser.setAccount(userToUpdate.getAccount());
        dbUser.setCard(userToUpdate.getCard());
        dbUser.setFeatures(userToUpdate.getFeatures());
        dbUser.setNews(userToUpdate.getNews());

        return this.userRepository.save(dbUser);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        User dbUser = this.findById(id);
        this.userRepository.delete(dbUser);
    }

    // Método patch() para atualizações parciais
    @Transactional
    public User patch(Long id, Map<String, Object> updates) {
        // Buscar o usuário pelo ID
        User user = this.findById(id);

        // Iterar sobre o mapa de atualizações e aplicar as mudanças
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    user.setName((String) value);  // Atualizar o nome do usuário
                    break;
                case "account":
                    user.setAccount((Account) value); // Atualizar a conta
                    break;
                case "card":
                    if (value instanceof Map) {
                        Map<String, Object> cardUpdates = (Map<String, Object>) value;
                        if (cardUpdates.containsKey("limit")) {
                            // Garantir que o limite seja um valor válido (BigDecimal)
                            Object limitValue = cardUpdates.get("limit");
                            if (limitValue != null) {
                                try {
                                    // Converte o valor para BigDecimal de forma segura
                                    BigDecimal newLimit = new BigDecimal(limitValue.toString());

                                    // Atualiza o limite diretamente, utilizando o método setLimit com BigDecimal
                                    user.getCard().setLimit(newLimit);
                                } catch (NumberFormatException e) {
                                    // Caso ocorra um erro de conversão, lança uma exceção com a mensagem de erro
                                    throw new IllegalArgumentException("O valor de 'limit' não é válido. Deve ser um número.");
                                }
                            }
                        }
                    }
                    break;
                case "features":
                    user.setFeatures((List<Feature>) value); // Atualizar as features
                    break;
                case "news":
                    user.setNews((List<News>) value); // Atualizar as notícias
                    break;
                default:
                    // Ignorar campos desconhecidos
                    break;
            }
        });

        // Salvar o usuário com as atualizações no banco de dados
        return this.userRepository.save(user);
    }



    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }
}
