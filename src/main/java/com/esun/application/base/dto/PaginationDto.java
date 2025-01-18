package com.esun.application.base.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDto implements Serializable {

    private static final long serialVersionUID = -4331972014310490609L;
    private long currentPage;
    private long totalItems;
    private long itemPerPage;
    private long totalPages;

    public PaginationDto(long currentPage, long totalItems, long itemPerPage) {
        this(
                currentPage,
                totalItems,
                itemPerPage,
                (totalItems % itemPerPage == 0) ? totalItems / itemPerPage : (totalItems / itemPerPage) + 1
        );
    }
}
