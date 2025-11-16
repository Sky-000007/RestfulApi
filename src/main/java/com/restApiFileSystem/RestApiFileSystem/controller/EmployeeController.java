package com.restApiFileSystem.RestApiFileSystem.controller;

import com.restApiFileSystem.RestApiFileSystem.entity.Document;
import com.restApiFileSystem.RestApiFileSystem.entity.Employee;
import com.restApiFileSystem.RestApiFileSystem.service.DocumentService;
import com.restApiFileSystem.RestApiFileSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("{id}/upload")
    public ResponseEntity<Document> uploadDocument(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        Document document = documentService.uploadDocument(id, file);
        return document != null ? ResponseEntity.ok(document) : ResponseEntity.badRequest().build();
    }
}