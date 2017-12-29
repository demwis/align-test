INSERT INTO users (id, `name`, pass_hash) VALUES ('read', 'Read-only user', '');
INSERT INTO users (id, `name`, pass_hash) VALUES ('admin', 'Administrator', '');

INSERT INTO authorities (id) VALUES ('read');
INSERT INTO authorities (id) VALUES ('admin');

INSERT INTO user_authorities (user_id, authority_id) VALUES ('read', 'read');
INSERT INTO user_authorities (user_id, authority_id) VALUES ('admin', 'read');
INSERT INTO user_authorities (user_id, authority_id) VALUES ('admin', 'admin');