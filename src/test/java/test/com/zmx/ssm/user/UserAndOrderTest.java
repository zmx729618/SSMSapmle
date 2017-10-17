package test.com.zmx.ssm.user;

import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zmx.ssm.user.domain.Order;
import com.zmx.ssm.user.domain.User;



/**
 * @author Administrator
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@Transactional
public class UserAndOrderTest {
    @Resource(name="sqlSessionFactory")
	private  SqlSessionFactory sessionFactory;
	
	/**
	 * @throws java.lang.Exception
	 */
/*	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		sessionFactory = factoryBuilder.build(inputStream);

	}*/
	
	//一对多，查询person（一）级联查询订单order（多）
	@Test
	public void testSelectUserFetchOrder() throws Exception {
		SqlSession session = sessionFactory.openSession();
		User user = session.selectOne("com.zmx.ssm.user.mapper.UserMapper.selectUserFetchOrder", 1);
		System.out.println(user);
		System.out.println(user.getOrderList().size());
		for(Order order : user.getOrderList()){
			System.out.println(order);
		}
		session.close();
	}
	
	//多对一，查询订单order（多）级联查询person（一）
	@Test
	public void testSelectOrderFetchUser() throws Exception{
		SqlSession session = sessionFactory.openSession();
		Order order = session.selectOne("com.zmx.ssm.user.domain.Order.selectOrderFetchUser", 1);
		System.out.println(order);
		System.out.println(order.getUser());
		session.close();
	}
	   
}
