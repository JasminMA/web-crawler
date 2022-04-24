package com.webcrawler.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    @Builder.Default
    private Boolean success = true;

    private ErrorPayload errors;

    @Builder.Default
    private Integer code = HttpStatus.OK.value();

    private T payload;

    private String serviceTime;

    public static <T> ApiResponse<T> fail(final HttpStatus errorStatus) {

        return status(false, errorStatus, null, null);
    }

    public static <T> ApiResponse<T> ok(final T payload) {

        return status(HttpStatus.OK, payload, null);
    }

    public static <T> ApiResponse<T> created(final T payload) {

        return status(HttpStatus.CREATED, payload, null);
    }

    public static <T> ApiResponse<T> accepted(final T payload) {

        return status(HttpStatus.ACCEPTED, payload, null);
    }

    public static <T> ApiResponse<T> ok(final T payload, final String serviceTime) {

        return status(HttpStatus.OK, payload, serviceTime);
    }

    public static <T> ApiResponse<T> created(final T payload, final String serviceTime) {

        return status(HttpStatus.CREATED, payload, serviceTime);
    }

    public static <T> ApiResponse<T> accepted(final T payload, final String serviceTime) {

        return status(HttpStatus.ACCEPTED, payload, serviceTime);
    }

    private static <T> ApiResponse<T> status(final HttpStatus status, final T payload, final String serviceTime) {

        return new ApiResponse<>(true, null, status.value(), payload, serviceTime);
    }

    private static <T> ApiResponse<T> status(final boolean sucess, final HttpStatus status, final T payload, final String serviceTime) {

        return new ApiResponse<>(sucess, null, status.value(), payload, serviceTime);
    }

}
