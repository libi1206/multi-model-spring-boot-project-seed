package com.company.project.service.impl;

import com.company.project.bean.auto.StudentExampleBean;
import com.company.project.constent.Code;
import com.company.project.dao.auto.StudentExampleBeanMapper;
import com.company.project.exception.BusinessException;
import com.company.project.model.TokenInfo;
import com.company.project.response.BaseResult;
import com.company.project.response.BaseResultFactory;
import com.company.project.model.StudentDTO;
import com.company.project.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-04-03 15:24
 */
@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    private StudentExampleBeanMapper studentExampleBeanMapper;

    @Override
    public BaseResult addStudent(TokenInfo tokenInfo, StudentDTO studentDTO) {
        log.info("token解析结果：userId:{} userName:{}", tokenInfo.getUserId(), tokenInfo.getUserName());
        StudentExampleBean bean = new StudentExampleBean();
        bean.setId(studentDTO.getStudentId());
        bean.setMajor(studentDTO.getMajor());
        bean.setLevel(studentDTO.getLevel());
        bean.setName(studentDTO.getName());

        studentExampleBeanMapper.insertSelective(bean);
        return BaseResultFactory.produceResult(Code.SUCCESS, bean);
    }

    @Override
    public BaseResult selectStudent(Integer studentId) {
        StudentExampleBean bean = studentExampleBeanMapper.selectByPrimaryKey(studentId);
        if (ObjectUtils.isEmpty(bean)) {
            throw new BusinessException(Code.ERROR);
        }
        return BaseResultFactory.produceResult(Code.SUCCESS, bean);
    }

}
