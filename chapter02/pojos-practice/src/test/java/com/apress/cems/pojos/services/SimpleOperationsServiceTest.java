
package com.apress.cems.pojos.services;

import com.apress.cems.dao.*;
import com.apress.cems.util.CaseType;
import com.apress.cems.util.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
// comment the @Disabled annotation to run the test
@Disabled
public class SimpleOperationsServiceTest extends SimpleServiceTestBase {
    static final Long DETECTIVE_ID = 1L;
    static final String BADGE_NO = "NY112233";

    @BeforeEach
    void setUp() {
        init();
        //create detective
        var person = new Person();
        person.setId(DETECTIVE_ID);
        person.setFirstName("Sherlock");
        person.setLastName("Holmes");
        person.setHiringDate(LocalDateTime.now());
        person.setPassword("123");
        var detective = detectiveService.createDetective(person, Rank.INSPECTOR);
        detective.setBadgeNumber(BADGE_NO);
        assertNotNull(detective);
        assertEquals(DETECTIVE_ID, detective.getId());

        // create storage entries
        var storage = new Storage();
        storage.setName("Here");
        storage.setLocation("Here");
        storageRepo.save(storage);
        assertNotNull(storage.getId());

        var storage1 = new Storage();
        storage1.setName("There");
        storage1.setLocation("There");
        storageRepo.save(storage1);
        assertNotNull(storage1.getId());
    }

    @DisplayName("Pojo Exercise Practice")
    @Test
    void testCreateCasePractice(){
        Map<Evidence, String> evidenceLocationMap = new HashMap<>();
        var ev = new Evidence();
        ev.setItemName("drugs");
        ev.setNotes("confiscated from minor");
        ev.setNumber("DR12345687");

        evidenceLocationMap.put(ev, "Here");

        //create criminal case
        var criminalCase = operationsService.createCriminalCase(CaseType.FELONY,
                "Drugs being sold to minors", BADGE_NO, evidenceLocationMap);

        assertNotNull(criminalCase);
        assertNotNull(criminalCase.getLeadInvestigator());

    }

}
