CREATE TABLE users (
  id        VARCHAR(36) NOT NULL,
  `name`    VARCHAR(50) NOT NULL,
  pass_hash VARCHAR(50) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE authorities (
  id VARCHAR(100) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE user_authorities (
  user_id      VARCHAR(36) NOT NULL,
  authority_id VARCHAR(100) NOT NULL,

  PRIMARY KEY (user_id, authority_id),
  CONSTRAINT FK_USERS FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT FK_AUTHORITIES FOREIGN KEY (authority_id) REFERENCES authorities (id)
);