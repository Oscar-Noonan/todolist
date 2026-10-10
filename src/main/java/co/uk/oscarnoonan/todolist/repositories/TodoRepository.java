package co.uk.oscarnoonan.todolist.repositories;

import co.uk.oscarnoonan.todolist.database.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository
        extends JpaRepository<Todo, Long> {
}