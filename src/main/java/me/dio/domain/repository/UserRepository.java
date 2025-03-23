package me.dio.domain.repository;

import me.dio.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // anotação: acessar e manipular os dados do banco de dados
// Userrepository herdará os métodos da interface JpaRespository
public interface UserRepository extends JpaRepository<User, Long> {
    //verifica se já existe um usuario com este número de conta
    boolean existsByAccountNumber(String number);

    boolean existsByCardNumber(String number);
}
