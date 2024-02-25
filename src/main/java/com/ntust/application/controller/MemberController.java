package com.ntust.application.controller;

import com.ntust.application.controller.dio.CreateMemberDio;
import com.ntust.application.controller.dio.SearchMemberListDio;
import com.ntust.application.controller.dio.UpdateMemberDio;
import com.ntust.application.controller.dto.GetMemberDto;
import com.ntust.application.controller.dto.SearchMemberListDto;
import com.ntust.application.service.member.*;
import com.ntust.application.worker.MemberWorker;
import com.ntust.base.service.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="Member")
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberWorker memberWorker;

    private final SearchMemberListService SearchMemberListService;

    @ApiOperation(value="get member data")
    @GetMapping("/search")
    public ResponseDto<SearchMemberListDto> searchMember(@RequestParam(name="keyword", required = false, defaultValue = "") String keyword) {
        SearchMemberListDio input = new SearchMemberListDio();
        input.setKeyword(keyword);

        return SearchMemberListService.request(input);
    }

    private final GetMemberService getMemberService;

    @ApiOperation(value="get member data")
    @ApiImplicitParam(name="id", value="ID", required = true, paramType = "path", dataTypeClass = Long.class)
    @GetMapping("/{id}")
    public ResponseDto<GetMemberDto>  getMember(@PathVariable Long id) {

        return getMemberService.request(id);
    }

    private final CreateMemberService createMemberService;

    @ApiOperation(value="create member data")
    @PostMapping("")
    public ResponseDto<Long> createMember(CreateMemberDio input) {

        return createMemberService.request(input);
    }

    private final DeleteMemberService deleteMemberService;

    @ApiOperation(value="delete member data")
    @ApiImplicitParam(name="id", value="ID", required = true, paramType = "path", dataTypeClass = Long.class)
    @DeleteMapping("/{id}")
    public ResponseDto<Void> deleteMember(@PathVariable Long id) {
        return deleteMemberService.request(id);
    }

    private final UpdateMemberService updateMemberService;

    @ApiOperation(value="update member data")
    @ApiImplicitParam(name="id", value="ID", required = true, paramType = "path", dataTypeClass = Long.class)
    @PatchMapping("/{id}")
    public ResponseDto<Void> updateMember(@PathVariable Long id, @RequestBody UpdateMemberDio input) {
        input.setId(id);

        return updateMemberService.request(input);
    }
}