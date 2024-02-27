package com.ntust.application.service.member;

import com.ntust.application.controller.dto.GetMemberDto;
import com.ntust.application.dao.entity.MemberDo;
import com.ntust.application.worker.MemberWorker;
import com.ntust.base.service.BaseService;
import com.ntust.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteMemberService extends BaseService<Long, Void> {
    private final MemberWorker memberWorker;

    @Override
    public Void processData(Long id) {
        memberWorker.deleteMember(id);

        return null;
    }

    @Override
    public ResponseDto<Void> generateResult(Void data) {
        ResponseDto<Void> dto = new ResponseDto<>();
        dto.setData(data);
        dto.setSuccess(true);

        return dto;
    }
}
