CREATE TABLE authority_user
(
    id       BIGINT(20) NOT NULL AUTO_INCREMENT,
    login_id VARCHAR(30)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled  INT(1) NOT NULL DEFAULT '1',
    PRIMARY KEY (id),
    UNIQUE KEY login_id (login_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE authority_role
(
    id   INT(1) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE authority_user_role
(
    user_id BIGINT(20) NOT NULL,
    role_id INT(1) NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT authority_user_role_ibfk_1 FOREIGN KEY (user_id) REFERENCES authority_user (id),
    CONSTRAINT authority_user_role_ibfk_2 FOREIGN KEY (role_id) REFERENCES authority_role (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;