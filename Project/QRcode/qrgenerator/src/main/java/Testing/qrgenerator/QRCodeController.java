package com.example.demo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
public class QRCodeController {

    @GetMapping("/")
    public String showForm() {
        return "qrcode-form";
    }

    @PostMapping("/generateQRCode")
    public String generateQRCode(@RequestParam String text, Model model) {
        try {
            String encodedText = URLEncoder.encode(text, "UTF-8");

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            model.addAttribute("qrCodeImage", qrCodeWriter.encode(encodedText, BarcodeFormat.QR_CODE, 200, 200, hints));
        } catch (UnsupportedEncodingException | WriterException e) {
            // Handle exceptions
            e.printStackTrace();
        }

        return "qrcode-result";
    }
}
