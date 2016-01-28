create table Slogan_Slogan (
	uuid_ VARCHAR(75) null,
	sloganId LONG not null primary key,
	sloganDate DATE null,
	sloganText VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	companyId LONG,
	groupId LONG,
	userId LONG
);

create table Slogan_slogan (
	sloganId LONG not null primary key,
	sloganDate DATE null,
	sloganText VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG
);