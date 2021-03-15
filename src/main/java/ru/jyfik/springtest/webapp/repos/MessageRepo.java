package ru.jyfik.springtest.webapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jyfik.springtest.webapp.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Integer> {
}
