
package com.apress.cems.pojos.repos.stub;

import com.apress.cems.dao.AbstractEntity;
import com.apress.cems.pojos.repos.AbstractRepo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public abstract class StubAbstractRepo <T extends AbstractEntity> implements AbstractRepo<T> {

    protected Map<Long, T> records = new HashMap<>();

    @Override
    public void save(T entity) {
        if (entity.getId() == null) {
            var id = (long) records.size() + 1;
            entity.setId(id);
        }
        records.put(entity.getId(), entity);
    }

    @Override
    public void delete(T entity) {
        records.remove(entity.getId());
    }

    @Override
    public int deleteById(Long entityId) {
        return records.remove(entityId) == null? 0 : 1;
    }

    @Override
    public T findById(Long entityId) {
        return records.get(entityId);
    }
}
