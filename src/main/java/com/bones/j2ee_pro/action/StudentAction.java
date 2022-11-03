package com.bones.j2ee_pro.action;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bones.j2ee_pro.mapper.MajorTableMapper;
import com.bones.j2ee_pro.mapper.StudentTableMapper;
import com.bones.j2ee_pro.pojo.MajorTable;
import com.bones.j2ee_pro.pojo.StudentTable;
import com.bones.j2ee_pro.pojo.UserTable;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class StudentAction extends ActionSupport {
    @Autowired
    private StudentTableMapper studentTableMapper;
    @Autowired
    private MajorTableMapper majorTableMapper;
    StudentTable student;
    MajorTable major;
    public String execute() throws Exception{
        UserTable user;
        StudentTable stu;
        ActionContext context=ActionContext.getContext();
        Map session=context.getSession();
        user=(UserTable)session.get("user");
        //stu=user.getStudent();
        QueryWrapper<StudentTable> wrapper = new QueryWrapper<>();
        wrapper.eq("name",user.getUsername());
        stu= studentTableMapper.selectOne(wrapper);
        Map request=(Map)ActionContext.getContext().get("request");
        request.put("stu", stu);
        //MajorDAO majorDAO=new MajorDAOImp();
        List<MajorTable> majors = majorTableMapper.selectList(null);
        //List majors=majorDAO.query_all_major();
        request.put("majors", majors);
        return "success";
    }
    public String save() throws Exception{
        //StudentDAO studentDAO=new StudentDAOImp();
        //studentDAO.update_student(student);


        //MajorDAO majorDAO=new MajorDAOImp();
        QueryWrapper<MajorTable> wrapper = new QueryWrapper<>();
        wrapper.eq("mid",major.getMid());
        MajorTable m  = majorTableMapper.selectOne(wrapper);
        //MajorTable m=majorDAO.query_major_by_mid(major.getMid());


        StudentTable stu;
        ActionContext context=ActionContext.getContext();
        Map session=context.getSession();
        UserTable user=(UserTable)session.get("user");
        //stu=user.getStudent();
        QueryWrapper<StudentTable> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("name",user.getUsername());
        stu= studentTableMapper.selectOne(wrapper1);

        stu.setMajor(m);
        stu.setName(student.getName());
        stu.setBirthday(student.getBirthday());
        stu.setGender(student.getGender());
        stu.setCredit(student.getCredit());
        stu.setRemarks(student.getRemarks());

        //student.setMajor(m);

        //studentDAO.update_student(stu);
        studentTableMapper.update(stu,null);

        Map request=(Map)ActionContext.getContext().get("request");
        request.put("stu", stu);
        return "success";
    }
    public StudentTable getStudent() {
        return student;
    }
    public void setStudent(StudentTable student) {
        this.student = student;
    }
    public MajorTable getMajor() {
        return major;
    }
    public void setMajor(MajorTable major) {
        this.major = major;
    }
}
