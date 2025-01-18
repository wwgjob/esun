CREATE OR REPLACE PROCEDURE delete_voting_item(voting_item_id BIGINT)
LANGUAGE plpgsql
AS $$
BEGIN
    DELETE FROM "voting_item"
    WHERE id = voting_item_id;
END;
$$;
