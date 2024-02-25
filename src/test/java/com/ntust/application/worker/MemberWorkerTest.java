package com.ntust.application.worker;


import com.ntust.application.dao.entity.MemberDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MemberWorkerTest {
    @Autowired
    private MemberWorker memberWorker;

    @Test
    public void testTestWorker() {
        MemberDo use = memberWorker.createMember("tom", "xxxx");
        Long userId = use.getId();
        System.out.println(userId);

        MemberDo user2 = memberWorker.getMemberById(userId);
        user2.setUserName("jack");

        memberWorker.updateUser(user2);

        System.out.println(user2.getId());
    }
}