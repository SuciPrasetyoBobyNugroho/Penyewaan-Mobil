-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Agu 2022 pada 01.52
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtksaplikasi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_mobil`
--

CREATE TABLE `data_mobil` (
  `no_plat` varchar(15) NOT NULL,
  `merk` varchar(30) NOT NULL,
  `tipe` varchar(15) NOT NULL,
  `harga` varchar(15) NOT NULL,
  `tahun` varchar(10) NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_mobil`
--

INSERT INTO `data_mobil` (`no_plat`, `merk`, `tipe`, `harga`, `tahun`, `keterangan`) VALUES
('B 9877 TSK', 'Mitshubishi', 'STANDART', '350000', '2015', 'PERBAIKAN'),
('B 9865 TRE', 'Mitshubishi', 'VIP', '500000', '2019', 'TERSEDIA'),
('B 9789 ER', 'Isuzu', 'STANDART', '350000', '2017', 'DI SEWA'),
('B 7867 ERK', 'Isuzu', 'VIP', '500000', '2019', 'DI SEWA'),
('B 9951 TKS', 'Mitshubishi', 'VIP', '500000', '2018', 'TERSEDIA');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_pegawai`
--

CREATE TABLE `data_pegawai` (
  `nik` varchar(15) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `bagian` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_pegawai`
--

INSERT INTO `data_pegawai` (`nik`, `nama`, `alamat`, `no_telepon`, `bagian`) VALUES
('201001', 'suci', 'jakarta', '081241418677', 'marketing'),
('201003', 'prasetyo', 'jakarta', '081224343567', 'supir'),
('201004', 'boby n', 'depok', '087881567622', 'supir'),
('201005', 'nugroho ', 'jakarta', '085245456788', 'supir');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_pelanggan`
--

CREATE TABLE `data_pelanggan` (
  `no_transaksi` varchar(15) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `kebutuhan` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `no_plat` varchar(15) NOT NULL,
  `tipe` varchar(15) NOT NULL,
  `harga` varchar(15) NOT NULL,
  `lama_sewa` varchar(5) NOT NULL,
  `total_bayar` varchar(15) NOT NULL,
  `dp` varchar(15) NOT NULL,
  `total_kurang` varchar(15) NOT NULL,
  `keterangan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_pelanggan`
--

INSERT INTO `data_pelanggan` (`no_transaksi`, `nama`, `kebutuhan`, `alamat`, `no_telp`, `no_plat`, `tipe`, `harga`, `lama_sewa`, `total_bayar`, `dp`, `total_kurang`, `keterangan`) VALUES
('TRK0001', 'Boby N', 'PRIBADI', 'Jakarta', '087881557871', 'B 7867 ERK', 'VIP', '500000', '3', '1500000', '500000', '1000000', 'BELUM LUNAS'),
('TRK0002', 'Nugroho', 'PRIBADI', 'Depok', '082242288660', 'B 9789 ER', 'STANDART', '350000', '7', '2450000', '2450000', '0', 'LUNAS');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `tempat_lahir` varchar(15) NOT NULL,
  `tanggal_lahir` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`, `nama`, `jenis_kelamin`, `tempat_lahir`, `tanggal_lahir`, `alamat`, `status`) VALUES
('admin', 'admin123', 'Admin', 'Laki-laki', 'jakarta', '2000-08-17', 'Jakarta', 'on'),
('boby', 'boby123', 'Boby Nugroho', 'Laki-laki', 'Klaten', '1997-01-10', 'Jakarta', 'on');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobilkeluar`
--

CREATE TABLE `mobilkeluar` (
  `no_transaksi` varchar(15) NOT NULL,
  `nik` varchar(15) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `no_plat` varchar(15) NOT NULL,
  `merk` varchar(30) NOT NULL,
  `tipe` varchar(15) NOT NULL,
  `tahun` varchar(10) NOT NULL,
  `tanggal` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mobilkeluar`
--

INSERT INTO `mobilkeluar` (`no_transaksi`, `nik`, `nama`, `no_telepon`, `no_plat`, `merk`, `tipe`, `tahun`, `tanggal`) VALUES
('TRK0001', '201003', 'prasetyo', '081224343567', 'B 7867 ERK', 'Isuzu', 'VIP', '2019', '03-06-2022'),
('TRK0002', '201004', 'boby n', '087881567622', 'B 9789 ER', 'Isuzu', 'STANDART', '2017', '04-06-2022');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobilkembali`
--

CREATE TABLE `mobilkembali` (
  `no_transaksi` varchar(15) CHARACTER SET latin1 NOT NULL,
  `no_plat` varchar(15) NOT NULL,
  `merk` varchar(30) NOT NULL,
  `tipe` varchar(15) NOT NULL,
  `tahun` varchar(10) NOT NULL,
  `tanggal` varchar(15) NOT NULL,
  `harga` varchar(15) NOT NULL,
  `jumlah` varchar(10) NOT NULL,
  `total` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mobilkembali`
--

INSERT INTO `mobilkembali` (`no_transaksi`, `no_plat`, `merk`, `tipe`, `tahun`, `tanggal`, `harga`, `jumlah`, `total`) VALUES
('TRK0001', 'B 7867 ERK', 'Isuzu', 'VIP', '2019', '05-06-2022', '500000', '3', '1500000'),
('TRK0002', 'B 9789 ER', 'Isuzu', 'STANDART', '2017', '10-06-2022', '350000', '7', '2450000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mobilkembali`
--
ALTER TABLE `mobilkembali`
  ADD PRIMARY KEY (`no_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
