package com.restApiFileSystem.RestApiFileSystem.controller;

import com.restApiFileSystem.RestApiFileSystem.entity.Document;
import com.restApiFileSystem.RestApiFileSystem.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // Endpoint to upload a document for a specific employee
    @PostMapping("/upload/{employeeId}")
    public ResponseEntity<Document> uploadDocument(@PathVariable Long employeeId, @RequestParam("file") MultipartFile file) {
        try {
            Document uploadedDocument = documentService.uploadDocument(employeeId, file);
            if (uploadedDocument != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(uploadedDocument);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint to retrieve a document by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            return ResponseEntity.ok(document);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Endpoint to delete a document by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        boolean isDeleted = documentService.deleteDocument(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
