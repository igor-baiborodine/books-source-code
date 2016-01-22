DROP TABLE IF EXISTS `book_tbl`;
CREATE TABLE `book_tbl` (
  `Book_Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `isbn_number` bigint(13) NOT NULL,
  `authors` varchar(250) NOT NULL,
  `created_date` datetime NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  `active` int(1) DEFAULT 1,
  PRIMARY KEY (`book_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

