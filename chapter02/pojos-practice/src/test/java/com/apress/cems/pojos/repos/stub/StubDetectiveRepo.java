
package com.apress.cems.pojos.repos.stub;

import com.apress.cems.dao.Detective;
import com.apress.cems.pojos.repos.DetectiveRepo;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Optional;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public class StubDetectiveRepo extends StubAbstractRepo<Detective> implements DetectiveRepo {

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        return Optional.of(records.get(1L));
    }
}
