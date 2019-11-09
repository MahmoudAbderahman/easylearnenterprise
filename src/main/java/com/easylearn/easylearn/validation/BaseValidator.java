package com.easylearn.easylearn.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.Optional;

@Log4j2
@Component
@Transactional
public abstract class BaseValidator<T> {
    @Autowired
    private EntityManager entityManager;
    private Class<T> clazz;
    private static final String ENTITY_EXISTENCE_VALIDATION_MESSAGE = "The %s with Id: [%s] doesn't exist";

    protected BaseValidator(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T validateExistence(Object primaryKey) {
        log.trace(" *** VALIDATING {} EXISTENCE *** ", clazz.getSimpleName());
        return Optional.ofNullable(entityManager.find(clazz, primaryKey))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format(ENTITY_EXISTENCE_VALIDATION_MESSAGE, clazz.getSimpleName(), primaryKey)));
    }
}

/*
package com.uptown.uptown.validation;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.Optional;

@Log4j2
@Component
@Transactional
public abstract class BaseValidator<T> {

    @Autowired
    protected EntityManager entityManager;
    private Class<T> clazz;
    private static final String ENTITY_EXISTENCE_VALIDATION_MESSAGE = "The %s with Id: [%s] doesn't exist";

    protected BaseValidator(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T validateExistence(Object primaryKey) {
        log.trace(" *** VALIDATING {} EXISTENCE *** ", clazz.getSimpleName());
        return Optional.ofNullable(entityManager.find(clazz, primaryKey))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format(ENTITY_EXISTENCE_VALIDATION_MESSAGE, clazz.getSimpleName(), primaryKey)));
    }
}
 */