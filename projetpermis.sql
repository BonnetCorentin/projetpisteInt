-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 16 juin 2021 à 00:11
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projetpermis`
--
CREATE DATABASE IF NOT EXISTS `projetpermis` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `projetpermis`;

-- --------------------------------------------------------

--
-- Structure de la table `action`
--

CREATE TABLE `action` (
  `id` int(11) NOT NULL,
  `fk_action` int(11) DEFAULT NULL,
  `wording` char(25) DEFAULT NULL,
  `scoreMinimum` int(11) DEFAULT NULL,
  `score_minimum` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `action`
--

INSERT INTO `action` (`id`, `fk_action`, `wording`, `scoreMinimum`, `score_minimum`) VALUES
(1, NULL, 'Se mettre en tenue', 1, 1),
(2, 1, 'Préparation véhicule', 5, 5),
(3, 2, 'Effectuer manoeuvre', 8, 9),
(4, NULL, 'Analyser panne(s)', 2, 2),
(5, 4, 'Resoudre panne(s)', 5, 5),
(21, NULL, 'Test action', NULL, 5);

-- --------------------------------------------------------

--
-- Structure de la table `action__mission`
--

CREATE TABLE `action__mission` (
  `fk_action` int(11) NOT NULL,
  `fk_mission` int(11) NOT NULL,
  `id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `action__mission`
--

