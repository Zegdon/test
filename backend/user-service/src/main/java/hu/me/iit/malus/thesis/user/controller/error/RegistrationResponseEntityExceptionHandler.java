package hu.me.iit.malus.thesis.user.controller.error;

import hu.me.iit.malus.thesis.user.controller.dto.RegistrationResponse;
import hu.me.iit.malus.thesis.user.model.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handler for registration process
 * @author Javorek Dénes
 */
public class RegistrationResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messages;

    @Autowired
    public RegistrationResponseEntityExceptionHandler(MessageSource messages) {
        this.messages = messages;
    }

    /**
     * Handles invalid RegistrationRequest, returnd 400 (Bad Request)
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        logger.error("400 Status Code", ex);
        final BindingResult result = ex.getBindingResult();
        final RegistrationResponse bodyOfResponse = new RegistrationResponse(result.getAllErrors(), "Invalid" + result.getObjectName());
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Handles UserAlreadyExists exception, returns 409 (Conflict)
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({ UserAlreadyExistException.class })
    public ResponseEntity<Object> handleUserAlreadyExist(final RuntimeException ex, final WebRequest request) {
        logger.error("409 Status Code", ex);
        final RegistrationResponse bodyOfResponse = new RegistrationResponse(messages.getMessage("message.regError", null, request.getLocale()), "UserAlreadyExist");
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
