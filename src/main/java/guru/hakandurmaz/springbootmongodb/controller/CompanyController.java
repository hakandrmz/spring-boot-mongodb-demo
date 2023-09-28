package guru.hakandurmaz.springbootmongodb.controller;

import guru.hakandurmaz.springbootmongodb.model.Company;
import guru.hakandurmaz.springbootmongodb.service.CompanyService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
  private final CompanyService companyService;

  @GetMapping
  public List<Company> getAllCompanies() {
    return companyService.getAllCompanies();
  }

  @GetMapping("/{id}")
  public Optional<Company> getCompanyById(@PathVariable String id) {
    return companyService.getCompanyById(id);
  }

  @PostMapping
  public Company createCompany(@RequestBody Company company) {
    return companyService.createCompany(company);
  }

  @PostMapping("/{companyId}/add-department/{departmentId}")
  public void addDepartmentToCompany(
      @PathVariable String companyId, @PathVariable String departmentId) {
    companyService.addDepartmentToCompany(companyId, departmentId);
  }

  @DeleteMapping("/{id}")
  public void deleteCompany(@PathVariable String id) {
    companyService.deleteCompany(id);
  }
}
