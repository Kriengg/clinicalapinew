-- Insert statements for PATIENT table
INSERT INTO PATIENT (first_name, last_name, age) VALUES ('John', 'Doe', 30);
INSERT INTO PATIENT (first_name, last_name, age) VALUES ('Jane', 'Smith', 25);
INSERT INTO PATIENT (first_name, last_name, age) VALUES ('Alice', 'Johnson', 40);
INSERT INTO PATIENT (first_name, last_name, age) VALUES ('Bob', 'Brown', 35);

-- Insert statements for CLINICALDATA table
INSERT INTO CLINICALDATA (patient_id, component_name, component_value, measured_date_time) VALUES (1, 'Blood Pressure', '120/80', '2024-10-10 10:00:00');
INSERT INTO CLINICALDATA (patient_id, component_name, component_value, measured_date_time) VALUES (1, 'Heart Rate', '72', '2024-10-10 10:05:00');
INSERT INTO CLINICALDATA (patient_id, component_name, component_value, measured_date_time) VALUES (2, 'Blood Pressure', '110/70', '2024-10-10 11:00:00');
INSERT INTO CLINICALDATA (patient_id, component_name, component_value, measured_date_time) VALUES (2, 'Heart Rate', '68', '2024-10-10 11:05:00');
INSERT INTO CLINICALDATA (patient_id, component_name, component_value, measured_date_time) VALUES (3, 'Blood Pressure', '130/85', '2024-10-10 12:00:00');
INSERT INTO CLINICALDATA (patient_id, component_name, component_value, measured_date_time) VALUES (3, 'Heart Rate', '75', '2024-10-10 12:05:00');
INSERT INTO CLINICALDATA (patient_id, component_name, component_value, measured_date_time) VALUES (4, 'Blood Pressure', '125/80', '2024-10-10 13:00:00');
INSERT INTO CLINICALDATA (patient_id, component_name, component_value, measured_date_time) VALUES (4, 'Heart Rate', '70', '2024-10-10 13:05:00');