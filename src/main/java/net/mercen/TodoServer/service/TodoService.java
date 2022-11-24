package net.mercen.TodoServer.service;

import lombok.AllArgsConstructor;
import net.mercen.TodoServer.model.TodoEntity;
import net.mercen.TodoServer.model.TodoRequest;
import net.mercen.TodoServer.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    //    1	todo Add Item
    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoEntity);
    }
    //    2	todo Get an Item
    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    //    3	todo Get all Items
    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }
    //    4	todo Modify an Item
    public TodoEntity updateById(Long id, TodoRequest request) {
        TodoEntity todoEntity = this.searchById(id);
        if(request.getTitle() != null) {
            todoEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }
    //    5	todo Delete an Item
    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }
    //    6	todo Delete all Items
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }

}