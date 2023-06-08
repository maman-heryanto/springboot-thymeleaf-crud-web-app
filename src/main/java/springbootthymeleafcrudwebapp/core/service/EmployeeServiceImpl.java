package springbootthymeleafcrudwebapp.core.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import springbootthymeleafcrudwebapp.core.model.Employee;
import springbootthymeleafcrudwebapp.core.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }
    @Override
    public Employee employeeGetById(long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = null;
        if (employeeOptional.isPresent()){
            employee = employeeOptional.get();
        }else{
            throw new RuntimeException("Employee not found for id:"+id);
        }
        return employee;
    }
    @Override
    public void deleteEmployeeById(long id){
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return this.employeeRepository.findAll(pageable);
    }


}
