CREATE TABLE doctor (
  doctor_id SERIAL NOT NULL,
  name VARCHAR (255) NOT NULL,
  CONSTRAINT pk_doctor_id PRIMARY KEY (doctor_id)
);

CREATE TABLE procedure (
  procedure_id SERIAL NOT NULL,
  name VARCHAR (255) NOT NULL,
  CONSTRAINT pk_procedure_id PRIMARY KEY (procedure_id)
);

CREATE TABLE visit (
  visit_id BIGSERIAL NOT NULL,
  doctor_id INT NOT NULL,
  procedure_id INT NOT NULL,
  time TIME WITHOUT TIME ZONE NOT NULL,
  date DATE NOT NULL,
  interval VARCHAR(13) NOT NULL,
  is_active BOOLEAN NOT NULL DEFAULT TRUE,
  is_booked BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT pk_visit_id PRIMARY KEY (visit_id),
  CONSTRAINT fk_visit_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)
    ON UPDATE CASCADE ON DELETE NO ACTION,
  CONSTRAINT fk_visit_procedure_id FOREIGN KEY (procedure_id) REFERENCES procedure(procedure_id)
    ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE client (
  client_id BIGSERIAL NOT NULL,
  name VARCHAR (255) NOT NULL,
  surname VARCHAR (255) NOT NULL,
  telephone VARCHAR (60) NOT NULL,
  email VARCHAR (255) NOT NULL,
  visit_id BIGINT NOT NULL,
  connection_type VARCHAR(5) NOT NULL,
  CONSTRAINT pk_client_id PRIMARY KEY (client_id),
  CONSTRAINT fk_client_visit_id FOREIGN KEY (visit_id) REFERENCES visit(visit_id)
    ON UPDATE CASCADE ON DELETE NO ACTION,
  CONSTRAINT chk_client_telephone_is_valid CHECK (telephone ~* '^[+]*[(]?[+]?[0-9]*[)]?[-\s\d]*$'),
  CONSTRAINT chk_client_email_is_valid CHECK (email ~* '^([a-z0-9_\-\.]+)@([a-z0-9_\-\.]+)\.([a-z]{2,5})$')
);

CREATE INDEX idx_visit_doctor_id ON visit(doctor_id);
CREATE INDEX idx_visit_procedure_id ON visit(procedure_id);
CREATE INDEX idx_client_visit_id ON client(visit_id);