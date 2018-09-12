package mybatis_lab;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.oop.eksp.user.data.UserMapper;
import com.oop.eksp.user.model.User;

public class MainTest {

	@Test
	public void testMybatis() throws IOException {
		String resource = "mybatis_cfg.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setAge(2);
		user.setUsername("xiaohei");
		userMapper.insert(user);
		session.commit(true);
		System.out.println(user.getId());
		//session.rollback(true);
		session.close();
	}

}
