package edu.whitehou.manage;

import edu.whitehou.entity.User;
import edu.whitehou.service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManageApplicationServiceTests {
    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
    }

}
