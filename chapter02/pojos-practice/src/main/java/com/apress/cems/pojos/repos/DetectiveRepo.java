
package com.apress.cems.pojos.repos;

import com.apress.cems.dao.Detective;

import java.util.Optional;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public interface DetectiveRepo extends AbstractRepo<Detective> {

    Optional<Detective> findByBadgeNumber(String badgeNumber);
}
