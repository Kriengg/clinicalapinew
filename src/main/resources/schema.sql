CREATE TABLE PATIENT (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT
);

CREATE TABLE CLINICALDATA (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT,
    component_name VARCHAR(50),
    component_value VARCHAR(50),
    measured_date_time TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES PATIENT(id)
);