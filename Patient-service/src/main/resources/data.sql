CREATE TABLE IF NOT EXISTS patient (
    patient_id UUID PRIMARY KEY,                               firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    registered_date DATE NOT NULL,
    gender VARCHAR(50),
    blood_type VARCHAR(10),
    emergency_contact_name VARCHAR(255),
    emergency_contact_phone VARCHAR(255),
    insured BOOLEAN,
    insurance_provider VARCHAR(255),
    medical_history TEXT,
    last_visit_date TIMESTAMP,
    status VARCHAR(50)
    );

INSERT INTO patient (
    patient_id, firstname, lastname, email, phone_number, address,
    date_of_birth, registered_date, gender, blood_type,
    emergency_contact_name, emergency_contact_phone,
    insured, insurance_provider, medical_history,
    last_visit_date, status
) VALUES

      ('550e8400-e29b-41d4-a716-446655440010','David','Nambala','david.nambala@example.com','+264811111111','Windhoek, Namibia',DATE '1987-05-12',DATE '2023-01-10','Male','A+','Anna Nambala','+264822222222',TRUE,'Momentum','None',TIMESTAMP '2024-05-10 09:00:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440011','Maria','Shikongo','maria.shikongo@example.com','+264833333333','Swakopmund, Namibia',DATE '1992-08-20',DATE '2023-02-15','Female','O-','Paul Shikongo','+264844444444',FALSE,NULL,'Asthma',TIMESTAMP '2024-04-15 10:30:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440012','John','Kandume','john.kandume@example.com','+264855555555','Walvis Bay, Namibia',DATE '1975-03-05',DATE '2022-09-12','Male','B+','Grace Kandume','+264866666666',TRUE,'Old Mutual','Diabetes Type 2',TIMESTAMP '2024-03-01 14:00:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440013','Elena','Petrus','elena.petrus@example.com','+264877777777','Oshakati, Namibia',DATE '1989-11-22',DATE '2023-05-01','Female','AB+','Samuel Petrus','+264888888888',TRUE,'NamHealth','High blood pressure',TIMESTAMP '2024-02-18 11:45:00','INACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440014','Peter','Hamutenya','peter.hamutenya@example.com','+264899999999','Rundu, Namibia',DATE '1994-06-30',DATE '2024-01-05','Male','O+','Julia Hamutenya','+264811223344',TRUE,'Momentum','None',TIMESTAMP '2024-06-10 08:30:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440015','Anna','Tjipura','anna.tjipura@example.com','+264812345111','Keetmanshoop, Namibia',DATE '1983-09-17',DATE '2022-07-20','Female','A-','Mark Tjipura','+264812345222',FALSE,NULL,'Migraines',TIMESTAMP '2024-01-20 13:15:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440016','Lucas','Munyika','lucas.munyika@example.com','+264812345333','Katima Mulilo, Namibia',DATE '1999-02-10',DATE '2024-03-01','Male','B-','Ruth Munyika','+264812345444',TRUE,'Old Mutual','None',TIMESTAMP '2024-06-01 16:00:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440017','Sophia','Uutoni','sophia.uutoni@example.com','+264812345555','Windhoek, Namibia',DATE '1991-12-05',DATE '2023-10-10','Female','O+','David Uutoni','+264812345666',TRUE,'Momentum','Allergy: Penicillin',TIMESTAMP '2024-05-05 12:30:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440018','Michael','Shipanga','michael.shipanga@example.com','+264812345777','Swakopmund, Namibia',DATE '1980-04-18',DATE '2022-12-15','Male','A+','Clara Shipanga','+264812345888',TRUE,'NamHealth','Hypertension',TIMESTAMP '2024-03-22 09:45:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440019','Linda','Amadhila','linda.amadhila@example.com','+264812345999','Oshakati, Namibia',DATE '1996-07-25',DATE '2024-02-10','Female','B+','Simon Amadhila','+264812346000',FALSE,NULL,'None',TIMESTAMP '2024-04-12 15:00:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440020','Brian','Ndapewa','brian.ndapewa@example.com','+264812346111','Walvis Bay, Namibia',DATE '1978-01-09',DATE '2021-08-05','Male','AB-','Emma Ndapewa','+264812346222',TRUE,'Old Mutual','Arthritis',TIMESTAMP '2024-02-05 10:10:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440021','Grace','Iipinge','grace.iipinge@example.com','+264812346333','Rundu, Namibia',DATE '1985-10-14',DATE '2023-04-18','Female','O-','Peter Iipinge','+264812346444',TRUE,'Momentum','None',TIMESTAMP '2024-05-25 14:20:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440022','Daniel','Angula','daniel.angula@example.com','+264812346555','Windhoek, Namibia',DATE '1993-03-29',DATE '2023-09-30','Male','A+','Maria Angula','+264812346666',TRUE,'NamHealth','None',TIMESTAMP '2024-06-05 11:00:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440023','Helena','Shilongo','helena.shilongo@example.com','+264812346777','Keetmanshoop, Namibia',DATE '1988-12-12',DATE '2022-11-11','Female','B-','Thomas Shilongo','+264812346888',FALSE,NULL,'Thyroid condition',TIMESTAMP '2024-03-28 13:00:00','ACTIVE'),

      ('550e8400-e29b-41d4-a716-446655440024','Joseph','Katjiua','joseph.katjiua@example.com','+264812346999','Katima Mulilo, Namibia',DATE '1972-06-06',DATE '2020-05-20','Male','O+','Linda Katjiua','+264812347000',TRUE,'Old Mutual','Heart condition',TIMESTAMP '2024-01-15 09:30:00','INACTIVE');

