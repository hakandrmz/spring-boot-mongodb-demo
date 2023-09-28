package guru.hakandurmaz.springbootmongodb.service;

import guru.hakandurmaz.springbootmongodb.model.Company;
import guru.hakandurmaz.springbootmongodb.model.Department;
import guru.hakandurmaz.springbootmongodb.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
  private final CompanyRepository companyRepository;
  private final DepartmentService departmentService;

  public void addDepartmentToCompany(String companyId, String departmentId) {
    Company company = companyRepository.findById(companyId).orElse(null);
    Department department = departmentService.getDepartmentById(departmentId).orElse(null);
    if (company != null && department != null) {
      department.setCompany(company);
      departmentService.createDepartment(department);
    }
  }

  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  public Optional<Company> getCompanyById(String id) {
    return companyRepository.findById(id);
  }

  public Company createCompany(Company company) {
    return companyRepository.save(company);
  }

  public void deleteCompany(String id) {
    companyRepository.deleteById(id);
  }
}
