package com.restApiFileSystem.RestApiFileSystem.entity;
import jakarta.persistence.*;
import com.restApiFileSystem.RestApiFileSystem.entity.Document;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Document> documents;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Document> getDocuments() {
        if (documents == null) {
            documents = new ArrayList<>();
        }
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}