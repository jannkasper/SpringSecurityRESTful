package jannkasper.spring.repositories;

import jannkasper.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
     Optional<User> findByCustomerName (String customerName);
     Optional<User> findByLogin (String login);
     boolean deleteByLogin(String login);
}
