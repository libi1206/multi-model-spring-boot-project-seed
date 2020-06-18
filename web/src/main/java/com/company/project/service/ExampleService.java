package com.company.project.service;

import com.company.project.bean.auto.StudentExampleBean;
import com.company.project.response.BaseResult;
import com.company.project.model.StudentDTO;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-04-03 14:56
 *
 */
public interface ExampleService {
    BaseResult<StudentExampleBean> addStudent(StudentDTO studentDTO);

    BaseResult<StudentExampleBean> selectStudent(Integer studentId);
}
