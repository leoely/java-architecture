package com.example.certificate.mapper;

import com.example.certificate.entity.inner.CertificateInner;
import com.example.certificate.entity.response.CertificateResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CertificateMapper {
  void insert(CertificateInner certificateInner);
  ArrayList<CertificateResponse> selectCodeByUserId(String id);
}
