package com.bones.j2ee_pro.action;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bones.j2ee_pro.mapper.CourseTableMapper;
import com.bones.j2ee_pro.mapper.StudentTableMapper;
import com.bones.j2ee_pro.pojo.CourseTable;
import com.bones.j2ee_pro.pojo.StudentTable;
import com.bones.j2ee_pro.pojo.UserTable;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CourseAction extends ActionSupport {
    @Autowired
    private StudentTableMapper studentTableMapper;
    @Autowired
    private CourseTableMapper courseTableMapper;
    CourseTable course;
    public String execute() throws Exception {
        UserTable user;
        StudentTable stu;
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        user = (UserTable) session.get("user");
        //stu = user.getStudent();
        QueryWrapper<StudentTable> wrapper = new QueryWrapper<>();
        wrapper.eq("name",user.getUsername());
        stu= studentTableMapper.selectOne(wrapper);


        List courses = new ArrayList();


        //courses.addAll(stu.getCourses());
        UpdateWrapper<CourseTable> wrapperCourse = new UpdateWrapper<>();
        wrapperCourse.set("stunum", stu.getSid());
        courseTableMapper.update(null,wrapperCourse);
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("courses", courses);
        return "success";
    }
    public String quit() throws Exception{
        UserTable user;
        StudentTable stu;
        ActionContext context=ActionContext.getContext();
        Map session=context.getSession();
        user=(UserTable)session.get("user");
        //stu=user.getStudent();
        QueryWrapper<StudentTable> wrapper = new QueryWrapper<>();
        wrapper.eq("name",user.getUsername());
        stu= studentTableMapper.selectOne(wrapper);

        //Iterator it=stu.getCourses().iterator();
        QueryWrapper<StudentTable> wrapperCourse = new QueryWrapper<>();
        List<StudentTable> studentTables = studentTableMapper.selectList(wrapperCourse);
        Iterator it = studentTables.iterator();

        while(it.hasNext())
        {
            CourseTable c=(CourseTable)it.next();//�����־û��� JavaBean ���� user
            if(c.getCid()==course.getCid())
            {
                it.remove();
                break;
            }
        }
        //StudentDAO studentDAO=new StudentDAOImp();
        //studentDAO.update_student(stu);
        studentTableMapper.insert(stu);


        List courses = new ArrayList();


        //courses.addAll(stu.getCourses());
        UpdateWrapper<CourseTable> wrapperCourse1 = new UpdateWrapper<>();
        wrapperCourse1.set("stunum", stu.getSid());
        courseTableMapper.update(null,wrapperCourse1);
        Map request=(Map)ActionContext.getContext().get("request");
        request.put("courses", courses);
        return "success";
    }

    public String queryallcourses() throws Exception{
        //CourseDAO courseDAO=new CourseDAOImp();
        //List courses=courseDAO.query_all_course();
        List<CourseTable> courses = courseTableMapper.selectList(null);

        //System.out.println(courses.size());
        Map request=(Map)ActionContext.getContext().get("request");
        request.put("courses", courses);
        return "success";
    }

    public String selectcourse() throws Exception{
        UserTable user;
        StudentTable stu;
        ActionContext context=ActionContext.getContext();
        Map session=context.getSession();
        user=(UserTable)session.get("user");
        //stu=user.getStudent();
        QueryWrapper<StudentTable> wrapper = new QueryWrapper<>();
        wrapper.eq("name",user.getUsername());
        stu= studentTableMapper.selectOne(wrapper);

        //Iterator it=stu.getCourses().iterator();
        QueryWrapper<StudentTable> wrapperCourse = new QueryWrapper<>();
        List<StudentTable> studentTables = studentTableMapper.selectList(wrapperCourse);
        Iterator it = studentTables.iterator();

        while(it.hasNext())
        {
            CourseTable c=(CourseTable)it.next();//�����־û��� JavaBean ���� user
            if(c.getCid()==course.getCid())
            {
                return "error";
            }
        }

//        CourseDAO courseDAO=new CourseDAOImp();
//        stu.getCourses().add(courseDAO.query_course_by_cid(course.getCid()));
//        StudentDAO studentDAO=new StudentDAOImp();
//        studentDAO.update_student(stu);
        QueryWrapper<CourseTable> wrapperCourse02 = new QueryWrapper<>();
        wrapperCourse02.eq("stunum", stu.getSid());
        List<CourseTable> courseTables = courseTableMapper.selectList(wrapperCourse02);
        CourseTable courseTable = courseTableMapper.selectById(course.getCid());
        courseTables.add(courseTable);

        return "success";
    }

    public CourseTable getCourse() {
        return course;
    }
    public void setCourse(CourseTable course) {
        this.course = course;
    }
}
