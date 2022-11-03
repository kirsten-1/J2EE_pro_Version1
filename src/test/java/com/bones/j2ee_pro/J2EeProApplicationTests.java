package com.bones.j2ee_pro;

import com.bones.j2ee_pro.mapper.CourseTableMapper;
import com.bones.j2ee_pro.mapper.MajorTableMapper;
import com.bones.j2ee_pro.pojo.CourseTable;
import com.bones.j2ee_pro.pojo.MajorTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class J2EeProApplicationTests {
    @Autowired(required = false)
    private CourseTableMapper courseTableMapper;
    private MajorTableMapper majorTableMapper;

    @Test
    void contextLoads() {
        List<CourseTable> courseTables = courseTableMapper.selectList(null);
        courseTables.forEach(System.out::println);
    }

}
