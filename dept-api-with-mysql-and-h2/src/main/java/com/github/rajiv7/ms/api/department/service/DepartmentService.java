package com.github.rajiv7.ms.api.department.service;

import lombok.extern.slf4j.Slf4j;
import com.github.rajiv7.ms.api.department.entity.Department;
import com.github.rajiv7.ms.api.department.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;

    public Department save(Department department) {
        log.info("Executing save department");
        return repo.save(department);
    }

    public Department searchById(Long deptId) {
        log.info("Executing searchById");
        return repo.findById(deptId).orElseThrow(() -> new EntityNotFoundException("Department ID : " + deptId));
    }

    public List<Department> searchAll() {
        return repo.findAll();
    }
}
