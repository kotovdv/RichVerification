package com.jquartz.rich.validation.core.pointer.exception;

import com.jquartz.rich.validation.core.exception.RichValidationException;

public class InvalidFieldPointerException extends RichValidationException {

    public InvalidFieldPointerException(String fieldName, Class<?> sourceClass, Throwable cause) {
        super(String.format("Failed to extract field [%s] from class [%s]", fieldName, sourceClass.getSimpleName()), cause);
    }
}
