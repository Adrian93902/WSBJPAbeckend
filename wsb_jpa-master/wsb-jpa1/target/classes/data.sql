INSERT INTO Address (address_id, city, address_line1, address_line2, postal_code)
VALUES
    (1, 'Warszawa', 'Aleje Jerozolimskie 123', 'Klatka A, mieszkanie 5', '00-001'),
    (2, 'Kraków', 'ul. Floriańska 12', 'Mieszkanie 3B', '30-005'),
    (3, 'Gdańsk', 'ul. Długa 15', 'Apartament 7', '80-001'),
    (4, 'Poznań', 'ul. Wielka 8', 'Klatka B, mieszkanie 15', '61-001'),
    (5, 'Wrocław', 'ul. Rynek 10', 'Klatka D, mieszkanie 6', '50-005'),
    (6, 'Łódź', 'ul. Piotrkowska 100', 'Apartament 25', '90-001');


INSERT INTO Doctor (doctor_id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES
    (1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', '123ABC', 'SURGEON', 1),
    (2, 'Aleksandra', 'Wiśniewska', '456123789', 'aleksandra.wisniewska@example.com', '456DEF', 'SURGEON', 2),
    (3, 'Piotr', 'Nowak', '789456123', 'piotr.nowak@example.com', '789GHI', 'GP', 3),
    (4, 'Magdalena', 'Kowalczyk', '654789321', 'magdalena.kowalczyk@example.com', '654JKL', 'GP', 4),
    (5, 'Andrzej', 'Lewandowski', '321654987', 'andrzej.lewandowski@example.com', '321MNO', 'DERMATOLOGIST', 5),
    (6, 'Karolina', 'Dąbrowska', '987321654', 'karolina.dabrowska@example.com', '987PQR', 'OCULIST', 6);


INSERT INTO Patient (patient_id, first_name, last_name, telephone_number, email, patient_number,height_cm,date_of_birth, address_id)
VALUES
    (1, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', 'PAT123','165' ,'2000-01-01', 1),
    (2, 'Tomasz', 'Wójcik', '369852147', 'tomasz.wojcik@example.com', 'PAT456','183' ,'1995-05-15', 2),
    (3, 'Monika', 'Lis', '147258369', 'monika.lis@example.com', 'PAT789','172' ,'1980-12-30', 3),
    (4, 'Marek', 'Szymański', '852963147', 'marek.szymanski@example.com','PAT1234','190', '1976-09-20', 4),
    (5, 'Ewa', 'Kowal', '963741852', 'ewa.kowal@example.com', 'PAT5678','141' ,'2002-07-10', 5),
    (6, 'Paweł', 'Zając', '741852963', 'pawel.zajac@example.com', 'PAT91011','177' ,'1990-03-25', 6);


INSERT INTO Visit (visit_id, description, time, doctor_id, patient_id)
VALUES
    (1, 'Badanie kontrolne', CURRENT_TIMESTAMP, 1, 1),
    (2, 'Konsultacja lekarska', CURRENT_TIMESTAMP, 2, 2),
    (3, 'Badanie neurologiczne', CURRENT_TIMESTAMP, 3, 3),
    (4, 'Zabieg chirurgiczny', CURRENT_TIMESTAMP, 4, 4),
    (5, 'Badanie okulistyczne', CURRENT_TIMESTAMP, 5, 5),
    (6, 'Kontrola ortopedyczna', CURRENT_TIMESTAMP, 6, 6),
    (7, 'Badanie kontrolne', CURRENT_TIMESTAMP, 6, 6),
    (8, 'Konsultacja lekarska', CURRENT_TIMESTAMP, 5, 5),
    (9, 'Badanie neurologiczne', CURRENT_TIMESTAMP,4, 4),
    (10, 'Zabieg chirurgiczny', CURRENT_TIMESTAMP, 3, 3),
    (11, 'Badanie okulistyczne', CURRENT_TIMESTAMP, 2, 2),
    (12, 'Kontrola ortopedyczna', CURRENT_TIMESTAMP, 1, 1);


INSERT INTO medical_treatment (mt_id, description, type, visit_id)
VALUES
    (1, 'US Doppler Tetnic', 'USG', 1),
    (2, 'Ocena prawdopodobnej choroby koardiologicznej', 'EKG', 2),
    (3, 'Kontrola nadgarstka', 'RTG', 3),
    (4, 'USG Piersi Lewej', 'USG', 4),
    (5, 'Ocena prawdopodobnej choroby koardiologicznej', 'EKG', 5),
    (6, 'Kontrola pooperacyjna klatki piersiowej', 'RTG', 6);