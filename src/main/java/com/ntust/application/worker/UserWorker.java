package com.ntust.application.worker;

import com.ntust.application.dao.entity.MemberDo;
import com.ntust.application.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserWorker {
    private final UserRepository userRepository;

    public MemberDo createUser(String name, String email) {
        MemberDo user = new MemberDo();
        user.setUserName(name);
        user.setUserEmail(email);

        user = userRepository.save(user);

        return user;
    }

    public MemberDo updateUser(MemberDo user) {
        user = userRepository.save(user);

        return user;
    }


    public MemberDo getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
