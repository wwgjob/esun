package com.ntust.application.worker;


import com.ntust.application.dao.entity.MemberDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserWorkerTest {
    @Autowired
    private UserWorker userWorker;

    @Test
    public void testTestWorker() {
        MemberDo use =userWorker.createUser("tom", "xxxx");
        Long userId = use.getId();
        System.out.println(userId);

        MemberDo user2 = userWorker.getUserById(userId);
        user2.setUserName("jack");

        userWorker.updateUser(user2);

        System.out.println(user2.getId());
    }
}