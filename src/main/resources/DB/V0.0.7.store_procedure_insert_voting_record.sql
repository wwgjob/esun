CREATE OR REPLACE PROCEDURE insert_voting_record(p_voting_item_ids bigint[])
LANGUAGE plpgsql AS $$
DECLARE
    item_id bigint;
BEGIN
    FOREACH item_id IN ARRAY p_voting_item_ids
    LOOP
        INSERT INTO voting_record (voting_item_id) VALUES (item_id);
    END LOOP;
END;
$$;
