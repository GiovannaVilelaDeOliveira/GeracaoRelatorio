package com.geracaorelatorio.app.usecases;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.temporal.TemporalField;
import java.util.Arrays;

public class TransformarHtmlEmPdfUseCase {
    public byte[] execute(MultipartFile multipartFile) throws IOException {

        File tempFile = File.createTempFile("teste","pdf");
       // File html = new File("C:\\Users\\usuario\\Downloads\\teste.html");
        File html = multipartFile.getResource().getFile();
        HtmlConverter.convertToPdf(html,tempFile);

        InputStream input = tempFile.toURL().openStream();
        byte [] bytes = input.readAllBytes();
        System.out.println(Arrays.toString(bytes));
        return bytes;
    }
}
