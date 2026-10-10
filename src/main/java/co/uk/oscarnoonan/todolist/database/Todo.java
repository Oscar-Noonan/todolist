package co.uk.oscarnoonan.todolist.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String note;

    private Boolean isCompleted;

    public Todo() {}

    public Todo(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public Boolean getisCompleted() {
        return isCompleted;
    }

    public void setisCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}