CREATE DATABASE job_portal;
USE job_portal;

CREATE TABLE candidates (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    skills TEXT
);

CREATE TABLE companies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    company_name VARCHAR(150),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE jobs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150),
    description TEXT,
    company_id INT,
    status VARCHAR(20) DEFAULT 'Open',
    FOREIGN KEY (company_id) REFERENCES companies(id)
);

CREATE TABLE applications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    job_id INT,
    candidate_id INT,
    status VARCHAR(20) DEFAULT 'Applied',
    FOREIGN KEY (job_id) REFERENCES jobs(id),
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);
INSERT INTO companies (company_name, email, password)
VALUES ('Infosys', 'hr@infosys.com', '1234');
INSERT INTO candidates (name, email, password, skills)
VALUES ('Harshitha', 'harshi@gmail.com', '1234', 'Java,SQL');
INSERT INTO jobs (title, description, company_id)
VALUES ('Java Developer', 'Looking for Java + MySQL Developer', 1);
INSERT INTO companies (company_name, email, password)
VALUES ('TCS', 'tcs@gmail.com', '1234');

INSERT INTO jobs (title, description, company_id, status)
VALUES ('Java Developer', 'Need Java + SQL skills', 1, 'Open');