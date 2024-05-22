package com.geracaorelatorio.infra.adapter.controller;

import com.geracaorelatorio.app.usecases.TransformarHtmlEmPdfUseCase;
import com.geracaorelatorio.infra.adapter.dto.PdfDto;
import com.geracaorelatorio.infra.adapter.viewmodels.PdfViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/gerar-pdf")
public class TransformarEmPdfController {

    @GetMapping
    private ResponseEntity<byte[]> transformarHtmlEmPdf(@RequestParam("arquivo") MultipartFile html) throws IOException {

        TransformarHtmlEmPdfUseCase transformarHtmlEmPdfUseCase = new TransformarHtmlEmPdfUseCase();
        byte[] bytes = transformarHtmlEmPdfUseCase.execute(html);
        return ResponseEntity.ok(bytes);
    }
}
