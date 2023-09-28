package guru.hakandurmaz.springbootmongodb.model;

import java.util.HashSet;
import java.util.Set;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
public class Company {
  @Id private String id;
  private String name;

  @DBRef private Set<User> users = new HashSet<>();
  @DBRef private Set<Department> departments = new HashSet<>();
}
