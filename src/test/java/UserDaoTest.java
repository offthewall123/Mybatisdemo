import com.xu.Entity.User;
import com.xu.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class UserDaoTest {

    @Test
    public void userDaoTest() throws IOException {
        String resource="config.xml";
        Reader reader=Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(reader);
        SqlSession session=factory.openSession();
        UserDao userDao=session.getMapper(UserDao.class);
        User user=new User();
//        user.setId(2);
//        user.setUserName("test2");
//        user.setPassWord("test2");
//
//        user.setUser_sex("test2");
//        user.setNick_name("test2");
//        userDao.insert(user);

        User u1=userDao.findByUserName("test");
        System.out.println(u1.getId());
        System.out.println(u1.getNick_name());
        System.out.println(userDao.countAll());
        session.commit();
        session.close();
    }
}
