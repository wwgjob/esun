package com.ntust.application.service.member;

import com.ntust.application.controller.dio.SearchMemberListDio;
import com.ntust.application.controller.dto.GetMemberDto;
import com.ntust.application.controller.dto.SearchMemberListDto;
import com.ntust.application.dao.entity.MemberDo;
import com.ntust.application.dao.mapper.MemberMapper;
import com.ntust.application.worker.MemberWorker;
import com.ntust.base.service.BaseService;
import com.ntust.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SearchMemberListService extends BaseService<SearchMemberListDio, SearchMemberListDto> {
    private final MemberMapper memberMapper;

    @Override
    public SearchMemberListDto processData(SearchMemberListDio input) {
        List<GetMemberDto> list = memberMapper.searchUsers(input.getKeyword());
        SearchMemberListDto dto = new SearchMemberListDto();
        dto.setList(list);

        return dto;
    }

    @Override
    public ResponseDto<SearchMemberListDto> generateResult(SearchMemberListDto data) {
        ResponseDto<SearchMemberListDto> dto = new ResponseDto<>();
        dto.setData(data);
        dto.setSuccess(true);

        return dto;
    }
}
