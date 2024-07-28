package com.example.certificate.controller;

import com.example.certificate.entity.request.CertificateCheckRequest;
import com.example.certificate.entity.request.CertificateCreateRequest;
import com.example.certificate.service.CertificateService;
import com.example.common.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificateController {
  @Autowired
  CertificateService certificateService;

  @PostMapping("/certificates/insert")
  public JsonResult<?> createCertificate(@RequestBody CertificateCreateRequest certificateCreateRequest) {
    certificateService.insert(certificateCreateRequest);
    return JsonResult.ok(null);
  }

  @PostMapping("certificates/check")
  public JsonResult<Boolean> checkCertificate(@RequestBody CertificateCheckRequest certificateCheckRequest) {
    boolean result = certificateService.selectCodeByUserId(certificateCheckRequest.userId()).equals(certificateCheckRequest.code());
    return JsonResult.ok(result);
  }
}
