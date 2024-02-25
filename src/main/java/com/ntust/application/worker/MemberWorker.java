package com.ntust.application.worker;

import com.ntust.application.controller.dio.UpdateMemberDio;
import com.ntust.application.dao.entity.MemberDo;
import com.ntust.application.dao.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberWorker {
    private final MemberRepository memberRepository;

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public List<MemberDo> search(String name, String email) {
        return memberRepository.findAllByUserNameContainingOrUserEmailContaining(name, email);
    }

    public MemberDo updateMember(UpdateMemberDio input) {
        MemberDo member = memberRepository.findById(input.getId()).orElse(null);

        member.setUserName(input.getName());
        member.setUserEmail(input.getEmail());

        member = memberRepository.save(member);

        return member;
    }

    public MemberDo createMember(String name, String email) {
        MemberDo member = new MemberDo();
        member.setUserName(name);
        member.setUserEmail(email);

        member = memberRepository.save(member);

        return member;
    }

    public MemberDo updateUser(MemberDo user) {
        user = memberRepository.save(user);

        return user;
    }


    public MemberDo getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
