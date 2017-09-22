package org.dance.jasper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: chathuranga
 * Date: 2/13/12
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl implements UserDao{



	@Override
	public List<User> retrieveAllRegisteredUsers() {

       List<User> allUsers = new ArrayList<>();
        
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("vishal@gmail.com");
        user1.setUserName("vishal2060");
        user1.setFirstName("vishal");
        allUsers.add(user1);
        
        User user2 = new User();
        user2.setId(2);
        user2.setEmail("sachin@gmail.com");
        user2.setUserName("sachin02");
        user2.setFirstName("sachin");
        allUsers.add(user2);
        
        User user3 = new User();
        user3.setId(3);
        user3.setEmail("sagar@gmail.com");
        user3.setUserName("sagar30");
        user3.setFirstName("sagar");
        allUsers.add(user3);

        return allUsers;

    }


  
}


