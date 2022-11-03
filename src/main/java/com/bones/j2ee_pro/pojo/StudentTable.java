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
@TableName("StudentTable")
public class StudentTable {
    private Integer sid;
    private String name;
    private Integer gender;
    private String birthday;
    private Integer credit;
    private String remarks;
    private MajorTable major;
    private UserTable user;
}
