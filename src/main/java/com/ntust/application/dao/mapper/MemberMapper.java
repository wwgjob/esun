package com.ntust.application.dao.mapper;

import com.ntust.application.controller.dto.GetMemberDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT id, user_name , user_email  FROM member WHERE user_name LIKE CONCAT('%', #{keyword}, '%') OR user_email LIKE CONCAT('%', #{keyword}, '%')")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "user_name"),
            @Result(property = "email", column = "user_email")
            // 其他属性和列的对应关系...
    })
    List<GetMemberDto>

    searchUsers(@Param("keyword") String keyword);
}
