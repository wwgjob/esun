package com.esun.application.controller;

import com.esun.application.controller.userVote.dio.CreateUserVoteDio;
import com.esun.application.controller.userVote.dio.SearchUserVoteListDio;
import com.esun.application.controller.userVote.dto.SearchUserVoteListDto;
import com.esun.application.service.voteUser.CreateUserVoteService;
import com.esun.application.service.voteUser.SearchUserVoteListService;
import com.esun.base.service.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@Api(tags = "User Vote")
@RequestMapping("userVote")
@RequiredArgsConstructor
public class UserVoteController {

    private final SearchUserVoteListService searchUserVoteListService;

    @ApiOperation(value = "get user vote data")
    @GetMapping("/search")
    public ResponseDto<SearchUserVoteListDto> searchUserVoteList(
            @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(name = "pageIndex", required = false, defaultValue = "0") Integer pageIndex) {
        SearchUserVoteListDio input = new SearchUserVoteListDio();
        input.setKeyword(keyword);
        input.setPageSize(pageSize);
        input.setPageIndex(pageIndex);

        return searchUserVoteListService.request(input);
    }

    private final CreateUserVoteService createUserVoteService;

    @ApiOperation(value = "create user vote data")
    @PostMapping("")
    public ResponseDto<Void> createUserVote(@RequestBody CreateUserVoteDio input) {
        return createUserVoteService.request(input);
    }

}