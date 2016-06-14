-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 14 Juin 2016 à 09:24
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpublankproject`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `helloworldById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `helloworldById` (IN `p_id` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM helloworld WHERE id = p_id$$

DROP PROCEDURE IF EXISTS `HelloworldByKey`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `HelloworldByKey` (IN `p_key` VARCHAR(2))  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM jpublankproject.helloworld where `key`=p_key$$

DROP PROCEDURE IF EXISTS `loadmapById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapById` (IN `p_id` INT)  NO SQL
SELECT * FROM map WHERE map_id = p_id$$

DROP PROCEDURE IF EXISTS `loadmapByKey`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapByKey` (IN `p_key` VARCHAR(50))  NO SQL
SELECT * FROM jpublankproject.map where `map_name`=p_key$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `helloworld`
--

DROP TABLE IF EXISTS `helloworld`;
CREATE TABLE IF NOT EXISTS `helloworld` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(2) NOT NULL,
  `message` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_UNIQUE` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `helloworld`
--

INSERT INTO `helloworld` (`id`, `key`, `message`) VALUES
(1, 'GB', 'Hello world'),
(2, 'FR', 'Bonjour le monde'),
(3, 'DE', 'Hallo Welt'),
(4, 'ID', 'Salamat pagi dunia');

-- --------------------------------------------------------

--
-- Structure de la table `highscore`
--

DROP TABLE IF EXISTS `highscore`;
CREATE TABLE IF NOT EXISTS `highscore` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_name` varchar(50) NOT NULL,
  `map` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `map`
--

INSERT INTO `map` (`id`, `map_name`, `map`) VALUES
(1, 'MAP1', 'BHHHHHHHHHHHHHHHHHHB\nV    V             V\nV    V             V\nV    V     P       V\nV  P BHHHHHB       V\nV P P1     K  L   CV\nV  P BHHHHHB       V\nV    V     P       V\nV    V             V\nV    V             V\nV    V             V\nBHHHHHHHHHHHHHHHHHHB'),
(2, 'MAP2', 'BHHHHHHHHHHHHHHHHHHB\nV        P         V\nV                1 V\nV      C           V\nV        Q2        V\nBHCHH          HHCHB\nV L                V\nV   BHHHHHHHHHHB   V\nV                  V\nV HHH  B    D  C 4 V\nV              3   V\nBHHHCHHHHHHHHHHCHHHB'),
(3, 'MAP3', '   BHH    P   HHB\n   VHH        HHV\n   V 1BB    BB  V\n   V  B       B V\n   V          K V\n   VV          VV\n  VC L        B VV\n VV              VV\nVBHHHH4      2HHHHBV\nV   CHH      CHB  3V\nVBB              BBV\n BHHHHHHHHHHHHHHHHB  '),
(4, 'MAP4', 'BHHHHHHHHHHHHHHHHHHB\nV        L         V\nV C              C V\nV             P    V\nV       4K         V\nBH HH    3     HH HB\nV   B          B   V\nV    HHHH  HHHH    V\nV   V          V   V\nV   C  B       C   V\nV   1          2   V\nBHHHCHHHHHHHHHHCHHHB'),
(5, 'MAP5', '   BHB   BHB    BHB\nBHHH HHKHH HHHHHH  B\nV                  V\nV HHHH 1CHHPHHH  H V\nV V   V V   V    C V\nV V   V V   V      V\nV V   V V   V3C    V\nBB      2   BB4 BB V\nVB CV V   V V   V  V\nV   V V   V V K V LV\nV  BV V   V V   V  V\nBHHHHHCHHHHHHHHHHHHB'),
(6, 'MAP6', 'BHHHHHHHHHHHHHHHHHHB\nVHH           1   PV\nVHHHHHHHHHHH   C   V\nV V   B     C B    V\nV V   B     C B    V\nV V    2           V\nV BHHHHHHHHHH H H  V\nV V   4 C   BBBB   V\nV V 3         B    V\nVC HHHH KHHHC      V\nV                 LV\nBHHHHHHHHHHHHHHHHHHB'),
(7, 'MAP7', 'BHHHHHHHHHHHHHHHHHHB\nVB               P V\nBBHHHHH       HHHHBB\nV 4   V       V BHBV\nV     V   L   V    V\nV                  V\nBHB    V 1C C2   BHB\nV  BHB V       V BHB\nV  3      V   BHB BV\nV         V        V\nV         V       KV\nBHHHHHHHHHOHHHHHHHHB'),
(8, 'MAP8', 'VHHHHHHHHHHHHHHHHHHV\nV        L         V\nV C              C V\nV             P    V\nV       4K         V\nHH HH    3     HH HH\nV   B          B   V\nV    HHHH  HHHH    V\nV   I          I   V\nV   C  B       C   V\nV   1          2   V\nVHHHOHHHHHHHHHHOHHHV'),
(9, 'MAP9', '    BHB   BHB    BHB\n HHHH HHKHH HHHHHHHV\n V                 V\n V HHHH 1CHHPHHH H V\n V V   V V   V   C V\n V V   V V   V     V\n V V   V V   V3C   V\nBB      2   BB4 BB V\nVB CV V   V V   V  V\nV   V V   V V K V LV\nV  BV V   V V   V  V\nVHHHHHCHHHHHHHHHHHHV'),
(10, 'TEST', 'BVHPL\n1234 \nCO   ');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
