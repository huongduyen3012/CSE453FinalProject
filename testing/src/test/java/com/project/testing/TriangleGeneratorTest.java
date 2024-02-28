package com.project.testing;

import com.project.testing.entities.Triangle;
import com.project.testing.repositories.TriangleRepository;
import com.project.testing.services.TriangleService;
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
public class TriangleGeneratorTest {
    @Autowired
    private TriangleRepository repo ;


    @Test
    public void testAddNew() {
        Triangle triangle = new Triangle();
        triangle.setSide(10, 10, 10);
        triangle.setType();

        Triangle savedTriangle = repo.save(triangle);

        Assertions.assertNotNull(savedTriangle);
        Assertions.assertTrue(savedTriangle.getId() > 0);
    }

    @Test
    public void testListAll() {
        Iterable<Triangle> triangles = repo.findAll();
        int count = 0;

        for (Triangle triangle : triangles) {
            System.out.println(triangle);
            count++;
        }

        Assertions.assertTrue(count > 0);
    }

    @Test
    public void testClear(){
        repo.deleteAll();
        Collection<Triangle> triangles = (Collection<Triangle>) repo.findAll();

        Assertions.assertEquals(0, triangles.size());
    }
}
