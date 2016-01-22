DROP TABLE IF EXISTS `toc_tbl`;
CREATE TABLE `toc_tbl` (
  `toc_Id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `toc_file` mediumblob DEFAULT NULL,  
  `file_name` varchar(100) DEFAULT NULL,
  `extension` varchar(3) DEFAULT NULL,
  `active` int(1) DEFAULT 1,
  PRIMARY KEY (`toc_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

#
#  Foreign keys for toc_tbl
#

ALTER TABLE `toc_tbl`
ADD CONSTRAINT `toc_tbl_fk1` FOREIGN KEY (`book_id`) REFERENCES `book_tbl` (`book_id`);