-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 04-Maio-2016 às 10:26
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
  `cpf` bigint(14) DEFAULT NULL,
  PRIMARY KEY (`ra`),
  UNIQUE KEY `rg` (`rg`,`cpf`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=100018 ;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`ra`, `rg`, `nome`, `cpf`) VALUES
(100000, '30568963-X', 'Chica', 30165498714763),
(100002, '30876123-11', 'Rodrigo Leopoldo Gragnoli', 12312321343),
(100005, '123213213', 'Abaporu', 123213123123),
(100012, '234123412', 'Rodrigo', 12341234141),
(100013, '324123213', 'Vania', 143123213123),
(100017, '546346534', 'Augusto Ferreira', 4634563653);

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
  `cod` int(4) NOT NULL AUTO_INCREMENT,
  `nome` varchar(90) NOT NULL,
  `area` varchar(30) NOT NULL,
  PRIMARY KEY (`cod`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `cursos`
--

INSERT INTO `cursos` (`cod`, `nome`, `area`) VALUES
(14, 'Matemática', 'Exatas'),
(20, 'Português', 'Humanas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `matriculas`
--

CREATE TABLE IF NOT EXISTS `matriculas` (
  `cod` int(5) NOT NULL AUTO_INCREMENT,
  `curso` int(4) NOT NULL,
  `turma` int(5) NOT NULL,
  `professor` int(4) NOT NULL,
  `aluno` int(6) NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `matriculas`
--

INSERT INTO `matriculas` (`cod`, `curso`, `turma`, `professor`, `aluno`) VALUES
(1, 14, 104, 1000, 100002),
(2, 20, 101, 1001, 100013);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE IF NOT EXISTS `professores` (
  `rp` int(4) NOT NULL AUTO_INCREMENT,
  `rg` varchar(12) NOT NULL,
  `cpf` bigint(14) NOT NULL,
  `nome` varchar(60) NOT NULL,
  PRIMARY KEY (`rp`),
  UNIQUE KEY `rg` (`rg`,`cpf`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1002 ;

--
-- Extraindo dados da tabela `professores`
--

INSERT INTO `professores` (`rp`, `rg`, `cpf`, `nome`) VALUES
(1000, '123231232', 12321312312, 'Carvalho'),
(1001, '21342143', 2314141243, 'Tavares');

-- --------------------------------------------------------

--
-- Estrutura da tabela `turmas`
--

CREATE TABLE IF NOT EXISTS `turmas` (
  `cod` int(5) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `periodo` varchar(80) NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=105 ;

--
-- Extraindo dados da tabela `turmas`
--

INSERT INTO `turmas` (`cod`, `nome`, `periodo`) VALUES
(100, 'A100/2016', 'Matutino'),
(101, 'A101/2016', 'Vespertino'),
(102, 'A102/2016', 'Matutino Vespertino'),
(104, 'A104/2016', 'Noturno');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `userid` int(4) NOT NULL AUTO_INCREMENT,
  `funcao` varchar(10) NOT NULL DEFAULT 'adm',
  `nome` varchar(80) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `entrada` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `id` (`userid`),
  UNIQUE KEY `login` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=40 ;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`userid`, `funcao`, `nome`, `email`, `senha`, `entrada`) VALUES
(24, 'adm', 'Rodrigo Leopoldo Gragnoli', 'rodrigo.gragnoli@gmail.com', '12345', '2016-04-28 05:58:23'),
(26, 'adm', 'Rodrigo Leopoldo Gragnoli', 'teste', '12345', '2016-04-28 06:02:50'),
(32, 'adm', 'Rodrigo Leopoldo Gragnoli', 'teste32', '', '2016-04-28 06:12:52'),
(36, 'adm', 'Rodrigo Leopoldo Gragnoli', 'sadsadas', '12321321', '2016-04-28 06:17:40'),
(39, 'adm', 'Abaporu', 'abap@aba.com', '1234', '2016-04-28 06:27:23');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
