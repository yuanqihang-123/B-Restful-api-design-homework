package com.thoughtworks.capability.gtb.restfulapidesign.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Integer statusCode;
    private String message;
}
