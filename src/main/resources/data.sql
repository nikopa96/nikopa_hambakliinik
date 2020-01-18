INSERT INTO nikopa_dental_clinic.doctor(name, telephone, email) VALUES ('Katie Cole', '+372 776 8420', 'katie.cole@nikopa.ee');
INSERT INTO nikopa_dental_clinic.doctor(name, telephone, email) VALUES ('Winifred Miles', '+372 598 0014', 'winifred.miles@nikopa.ee');
INSERT INTO nikopa_dental_clinic.doctor(name, telephone, email) VALUES ('Julia Love', '+372 807 0992', 'julia.love@nikopa.ee');
INSERT INTO nikopa_dental_clinic.doctor(name, telephone, email) VALUES ('Efa Lim', '+372 777 7645', 'efa.lim@nikopa.ee');
INSERT INTO nikopa_dental_clinic.doctor(name, telephone, email) VALUES ('Cydney Medrano', '+372 864 0001', 'cydney.medrano@nikopa.ee');
INSERT INTO nikopa_dental_clinic.doctor(name, telephone, email) VALUES ('Leandro Doherty', '+372 861 0171', 'leandro.doherty@nikopa.ee');
INSERT INTO nikopa_dental_clinic.doctor(name, telephone, email) VALUES ('Chantel Burns', '+372 555 1208', 'chantel.burns@nikopa.ee');
INSERT INTO nikopa_dental_clinic.doctor(name, telephone, email) VALUES ('Keeva Ryan', '+372 715 9091', 'keeva.ryan@nikopa.ee');

INSERT INTO nikopa_dental_clinic.procedure(name, additional_fields)
    VALUES ('Consultation', ('{"prices": [{"name": "Consultation (up to 15 minutes)", "value": "10€"}, ' ||
     '{"name": "Consultation (up to 30 minutes)", "value": "20€"}, ' ||
      '{"name": "Consultation for children", "value": "FREE"}, ' ||
       '{"name": "Consultation for pensioners", "value": "FREE"}]}')::jsonb);
INSERT INTO nikopa_dental_clinic.procedure(name, additional_fields)
    VALUES ('Treatment', ('{"prices": [{"name": "Tooth filling", "value": "40-99€"}, ' ||
     '{"name": "Temporary filling", "value": "20€"}, {"name": "Composite crown", "value": "120€"}, ' ||
      '{"name": "Tooth filling for children", "value": "FREE"}]}')::jsonb);
INSERT INTO nikopa_dental_clinic.procedure(name, additional_fields)
    VALUES ('Tooth extraction', ('{"prices": [{"name": "Single-rooted tooth extraction", "value": "50€"}, ' ||
     '{"name": "Multirooted tooth extraction", "value": "65€"}, ' ||
      '{"name": "Surgical extraction of wisdom tooth", "value": "125€"}, ' ||
       '{"name": "Tooth extraction for children", "value": "FREE"}]}')::jsonb);
INSERT INTO nikopa_dental_clinic.procedure(name, additional_fields)
    VALUES ('Prosthetics', ('{"prices": [{"name": "Ceramic crown", "value": "300€"}, ' ||
     '{"name": "Zirconium crown", "value": "500€"}, {"name": "Impression", "value": "50€"}, ' ||
      '{"name": "Temporary crown prepared during appointment", "value": "35€"}, ' ||
       '{"name": "Temporary laboratory crown", "value": "160€"}]}')::jsonb);
INSERT INTO nikopa_dental_clinic.procedure(name, additional_fields)
    VALUES ('Implantation', ('{"prices": [{"name": "Placing an implant", "value": "600€"}, ' ||
     '{"name": "Supra-construction", "value": "400€"}, {"name": "Crown on an implant", "value": "130€"}]}')::jsonb);

INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (4, 1, '13:41',  '2019-07-29', '13:00 - 14:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (5, 2, '16:15',  '2019-07-29', '16:00 - 17:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (1, 1, '7:41',  '2019-07-30', '7:00 - 8:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (1, 1, '9:28',  '2019-07-30', '9:00 - 10:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (2, 1, '11:44', '2019-07-30', '11:00 - 12:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (2, 1, '18:40', '2019-07-30', '18:00 - 19:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (2, 1, '19:22', '2019-07-30', '19:00 - 20:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (2, 1, '18:36', '2019-07-30', '18:00 - 19:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (3, 2, '8:45',  '2019-07-30', '8:00 - 9:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (3, 2, '10:30', '2019-07-30', '10:00 - 11:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (4, 2, '11:35', '2019-07-30', '11:00 - 12:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (4, 3, '12:30', '2019-07-30', '12:00 - 13:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (4, 3, '14:15', '2019-07-30', '14:00 - 15:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (4, 3, '16:35', '2019-07-30', '16:00 - 17:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (5, 4, '8:45',  '2019-07-30', '8:00 - 9:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (5, 4, '11:15', '2019-07-30', '11:00 - 12:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (6, 4, '11:30', '2019-07-30', '11:00 - 11:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (7, 4, '16:35', '2019-07-30', '16:00 - 17:00');
INSERT INTO nikopa_dental_clinic.visit(doctor_id, procedure_id, time, date, interval)
    VALUES (8, 5, '11:00', '2019-07-30', '11:00 - 12:00');

INSERT INTO nikopa_dental_clinic.client(name, surname, telephone, email, visit_id, connection_type)
    VALUES ('Frances', 'Slater', '+3728750917', 'frances@mail.eu', 1, 'PHONE');
INSERT INTO nikopa_dental_clinic.client(name, surname, telephone, email, visit_id, connection_type)
    VALUES ('Buddy', 'Schofield', '+3729098554', 'buddy@mail.eu', 2, 'EMAIL');