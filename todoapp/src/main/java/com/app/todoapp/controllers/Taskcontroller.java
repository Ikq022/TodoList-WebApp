package com.app.todoapp.controllers;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/tasks")
public class Taskcontroller {
    @Autowired
    private  final TaskService taskService;

    public Taskcontroller(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public  String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Integer id){
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditTask(@PathVariable Integer id,Model model){
        Task task = taskService.getTaskById(id);
        if (task != null) {
            model.addAttribute("updateTask", task);
            return "edit";
        }
        return  "redirect:/";
    }
    @PostMapping("/{id}/update")
    public String updateTask(@PathVariable Integer id,@RequestParam String title,@RequestParam(required = false) boolean completed){
        taskService.updateTask(id,title,completed);
        return "redirect:/";
    }
}
