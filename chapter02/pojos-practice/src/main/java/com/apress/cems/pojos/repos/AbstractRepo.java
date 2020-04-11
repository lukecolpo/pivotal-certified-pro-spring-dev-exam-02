
package com.apress.cems.pojos.repos;

import com.apress.cems.dao.AbstractEntity;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public interface AbstractRepo <T extends AbstractEntity> {

    void save(T entity);

    void delete(T entity);

    int deleteById(Long entityId);

    T findById(Long entityId);
}
