package springbootthymeleafcrudwebapp.core.service;

import org.springframework.data.domain.Page;
import springbootthymeleafcrudwebapp.core.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee employeeGetById(long id);
    void deleteEmployeeById(long id);

    Page<Employee> findPaginated(int pageNo,int pageSize);


}
