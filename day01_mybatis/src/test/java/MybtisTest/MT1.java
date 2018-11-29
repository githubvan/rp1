package MybtisTest;

import com.itheima.Dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MT1  {
    public static void main(String[] args) throws Exception {
        
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建SqlSessionFactoryBuilder工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(in);

        //使用工厂生产SqlSession对象
        SqlSession sqlSession = build.openSession();
        //创建一个代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        in.close();
        sqlSession.close();

    }
}
