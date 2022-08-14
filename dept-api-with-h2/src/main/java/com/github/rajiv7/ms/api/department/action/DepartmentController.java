package com.github.rajiv7.ms.api.department.action;

import com.github.rajiv7.ms.api.department.entity.Department;
import com.github.rajiv7.ms.api.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<Department> getAll(){
        log.info("List all departments");
        return service.searchAll();
    }

    @GetMapping("/{deptId}")
    public Department get(@PathVariable Long deptId){
        log.info("Find by dept by ID : " + deptId );
        return service.searchById(deptId);
    }

    @PostMapping("/")
    public Department save(@Valid @RequestBody Department department){
       log.info("Save dept : " + department );
        Department dept = service.save(department);
        return dept;
    }
}
