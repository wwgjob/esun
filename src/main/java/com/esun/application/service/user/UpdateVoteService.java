package com.esun.application.service.user;

import com.esun.application.controller.vote.dio.UpdateVoteDio;
import com.esun.application.worker.VotingItemWorker;
import com.esun.base.service.BaseService;
import com.esun.base.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateVoteService extends BaseService<UpdateVoteDio, Void> {
    private final VotingItemWorker votingItemWorker;

    @Override
    public Void processData(UpdateVoteDio input) {
        votingItemWorker.updateVotingItem(input);

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
