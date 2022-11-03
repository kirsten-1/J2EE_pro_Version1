package com.bones.j2ee_pro.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("CourseTable")
public class CourseTable {
    private int cid;
    private String name;
    private int semester;
    private int stunum;
    private int credit;
    private Set<StudentTable> students = new HashSet<>();
}
