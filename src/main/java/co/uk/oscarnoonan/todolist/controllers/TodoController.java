package co.uk.oscarnoonan.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.uk.oscarnoonan.todolist.database.Todo;
import co.uk.oscarnoonan.todolist.repositories.TodoRepository;


@Controller
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    @PostMapping("/CreateNote")
    public String createNote(@RequestParam String note) {
        Todo todo = new Todo(note);

        todoRepository.save(todo);

        return "redirect:/";
    }
    
}