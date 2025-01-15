-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Jan 2025 pada 11.12
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2210010111_pertambangan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mitra`
--

CREATE TABLE `mitra` (
  `id_mitra` char(25) NOT NULL,
  `nama_cv` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `telp` char(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mitra`
--

INSERT INTO `mitra` (`id_mitra`, `nama_cv`, `alamat`, `telp`) VALUES
('1', 'CV Sinar Abadi', 'Jl. Harapan Indah Jaya No. 4', '08239203993'),
('2', 'CV Sukses Jaya', 'Jl. Harapan Indah Jaya No. 2', '08532389312');

-- --------------------------------------------------------

--
-- Struktur dari tabel `produksi`
--

CREATE TABLE `produksi` (
  `id_produksi` char(25) NOT NULL,
  `tgl` date NOT NULL,
  `shift` enum('Pagi','Siang','Sore','Malam') NOT NULL,
  `id_truk` int(11) NOT NULL,
  `id_stokpile` int(11) NOT NULL,
  `muatan` char(20) NOT NULL,
  `kosong` char(20) NOT NULL,
  `volume` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `produksi`
--

INSERT INTO `produksi` (`id_produksi`, `tgl`, `shift`, `id_truk`, `id_stokpile`, `muatan`, `kosong`, `volume`) VALUES
('001', '2024-11-19', 'Pagi', 1, 1, '10kg', 'Ya', 10000),
('002', '2024-11-20', 'Siang', 2, 2, '80kg', 'Ya', 8000),
('003', '2024-11-21', 'Malam', 3, 3, '190kg', 'Ya', 18000),
('004', '2024-11-22', 'Sore', 4, 4, '90kg', 'Tidak', 3000),
('005', '2024-11-23', 'Malam', 5, 5, '50kg', 'Tidak', 3000),
('006', '2024-11-24', 'Siang', 6, 6, '70kg', 'Tidak', 4500),
('007', '2024-12-14', 'Malam', 7, 7, '89kg', 'Kemungkinan', 9000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `stokpile`
--

CREATE TABLE `stokpile` (
  `id_stokpile` int(11) NOT NULL,
  `kode_lahan` char(25) DEFAULT NULL,
  `stok` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `stokpile`
--

INSERT INTO `stokpile` (`id_stokpile`, `kode_lahan`, `stok`) VALUES
(201, 'LAHN-01', 50000),
(202, 'LAHN-02', 100000),
(203, 'LAHN-03', 60000),
(204, 'LAHN-04', 45000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `truk`
--

CREATE TABLE `truk` (
  `id_truk` int(11) NOT NULL,
  `id_mitra` int(11) NOT NULL,
  `kode_truk` char(50) NOT NULL,
  `merk` varchar(100) NOT NULL,
  `daya_angkut` char(50) NOT NULL,
  `nopolisi` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `truk`
--

INSERT INTO `truk` (`id_truk`, `id_mitra`, `kode_truk`, `merk`, `daya_angkut`, `nopolisi`) VALUES
(1, 1, 'TRK-001', 'Isuzu Giga', '12000', 'DA 1234 XY'),
(2, 2, 'TRK-002', 'Isuzu Giga', '15000', 'DA 5678 XY');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mitra`
--
ALTER TABLE `mitra`
  ADD PRIMARY KEY (`id_mitra`);

--
-- Indeks untuk tabel `produksi`
--
ALTER TABLE `produksi`
  ADD PRIMARY KEY (`id_produksi`);

--
-- Indeks untuk tabel `stokpile`
--
ALTER TABLE `stokpile`
  ADD PRIMARY KEY (`id_stokpile`);

--
-- Indeks untuk tabel `truk`
--
ALTER TABLE `truk`
  ADD PRIMARY KEY (`id_truk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
