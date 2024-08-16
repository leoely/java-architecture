package com.example.text.controller;

import com.example.common.entity.JsonResult;
import com.example.text.entity.inner.Text;
import com.example.text.service.TextService;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;


@RestController
public class TextController {
  @Autowired
  TextService textService;

  @GetMapping("/texts/search")
  public JsonResult<ArrayList<Text>> fullTextSearchText(@RequestParam String match) throws IOException {
    ArrayList<Text> result = textService.fullTextSearchText(match);
    return JsonResult.ok(result);
  }

  @PostMapping("/texts/insert")
  public JsonResult<?> insertText(@RequestBody Text text) {
    textService.insertText(text);
    return JsonResult.ok(null);
  }

  @DeleteMapping("/texts/{id}")
  public JsonResult<?> deleteText(@PathVariable String id) {
    textService.deleteTextById(id);
    return JsonResult.ok(null);
  }
}
