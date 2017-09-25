package com.mifinity.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mifinity.dao.UserDao;
import com.mifinity.entity.User;
import com.mifinity.service.UserService;

/**
 * Unit test for the App.
 */

@RunWith(SpringRunner.class)
public class AppTest {

	@MockBean
	private UserService userService;

	@MockBean
	private UserDao userDao;

	@Test
	public  void testFindByName() {
		User user = userService.userExist(new User("sergi"));
		assertNotNull(user);
	}

}
