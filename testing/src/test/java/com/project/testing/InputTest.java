package com.project.testing;

import com.project.testing.entities.Input;
import com.project.testing.repositories.ValueRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class InputTest {
    @Autowired
    private ValueRepository repo ;
    @Test
    public void testAddNew() {
        Input value = new Input();
        value.setValues(10, 220);

        Input saved = repo.save(value);

        Assertions.assertNotNull(saved);
        Assertions.assertTrue(saved.getId() > 0);
    }
}
