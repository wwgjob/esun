package com.ntust.application.service.member;

import com.ntust.application.controller.dio.CreateMemberDio;
import com.ntust.application.dao.entity.MemberDo;
import com.ntust.application.worker.MemberWorker;
import com.ntust.base.service.BaseService;
import com.ntust.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateMemberService extends BaseService<CreateMemberDio, Long> {
    private final MemberWorker memberWorker;

    @Override
    public Long processData(CreateMemberDio input) {
        MemberDo member = memberWorker.createMember(input.getName(), input.getEmail());

        return member.getId();
    }

    @Override
    public ResponseDto<Long> generateResult(Long data) {
        ResponseDto<Long> dto = new ResponseDto<>();
        dto.setData(data);
        dto.setSuccess(true);

        return dto;
    }
}
