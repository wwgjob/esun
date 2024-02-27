package com.ntust.application.service.member;

import com.ntust.application.controller.dto.GetMember2Dto;
import com.ntust.application.controller.dto.GetMemberDto;
import com.ntust.application.dao.entity.MemberDo;
import com.ntust.application.worker.MemberWorker;
import com.ntust.base.service.BaseService;
import com.ntust.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetMemberService extends BaseService<Long, GetMemberDto> {
    private final MemberWorker memberWorker;

    @Override
    public GetMemberDto processData(Long id) {
        MemberDo member = memberWorker.getMemberById(id);

        return convert(member);
    }

    private GetMemberDto convert(MemberDo memberDo) {
        GetMemberDto dto = new GetMemberDto();
        dto.setId(memberDo.getId());
        dto.setName(memberDo.getUserName());
        dto.setEmail(memberDo.getUserEmail());

        GetMember2Dto dto2 = GetMember2Dto.builder()
                .email(memberDo.getUserEmail())
                .id(memberDo.getId())
                .name(memberDo.getUserName()).build();


        return dto;
    }

    @Override
    public ResponseDto<GetMemberDto> generateResult(GetMemberDto data) {
        ResponseDto<GetMemberDto> dto = new ResponseDto<>();
        dto.setData(data);
        dto.setSuccess(true);

        return dto;
    }
}
