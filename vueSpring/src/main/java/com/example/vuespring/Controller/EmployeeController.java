package com.example.vuespring.Controller;

import com.example.vuespring.Entity.Employee;
import com.example.vuespring.Repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> fetchEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity saveEmployee(@RequestBody Employee employee) {
        if(employee != null) {
            employeeRepository.save(employee);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/find/{id}")
    public Employee findEmployee(@PathVariable("id") Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id){
        employeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
