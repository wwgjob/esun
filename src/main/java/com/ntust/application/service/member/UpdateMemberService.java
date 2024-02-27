package com.ntust.application.service.member;

import com.ntust.application.controller.dio.CreateMemberDio;
import com.ntust.application.controller.dio.UpdateMemberDio;
import com.ntust.application.dao.entity.MemberDo;
import com.ntust.application.worker.MemberWorker;
import com.ntust.base.service.BaseService;
import com.ntust.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateMemberService extends BaseService<UpdateMemberDio, Void> {
    private final MemberWorker memberWorker;

    @Override
    public Void processData(UpdateMemberDio input) {
        memberWorker.updateMember(input);

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