INSERT INTO `action__mission` (`fk_action`, `fk_mission`, `id`) VALUES
(2, 1, NULL),
(3, 1, NULL),
(3, 2, NULL),
(4, 1, NULL),
(4, 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(20),
(20),
(20),
(20),
(20),
(20);

-- --------------------------------------------------------

--
-- Structure de la table `indicator`
--

CREATE TABLE `indicator` (
  `id` int(11) NOT NULL,
  `fk_action` int(11) NOT NULL,
  `wording` char(50) DEFAULT NULL,
  `valueIfCheck` int(11) DEFAULT NULL,
  `valueIfUnCheck` int(11) DEFAULT NULL,
  `value_if_check` int(11) DEFAULT NULL,
  `value_if_un_check` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `indicator`
--

INSERT INTO `indicator` (`id`, `fk_action`, `wording`, `valueIfCheck`, `valueIfUnCheck`, `value_if_check`, `value_if_un_check`) VALUES
(1, 1, 'Prendre ses outils', 1, -1, NULL, NULL),
(2, 1, 'Prendre des explosifs', -1, 1, NULL, NULL),
(3, 3, 'Conduire à 110 km/h', -2, 2, NULL, NULL),
(4, 3, 'Conduire les yeux ouverts', 3, -6, NULL, NULL),
(5, 3, 'Avoir les deux mains sur le volant', 1, 0, NULL, NULL),
(6, 4, 'S informer auprès des techniciens', 1, 0, NULL, NULL),
(7, 4, 'Consulter le manuel', 0, 0, NULL, NULL),
(8, 4, 'Respecter la procèdure', 2, -2, NULL, NULL),
(9, 4, 'Demander de l aide à la tour de contrôle', -1, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `id` int(11) NOT NULL,
  `fk_learner` int(11) NOT NULL,
  `fk_mission` int(11) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `fk_learner`, `fk_mission`, `date`) VALUES
(1, 1, 1, NULL),
(2, 17, 1, NULL),
(4, 18, 1, '2021-06-15'),
(5, 18, 2, '2021-06-15'),
(6, 18, 1, '2021-06-15'),
(7, 17, 1, '2021-06-15'),
(14, 17, 1, '2021-06-15'),
(15, 18, 10, '2021-06-15'),
(19, 17, 2, '2021-06-15');

-- --------------------------------------------------------

--
-- Structure de la table `inscription__action`
--

CREATE TABLE `inscription__action` (
  `id` int(11) NOT NULL,
  `fk_inscription` int(11) NOT NULL,
  `fk_action` int(11) NOT NULL,
  `sort` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscription__action`
--

INSERT INTO `inscription__action` (`id`, `fk_inscription`, `fk_action`, `sort`, `score`) VALUES
(1, 1, 4, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `jeu`
--

CREATE TABLE `jeu` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `fk_learner` int(11) DEFAULT NULL,
  `fk_mission` int(11) DEFAULT NULL,
  `score_total` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `jeu`
--

INSERT INTO `jeu` (`id`, `date`, `fk_learner`, `fk_mission`, `score_total`) VALUES
(2, '2021-06-15', 1, 1, 35),
(3, '2021-06-15', 1, 1, 20),
(8, '2021-06-15', 17, 1, 41),
(9, '2021-06-15', 17, 1, 32),
(10, '2021-06-15', 17, 1, 35),
(11, '2021-06-15', 17, 1, 21),
(12, '2021-06-15', 17, 1, 25),
(13, '2021-06-15', 17, 1, 21),
(16, '2021-06-15', 18, 10, 0),
(17, '2021-06-15', 18, 10, 0),
(18, '2021-06-15', 18, 1, 43);

-- --------------------------------------------------------

--
-- Structure de la table `learner`
--

CREATE TABLE `learner` (
  `id` int(11) NOT NULL,
  `surname` char(25) DEFAULT NULL,
  `forname` char(25) DEFAULT NULL,
  `salt` char(200) DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  `mdp` char(200) DEFAULT NULL,
  `role` char(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `learner`
--

INSERT INTO `learner` (`id`, `surname`, `forname`, `salt`, `email`, `mdp`, `role`) VALUES
(1, 'Doe D', 'John', '144be33f', 'john.doe@email.com', '954A7E69F5FE03835BBCB1596FBF3EB386747F4EBF8E218DB3D1DE4DD0466B30', 'admin'),
(2, 'Vincent', 'Desquenne', '144be33f', 'vincent@vincent.fr', '954A7E69F5FE03835BBCB1596FBF3EB386747F4EBF8E218DB3D1DE4DD0466B30', 'apprenant'),
(17, 'Bonnet', 'Corentin', 'EAb/0HTnMbhV33zoX+AEwqjwcr7H7Sl0+k/SztIglIs=', 'coco@coco.fr', 'TmocrzUM5y6tsCIQO6V1GQ==', 'admin'),
(18, 'Alle', 'Yann', 'pnsxc35SuxYiyx5Uxpj2XbganquTH3niQYGX5tBEhnM=', 'yann@yann.fr', '4SOhCpBcTh4QQ65MLbrexQ==', 'apprenant'),
(19, 'admin', 'admin', 'PwZ4VqZPusnBUGElzK/MJe0rVA7ZKxZgyPk2McuqVOE=', 'admin@admin.fr', 'HOP0PlR+qW1yXZ8L79qAhg==', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE `mission` (
  `id` int(11) NOT NULL,
  `wording` char(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `mission`
--

INSERT INTO `mission` (`id`, `wording`) VALUES
(1, 'Mission T'),
(2, 'Mission B'),
(10, 'Mission C'),
(11, 'Mission 5');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `action`
--
ALTER TABLE `action`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Act_KEY_FK_ACTION_PREDECESSOR` (`fk_action`);

--
-- Index pour la table `action__mission`
--
ALTER TABLE `action__mission`
  ADD PRIMARY KEY (`fk_action`,`fk_mission`),
  ADD KEY `MisGoa_KEY_FK_MISSION` (`fk_mission`),
  ADD KEY `ActGoa_KEY_FK_ACTION` (`fk_action`);

--
-- Index pour la table `indicator`
--
ALTER TABLE `indicator`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Ind_KEY_FK_ACTION` (`fk_action`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Ins_KEY_FK_LEARNER` (`fk_learner`),
  ADD KEY `Ins_KEY_FK_GAME` (`fk_mission`);

--
-- Index pour la table `inscription__action`
--
ALTER TABLE `inscription__action`
  ADD PRIMARY KEY (`id`),
  ADD KEY `LeaAct_KEY_FK_INSCRIPTION` (`fk_inscription`),
  ADD KEY `LeaAct_KEY_FK_ACTION` (`fk_action`);

--
-- Index pour la table `jeu`
--
ALTER TABLE `jeu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqqnmsisec3ii7pf1huxb283ye` (`fk_mission`);

--
-- Index pour la table `learner`
--
ALTER TABLE `learner`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `action`
--
ALTER TABLE `action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT pour la table `indicator`
--
ALTER TABLE `indicator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `inscription__action`
--
ALTER TABLE `inscription__action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `learner`
--
ALTER TABLE `learner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `mission`
--
ALTER TABLE `mission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `action`
--
ALTER TABLE `action`
  ADD CONSTRAINT `Act_FK_ACTION` FOREIGN KEY (`fk_action`) REFERENCES `action` (`id`);

--
-- Contraintes pour la table `action__mission`
--
ALTER TABLE `action__mission`
  ADD CONSTRAINT `ActGoa_FK_ACTION` FOREIGN KEY (`fk_action`) REFERENCES `action` (`id`),
  ADD CONSTRAINT `ActGoa_FK_MISSION` FOREIGN KEY (`fk_mission`) REFERENCES `mission` (`id`);

--
-- Contraintes pour la table `indicator`
--
ALTER TABLE `indicator`
  ADD CONSTRAINT `Ind_FK_ACTION` FOREIGN KEY (`fk_action`) REFERENCES `action` (`id`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `Ins_FK_LEARNER` FOREIGN KEY (`fk_learner`) REFERENCES `learner` (`id`),
  ADD CONSTRAINT `Ins_FK_MISSION` FOREIGN KEY (`fk_mission`) REFERENCES `mission` (`id`);

--
-- Contraintes pour la table `inscription__action`
--
ALTER TABLE `inscription__action`
  ADD CONSTRAINT `LeaAct_FK_ACTION` FOREIGN KEY (`fk_action`) REFERENCES `action` (`id`),
  ADD CONSTRAINT `LeaAct_FK_INSCRIPTION` FOREIGN KEY (`fk_inscription`) REFERENCES `inscription` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
