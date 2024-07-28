package com.example.certificate.controller;

import com.example.certificate.entity.request.CertificateCheckRequest;
import com.example.certificate.entity.request.CertificateCreateRequest;
import com.example.certificate.service.CertificateService;
import com.example.common.entity.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificateController {
  @Autowired
  CertificateService certificateService;

  Logger logger = LoggerFactory.getLogger(CertificateController.class);

  @PostMapping("/certificates/insert")
  public JsonResult<?> createCertificate(@RequestBody CertificateCreateRequest certificateCreateRequest) {
    logger.info("[Visit] Api /certificates/insert.");
    certificateService.insert(certificateCreateRequest);
    return JsonResult.ok(null);
  }

  @PostMapping("certificates/check")
  public JsonResult<Boolean> checkCertificate(@RequestBody CertificateCheckRequest certificateCheckRequest) {
    logger.info("[Visit] Api /certificates/check.");
    boolean result = certificateService.selectCodeByUserId(certificateCheckRequest.userId()).equals(certificateCheckRequest.code());
    return JsonResult.ok(result);
  }
}
