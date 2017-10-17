package test.com.zmx.ssm.user;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zmx.ssm.user.domain.Order;
import com.zmx.ssm.user.domain.User;

public class Client {

	
	public static void main(String[] args) throws Exception {
		
		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = factoryBuilder.build(inputStream);
		
		SqlSession session = sessionFactory.openSession();
		User user = session.selectOne("com.zmx.ssm.user.domain.User.selectUserFetchOrder", 1);
		System.out.println(user);
		System.out.println(user.getOrderList().size());
		for(Order orders : user.getOrderList()){
			System.out.println(orders);
		}
		session.close();
		
		/*SqlSession session = sessionFactory.openSession();
		Order order = session.selectOne("com.zmx.ssm.user.domain.Order.selectOrderFetchUser", 1);
		System.out.println(order);
		System.out.println(order.getUser());
		session.close();*/
		
	}

}
