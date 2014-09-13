import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taskSell.Service.UserServiceI;
import com.taskSell.model.User;


public class Test {

	/**
	 * <p>Title: main</p>
	 * <p>Description: </p>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"});
			UserServiceI userService = (UserServiceI) ac.getBean("userService");
			User user = new User();
			user.setUserName("123");
			user.setUserPwd("123");
			userService.login(user);
			
	}

}
