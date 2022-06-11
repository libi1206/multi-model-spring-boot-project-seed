package com.company.project.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.bean.Student;
import com.company.project.dao.StudentMapper;
import com.company.project.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author libi
 * @since 2022-06-11
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
