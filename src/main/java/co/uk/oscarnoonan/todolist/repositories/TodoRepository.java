package co.uk.oscarnoonan.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.uk.oscarnoonan.todolist.database.Todo;

public interface TodoRepository
        extends JpaRepository<Todo, Long> {
}