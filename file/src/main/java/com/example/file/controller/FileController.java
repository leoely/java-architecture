package com.example.file.controller;

import com.example.common.entity.JsonResult;
import com.example.file.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
  Logger logger = LoggerFactory.getLogger(FileController.class);

  @Autowired
  FileService fileService;

  @PostMapping("/files/upload")
  public JsonResult<?> uploadFile(@RequestParam("file")MultipartFile multipartFile) {
    logger.info("[Visit] Api /files/upload.");
    try {
      fileService.save(multipartFile);
    } catch (IOException e) {
      return JsonResult.bad("Upload file fail.");
    }
    return JsonResult.ok("Upload file success");
  }
}
