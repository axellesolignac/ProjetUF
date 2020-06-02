-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 30 mai 2020 à 13:32
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetuf`
--

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

DROP TABLE IF EXISTS `affectation`;
CREATE TABLE IF NOT EXISTS `affectation` (
  `id_agent` int(11) DEFAULT NULL,
  `lastname_agent` varchar(50) DEFAULT NULL,
  `firstname_agent` varchar(50) DEFAULT NULL,
  `agence` varchar(50) DEFAULT NULL,
  `id_bien` int(11) DEFAULT NULL,
  `lastname_client` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `affectation`
--

INSERT INTO `affectation` (`id_agent`, `lastname_agent`, `firstname_agent`, `agence`, `id_bien`, `lastname_client`) VALUES
(3, 'Coulombe', 'Sven', 'AGAIX01', 1, 'Mousseux'),
(8, 'Novich', 'Gilberte', 'AGAIX01', 5, 'Vongola'),
(6, 'Benjamin', 'Anna', 'AGPA01', 3, 'Philipps'),
(10, 'Malo', 'Michel', 'AGPA01', 8, 'Roche'),
(4, 'Lieutaud', 'Celine', 'AGLY01', 7, 'Apid'),
(9, 'Auche', 'Marion', 'AGLY01', 2, 'Jo'),
(12, 'Fabre', 'Brice', 'AGBO01', 4, 'Bolduc'),
(11, 'Callier', 'Marco', 'AGBO01', 6, 'Jumel');

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

DROP TABLE IF EXISTS `agence`;
CREATE TABLE IF NOT EXISTS `agence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `nbAgent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`id`, `number`, `city`, `nbAgent`) VALUES
(1, 'AGAIX01', 'Aix', 3),
(2, 'AGPA01', 'Paris', 3),
(3, 'AGLY01', 'Lyon', 3),
(4, 'AGBO01', 'Bordeaux', 3);

-- --------------------------------------------------------

--
-- Structure de la table `bien`
--

DROP TABLE IF EXISTS `biens`;
CREATE TABLE IF NOT EXISTS `biens` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `prix` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `superficie` int(11) DEFAULT NULL,
  `surfaceTerrain` int(11) DEFAULT NULL,
  `dependance` int(11) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `nbPiece` int(11) DEFAULT NULL,
  `nbEtage` int(11) DEFAULT NULL,
  `nbChambre` int(11) DEFAULT NULL,
  `owner` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `bien`
--

INSERT INTO `biens` (`id`, `categorie`, `title`, `prix`, `address`, `city`, `description`, `superficie`, `surfaceTerrain`, `dependance`, `photo`, `nbPiece`, `nbEtage`, `nbChambre`, `owner`, `status`) VALUES
(1, 'maison', 'Maison rose', 250000, 'rue du compas', 'Aix', 'très jolie maison plein pied avec vue sur la route', 90, 120, 0, 'maison.png', 5, 0, 2, 'Mousseux', 'Vendu'),
(2, 'appartement', 't3', 250000, '35 rue de la terrasse', 'Lyon', 'très joli appartement, belle vue sur parc', 57, 57, 1, NULL, 3, 2, 1, 'Jo', 'Vendu'),
(3, 'maison', 'espacia', 350000, '45 au bout de la rue', 'Paris', 'maison a plusieurs étages avec vue sur La Seine', 100, 120, 0, NULL, 6, 2, 3, 'Philipps', 'En vente'),
(4, 'appartement', 't2', 30000, '90 cours jean jaures', 'Bordeaux', 'petit appartement idéal pour des étudiants', 45, 45, 0, NULL, 2, 3, 1, 'Bolduc', 'En vente'),
(5, 'appartement', 't3', 45000, '5 rue le corbusier', 'Aix', 'appartement proche de magasin', 67, 70, 1, NULL, 3, 2, 2, 'Vongola', 'En vente'),
(6, 'maison', 'neuve', 350000, '32 rue des mocassins', 'Bordeaux', 'maison avec vaste jardin', 110, 200, 2, NULL, 6, 1, 3, 'Jumel', 'Vendu'),
(7, 'maison', 'serenity', 340000, '23 rue du bonheur', 'Lyon', 'maison familiale a la sortie de la ville', 95, 130, 1, NULL, 5, 0, 4, 'Apid', 'En vente'),
(8, 'appartement', 't4', 150000, '15 saint Honore', 'Paris', 'très bel appartement avec une vue sur la tour Eiffel', 75, 75, 0, NULL, 4, 2, 3, 'Roche', 'Vendu');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) NOT NULL DEFAULT 'fr',
  `id_agent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `username`, `password`, `lastname`, `firstname`, `gender`, `birthdate`, `phone`, `email`, `address`, `city`, `nationality`, `id_agent`) VALUES
