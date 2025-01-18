package com.esun.application.service.voteUser;

import com.esun.application.controller.userVote.dio.SearchUserVoteListDio;
import com.esun.application.controller.userVote.dto.SearchUserVoteListDto;
import com.esun.application.controller.vote.dio.CreateVoteDio;
import com.esun.application.worker.VotingItemWorker;
import com.esun.application.worker.VotingRecordWorker;
import com.esun.base.service.BaseService;
import com.esun.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class SearchUserVoteListService extends BaseService<SearchUserVoteListDio, SearchUserVoteListDto> {
    private final VotingRecordWorker votingRecordWorker;

    @Override
    public SearchUserVoteListDto processData(SearchUserVoteListDio input) {
        return votingRecordWorker.searchVotingRecord(input);
    }

    @Override
    public ResponseDto<SearchUserVoteListDto> generateResult(SearchUserVoteListDto data) {
        ResponseDto<SearchUserVoteListDto> dto = new ResponseDto<>();
        dto.setData(data);
        dto.setSuccess(true);

        return dto;
    }
}
