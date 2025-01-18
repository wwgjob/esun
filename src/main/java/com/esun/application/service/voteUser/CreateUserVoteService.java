package com.esun.application.service.voteUser;

import com.esun.application.controller.userVote.dio.CreateUserVoteDio;
import com.esun.application.worker.VotingRecordWorker;
import com.esun.base.service.BaseService;
import com.esun.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserVoteService extends BaseService<CreateUserVoteDio, Void> {
    private final VotingRecordWorker votingRecordWorker;

    @Override
    public Void processData(CreateUserVoteDio input) {
        votingRecordWorker.createVotingRecord(input);

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
