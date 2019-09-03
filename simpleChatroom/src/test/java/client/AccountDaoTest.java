package client;


import com.cao.client.dao.AccountDao;
import com.cao.client.entity.User;
import org.junit.Assert;
import org.junit.Test;



public class AccountDaoTest {
    private AccountDao accountDao = new AccountDao();
    @Test
    public void userReg() {
        User user = new User();
        user.setUserName("fish");
        user.setPassWord("123");
        user.setBrief("呵呵呵呵");
        boolean flag = accountDao.userReg(user);
        Assert.assertTrue(flag);
    }

    @Test
    public void userLogin()  {
        String username = "fish";
        String password = "123";
        User user = accountDao.userLogin(username,password);
        System.out.println(user);
        Assert.assertNotNull(user);
    }
}