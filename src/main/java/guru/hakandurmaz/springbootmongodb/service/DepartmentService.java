package guru.hakandurmaz.springbootmongodb.service;

import guru.hakandurmaz.springbootmongodb.model.Department;
import guru.hakandurmaz.springbootmongodb.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
  private final DepartmentRepository departmentRepository;

  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }

  public Optional<Department> getDepartmentById(String id) {
    return departmentRepository.findById(id);
  }

  public Department createDepartment(Department department) {
    return departmentRepository.save(department);
  }

  public void deleteDepartment(String id) {
    departmentRepository.deleteById(id);
  }
}
