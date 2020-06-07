package project.dao;


import com.company.project.bean.auto.StudentExampleBean;
import com.company.project.dao.auto.StudentExampleBeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import project.Tester;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-04-03 11:07
 */

@Slf4j
public class TestStudentDao extends Tester {
    @Autowired
    StudentExampleBeanMapper studentExampleBeanMapper;

    @Test
    public void testDao() {
        StudentExampleBean student = new StudentExampleBean();
        student.setId(1161020054);
        student.setName("libi");
        student.setLevel(4);
        student.setMajor("计算机科学与技术");

        studentExampleBeanMapper.insertSelective(student);
        log.info("插入完成");
    }

}
