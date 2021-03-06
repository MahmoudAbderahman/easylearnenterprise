/**
 * @Author: Mahmoud Abdelrahman
 * ObjectMapper Interface is where the code required for mapping objects declared.
 */
package com.easylearn.easylearn.mapper;

import java.util.Set;

public interface ObjectMapper<T, E, F> {


    T mapToEntity(E request);

    T mapToEntity(T entity, E request);

    F mapToDTO(T entity);

    Set<F> mapToDTOs(Set<T> entities);
}
