package com.esun.application.dao.mapper;

import com.esun.application.controller.vote.dto.GetVoteDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VotingItemMapper {
    @Select("<script>" +
            "SELECT " +
            "    id, " +
            "    project " +
            "FROM voting_item " +
            "WHERE 1=1 " +
            "<if test='keyword != null'>" +
            "    AND (" +
            "        project LIKE CONCAT('%', #{keyword}, '%') " +
            "    )" +
            "</if>" +
            "ORDER BY id DESC " +
            "<if test='pageSize != null'>" +
            "    LIMIT #{pageSize} OFFSET #{offset}" +
            "</if>" +
            "</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "project", column = "project")
    })
    List<GetVoteDto> searchList(
            @Param("keyword") String keyword,
            @Param("pageSize") Integer pageSize,
            @Param("offset") Integer offset
    );

    @Select("<script>" +
            "SELECT count(*) " +
            "FROM voting_item " +
            "WHERE 1=1 " +
            "<if test='keyword != null'>" +
            "    AND (" +
            "        project LIKE CONCAT('%', #{keyword}, '%') " +
            "    )" +
            "</if>" +
            "</script>")
    Integer findTotalCount(@Param("keyword") String keyword);
}
