--
-- Dumping data for table `admin`
--

INSERT INTO admin (id, name, email, pass, active, created) VALUES
                                              (1, 'Administrator One', 'admin@gmail.com', 'Password123', 'ACTIVE', '2022-10-05')



--
-- Dumping data for table `bill`
--

INSERT INTO bill (id, user_id, units, amount, status, start_date, end_date, active, created)
VALUES
 (17, 8, 210, '450.00', 'PROCESSED', '2021-07-06', '2021-08-05', 'ACTIVE', '2022-05-10'),
 (18, 1, 61, '122.00', 'PROCESSED', '2021-07-10', '2021-08-09', 'ACTIVE', '2022-05-10'),
 (19, 2, 78, '156.00', 'PENDING', '2021-07-10', '2021-08-09', 'ACTIVE', '2022-05-10'),
 (20, 3, 70, '140.00', 'PROCESSED', '2021-07-10', '2021-08-09', 'ACTIVE', '2022-05-10'),
 (21, 4, 98, '196.00', 'PENDING', '2021-07-10', '2021-08-09', 'ACTIVE', '2022-05-10'),
 (22, 9, 55, '110.00', 'PROCESSED', '2021-07-10', '2021-08-09', 'ACTIVE', '2022-05-10'),
 (23, 11, 89, '178.00', 'PROCESSED', '2021-07-10', '2021-08-09', 'ACTIVE', '2022-05-10'),
 (24, 7, 103, '206.00', 'PENDING', '2021-07-10', '2021-08-09', 'ACTIVE', '2022-05-10');


--
-- Dumping data for table `complaint`
--

INSERT INTO complaints (id, user_id, text, active, created)
 VALUES
    (1, 1, 'Transaction Not Processed', 'ACTIVE', '2022-05-10'),
    (2, 1, 'Transaction Not Processed', 'ACTIVE', '2022-05-10'),
    (3, 2, 'Previous Complaint Not Processed', 'ACTIVE', '2022-05-10'),
    (4, 2, 'Transaction Not Processed', 'ACTIVE', '2022-05-10'),
    (5, 2, 'Transaction Not Processed', 'ACTIVE', '2022-05-10'),
    (6, 1, 'Bill Not Correct', 'ACTIVE', '2022-05-10'),
    (7, 3, 'Bill Not Correct', 'ACTIVE', '2022-05-10'),
    (8, 3, 'Transaction Not Processed', 'ACTIVE', '2022-05-10'),
    (9, 4, 'Transaction Not Processed', 'ACTIVE', '2022-05-10'),
    (10, 4, 'Bill Not Correct', 'ACTIVE', '2022-05-10'),
    (11, 5, 'Bill Generated Late', 'ACTIVE', '2022-05-10'),
    (12, 1, 'Bill Generated Late', 'ACTIVE', '2022-05-10'),
    (13, 11, 'Bill Generated Late', 'ACTIVE', '2022-05-10');


--
-- Dumping data for table `transaction`
--

INSERT INTO transactions (id, bill_id, payable, pdate, status, active, created)
VALUES
    (17, 17, '450.00', '2021-07-06', 'PROCESSED', 'ACTIVE', '2022-05-10'),
    (18, 18, '122.00', '2021-07-10', 'PROCESSED', 'ACTIVE', '2022-05-10'),
    (19, 19, '156.00', NULL, 'PENDING', 'ACTIVE', '2022-05-10'),
    (20, 20, '140.00', '2021-07-10', 'PROCESSED', 'ACTIVE', '2022-05-10'),
    (21, 21, '196.00', NULL, 'PENDING', 'ACTIVE', '2022-05-10'),
    (22, 22, '110.00', '2021-07-10', 'PROCESSED', 'ACTIVE', '2022-05-10'),
    (23, 23, '178.00', '2021-07-10', 'PROCESSED', 'ACTIVE', '2022-05-10'),
    (24, 24, '206.00', NULL, 'PENDING', 'ACTIVE', '2022-05-10');

--
-- Dumping data for table `unitsrate`
--

INSERT INTO unitsrate (id, twohundred, fivehundred, thousand, active, created) VALUES
    (1, 2, 5, 10, 'ACTIVE', '2022-05-10');


--
-- Dumping data for table `user`
--

INSERT INTO users (id,
                   first_name,
                   last_name,
                   iin,
                   email,
                   phone_number,
                   password,
                   address,
                   active,
                   created)
VALUES
  (1, 'Frederick', 'J Baker', '980126854515', 'baker@gmail.com', '87072564514', 'password', '1488 Franklin Street', 'ACTIVE','2022-05-10'),
  (2, 'Antonio', 'Dominguez', '890314854515', 'antonio@gmail.com', '87085454755', 'password', '3961 Sycamore Lake Road', 'ACTIVE','2022-05-10'),
  (3, 'Etta', 'H Abner', '950425854515' , 'etta@gmail.com', '87012569980', 'password', '3255 Ocello Street', 'ACTIVE','2022-05-10'),
  (4, 'Jeffrey', 'Wegman', '940625854515', 'wegman@gmail.com', '87012458888', 'password', '2962 Pine Tree Lane', 'ACTIVE','2022-05-10'),
  (5, 'Benjamin', ' Sanderson', '871201854515', 'benjamin@gmail.com', '7012565800', 'password', '4830 Bell Street', 'ACTIVE','2022-05-10'),
  (6, 'Eric', 'Webb', '840817854515', 'ericw@gmail.com', '87076541000', 'password', '3485 Stewart Street', 'ACTIVE','2022-05-10'),
  (7, 'Jonathan', 'Lasalle', '990825854515', 'jonathan@gmail.com', '87014585025', 'password', '3850 Olen Thomas Drive', 'ACTIVE','2022-05-10'),
  (8, 'Liam', 'Moore', '940712854515', 'liamoore@gmail.com', '87012545555', 'password', '744 Ralph Street', 'ACTIVE','2022-05-10'),
  (9, 'Will', 'Williams', '920404854515', 'williams@gmail.com', '87076969855', 'password', '7855 Allace Avenue', 'ACTIVE','2022-05-10'),
  (10, 'Christine', 'Moore', '970326854515', 'moore@gmail.com', '87006500010', 'password', '1458 Bleckstreet', 'ACTIVE','2022-05-10'),
  (11, 'Timothy', ' Diaz', '910824854515', 'timothy@gmail.com', '87071258020', 'password', '4840 Oakdale Avenue', 'ACTIVE','2022-05-10');
