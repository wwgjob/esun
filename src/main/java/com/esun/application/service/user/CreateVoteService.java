package com.esun.application.service.user;

import com.esun.application.controller.vote.dio.CreateVoteDio;
import com.esun.application.worker.VotingItemWorker;
import com.esun.base.service.BaseService;
import com.esun.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateVoteService extends BaseService<CreateVoteDio, Long> {
    private final VotingItemWorker votingItemWorker;

    @Override
    public Long processData(CreateVoteDio input) {
        return votingItemWorker.createVotingItem(input);
    }

    @Override
    public ResponseDto<Long> generateResult(Long data) {
        ResponseDto<Long> dto = new ResponseDto<>();
        dto.setData(data);
        dto.setSuccess(true);

        return dto;
    }
}
