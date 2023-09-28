package guru.hakandurmaz.springbootmongodb.service;

import guru.hakandurmaz.springbootmongodb.model.Company;
import guru.hakandurmaz.springbootmongodb.model.Department;
import guru.hakandurmaz.springbootmongodb.model.User;
import guru.hakandurmaz.springbootmongodb.repository.CompanyRepository;
import guru.hakandurmaz.springbootmongodb.repository.DepartmentRepository;
import guru.hakandurmaz.springbootmongodb.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final CompanyRepository companyRepository;
  private final DepartmentRepository departmentRepository;

  public User createUser(String username) {
    User user = new User();
    user.setUsername(username);
    return userRepository.save(user);
  }

  public User getUserById(String userId) {
    return userRepository.findById(userId).orElse(null);
  }

  public Set<User> getUsersByCompany(String companyId) {
    Company company = companyRepository.findById(companyId).orElse(null);
    if (company != null) {
      return userRepository.findByCompanies(company);
    }
    return new HashSet<>();
  }

  public Set<User> getUsersByDepartment(String departmentId) {
    Department department = departmentRepository.findById(departmentId).orElse(null);
    if (department != null) {
      return userRepository.findByDepartments(department);
    }
    return new HashSet<>();
  }

  public void addUserToCompany(String userId, String companyId) {
    User user = userRepository.findById(userId).orElse(null);
    Company company = companyRepository.findById(companyId).orElse(null);
    if (user != null && company != null) {
      user.getCompanies().add(company);
      userRepository.save(user);
    }
  }

  public void addUserToDepartment(String userId, String departmentId) {
    User user = userRepository.findById(userId).orElse(null);
    Department department = departmentRepository.findById(departmentId).orElse(null);
    if (user != null && department != null) {
      user.getDepartments().add(department);
      userRepository.save(user);
    }
  }

  public User getUsersByName(String username) {
    return userRepository.findByUsername(username);
  }
}
