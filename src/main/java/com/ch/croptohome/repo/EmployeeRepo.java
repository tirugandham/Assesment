package com.ch.croptohome.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ch.croptohome.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE " +
            "LOWER(e.employeeId) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(e.userName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    List<Employee> findBySearchTerm(@Param("searchTerm") String searchTerm);

}
