CREATE OR REPLACE FUNCTION add_voting_item(project VARCHAR)
RETURNS BIGINT AS $$
DECLARE
    new_id BIGINT;
BEGIN
    INSERT INTO "voting_item" (project)
    VALUES (project)
    RETURNING id INTO new_id;

    RETURN new_id;
END;
$$ LANGUAGE plpgsql;
