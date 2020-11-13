package com.company.project.controller;

import com.company.project.annotation.RequestToken;
import com.company.project.bean.auto.StudentExampleBean;
import com.company.project.model.TokenInfo;
import com.company.project.response.BaseResult;
import com.company.project.model.StudentDTO;
import com.company.project.service.ExampleService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-04-03 15:44
 */
@RestController
@RequestMapping("/api/example")
@Api(value = "示例controller")
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    @ApiOperation(value = "增加学生", notes = "增加学生记录")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public BaseResult<StudentExampleBean> insert(
            @RequestToken @ApiIgnore TokenInfo tokenInfo,
            @RequestBody StudentDTO studentDTO
    ) {
        return exampleService.addStudent(tokenInfo, studentDTO);
    }

    @ApiOperation(value = "查询学生", notes = "查询学生记录")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public BaseResult<StudentExampleBean> select(
            @RequestParam Integer studentId
    ) {
        return exampleService.selectStudent(studentId);
    }

    @ApiOperation(value = "查询所有学生",notes = "陈宣所有学生")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public BaseResult<Page> all(
            @RequestParam Integer page,
            @RequestParam Integer pageSize
    ){
        return exampleService.selectAll(page, pageSize);
    }
}
