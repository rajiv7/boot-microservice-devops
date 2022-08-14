package com.github.rajiv7.ms.api.department.repo;

import com.github.rajiv7.ms.api.department.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository repo;

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(repo).isNotNull();
    }

    private Department dept = null;
    @BeforeEach
    public void initDept(){
        dept = new Department(1L, "TEST-name", "TEST-CODE", null, "Pune, INDIA");
    }


    @Test
    @DisplayName("Unit test for search department by ID")
    public void whenSaved_thenFindById(){
        repo.save(dept);
        assertThat(repo.findById(1L).get()).isNotNull();
    }

    @Test
    @DisplayName("Unit test for search department by name")
    public void whenSaved_thenFindByName(){
        repo.save(dept);
        assertThat(repo.findByName("TEST-name")).isNotNull();
    }

    @Test
    @DisplayName("Unit test for saving entity without name")
    public void shouldFail_whenSavedWithoutName(){
        dept.setName(null);
        assertThat(repo.save(dept));
    }
}
