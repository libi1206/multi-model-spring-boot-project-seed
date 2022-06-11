package com.company.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.project.bean.Student;
import com.company.project.model.TokenInfo;
import com.company.project.response.BaseResult;
import com.company.project.model.StudentDTO;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-04-03 14:56
 */
public interface ExampleService {
    BaseResult<Student> creationStudent(TokenInfo tokenInfo, StudentDTO studentDTO);

    BaseResult<Student> selectStudent(Integer studentId);

    BaseResult<IPage> selectAll(Integer page, Integer pageSize);
}
