package com.esun.application.controller;

import com.esun.application.controller.vote.dio.CreateVoteDio;
import com.esun.application.controller.vote.dio.SearchVoteListDio;
import com.esun.application.controller.vote.dio.UpdateVoteDio;
import com.esun.application.controller.vote.dto.SearchVoteListDto;
import com.esun.application.service.user.CreateVoteService;
import com.esun.application.service.user.DeleteVoteService;
import com.esun.application.service.user.SearchVoteListService;
import com.esun.application.service.user.UpdateVoteService;
import com.esun.base.service.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@Api(tags = "Vote")
@RequestMapping("vote")
@RequiredArgsConstructor
public class VoteController {

    private final SearchVoteListService searchVoteListService;

    @ApiOperation(value = "get vote data")
    @GetMapping("/search")
    public ResponseDto<SearchVoteListDto> searchVoteList(
            @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(name = "pageIndex", required = false, defaultValue = "0") Integer pageIndex) {
        SearchVoteListDio input = new SearchVoteListDio();
        input.setKeyword(keyword);
        input.setPageSize(pageSize);
        input.setPageIndex(pageIndex);

        return searchVoteListService.request(input);
    }

    private final CreateVoteService createVoteService;

    @ApiOperation(value = "create vote data")
    @PostMapping("")
    public ResponseDto<Long> createVote(@RequestBody CreateVoteDio input) {
        return createVoteService.request(input);
    }

    private final DeleteVoteService deleteVoteService;

    @ApiOperation(value = "delete vote data")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataTypeClass = Long.class)
    @DeleteMapping("/{id}")
    public ResponseDto<Void> deleteVote(@PathVariable Long id) {
        return deleteVoteService.request(id);
    }

    private final UpdateVoteService updateVoteService;

    @ApiOperation(value = "update vote data")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataTypeClass = Long.class)
    @PatchMapping("/{id}")
    public ResponseDto<Void> updateVote(@PathVariable Long id, @RequestBody UpdateVoteDio input) {
        input.setId(id);
        return updateVoteService.request(input);
    }
}