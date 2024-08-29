package com.example.certificate.service;

import com.example.certificate.entity.inner.CertificateInner;
import com.example.certificate.entity.request.CertificateCreateRequest;
import com.example.certificate.entity.response.CertificateResponse;
import com.example.certificate.mapper.CertificateMapper;
import jakarta.annotation.PostConstruct;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultSysOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultTransitOperations;
import org.springframework.vault.support.VaultMount;

import java.util.ArrayList;

@Service
public class CertificateService {
  @Autowired
  CertificateMapper certificateMapper;

  @Autowired
  VaultTemplate vaultTemplate;

  @Autowired
  RedissonClient redissonClient;

  final static String INSERT_LOCK = "insert-lock";

  VaultTransitOperations vaultTransitOperations;
  VaultSysOperations vaultSysOperations;

  @PostConstruct
  void createVaultTransitOperations() {
    this.vaultTransitOperations = vaultTemplate.opsForTransit();
    this.vaultSysOperations = vaultTemplate.opsForSys();
    if (!this.vaultSysOperations.getMounts().containsKey("transit/")) {
      this.vaultSysOperations.mount("transit", VaultMount.create("transit"));
      this.vaultTransitOperations.createKey("demo-key");
    }
  }

  public void insert(CertificateCreateRequest certificateCreateRequest) {
    RLock lock = redissonClient.getLock(INSERT_LOCK);
    boolean isLocked = lock.tryLock();
    if (isLocked) {
      lock.lock();
      CertificateInner certificateInner = new CertificateInner(certificateCreateRequest.id(), certificateCreateRequest.userId(), this.vaultTransitOperations.encrypt("demo-key", certificateCreateRequest.code()));
      certificateMapper.insert(certificateInner);
      lock.unlock();
    }
  }

  public String selectCodeByUserId(String id) {
    ArrayList<CertificateResponse> certificateResponses = certificateMapper.selectCodeByUserId(id);
    if (certificateResponses.isEmpty()) {
      return "";
    } else {
      return this.vaultTransitOperations.decrypt("demo-key", certificateResponses.get(0).code());
    }
  }
}
