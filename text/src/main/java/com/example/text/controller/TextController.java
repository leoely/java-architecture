package com.example.text.controller;

import com.example.common.entity.JsonResult;
import com.example.text.entity.inner.Text;
import com.example.text.service.TextService;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class TextController {
  @Autowired
  TextService textService;

  @GetMapping("/texts/search")
  public JsonResult<String> fullTextSearchText(@RequestParam String match) throws IOException {
    String result = textService.fullTextSearchText(match);
    return JsonResult.ok(result);
  }

  @PostMapping("/texts/insert")
  public void insertText(@RequestBody Text text) {
    textService.insertText(text);
  }

  @DeleteMapping("/texts/{id}")
  public void deleteText(@PathVariable String id) {
    textService.deleteTextById(id);
  }
}
