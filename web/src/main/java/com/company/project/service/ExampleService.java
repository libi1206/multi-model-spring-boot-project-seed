package com.company.project.service;

import com.company.project.response.BaseResult;
import com.company.project.model.StudentDTO;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-04-03 14:56
 *
 */
public interface ExampleService {
    BaseResult addStudent(StudentDTO studentDTO);

    BaseResult selectStudent(Integer studentId);
}
