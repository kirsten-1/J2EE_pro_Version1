package com.bones.j2ee_pro.action;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bones.j2ee_pro.mapper.UserTableMapper;
import com.bones.j2ee_pro.pojo.UserTable;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport {
    private UserTable user;
    //private UserDAO userDAO;
    @Autowired
    private UserTableMapper userTableMapper;

    public String execute() throws Exception{
        String usr=user.getUsername();
        String pwd=user.getPassword();
        boolean validated=false;
        ActionContext context=ActionContext.getContext();
        Map session=context.getSession();
        UserTable user1=null;

        user1=(UserTable)session.get("user");
        if(user1==null){
            QueryWrapper<UserTable> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("username",usr).eq("password",pwd);
            List users = userTableMapper.selectList(wrapper1);
//            userDAO=new UserDAOImp();
//            List users=userDAO.query_user_by_username_password(usr, pwd);
            Iterator it=users.iterator();
            while(it.hasNext())
            {
                if(users.size()!=0){
                    user=(UserTable)it.next();//�����־û��� JavaBean ���� user
                    session.put("user", user);//�� user ����洢�ڻỰ��
                    validated=true;//��ʶΪ true ��ʾ��֤�ɹ�ͨ��
                }
            }
        }
        else{
            validated=true;	//���û���֮ǰ�ѵ�¼�����ɹ���֤���ʱ�ʶΪ true ��ʾ����������
        }
        if(validated)
        {
        	/*StudentTable stu=user.getStudent();
        	stu.setBirthday("45646");
        	StudentDAO studentDAO=new StudentDAOImp();
        	studentDAO.update_student(stu);*/
            //��֤�ɹ������ַ���"success"
            return "success";
        }
        else{
            //��֤ʧ�ܷ����ַ���"error"
            return "error";
        }
    }
    // user���Ե�getter/setter����

    public UserTable getUser(){
        return user;
    }
    public void setUser(UserTable user){
        this.user=user;
    }
}
