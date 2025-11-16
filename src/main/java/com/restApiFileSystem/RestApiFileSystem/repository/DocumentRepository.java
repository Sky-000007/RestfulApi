package com.restApiFileSystem.RestApiFileSystem.repository;

import com.restApiFileSystem.RestApiFileSystem.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
