-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27-Abr-2016 às 15:19
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `escola`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE IF NOT EXISTS `alunos` (
  `ra` int(6) NOT NULL AUTO_INCREMENT,
  `rg` varchar(12) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `cpf` int(12) NOT NULL,
  PRIMARY KEY (`ra`),
  UNIQUE KEY `rg` (`rg`,`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aulas`
--

CREATE TABLE IF NOT EXISTS `aulas` (
  `cod_aula` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(90) NOT NULL,
  `horario` time(6) NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`cod_aula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `cod_cursos` int(6) NOT NULL AUTO_INCREMENT,
  `nome` int(90) NOT NULL,
  `area` varchar(30) NOT NULL,
  PRIMARY KEY (`cod_cursos`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE IF NOT EXISTS `professores` (
  `rp` int(6) NOT NULL AUTO_INCREMENT,
  `rg` varchar(12) NOT NULL,
  `cpf` int(12) NOT NULL,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY (`rp`),
  UNIQUE KEY `rg` (`rg`,`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `turmas`
--

CREATE TABLE IF NOT EXISTS `turmas` (
  `cod_turma` int(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `periodo` varchar(10) NOT NULL,
  PRIMARY KEY (`cod_turma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(4) NOT NULL,
  `funcao` varchar(10) NOT NULL DEFAULT 'adm',
  `nome` varchar(80) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(150) DEFAULT NULL,
  `entrada` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `login` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
