SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE IF NOT EXISTS `schoolmate` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `schoolmate`;

DROP TABLE IF EXISTS `adminstaff`;
CREATE TABLE IF NOT EXISTS `adminstaff` (
`adminid` int(11) NOT NULL,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(20) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `assignments`;
CREATE TABLE IF NOT EXISTS `assignments` (
`assignmentid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `title` varchar(15) NOT NULL DEFAULT '',
  `totalpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `assigneddate` date NOT NULL DEFAULT '0000-00-00',
  `duedate` date NOT NULL DEFAULT '0000-00-00',
  `assignmentinformation` text
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

INSERT INTO `assignments` (`assignmentid`, `courseid`, `semesterid`, `termid`, `title`, `totalpoints`, `assigneddate`, `duedate`, `assignmentinformation`) VALUES
(2, 1, 1, 1, 'Compiti', 2.00, '2017-01-01', '2017-02-01', 'Noiosi; noiosissimi');

DROP TABLE IF EXISTS `courses`;
CREATE TABLE IF NOT EXISTS `courses` (
`courseid` int(11) NOT NULL,
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `coursename` varchar(20) NOT NULL DEFAULT '',
  `teacherid` int(11) NOT NULL DEFAULT '0',
  `sectionnum` varchar(15) NOT NULL DEFAULT '0',
  `roomnum` varchar(5) NOT NULL DEFAULT '',
  `periodnum` char(3) NOT NULL DEFAULT '',
  `q1points` double(6,2) NOT NULL DEFAULT '0.00',
  `q2points` double(6,2) NOT NULL DEFAULT '0.00',
  `totalpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `aperc` double(6,3) NOT NULL DEFAULT '0.000',
  `bperc` double(6,3) NOT NULL DEFAULT '0.000',
  `cperc` double(6,3) NOT NULL DEFAULT '0.000',
  `dperc` double(6,3) NOT NULL DEFAULT '0.000',
  `fperc` double(6,3) NOT NULL DEFAULT '0.000',
  `dotw` varchar(5) DEFAULT NULL,
  `substituteid` int(11) DEFAULT NULL,
  `secondcourseid` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `courses` (`courseid`, `semesterid`, `termid`, `coursename`, `teacherid`, `sectionnum`, `roomnum`, `periodnum`, `q1points`, `q2points`, `totalpoints`, `aperc`, `bperc`, `cperc`, `dperc`, `fperc`, `dotw`, `substituteid`, `secondcourseid`) VALUES
(1, 1, 1, 'Fortgeschrittene Mat', 1, '1', '1', '1', -30.00, 34.00, 4.00, 0.000, 0.000, 0.000, 0.000, 0.000, 'MH', 0, 0);

DROP TABLE IF EXISTS `grades`;
CREATE TABLE IF NOT EXISTS `grades` (
`gradeid` int(11) NOT NULL,
  `assignmentid` int(11) NOT NULL DEFAULT '0',
  `courseid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0',
  `points` double(6,2) DEFAULT '0.00',
  `comment` text,
  `submitdate` date DEFAULT '0000-00-00',
  `islate` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `parents`;
CREATE TABLE IF NOT EXISTS `parents` (
`parentid` int(11) NOT NULL,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) DEFAULT NULL,
  `lname` varchar(15) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `parents` (`parentid`, `userid`, `fname`, `lname`) VALUES
(1, 5, 'Ik ben', 'de vader');

DROP TABLE IF EXISTS `parent_student_match`;
CREATE TABLE IF NOT EXISTS `parent_student_match` (
`matchid` int(11) NOT NULL,
  `parentid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `parent_student_match` (`matchid`, `parentid`, `studentid`) VALUES
(1, 1, 1);

DROP TABLE IF EXISTS `registrations`;
CREATE TABLE IF NOT EXISTS `registrations` (
`regid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `q1currpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `q2currpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `currentpoints` double(6,2) NOT NULL DEFAULT '0.00'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `registrations` (`regid`, `courseid`, `studentid`, `semesterid`, `termid`, `q1currpoints`, `q2currpoints`, `currentpoints`) VALUES
(1, 1, 1, 1, 1, 0.00, 0.00, 0.00);

DROP TABLE IF EXISTS `schoolattendance`;
CREATE TABLE IF NOT EXISTS `schoolattendance` (
`sattendid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL DEFAULT '0',
  `sattenddate` date NOT NULL DEFAULT '0000-00-00',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `type` enum('tardy','absent') DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

INSERT INTO `schoolattendance` (`sattendid`, `studentid`, `sattenddate`, `semesterid`, `termid`, `type`) VALUES
(1, 1, '2017-01-01', 1, 1, 'absent'),
(2, 1, '2017-01-02', 1, 1, 'tardy'),
(3, 1, '0000-00-00', 1, 1, 'tardy'),
(4, 1, '0000-00-00', 1, 1, 'tardy');

DROP TABLE IF EXISTS `schoolbulletins`;
CREATE TABLE IF NOT EXISTS `schoolbulletins` (
`sbulletinid` int(11) NOT NULL,
  `title` varchar(15) NOT NULL DEFAULT '',
  `message` text NOT NULL,
  `bulletindate` date NOT NULL DEFAULT '0000-00-00'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `schoolbulletins` (`sbulletinid`, `title`, `message`, `bulletindate`) VALUES
(1, 'Attention', '!', '2017-08-22');

DROP TABLE IF EXISTS `schoolinfo`;
CREATE TABLE IF NOT EXISTS `schoolinfo` (
  `schoolname` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(50) DEFAULT NULL,
  `phonenumber` varchar(14) DEFAULT NULL,
  `sitetext` text,
  `sitemessage` text,
  `currenttermid` int(11) DEFAULT NULL,
  `numsemesters` int(3) NOT NULL DEFAULT '0',
  `numperiods` int(3) NOT NULL DEFAULT '0',
  `apoint` double(6,3) NOT NULL DEFAULT '0.000',
  `bpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `cpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `dpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `fpoint` double(6,3) NOT NULL DEFAULT '0.000'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `schoolinfo` (`schoolname`, `address`, `phonenumber`, `sitetext`, `sitemessage`, `currenttermid`, `numsemesters`, `numperiods`, `apoint`, `bpoint`, `cpoint`, `dpoint`, `fpoint`) VALUES
('School Name', '1,Street', '52365895', '', 'This is the Message of the day:-\r\n\r\n\r\nWe think our fathers fools, so wise do we grow,\r\nno doubt our wisest sons would think us\r\nso.', NULL, 2, 4, 0.000, 0.000, 0.000, 0.000, 0.000);

DROP TABLE IF EXISTS `semesters`;
CREATE TABLE IF NOT EXISTS `semesters` (
`semesterid` int(11) NOT NULL,
  `termid` varchar(15) NOT NULL DEFAULT '',
  `title` varchar(15) NOT NULL DEFAULT '',
  `startdate` date NOT NULL DEFAULT '0000-00-00',
  `midtermdate` date NOT NULL DEFAULT '0000-00-00',
  `enddate` date NOT NULL DEFAULT '0000-00-00',
  `type` enum('1','2') DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `semesters` (`semesterid`, `termid`, `title`, `startdate`, `midtermdate`, `enddate`, `type`) VALUES
(1, '1', 'First Semester', '2017-01-01', '2017-03-01', '2017-05-31', '1');

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
`studentid` int(11) NOT NULL,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) NOT NULL DEFAULT '',
  `mi` char(1) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT ''
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `students` (`studentid`, `userid`, `fname`, `mi`, `lname`) VALUES
(1, 4, 'Soy', 'S', 'El Estudiante');

DROP TABLE IF EXISTS `teachers`;
CREATE TABLE IF NOT EXISTS `teachers` (
`teacherid` int(11) NOT NULL,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT ''
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `teachers` (`teacherid`, `userid`, `fname`, `lname`) VALUES
(1, 3, 'Je Suis', 'Le Professeur');

DROP TABLE IF EXISTS `terms`;
CREATE TABLE IF NOT EXISTS `terms` (
`termid` int(11) NOT NULL,
  `title` varchar(15) NOT NULL DEFAULT '',
  `startdate` date NOT NULL DEFAULT '0000-00-00',
  `enddate` date NOT NULL DEFAULT '0000-00-00'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `terms` (`termid`, `title`, `startdate`, `enddate`) VALUES
(1, 'First Term', '2017-01-01', '2017-12-31');

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
`userid` int(11) NOT NULL,
  `username` varchar(15) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `type` enum('Admin','Teacher','Substitute','Student','Parent') NOT NULL DEFAULT 'Admin'
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

INSERT INTO `users` (`userid`, `username`, `password`, `type`) VALUES
(1, 'test', '098f6bcd4621d373cade4e832627b4f6', 'Admin'),
(2, 'schoolmate', '098f6bcd4621d373cade4e832627b4f6', 'Admin'),
(3, 'teacher', '098f6bcd4621d373cade4e832627b4f6', 'Teacher'),
(4, 'student', '098f6bcd4621d373cade4e832627b4f6', 'Student'),
(5, 'parent', '098f6bcd4621d373cade4e832627b4f6', 'Parent'),
(6, 'substitute', '098f6bcd4621d373cade4e832627b4f6', 'Substitute');


ALTER TABLE `adminstaff`
 ADD PRIMARY KEY (`adminid`), ADD UNIQUE KEY `UserID` (`userid`);

ALTER TABLE `assignments`
 ADD PRIMARY KEY (`assignmentid`);

ALTER TABLE `courses`
 ADD PRIMARY KEY (`courseid`);

ALTER TABLE `grades`
 ADD PRIMARY KEY (`gradeid`);

ALTER TABLE `parents`
 ADD PRIMARY KEY (`parentid`);

ALTER TABLE `parent_student_match`
 ADD PRIMARY KEY (`matchid`);

ALTER TABLE `registrations`
 ADD PRIMARY KEY (`regid`);

ALTER TABLE `schoolattendance`
 ADD PRIMARY KEY (`sattendid`);

ALTER TABLE `schoolbulletins`
 ADD PRIMARY KEY (`sbulletinid`);

ALTER TABLE `schoolinfo`
 ADD PRIMARY KEY (`schoolname`);

ALTER TABLE `semesters`
 ADD PRIMARY KEY (`semesterid`);

ALTER TABLE `students`
 ADD PRIMARY KEY (`studentid`), ADD UNIQUE KEY `UserID` (`userid`);

ALTER TABLE `teachers`
 ADD PRIMARY KEY (`teacherid`), ADD UNIQUE KEY `UserID` (`userid`);

ALTER TABLE `terms`
 ADD PRIMARY KEY (`termid`);

ALTER TABLE `users`
 ADD PRIMARY KEY (`userid`), ADD UNIQUE KEY `username` (`username`);


ALTER TABLE `adminstaff`
MODIFY `adminid` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `assignments`
MODIFY `assignmentid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
ALTER TABLE `courses`
MODIFY `courseid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `grades`
MODIFY `gradeid` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `parents`
MODIFY `parentid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `parent_student_match`
MODIFY `matchid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `registrations`
MODIFY `regid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `schoolattendance`
MODIFY `sattendid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
ALTER TABLE `schoolbulletins`
MODIFY `sbulletinid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `semesters`
MODIFY `semesterid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `students`
MODIFY `studentid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `teachers`
MODIFY `teacherid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `terms`
MODIFY `termid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
ALTER TABLE `users`
MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
