CREATE OR REPLACE FUNCTION search_voting_record(
    p_keyword VARCHAR(255),
    p_pageSize INT,
    p_pageIndex INT
)
RETURNS TABLE(id BIGINT, project VARCHAR, count INT) AS
$$
BEGIN
    -- 使用 CASE 判斷 p_keyword 是否為 NULL
    RETURN QUERY
    SELECT vi.id,
           vi.project AS project,
           COUNT(vr.id)::INTEGER AS count
    FROM voting_item vi
    LEFT JOIN voting_record vr ON vi.id = vr.voting_item_id
    WHERE (p_keyword IS NULL OR vi.project LIKE CONCAT('%', p_keyword, '%'))
    GROUP BY vi.id, vi.project
    LIMIT p_pageSize OFFSET (p_pageIndex) * p_pageSize;
END;
$$ LANGUAGE plpgsql;
