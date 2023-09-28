package guru.hakandurmaz.springbootmongodb.repository;

import guru.hakandurmaz.springbootmongodb.model.Company;
import guru.hakandurmaz.springbootmongodb.model.Department;
import guru.hakandurmaz.springbootmongodb.model.User;
import java.util.Set;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  User findByUsername(String username);

  Set<User> findByCompanies(Company company);

  Set<User> findByDepartments(Department department);
}
