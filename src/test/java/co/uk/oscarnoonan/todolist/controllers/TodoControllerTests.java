package co.uk.oscarnoonan.todolist.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import co.uk.oscarnoonan.todolist.database.Todo;
import co.uk.oscarnoonan.todolist.repositories.TodoRepository;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TodoRepository todoRepository;

    @Test
    void indexReturnsIndexViewAndTodos() throws Exception {
        when(todoRepository.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("todos"));
    }

    @Test
    void indexPassesTodosToModel() throws Exception {
        Todo todo1 = new Todo("Test note 1");
        Todo todo2 = new Todo("Test note 2");
        Todo todo3 = new Todo("Test note 3");

        when(todoRepository.findAll()).thenReturn(List.of(todo1, todo2, todo3));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("todos", List.of(todo1, todo2, todo3)));
    }
}