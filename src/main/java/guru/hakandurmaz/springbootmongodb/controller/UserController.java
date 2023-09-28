package guru.hakandurmaz.springbootmongodb.controller;

import guru.hakandurmaz.springbootmongodb.model.User;
import guru.hakandurmaz.springbootmongodb.service.UserService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public User createUser(@RequestParam String username) {
    return userService.createUser(username);
  }

  @GetMapping("/{userId}")
  public User getUserById(@PathVariable String userId) {
    return userService.getUserById(userId);
  }

  @GetMapping("/{userId}/companies")
  public Set<User> getUsersByCompany(@PathVariable String userId, @RequestParam String companyId) {
    return userService.getUsersByCompany(companyId);
  }

  @GetMapping("/{departmentId}/departments")
  public Set<User> getUsersByDepartment(@PathVariable String departmentId) {
    return userService.getUsersByDepartment(departmentId);
  }

  @GetMapping("/findByUsers/{username}")
  public User getUsersByName(@PathVariable String username) {
    return userService.getUsersByName(username);
  }

  @PostMapping("/{userId}/add-company")
  public void addUserToCompany(@PathVariable String userId, @RequestParam String companyId) {
    userService.addUserToCompany(userId, companyId);
  }

  @PostMapping("/{userId}/add-department")
  public void addUserToDepartment(@PathVariable String userId, @RequestParam String departmentId) {
    userService.addUserToDepartment(userId, departmentId);
  }
}
