package movies.select.com.br.backend.adapters.inbound.handler;

import jakarta.servlet.http.HttpServletRequest;
import movies.select.com.br.backend.domain.exception.ApiErrorResponse;
import movies.select.com.br.backend.domain.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

import static java.time.LocalDateTime.now;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> handlerApplicationException(
            final ApplicationException exception,
            final HttpServletRequest request) {

        ApiErrorResponse response = ApiErrorResponse.builder()
                .guid(UUID.randomUUID().toString())
                .errorCode(exception.getCode())
                .message(exception.getMessage())
                .statusCode(exception.getStatus().value())
                .statusName(exception.getStatus().name())
                .path(request.getRequestURI())
                .method(request.getMethod())
                .timestamp(now())
                .build();

        return new ResponseEntity<>(response, exception.getStatus());
    }
}
