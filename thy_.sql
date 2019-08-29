-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 29 Ağu 2019, 18:35:11
-- Sunucu sürümü: 10.4.6-MariaDB
-- PHP Sürümü: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `thy_`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin`
--

CREATE TABLE `admin` (
  `aid` int(11) NOT NULL,
  `aname` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `amail` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `apass` varchar(32) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `admin`
--

INSERT INTO `admin` (`aid`, `aname`, `amail`, `apass`) VALUES
(1, 'Aziz', 'admin@mail.com', '827ccb0eea8a706c4c34a16891f84e7b'),
(3, 'Ali', 'mehmet@mail.com', '827ccb0eea8a706c4c34a16891f84e7b');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `ptitle` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `pdesc` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `pphoto` varchar(500) COLLATE utf8_turkish_ci NOT NULL,
  `pprice` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `product`
--

INSERT INTO `product` (`pid`, `ptitle`, `pdesc`, `pphoto`, `pprice`) VALUES
(1, 'Buzdalabi', 'desc', 'https://cdn.akakce.com/bosch/bosch-kgn86ai42n-a-kombi-no-frost-buzdolabi-z.jpg', '12.90'),
(2, 'Televizyon', 'Tel Desc', 'https://img-teknosa-sap.mncdn.com/category/kategori_televizyon_televizyolar.jpg', '9.00'),
(3, 'Audi A5 - Full - Sporback', 'Jet gibi araba', 'https://auto.ndtvimg.com/car-images/big/audi/a5/audi-a5.jpg?v=11', '250.00'),
(6, 'Buzdalabı', 'desc', 'https://img-teknosa-sap.mncdn.com/category/kategori_televizyon_televizyolar.jpg', '1200.00'),
(8, 'iPhone X Max', 'Max Ücret', 'https://cdn.akakce.com/bosch/bosch-kgn86ai42n-a-kombi-no-frost-buzdolabi-z.jpg', '11000.00');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`aid`);

--
-- Tablo için indeksler `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admin`
--
ALTER TABLE `admin`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
