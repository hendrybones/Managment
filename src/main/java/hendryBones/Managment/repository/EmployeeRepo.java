package hendryBones.Managment.repository;

import hendryBones.Managment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmployedById(Long id);

    Optional<Employee>findEmployeeById(Long id);

}