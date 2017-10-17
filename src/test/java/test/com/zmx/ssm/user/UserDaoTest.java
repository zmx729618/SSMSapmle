package test.com.zmx.ssm.user;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.zmx.ssm.user.dao.UserDao;
import com.zmx.ssm.user.domain.User;

  

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() {
        User user=new User();
        user.setId(14);
        user.setAccount("manager");
        user.setPassword("123456");        
        userDao.addUser(user);
    }
    
    


}