(1, 'mousseuxpj', 'azerty', 'Mousseux', 'Pierre-jean', 'homme', '1957-12-02', 352415195, 'pj.mousse@gmail.com', '2 rue de la paix', 'Aix', 'fr', 3),
(2, 'marionj', 'azerty', 'Jo', 'marion', 'femme', '1968-01-01', 152625484, 'marionj@gmail.com', '35 rue de la terrasse', 'Lyon', 'fr', 9),
(3, 'philippsV', 'azerty', 'Philipps', 'Valentin', 'homme', '1987-03-26', 321546294, 'philipps.valentin@gmail.com', '45 au bout de la rue', 'Paris', 'fr', 6),
(4, 'rocher', 'azerty', 'Roche', 'Rosethorn', 'femme', '1980-06-14', 641519784, 'rosethorn.roche@gmail.com', '15 saint Honore', 'Paris', 'fr', 10),
(5, 'apidLo', 'azerty', 'Apid', 'Lorie', 'femme', '1985-12-23', 485623515, 'lorie.apid@gmail.com', '23 rue du bonheur', 'Lyon', 'fr', 4),
(6, 'vongolaX', 'azerty', 'Vongola', 'Xanxus', 'homme', '1968-11-23', 584953216, 'xanxus.vongola@gmail.com', '24 saint varia', 'Aix', 'fr', 8),
(7, 'bolducV', 'azerty', 'Bolduc', 'Voleta', 'femme', '1981-06-04', 495843262, 'voleta.bolduc@gmail.com', '90 cours jean jaures', 'Bordeaux', 'fr', 12),
(8, 'jumelE', 'azerty', 'Jumel', 'Eric', 'homme', '1984-02-12', 345548462, 'eric.jumel@gmail.com', '32 rue des mocassins', 'Bordeaux', 'fr', 11);

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

DROP TABLE IF EXISTS `document`;
CREATE TABLE IF NOT EXISTS `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `contenu` varchar(250) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `document`
--

INSERT INTO `document` (`id`, `title`, `type`, `contenu`, `id_client`) VALUES
(1, 'riba', 'rib', 'ohlalala un rib', 1);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `id_agent` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `gender` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `agence` varchar(10) DEFAULT NULL,
  `nbVendeur` int(11) DEFAULT NULL,
  `nbBienVente` int(11) DEFAULT NULL,
  `nbBienVendu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_agent`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id_agent`, `password`, `lastname`, `firstname`, `status`, `gender`, `email`, `agence`, `nbVendeur`, `nbBienVente`, `nbBienVendu`) VALUES
(5, 'Stephijuri13!', 'Mousse', 'Jean-philippe', 1, 'homme', 'jp.mousse@stephi.com', 'AGPA01', 0, 0, 0),
(3, 'Stephicompta13!', 'Coulombe', 'Sven', 0, 'homme', 'sven.coulombre@stephi.com', 'AGAIX01', 1, 0, 1),
(2, 'Stephicommerce13!', 'Belair', 'Christophe', 1, 'homme', 'christophe.belair@stephi.com', 'AGLY01', 0, 0, 0),
(4, 'Stephirh13!', 'Lieutaud', 'Celine', 0, 'femme', 'celine.lieutaud@stephi.com', 'AGLY01', 1, 1, 0),
(1, 'Stephidir13!', 'Neige', 'Elsa', 1, 'femme', 'elsa.neige@stephi.com', 'AGAIX01', 0, 0, 0),
(6, 'Stephicom13!', 'Benjamin', 'Anna', 0, 'femme', 'anna.benjamin@stephi.com', 'AGPA01', 1, 1, 0),
(7, 'Stephiagence13!', 'Solignac', 'Karine', 1, 'femme', 'karine.solignac@stephi.com', 'AGBO01', 0, 0, 0),
(8, 'Stephiagent', 'Novich', 'Gilberte', 0, 'femme', 'gilberte.novich@stephi.com', 'AGAIX01', 1, 1, 0),
(9, 'Stephiagent', 'Auche', 'Marion', 0, 'femme', 'marion.auche@stephi.com', 'AGLY01', 1, 0, 1),
(10, 'Stephiagent', 'Malo', 'Michel', 0, 'homme', 'michel.malo@stephi.com', 'AGPA01', 1, 0, 1),
(11, 'Stephiagent', 'Callier', 'Marco', 0, 'homme', 'marco.callier@stephi.com', 'AGBO01', 1, 0, 1),
(12, 'Stephiagent', 'Fabre', 'Brice', 0, 'homme', 'brice.fabre@stephi.com', 'AGBO01', 1, 1, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
