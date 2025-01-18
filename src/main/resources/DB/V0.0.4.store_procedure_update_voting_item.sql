CREATE OR REPLACE PROCEDURE update_voting_item(voting_item_id BIGINT, new_project VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE "voting_item"
    SET project = new_project
    WHERE id = voting_item_id;
END;
$$;
