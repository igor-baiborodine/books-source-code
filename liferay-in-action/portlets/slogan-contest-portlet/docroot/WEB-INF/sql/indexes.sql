create index IX_2A4C57A3 on Slogan_Slogan (companyId);
create index IX_C13C6AE5 on Slogan_Slogan (groupId);
create index IX_44A7F4CB on Slogan_Slogan (groupId, status);
create index IX_504747C4 on Slogan_Slogan (sloganText);
create index IX_A202154B on Slogan_Slogan (status);
create index IX_5C972AF on Slogan_Slogan (uuid_);
create unique index IX_C17096DB on Slogan_Slogan (uuid_, groupId);

create index IX_DF988FC3 on Slogan_slogan (companyId);
create index IX_D6782B05 on Slogan_slogan (groupId);