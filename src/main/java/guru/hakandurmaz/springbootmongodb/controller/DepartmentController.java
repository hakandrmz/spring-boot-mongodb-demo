package guru.hakandurmaz.springbootmongodb.controller;

import guru.hakandurmaz.springbootmongodb.model.Department;
import guru.hakandurmaz.springbootmongodb.service.DepartmentService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
  private final DepartmentService departmentService;

  @GetMapping
  public List<Department> getAllDepartments() {
    return departmentService.getAllDepartments();
  }

  @GetMapping("/{id}")
  public Optional<Department> getDepartmentById(@PathVariable String id) {
    return departmentService.getDepartmentById(id);
  }

  @PostMapping
  public Department createDepartment(@RequestBody Department department) {
    return departmentService.createDepartment(department);
  }

  @DeleteMapping("/{id}")
  public void deleteDepartment(@PathVariable String id) {
    departmentService.deleteDepartment(id);
  }
}
