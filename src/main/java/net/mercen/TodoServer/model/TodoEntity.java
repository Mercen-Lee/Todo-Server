package net.mercen.TodoServer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "todo_entity")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "todoOrder", nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

    public TodoEntity(Long id, String title, Long order, Boolean completed){
        this.id =  id;
        this.title = title;
        this.order = order;
        this.completed = completed;
    }
}