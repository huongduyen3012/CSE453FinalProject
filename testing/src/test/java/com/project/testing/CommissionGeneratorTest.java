package com.project.testing;

import com.project.testing.entities.Commission;
import com.project.testing.entities.Triangle;
import com.project.testing.repositories.CommissionRepository;
import com.project.testing.repositories.TriangleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CommissionGeneratorTest {
    @Autowired
    private CommissionRepository repo ;

    @Test
    public void testAddNew() {
        Commission commission = new Commission();
        commission.setInput(30,35,40);

        Commission savedCommission = repo.save(commission);

        Assertions.assertNotNull(savedCommission);
        Assertions.assertTrue(savedCommission.getId() >0);
    }

    @Test
    public void testListAll() {
        Iterable<Commission> commissions = repo.findAll();
        int count = 0;

        for (Commission commission : commissions) {
            System.out.println(commission);
            count++;
        }

        Assertions.assertTrue(count > 0);
    }

    @Test
    public void testClear(){
        repo.truncateTable();
        Collection<Commission> triangles = (Collection<Commission>) repo.findAll();

        Assertions.assertEquals(0, triangles.size());
    }
}
