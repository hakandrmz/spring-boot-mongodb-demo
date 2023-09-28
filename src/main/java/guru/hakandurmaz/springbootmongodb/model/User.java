package guru.hakandurmaz.springbootmongodb.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Data
public class User {
  @Id private String id;
  private String username;

  @DBRef private Set<Company> companies = new HashSet<>();
  @DBRef private Set<Department> departments = new HashSet<>();
}
