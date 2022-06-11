package com.company.project.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.project.bean.Student;
import com.company.project.constent.Code;
import com.company.project.exception.BusinessException;
import com.company.project.model.TokenInfo;
import com.company.project.response.BaseResult;
import com.company.project.response.BaseResultFactory;
import com.company.project.model.StudentDTO;
import com.company.project.service.ExampleService;
import com.company.project.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-04-03 15:24
 */
@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private StudentService studentService;

    @Override
    public BaseResult creationStudent(TokenInfo tokenInfo, StudentDTO studentDTO) {
        log.info("token解析结果：userId:{} userName:{}", tokenInfo.getUserId(), tokenInfo.getUserName());
        Student bean = new Student();
        bean.setId(studentDTO.getStudentId());
        bean.setName(studentDTO.getName());
        bean.setInsertTime(new Date());
        studentService.save(bean);
        return BaseResultFactory.produceResult(Code.SUCCESS, bean);
    }

    @Override
    public BaseResult selectStudent(Integer studentId) {
        Student bean = studentService.getById(studentId);
        if (ObjectUtils.isEmpty(bean)) {
            throw new BusinessException(Code.ERROR);
        }
        return BaseResultFactory.produceResult(Code.SUCCESS, bean);
    }

    @Override
    public BaseResult<IPage> selectAll(Integer page, Integer pageSize) {
        Page<Student> studentPage = new Page<>(page, pageSize);
        IPage<Student> page1 = studentService.page(studentPage);
        return BaseResultFactory.produceResult(Code.SUCCESS, page1);
    }

}
