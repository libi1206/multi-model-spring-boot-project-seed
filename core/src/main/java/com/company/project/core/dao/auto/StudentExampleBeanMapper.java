package com.company.project.core.dao.auto;

import com.company.project.core.bean.auto.StudentExampleBean;
import com.company.project.core.bean.auto.StudentExampleBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentExampleBeanMapper {
    int countByExample(StudentExampleBeanExample example);

    int deleteByExample(StudentExampleBeanExample example);

    @Delete({
        "delete from student_example",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into student_example (id, name, ",
        "major, level, club)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{major,jdbcType=VARCHAR}, #{level,jdbcType=INTEGER}, #{club,jdbcType=VARCHAR})"
    })
    int insert(StudentExampleBean record);

    int insertSelective(StudentExampleBean record);

    List<StudentExampleBean> selectByExample(StudentExampleBeanExample example);

    @Select({
        "select",
        "id, name, major, level, club",
        "from student_example",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    StudentExampleBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentExampleBean record, @Param("example") StudentExampleBeanExample example);

    int updateByExample(@Param("record") StudentExampleBean record, @Param("example") StudentExampleBeanExample example);

    int updateByPrimaryKeySelective(StudentExampleBean record);

    @Update({
        "update student_example",
        "set name = #{name,jdbcType=VARCHAR},",
          "major = #{major,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=INTEGER},",
          "club = #{club,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentExampleBean record);
}