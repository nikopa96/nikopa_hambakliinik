DROP SCHEMA IF EXISTS nikopa_dental_clinic CASCADE;
CREATE SCHEMA IF NOT EXISTS nikopa_dental_clinic;

CREATE TABLE nikopa_dental_clinic.doctor (
  doctor_id SERIAL NOT NULL,
  name VARCHAR (255) NOT NULL,
  telephone VARCHAR (15) NOT NULL,
  email VARCHAR (255) NOT NULL,
  photo_url VARCHAR (50),
  additional_fields JSONB,
  CONSTRAINT pk_doctor_id PRIMARY KEY (doctor_id)
);

CREATE TABLE nikopa_dental_clinic.procedure (
  procedure_id SERIAL NOT NULL,
  name VARCHAR (255) NOT NULL,
  additional_fields JSONB,
  CONSTRAINT pk_procedure_id PRIMARY KEY (procedure_id)
);

CREATE TABLE nikopa_dental_clinic.visit (
  visit_id BIGSERIAL NOT NULL,
  doctor_id INT NOT NULL,
  procedure_id INT NOT NULL,
  time TIME WITHOUT TIME ZONE NOT NULL,
  date DATE NOT NULL,
  interval VARCHAR(13) NOT NULL,
  is_active BOOLEAN NOT NULL DEFAULT TRUE,
  is_booked BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT pk_visit_id PRIMARY KEY (visit_id),
  CONSTRAINT fk_visit_doctor_id FOREIGN KEY (doctor_id) REFERENCES nikopa_dental_clinic.doctor(doctor_id)
    ON UPDATE CASCADE ON DELETE NO ACTION,
  CONSTRAINT fk_visit_procedure_id FOREIGN KEY (procedure_id) REFERENCES nikopa_dental_clinic.procedure(procedure_id)
    ON UPDATE CASCADE ON DELETE NO ACTION,
  CONSTRAINT chk_visit_interval_is_valid CHECK (visit.interval ~* '^[0-2]?\d[:]\d\d\s[-]\s[0-2]?\d[:]\d\d*$')
);
CREATE INDEX idx_visit_doctor_id ON nikopa_dental_clinic.visit(doctor_id);
CREATE INDEX idx_visit_procedure_id ON nikopa_dental_clinic.visit(procedure_id);

CREATE TABLE nikopa_dental_clinic.client (
  client_id BIGSERIAL NOT NULL,
  name VARCHAR (255) NOT NULL,
  surname VARCHAR (255) NOT NULL,
  telephone VARCHAR (60) NOT NULL,
  email VARCHAR (255) NOT NULL,
  visit_id BIGINT NOT NULL UNIQUE,
  connection_type VARCHAR(5) NOT NULL,
  CONSTRAINT pk_client_id PRIMARY KEY (client_id),
  CONSTRAINT fk_client_visit_id FOREIGN KEY (visit_id) REFERENCES nikopa_dental_clinic.visit(visit_id)
    ON UPDATE CASCADE ON DELETE NO ACTION,
  CONSTRAINT chk_client_telephone_is_valid CHECK (telephone ~* '^[+]*[(]?[+]?[0-9]*[)]?[-\s\d]*$'),
  CONSTRAINT chk_client_email_is_valid CHECK (email ~* '^([a-z0-9_\-\.]+)@([a-z0-9_\-\.]+)\.([a-z]{2,5})$')
);
CREATE INDEX idx_client_visit_id ON nikopa_dental_clinic.client(visit_id);
