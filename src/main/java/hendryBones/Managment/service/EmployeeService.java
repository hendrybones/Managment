package hendryBones.Managment.service;

import hendryBones.Managment.exception.UserNotFoundException;
import hendryBones.Managment.model.Employee;
import hendryBones.Managment.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){

        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){

        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){

        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id +"was not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployedById(id);

    }
}
