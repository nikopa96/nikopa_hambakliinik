INSERT INTO doctor(name) VALUES ('Katie Cole');
INSERT INTO doctor(name) VALUES ('Winifred Miles');
INSERT INTO doctor(name) VALUES ('Julia Love');
INSERT INTO doctor(name) VALUES ('Efa Lim');
INSERT INTO doctor(name) VALUES ('Cydney Medrano');
INSERT INTO doctor(name) VALUES ('Leandro Doherty');
INSERT INTO doctor(name) VALUES ('Chantel Burns');
INSERT INTO doctor(name) VALUES ('Keeva Ryan');

INSERT INTO procedure(name) VALUES ('Konsultatsioon');
INSERT INTO procedure(name) VALUES ('Hambaravi');
INSERT INTO procedure(name) VALUES ('Hamba eemaldamine');
INSERT INTO procedure(name) VALUES ('Proteseerimine');
INSERT INTO procedure(name) VALUES ('Implantoloogia');

INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (1, 1, '7:41',  '2019-07-30', '7:00 - 8:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (1, 1, '9:28',  '2019-07-30', '9:00 - 10:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (2, 1, '11:44', '2019-07-30', '11:00 - 12:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (2, 1, '18:40', '2019-07-30', '18:00 - 19:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (2, 1, '19:22', '2019-07-30', '19:00 - 20:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (2, 1, '18:36', '2019-07-30', '18:00 - 19:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (3, 2, '8:45',  '2019-07-30', '8:00 - 9:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (3, 2, '10:30', '2019-07-30', '10:00 - 11:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (4, 2, '11:35', '2019-07-30', '11:00 - 12:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (4, 3, '12:30', '2019-07-30', '12:00 - 13:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (4, 3, '14:15', '2019-07-30', '14:00 - 15:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (4, 3, '16:35', '2019-07-30', '16:00 - 17:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (5, 4, '8:45',  '2019-07-30', '8:00 - 9:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (5, 4, '11:15', '2019-07-30', '11:00 - 12:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (6, 4, '11:30', '2019-07-30', '11:00 - 11:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (7, 4, '16:35', '2019-07-30', '16:00 - 17:00');
INSERT INTO visit(doctor_id, procedure_id, time, date, interval) VALUES (8, 5, '11:00', '2019-07-30', '11:00 - 12:00');