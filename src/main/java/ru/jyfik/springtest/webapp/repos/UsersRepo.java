package ru.jyfik.springtest.webapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jyfik.springtest.webapp.domain.User;

public interface UsersRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