INSERT INTO patient (
    patient_id, firstname, lastname, email, phone_number, address,
    date_of_birth, registered_date, gender, blood_type,
    emergency_contact_name, emergency_contact_phone,
    insured, insurance_provider, medical_history,
    last_visit_date, status
)
SELECT
    '550e8400-e29b-41d4-a716-446655440001',
    'Thomas',
    'Shikalepo',
    'thomas.shikalepo@example.com',
    '+264812345678',
    '12 Independence Ave, Windhoek',
    '1998-04-12',
    '2024-01-10',
    'Male',
    'O+',
    'Maria Shikalepo',
    '+264819876543',
    TRUE,
    'NamHealth Insurance',
    'No known allergies. Previous minor surgery in 2018.',
    '2024-05-20 10:30:00',
    'ACTIVE'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE patient_id = '550e8400-e29b-41d4-a716-446655440001'
);

INSERT INTO patient (
    patient_id, firstname, lastname, email, phone_number, address,
    date_of_birth, registered_date, gender, blood_type,
    emergency_contact_name, emergency_contact_phone,
    insured, insurance_provider, medical_history,
    last_visit_date, status
)
SELECT
    '550e8400-e29b-41d4-a716-446655440002',
    'Amelia',
    'Nghipandulwa',
    'amelia.nghipandulwa@example.com',
    '+264813456789',
    '45 Sam Nujoma Dr, Swakopmund',
    '1992-11-03',
    '2023-08-15',
    'Female',
    'A-',
    'Paul Nghipandulwa',
    '+264817654321',
    FALSE,
    NULL,
    'Asthma diagnosed in 2010.',
    '2024-04-02 14:15:00',
    'ACTIVE'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE patient_id = '550e8400-e29b-41d4-a716-446655440002'
);

INSERT INTO patient (
    patient_id, firstname, lastname, email, phone_number, address,
    date_of_birth, registered_date, gender, blood_type,
    emergency_contact_name, emergency_contact_phone,
    insured, insurance_provider, medical_history,
    last_visit_date, status
)
SELECT
    '550e8400-e29b-41d4-a716-446655440003',
    'Michael',
    'Haufiku',
    'michael.haufiku@example.com',
    '+264814567890',
    '89 Lagoon St, Walvis Bay',
    '1985-07-19',
    '2022-03-22',
    'Male',
    'B+',
    'Anna Haufiku',
    '+264816789012',
    TRUE,
    'Momentum Namibia',
    'Type 2 Diabetes.',
    '2024-06-01 09:00:00',
    'ACTIVE'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE patient_id = '550e8400-e29b-41d4-a716-446655440003'
);

INSERT INTO patient (
    patient_id, firstname, lastname, email, phone_number, address,
    date_of_birth, registered_date, gender, blood_type,
    emergency_contact_name, emergency_contact_phone,
    insured, insurance_provider, medical_history,
    last_visit_date, status
)
SELECT
    '550e8400-e29b-41d4-a716-446655440004',
    'Elina',
    'Petrus',
    'elina.petrus@example.com',
    '+264815678901',
    '23 Oshakati Main Rd, Oshakati',
    '1979-02-25',
    '2021-12-10',
    'Female',
    'AB+',
    'Joseph Petrus',
    '+264818765432',
    TRUE,
    'Old Mutual Health',
    'High blood pressure.',
    '2024-03-18 16:45:00',
    'INACTIVE'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE patient_id = '550e8400-e29b-41d4-a716-446655440004'
);