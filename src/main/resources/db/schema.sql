
--
-- Table structure for table `admin`
--

CREATE TABLE admin (
                       id serial NOT NULL,
                       name varchar(40) NOT NULL,
                       email varchar(40) NOT NULL,
                       pass varchar(20) NOT NULL,
                       active varchar NOT NULL,
                       created date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE bill (
                      id serial NOT NULL,
                      user_id int NOT NULL,
                      units int NOT NULL,
                      amount decimal(10,2) NOT NULL,
                      status varchar(10) NOT NULL,
                      start_date date NOT NULL,
                      end_date date NOT NULL,
                      active varchar NOT NULL,
                      created date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE complaints (
                           id serial NOT NULL,
                           user_id int NOT NULL,
                           text varchar(140) NOT NULL,
                           active varchar NOT NULL,
                           created date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE transactions (
                             id serial NOT NULL,
                             bill_id int NOT NULL,
                             payable decimal(10,2) NOT NULL,
                             pdate date DEFAULT NULL,
                             status varchar(10) NOT NULL,
                             active varchar NOT NULL,
                             created date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `unitsrate`
--

CREATE TABLE unitsrate (
                           id serial NOT NULL,
                           twohundred int NOT NULL,
                           fivehundred int NOT NULL,
                           thousand int NOT NULL,
                           active varchar NOT NULL,
                           created date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE users (
                       id serial NOT NULL,
                       first_name varchar(40) NOT NULL,
                       last_name varchar(40) NOT NULL,
                       patronymic varchar(40),
                       iin varchar(40),
                       email varchar(40) NOT NULL,
                       phone_number varchar(255) NOT NULL,
                       password varchar(20) NOT NULL,
                       address varchar(100) NOT NULL,
                       active varchar NOT NULL,
                       created date NOT NULL
);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE admin
    ADD PRIMARY KEY (id);

--
-- Indexes for table `bill`
--
ALTER TABLE bill
    ADD PRIMARY KEY (id);
--ADD KEY aid (aid),
--ADD KEY uid (uid);

--
-- Indexes for table `complaint`
--
ALTER TABLE complaints
    ADD PRIMARY KEY (id);
--ADD KEY aid (aid),
--ADD KEY uid (uid);

--
-- Indexes for table `transaction`
--
ALTER TABLE transactions
    ADD PRIMARY KEY (id);
--ADD KEY bid (bid);

--
-- Indexes for table `user`
--
ALTER TABLE users
    ADD PRIMARY KEY (id);

--
-- Constraints for table `bill`
--
ALTER TABLE bill
  ADD CONSTRAINT bill_ibfk_2 FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `complaint`
--
ALTER TABLE complaints
  ADD CONSTRAINT complaint_ibfk_2 FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE transactions
    ADD CONSTRAINT transaction_ibfk_1 FOREIGN KEY (bill_id) REFERENCES bill (id) ON DELETE CASCADE ON UPDATE CASCADE;
