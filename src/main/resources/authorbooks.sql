-- --------------------------------------------------------
-- Host:                         192.168.1.21
-- Server versie:                5.5.43-MariaDB - Source distribution
-- Server OS:                    Linux
-- HeidiSQL Versie:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Databasestructuur van example_app wordt geschreven
DROP DATABASE IF EXISTS `author_books`;
CREATE DATABASE IF NOT EXISTS `author_books` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `author_books`;


-- Structuur van  tabel example_app.authors wordt geschreven
DROP TABLE IF EXISTS `authors`;
CREATE TABLE IF NOT EXISTS `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumpen data van tabel example_app.authors: ~0 rows (ongeveer)
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
REPLACE INTO `authors` (`id`, `first_name`, `last_name`, `date_of_birth`) VALUES
	(1, 'Dan', 'Brown', '1964-06-22'),
	(2, 'Isaac', 'Asimov', '1919-10-04'),
	(3, 'Douglas', 'Adams', '1952-03-11');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;


-- Structuur van  tabel example_app.books wordt geschreven
DROP TABLE IF EXISTS `books`;
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(250) NOT NULL,
  `author_id` int(11) NOT NULL,
  `genre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bok_atr` (`author_id`),
  CONSTRAINT `fk_bok_atr` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumpen data van tabel example_app.books: ~0 rows (ongeveer)
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
REPLACE INTO `books` (`id`, `title`, `author_id`, `genre`) VALUES
	(1, 'The Hitchhiker\'s Guide to the Galaxy', 3, 'Science Fiction'),
	(2, 'I, Robot', 2, 'Science Fiction'),
	(3, 'The Caves of Steel', 2, 'Science Fiction'),
	(4, 'The Robots of Dawn', 2, 'Science Fiction'),
	(5, 'Angels & Demons', 1, 'Mystery-Thriller'),
	(6, 'The Da Vinci Code', 1, 'Mystery-Thriller'),
	(7, 'The Lost Symbol', 1, 'Mystery-Thriller'),
	(8, 'Inferno', 1, 'Mystery-Thriller');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
