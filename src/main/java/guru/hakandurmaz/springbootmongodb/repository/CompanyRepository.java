package guru.hakandurmaz.springbootmongodb.repository;

import guru.hakandurmaz.springbootmongodb.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {}
