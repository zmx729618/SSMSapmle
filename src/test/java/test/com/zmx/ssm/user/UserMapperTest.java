package test.com.zmx.ssm.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zmx.ssm.user.domain.User;
import com.zmx.ssm.user.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserMapperTest {
	
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user=new User();
        user.setId(13);
        user.setAccount("manager");
        user.setPassword("123456");        
        userMapper.addUser(user);
    }

}
