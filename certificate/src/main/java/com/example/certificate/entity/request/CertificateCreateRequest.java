package com.example.certificate.entity.request;

import org.springframework.vault.repository.mapping.Secret;

@Secret(backend = "certificates")
public record CertificateCreateRequest(String id, String userId, String code) {}
