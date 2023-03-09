package com.example.haspermissiondemo.service;

import com.example.haspermissiondemo.model.Document;
import com.example.haspermissiondemo.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    // @PostAuthorize("hasPermission(returnObject, 'ROLE_admin')") // for first override method
    @PreAuthorize("hasPermission(#code, 'document', 'ROLE_admin')")
    public Document getDocument(String code){
        return documentRepository.findDocument(code);
    }
}
