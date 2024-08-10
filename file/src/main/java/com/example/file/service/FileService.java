package com.example.file.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
  private final String root = "/tmp/upload";

  public void save(MultipartFile multipartFile) throws IOException {
    Path path = Paths.get(this.root, multipartFile.getOriginalFilename());
    Files.copy(multipartFile.getInputStream(), path);
  }
}
