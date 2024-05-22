package com.geracaorelatorio.infra.adapter.viewmodels;

import com.geracaorelatorio.infra.adapter.dto.PdfDto;

public class PdfViewModel {
    public static PdfDto toDto(byte[] bytes){
        return new PdfDto(bytes);
    }
}
