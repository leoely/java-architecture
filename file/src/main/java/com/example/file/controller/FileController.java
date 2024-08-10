package com.example.file.controller;

import com.example.common.entity.JsonResult;
import com.example.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
  @Autowired
  FileService fileService;

  @PostMapping("/files/upload")
  public JsonResult<?> uploadFile(@RequestParam("file")MultipartFile multipartFile) {
    try {
      fileService.save(multipartFile);
    } catch (IOException e) {
      return JsonResult.bad("Upload file fail.");
    }
    return JsonResult.ok("Upload file success");
  }
}
