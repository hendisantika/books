DROP TABLE IF EXISTS author_book;
DROP TABLE IF EXISTS category_book;
DROP TABLE IF EXISTS publisher_book;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS publisher;

CREATE TABLE IF NOT EXISTS book
(
    id               BIGINT(20) NOT NULL AUTO_INCREMENT,
    image_path       VARCHAR(255) NOT NULL,
    leading_sentence VARCHAR(255) NOT NULL,
    sub_title        VARCHAR(255) DEFAULT NULL,
    title            VARCHAR(255) NOT NULL,
    url              VARCHAR(255) NOT NULL,
    like_count       INT(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS author
(
    id         BIGINT(20) NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255) NOT NULL,
    like_count INT(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (id),
    UNIQUE KEY NAME (NAME)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS category
(
    id         BIGINT(20) NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255) NOT NULL,
    like_count INT(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (id),
    UNIQUE KEY NAME (NAME)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS publisher
(
    id         BIGINT(20) NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255) NOT NULL,
    like_count INT(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (id),
    UNIQUE KEY NAME (NAME)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS author_book
(
    author_id BIGINT(20) NOT NULL,
    book_id   BIGINT(20) NOT NULL,
    PRIMARY KEY (author_id, book_id),
    KEY       book_id(book_id),
    CONSTRAINT author_book_ibfk_1 FOREIGN KEY (author_id) REFERENCES author (id),
    CONSTRAINT author_book_ibfk_2 FOREIGN KEY (book_id) REFERENCES book (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS category_book
(
    category_id BIGINT(20) NOT NULL,
    book_id     BIGINT(20) NOT NULL,
    PRIMARY KEY (category_id, book_id),
    KEY         book_id(book_id),
    CONSTRAINT category_book_ibfk_1 FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT category_book_ibfk_2 FOREIGN KEY (book_id) REFERENCES book (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS publisher_book
(
    publisher_id BIGINT(20) NOT NULL,
    book_id      BIGINT(20) NOT NULL,
    PRIMARY KEY (publisher_id, book_id),
    KEY          book_id(book_id),
    CONSTRAINT publisher_book_ibfk_1 FOREIGN KEY (publisher_id) REFERENCES publisher (id),
    CONSTRAINT publisher_book_ibfk_2 FOREIGN KEY (book_id) REFERENCES book (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;