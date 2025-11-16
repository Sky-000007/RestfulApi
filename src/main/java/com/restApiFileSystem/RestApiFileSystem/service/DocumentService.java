package com.restApiFileSystem.RestApiFileSystem.service;

import com.restApiFileSystem.RestApiFileSystem.entity.Document;
import com.restApiFileSystem.RestApiFileSystem.entity.Employee;
import com.restApiFileSystem.RestApiFileSystem.repository.DocumentRepository;
import com.restApiFileSystem.RestApiFileSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Upload document for a specific employee
    public Document uploadDocument(Long employeeId, MultipartFile file) throws IOException {
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();

            Document document = new Document();
            document.setFileName(file.getOriginalFilename());
            document.setFileType(file.getContentType());
            document.setFileSize(file.getSize());
            document.setData(file.getBytes());
            document.setEmployee(employee);

            return documentRepository.save(document);
        }
        return null;
    }

    // Get document by ID
    public Document getDocumentById(Long id) {
        Optional<Document> document = documentRepository.findById(id);
        return document.orElse(null);
    }

    // Delete document by ID
    public boolean deleteDocument(Long id) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()) {
            documentRepository.delete(document.get());
            return true;
        }
        return false;
    }
}
