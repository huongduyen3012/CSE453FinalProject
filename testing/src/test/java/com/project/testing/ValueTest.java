package com.project.testing;

import com.project.testing.entities.BoundaryValue;
import com.project.testing.entities.Triangle;
import com.project.testing.repositories.BoundaryValueRepository;
import com.project.testing.repositories.TriangleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Collection;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ValueTest {
    @Autowired
    private BoundaryValueRepository repo;

    @Test
    public void testAddNew() {
        BoundaryValue value = new BoundaryValue();
        value.setMax(200);
        value.setMin(20);
        value.setType("normal");

        BoundaryValue saved = repo.save(value);

        Assertions.assertNotNull(saved);
        Assertions.assertTrue(saved.getId() > 0);
    }

    @Test
    public void testClear() {
        repo.deleteAll();
        Collection<BoundaryValue> triangles = (Collection<BoundaryValue>) repo.findAll();

        Assertions.assertEquals(0, triangles.size());
    }
}
