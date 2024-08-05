CREATE TABLE `admin`
(
    id           VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    name         VARCHAR(255) NULL,
    role_role_id BIGINT NULL,
    CONSTRAINT pk_admin PRIMARY KEY (id)
);

CREATE TABLE candidate
(
    id            VARCHAR(255) NOT NULL,
    name          VARCHAR(255) NULL,
    is_open       INT NULL,
    dob           date NULL,
    email         VARCHAR(255) NULL,
    phone         VARCHAR(255) NULL,
    password      VARCHAR(255) NULL,
    gender        INT NULL,
    link_fb       VARCHAR(255) NULL,
    link_linkedin VARCHAR(255) NULL,
    link_git      VARCHAR(255) NULL,
    created_at    date NULL,
    updated_at    date NULL,
    role_role_id  BIGINT NULL,
    CONSTRAINT pk_candidate PRIMARY KEY (id)
);

CREATE TABLE certificate_candidate
(
    id             VARCHAR(255) NOT NULL,
    name           VARCHAR(255) NULL,
    `organization` VARCHAR(255) NULL,
    started_at     date NULL,
    ended_at       date NULL,
    info           VARCHAR(255) NULL,
    created_at     date NULL,
    updated_at     date NULL,
    candidate_id   VARCHAR(255) NULL,
    CONSTRAINT pk_certificatecandidate PRIMARY KEY (id)
);

CREATE TABLE company
(
    id                 VARCHAR(255) NOT NULL,
    account_company_id BIGINT NULL,
    email              VARCHAR(255) NULL,
    password           VARCHAR(255) NULL,
    name               VARCHAR(255) NULL,
    logo               VARCHAR(255) NULL,
    website            VARCHAR(255) NULL,
    link_fb            VARCHAR(255) NULL,
    link_linked        VARCHAR(255) NULL,
    follower           BIGINT NULL,
    size               BIGINT NULL,
    type_company_id    VARCHAR(255) NULL,
    `description`      VARCHAR(255) NULL,
    created_at         date NULL,
    updated_at         date NULL,
    is_deleted         BIT(1) NULL,
    role_role_id       BIGINT NULL,
    CONSTRAINT pk_company PRIMARY KEY (id)
);

CREATE TABLE education_candidate
(
    id           VARCHAR(255) NOT NULL,
    name         VARCHAR(255) NULL,
    major        VARCHAR(255) NULL,
    start_at     date NULL,
    end_at       date NULL,
    info         VARCHAR(255) NULL,
    created_at   date NULL,
    updated_at   date NULL,
    candidate_id VARCHAR(255) NULL,
    CONSTRAINT pk_educationcandidate PRIMARY KEY (id)
);

CREATE TABLE experience_candidate
(
    id           VARCHAR(255) NOT NULL,
    position     VARCHAR(255) NULL,
    company      VARCHAR(255) NULL,
    start_at     date NULL,
    end_at       date NULL,
    info         VARCHAR(255) NULL,
    created_at   date NULL,
    updated_at   date NULL,
    candidate_id VARCHAR(255) NULL,
    CONSTRAINT pk_experiencecandidate PRIMARY KEY (id)
);

CREATE TABLE job
(
    id            VARCHAR(255) NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    salary        VARCHAR(255) NULL,
    expire_at     date NULL,
    created_at    date NULL,
    updated_at    date NULL,
    location_id   VARCHAR(255) NULL,
    CONSTRAINT pk_job PRIMARY KEY (id)
);

CREATE TABLE job_candidate
(
    id           VARCHAR(255) NOT NULL,
    cv_url       VARCHAR(255) NULL,
    content      VARCHAR(255) NULL,
    status       INT NULL,
    candidate_id VARCHAR(255) NULL,
    job_id       VARCHAR(255) NULL,
    CONSTRAINT pk_jobcandidate PRIMARY KEY (id)
);

CREATE TABLE level_job
(
    id        VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NULL,
    create_at date NULL,
    update_at date NULL,
    CONSTRAINT pk_leveljob PRIMARY KEY (id)
);

CREATE TABLE location
(
    id         VARCHAR(255) NOT NULL,
    name       VARCHAR(255) NULL,
    created_at date NULL,
    updated_at date NULL,
    CONSTRAINT pk_location PRIMARY KEY (id)
);

CREATE TABLE project_candidate
(
    id           VARCHAR(255) NOT NULL,
    name         VARCHAR(255) NULL,
    link         VARCHAR(255) NULL,
    started_at   date NULL,
    ended_at     date NULL,
    info         VARCHAR(255) NULL,
    created_at   date NULL,
    updated_at   date NULL,
    candidate_id VARCHAR(255) NULL,
    CONSTRAINT pk_projectcandidate PRIMARY KEY (id)
);

CREATE TABLE `role`
(
    role_id   BIGINT AUTO_INCREMENT NOT NULL,
    role_name VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (role_id)
);

CREATE TABLE skill_candidate
(
    id           VARCHAR(255) NOT NULL,
    name         VARCHAR(255) NULL,
    level_job_id VARCHAR(255) NULL,
    candidate_id VARCHAR(255) NULL,
    CONSTRAINT pk_skillcandidate PRIMARY KEY (id)
);

CREATE TABLE type_company
(
    id         VARCHAR(255) NOT NULL,
    name       VARCHAR(255) NULL,
    created_at date NULL,
    updated_at date NULL,
    CONSTRAINT pk_typecompany PRIMARY KEY (id)
);

CREATE TABLE type_job
(
    id        VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NULL,
    create_at date NULL,
    update_at date NULL,
    CONSTRAINT pk_typejob PRIMARY KEY (id)
);

ALTER TABLE `admin`
    ADD CONSTRAINT FK_ADMIN_ON_ROLE_ROLE FOREIGN KEY (role_role_id) REFERENCES `role` (role_id);

ALTER TABLE candidate
    ADD CONSTRAINT FK_CANDIDATE_ON_ROLE_ROLE FOREIGN KEY (role_role_id) REFERENCES `role` (role_id);

ALTER TABLE certificate_candidate
    ADD CONSTRAINT FK_CERTIFICATECANDIDATE_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE company
    ADD CONSTRAINT FK_COMPANY_ON_ROLE_ROLE FOREIGN KEY (role_role_id) REFERENCES `role` (role_id);

ALTER TABLE education_candidate
    ADD CONSTRAINT FK_EDUCATIONCANDIDATE_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE experience_candidate
    ADD CONSTRAINT FK_EXPERIENCECANDIDATE_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE job_candidate
    ADD CONSTRAINT FK_JOBCANDIDATE_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE job_candidate
    ADD CONSTRAINT FK_JOBCANDIDATE_ON_JOB FOREIGN KEY (job_id) REFERENCES job (id);

ALTER TABLE job
    ADD CONSTRAINT FK_JOB_ON_LOCATION FOREIGN KEY (location_id) REFERENCES location (id);

ALTER TABLE project_candidate
    ADD CONSTRAINT FK_PROJECTCANDIDATE_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE skill_candidate
    ADD CONSTRAINT FK_SKILLCANDIDATE_ON_CANDIDATE FOREIGN KEY (candidate_id) REFERENCES candidate (id);

ALTER TABLE skill_candidate
    ADD CONSTRAINT FK_SKILLCANDIDATE_ON_LEVEL_JOB FOREIGN KEY (level_job_id) REFERENCES level_job (id);