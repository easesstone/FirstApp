package com.sydney.dream;

import com.sydney.dream.dao.IUserOperation;
import com.sydney.dream.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sydney.dream.Main.sqlSessionFactory;

public class ServiceForMain {
    /**
     * 取出一个用户的信息，用的是UserMapper.xml 里面的配置。
     * @param id
     * @return
     */
    public static User getUserById01(int id) {
        SqlSession session = null;
        User user = null;
        try {
            session = sqlSessionFactory.openSession();
            String statement = "com.sydney.dream.model.User.getUser";
            // selectOne 的结果需要强制转换,因为selectOne 的结果是泛型
            user = (User) session.selectOne(statement, 1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    /**
     * 获取用户信息，面向接口编程，用的识IUserOperationMapper.xml 里面的配置。
     * @param id
     * @return
     */
    public static User getUserById02(int id) {
        SqlSession session = null;
        User user = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserOperation iUserOperation =  session.getMapper(IUserOperation.class);
            // selectOne 的结果需要强制转换,因为selectOne 的结果是泛型
            user = iUserOperation.getUser01(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    /**
     * 获取用户列表，面向接口编程
     * @param name
     * @return
     */
    public static List<User> getUsers(String name) {
        SqlSession session = null;
        List<User> users = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserOperation iUserOperation =  session.getMapper(IUserOperation.class);
            // selectOne 的结果需要强制转换,因为selectOne 的结果是泛型
            users = iUserOperation.getUsers(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    /**
     * 添加用户，面向接口编程。
     * @param user
     * @return
     */
    public static boolean addUser(User user) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserOperation iUserOperation =  session.getMapper(IUserOperation.class);
            iUserOperation.addUser(user);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * 删除用户数据，面向接口编程。
     * @param id
     * @return
     */
    public static boolean deleteUser(int id) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserOperation iUserOperation =  session.getMapper(IUserOperation.class);
            iUserOperation.deleteById(id);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * 更新用户数据，面向接口个编程。
     * @param user
     * @return
     */
    public static boolean updateUser(User user) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            IUserOperation iUserOperation =  session.getMapper(IUserOperation.class);
            iUserOperation.updateUser(user);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
