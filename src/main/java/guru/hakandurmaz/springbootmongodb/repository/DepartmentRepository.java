package guru.hakandurmaz.springbootmongodb.repository;

import guru.hakandurmaz.springbootmongodb.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {}
