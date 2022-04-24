package com.webcrawler.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorPayload {

    private String enMessage;

    private String arMessage;

    private LocalDateTime timestamp = LocalDateTime.now();

    private String detailsAsString;

}