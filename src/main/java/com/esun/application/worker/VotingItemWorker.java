package com.esun.application.worker;

import com.esun.application.base.dto.PaginationDto;
import com.esun.application.controller.vote.dio.CreateVoteDio;
import com.esun.application.controller.vote.dio.SearchVoteListDio;
import com.esun.application.controller.vote.dio.UpdateVoteDio;
import com.esun.application.controller.vote.dto.GetVoteDto;
import com.esun.application.controller.vote.dto.SearchVoteListDto;
import com.esun.application.dao.mapper.VotingItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VotingItemWorker {
    private final VotingItemMapper votingItemMapper;
    private final JdbcTemplate jdbcTemplate;

    public SearchVoteListDto getVoteList(SearchVoteListDio input) {
        SearchVoteListDto dto = new SearchVoteListDto();
        dto.setItems(this.getList(input));
        dto.setPagination(this.generatePagination(input));

        return dto;
    }

    public PaginationDto generatePagination(SearchVoteListDio input) {
        int count = votingItemMapper.findTotalCount(input.getKeyword());
        return new PaginationDto(input.getPageIndex() + 1, count, input.getPageSize());
    }

    public List<GetVoteDto> getList(SearchVoteListDio input) {
        return votingItemMapper.searchList(
                input.getKeyword(),
                input.getPageSize(),
                input.getPageIndex() == null || input.getPageSize() == null ? 0 : input.getPageIndex() * input.getPageSize()
        );
    }

    public Void updateVotingItem(UpdateVoteDio input) {
        Long id = input.getId();
        String project = input.getProject();

        jdbcTemplate.update("CALL update_voting_item(?, ?)", id, project);

        return null;
    }

    public Long createVotingItem(CreateVoteDio input) {
        String project = input.getProject();

        return jdbcTemplate.queryForObject(
                "SELECT add_voting_item(?)",
                new Object[]{project},
                Long.class
        );
    }

    public void deleteVotingItem(Long id) {
        jdbcTemplate.update("CALL delete_voting_item(?)", id);
    }
}
