CREATE TABLE products (
  id    VARCHAR(36) NOT NULL,
  brand VARCHAR(50) NOT NULL,
  name  VARCHAR(100) NOT NULL,
  price DECIMAL(20, 2) NOT NULL,
  quantity INT DEFAULT 0,

  PRIMARY KEY (id)
);