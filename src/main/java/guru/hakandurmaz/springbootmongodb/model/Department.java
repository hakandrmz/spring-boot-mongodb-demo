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
public class Department {
  @Id private String id;
  private String name;

  @DBRef private Set<User> users = new HashSet<>();
  @DBRef private Company company;
}
