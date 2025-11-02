CREATE DATABASE bp3_praktikum7_2410031;
USE bp3_praktikum7_2410031;

CREATE TABLE tagihan2410031 (
    notagihan2410031 CHAR(10) PRIMARY KEY,
    namapelanggan2410031 VARCHAR(50),
    kodetarif2410031 VARCHAR(5),
    meterlalu2410031 INT,
    metersekarang2410031 INT,
    pemakaian2410031 INT,
    diskon2410031 DOUBLE,
    totalbayar2410031 DOUBLE
);
