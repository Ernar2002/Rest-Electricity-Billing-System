
--
-- Table structure for table `admin`
--

CREATE TABLE admin (
                       id serial NOT NULL,
                       name varchar(40) NOT NULL,
                       email varchar(40) NOT NULL,
                       pass varchar(20) NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE bill (
                      id serial NOT NULL,
                      aid int NOT NULL,
                      uid int NOT NULL,
                      units int NOT NULL,
                      amount decimal(10,2) NOT NULL,
                      status varchar(10) NOT NULL,
                      bdate date NOT NULL,
                      ddate date NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE complaint (
                           id serial NOT NULL,
                           uid int NOT NULL,
                           aid int NOT NULL,
                           complaint varchar(140) NOT NULL,
                           status varchar(40) NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE transaction (
                             id serial NOT NULL,
                             bid int NOT NULL,
                             payable decimal(10,2) NOT NULL,
                             pdate date DEFAULT NULL,
                             status varchar(10) NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `unitsrate`
--

CREATE TABLE unitsrate (
                           sno int DEFAULT NULL,
                           twohundred int NOT NULL,
                           fivehundred int NOT NULL,
                           thousand int NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE users (
                       id serial NOT NULL,
                       name varchar(40) NOT NULL,
                       email varchar(40) NOT NULL,
                       phone varchar(255) NOT NULL,
                       pass varchar(20) NOT NULL,
                       address varchar(100) NOT NULL
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
ALTER TABLE complaint
    ADD PRIMARY KEY (id);
--ADD KEY aid (aid),
--ADD KEY uid (uid);

--
-- Indexes for table `transaction`
--
ALTER TABLE transaction
    ADD PRIMARY KEY (id)
--ADD KEY bid (bid);

--
-- Indexes for table `user`
--
ALTER TABLE users
    ADD PRIMARY KEY (id);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE admin
    MODIFY id int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
    MODIFY `id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `complaint`
--
ALTER TABLE `complaint`
    MODIFY `id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
    MODIFY `id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
    MODIFY `id` int(14) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE bill
    ADD CONSTRAINT bill_ibfk_1 FOREIGN KEY (aid) REFERENCES admin (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT bill_ibfk_2 FOREIGN KEY (uid) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `complaint`
--
ALTER TABLE complaint
    ADD CONSTRAINT complaint_ibfk_1 FOREIGN KEY (aid) REFERENCES admin (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT complaint_ibfk_2 FOREIGN KEY (uid) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE transaction
    ADD CONSTRAINT transaction_ibfk_1 FOREIGN KEY (bid) REFERENCES bill (id) ON DELETE CASCADE ON UPDATE CASCADE;
