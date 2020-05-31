package taskmanager.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import taskmanager.demo.domain.SubTask;
import taskmanager.demo.domain.Task;
import taskmanager.demo.dto.SubTaskDTO;
import taskmanager.demo.dto.TaskDTO;
import taskmanager.demo.service.SubTaskService;
import taskmanager.demo.service.TaskService;

import javax.validation.Valid;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private SubTaskService subTaskService;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/tasks")
    public String task(Model model) {
        if (taskService.getTasks().size() == 0) {
            model.addAttribute("tasksList", null);
        } else {
            model.addAttribute("tasksList", taskService.getTasks());
        }
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String showTask(Model model, @PathVariable(value = "id") String id) {
        Long lid = Long.parseLong(id);
        model.addAttribute("task", taskService.getTaskDTO(lid));
        if (subTaskService.getSubTasksFromIdMainTask(lid).size() == 0) {
            model.addAttribute("subtasks", null);
        } else {
            model.addAttribute("subtasks", subTaskService.getSubTasksFromIdMainTask(lid));
        }
        return "taskdetail";
    }

    @GetMapping("/tasks/new")
    public String newTask(Model model) {
        model.addAttribute("taskDTO", new TaskDTO());
        return "newTask";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newTask";
        }
        taskService.addTask(task);
        return "redirect:tasks";
    }

    @PostMapping("/tasks/edit")
    public String editValues(@ModelAttribute @Valid TaskDTO task, @RequestParam(value = "id") String id, BindingResult bindingResult){
        Long lid = Long.parseLong(id);
        if (bindingResult.hasErrors()){
            return "editTask";
        }
        taskService.updateTask(lid, task);
        return "redirect:/tasks/" + lid;
    }

    @GetMapping("/tasks/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id") String id){
        Long lid = Long.parseLong(id);
        if (taskService.getTask(lid) != null) {
            model.addAttribute("id", lid);
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTaskDTO(taskService.getTask(lid));
            model.addAttribute("taskDTO", taskDTO);
            return "editTask";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String createSubTask(Model model, @PathVariable(value = "id") String id){
        Long lid = Long.parseLong(id);
        if (taskService.getTask(lid) != null) {
            SubTaskDTO subTaskDTO = new SubTaskDTO();
            subTaskDTO.setIdMainTask(lid);
            model.addAttribute("subtask", subTaskDTO);
            model.addAttribute("title", taskService.getTask(lid).getTitle());
            return "newSubTask";
        }
        return "redirect:tasks";
    }

    @PostMapping("/addSub")
    public String addSubTask(@ModelAttribute @Valid SubTaskDTO subtask, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("Some error");
            return "newSubTask";
        }
        subTaskService.addSubTask(subtask);
        return "redirect:/tasks/" + subtask.getIdMainTask();
    }
}
