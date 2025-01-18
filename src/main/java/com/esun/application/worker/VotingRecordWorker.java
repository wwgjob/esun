package com.esun.application.worker;

import com.esun.application.base.dto.PaginationDto;
import com.esun.application.controller.userVote.dio.CreateUserVoteDio;
import com.esun.application.controller.userVote.dio.SearchUserVoteListDio;
import com.esun.application.controller.userVote.dto.GetUserVoteDto;
import com.esun.application.controller.userVote.dto.SearchUserVoteListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VotingRecordWorker {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchUserVoteListDto searchVotingRecord(SearchUserVoteListDio input) {
        String query = "SELECT * FROM search_voting_record(?, ?, ?)";

        List<GetUserVoteDto> items = jdbcTemplate.query(query, new Object[]{
                input.getKeyword() != null ? input.getKeyword() : "",
                input.getPageSize(),
                input.getPageIndex()
        }, new ResultSetExtractor<List<GetUserVoteDto>>() {
            public List<GetUserVoteDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<GetUserVoteDto> list = new ArrayList<>();
                while (rs.next()) {
                    GetUserVoteDto userVote = new GetUserVoteDto();
                    userVote.setId(rs.getLong("id"));
                    userVote.setProject(rs.getString("project"));
                    userVote.setCount(rs.getInt("count"));
                    list.add(userVote);
                }
                return list;
            }
        });

        // 取得總資料筆數
        int totalItems = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM voting_item WHERE project LIKE ?",
                new Object[]{"%" + input.getKeyword() + "%"}, Integer.class);

        PaginationDto pagination = new PaginationDto();
        pagination.setTotalItems(totalItems);

        SearchUserVoteListDto result = new SearchUserVoteListDto();
        result.setItems(items);
        result.setPagination(pagination);

        return result;
    }

    public void createVotingRecord(CreateUserVoteDio input) {
        Long[] votingItemArray = input.getVotingItemId().toArray(new Long[0]);

        String sql = "CALL insert_voting_record(?)";

        jdbcTemplate.update(sql, new Object[] { votingItemArray });
    }

}
