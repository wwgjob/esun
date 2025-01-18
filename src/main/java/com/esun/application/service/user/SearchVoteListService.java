package com.esun.application.service.user;

import com.esun.application.controller.vote.dio.SearchVoteListDio;
import com.esun.application.controller.vote.dto.SearchVoteListDto;
import com.esun.application.worker.VotingItemWorker;
import com.esun.base.service.BaseService;
import com.esun.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchVoteListService extends BaseService<SearchVoteListDio, SearchVoteListDto> {
    private final VotingItemWorker votingItemWorker;

    @Override
    public SearchVoteListDto processData(SearchVoteListDio input) {
        return votingItemWorker.getVoteList(input);
    }

    @Override
    public ResponseDto<SearchVoteListDto> generateResult(SearchVoteListDto data) {
        ResponseDto<SearchVoteListDto> dto = new ResponseDto<>();
        dto.setData(data);
        dto.setSuccess(true);

        return dto;
    }
}
