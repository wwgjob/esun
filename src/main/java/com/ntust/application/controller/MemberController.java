package com.ntust.application.controller;

import com.ntust.application.dao.entity.MemberDo;
import com.ntust.application.worker.UserWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final UserWorker userWorker;
    @GetMapping("/{id}")
    public MemberDo getMember(@PathVariable Long id) {
        MemberDo memberDo = userWorker.getUserById(id);

        return memberDo;
    }
}