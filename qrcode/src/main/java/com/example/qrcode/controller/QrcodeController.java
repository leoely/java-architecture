package com.example.qrcode.controller;

import com.example.common.entity.JsonResult;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@RestController
public class QrcodeController {
  Logger logger = LoggerFactory.getLogger(QrcodeController.class);

  @GetMapping("/qrcodes/image")
  public JsonResult<String> getQrcode(@RequestParam String code) throws WriterException, IOException {
    logger.info("[Visit] Api /certificates/insert.");
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(code, BarcodeFormat.QR_CODE, 200, 200);
    BufferedImage result = MatrixToImageWriter.toBufferedImage(bitMatrix);
    Path path = FileSystems.getDefault().getPath("/tmp/qrcode/qrcode.png");
    MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    return JsonResult.ok("success");
  }
}
