--
-- Dumping data for table `admin`
--

INSERT INTO admin (id, name, email, pass) VALUES
                                              (1, 'Administrator One', 'admin@gmail.com', 'Password@123'),
                                              (2, 'Administrator Two', 'admin2@gmail.com', 'admin2');



--
-- Dumping data for table `bill`
--

INSERT INTO bill (id, aid, uid, units, amount, status, bdate, ddate) VALUES
                                                                         (17, 1, 8, 210, '450.00', 'PROCESSED', '2021-07-06', '2021-08-05'),
                                                                         (18, 1, 1, 61, '122.00', 'PROCESSED', '2021-07-10', '2021-08-09'),
                                                                         (19, 1, 2, 78, '156.00', 'PENDING', '2021-07-10', '2021-08-09'),
                                                                         (20, 1, 3, 70, '140.00', 'PROCESSED', '2021-07-10', '2021-08-09'),
                                                                         (21, 1, 4, 98, '196.00', 'PENDING', '2021-07-10', '2021-08-09'),
                                                                         (22, 1, 9, 55, '110.00', 'PROCESSED', '2021-07-10', '2021-08-09'),
                                                                         (23, 1, 11, 89, '178.00', 'PROCESSED', '2021-07-10', '2021-08-09'),
                                                                         (24, 1, 7, 103, '206.00', 'PENDING', '2021-07-10', '2021-08-09');


--
-- Dumping data for table `complaint`
--

INSERT INTO complaint (id, uid, aid, complaint, status) VALUES
                                                            (1, 1, 1, 'Transaction Not Processed', 'PROCESSED'),
                                                            (2, 1, 1, 'Transaction Not Processed', 'PROCESSED'),
                                                            (3, 2, 1, 'Previous Complaint Not Processed', 'PROCESSED'),
                                                            (4, 2, 1, 'Transaction Not Processed', 'PROCESSED'),
                                                            (5, 2, 2, 'Transaction Not Processed', 'PROCESSED'),
                                                            (6, 1, 1, 'Bill Not Correct', 'PROCESSED'),
                                                            (7, 3, 1, 'Bill Not Correct', 'PROCESSED'),
                                                            (8, 3, 2, 'Transaction Not Processed', 'PROCESSED'),
                                                            (9, 4, 2, 'Transaction Not Processed', 'PROCESSED'),
                                                            (10, 4, 1, 'Bill Not Correct', 'PROCESSED'),
                                                            (11, 5, 2, 'Bill Generated Late', 'PROCESSED'),
                                                            (12, 1, 2, 'Bill Generated Late', 'NOT PROCESSED'),
                                                            (13, 11, 1, 'Bill Generated Late', 'PROCESSED');


--
-- Dumping data for table `transaction`
--

INSERT INTO transaction (id, bid, payable, pdate, status) VALUES
                                                              (17, 17, '450.00', '2021-07-06', 'PROCESSED'),
                                                              (18, 18, '122.00', '2021-07-10', 'PROCESSED'),
                                                              (19, 19, '156.00', NULL, 'PENDING'),
                                                              (20, 20, '140.00', '2021-07-10', 'PROCESSED'),
                                                              (21, 21, '196.00', NULL, 'PENDING'),
                                                              (22, 22, '110.00', '2021-07-10', 'PROCESSED'),
                                                              (23, 23, '178.00', '2021-07-10', 'PROCESSED'),
                                                              (24, 24, '206.00', NULL, 'PENDING');

--
-- Dumping data for table `unitsrate`
--

INSERT INTO unitsrate (sno, twohundred, fivehundred, thousand) VALUES
    (1, 2, 5, 10);


--
-- Dumping data for table `user`
--

INSERT INTO users (id, name, email, phone, pass, address) VALUES
                                                              (1, 'Frederick J Baker\n', 'baker@gmail.com', '7450002145', 'password', '1488 Franklin Street'),
                                                              (2, 'Antonio Dominguez', 'antonio@gmail.com', '7854547855', 'password', '3961 Sycamore Lake Road'),
                                                              (3, 'Etta H Abner', 'etta@gmail.com', '7012569980', 'password', '3255 Ocello Street'),
                                                              (4, 'Jeffrey Wegman', 'wegman@gmail.com', '7012458888', 'password', '2962 Pine Tree Lane'),
                                                              (5, 'Benjamin Sanderson', 'benjamin@gmail.com', '7012565800', 'password', '4830 Bell Street'),
                                                              (6, 'Eric Webb', 'ericw@gmail.com', '7896541000', 'password', '3485 Stewart Street'),
                                                              (7, 'Jonathan Lasalle', 'jonathan@gmail.com', '70145850025', 'password', '3850 Olen Thomas Drive'),
                                                              (8, 'Liam Moore', 'liamoore@gmail.com', '7012545555', 'password', '744 Ralph Street'),
                                                              (9, 'Will Williams', 'williams@gmail.com', '7696969855', 'password', '7855 Allace Avenue'),
                                                              (10, 'Christine Moore', 'moore@gmail.com', '7896500010', 'password', '1458 Bleckstreet'),
                                                              (11, 'Timothy Diaz', 'timothy@gmail.com', '7412580020', 'password', '4840 Oakdale Avenue');
