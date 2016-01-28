create index IX_6EAAD412 on PR_PRProduct (companyId);
create index IX_DA9D3714 on PR_PRProduct (groupId);
create index IX_C7EFF736 on PR_PRProduct (groupId, productName);

create index IX_9BD618EC on PR_PRRegistration (groupId);
create index IX_98A73079 on PR_PRRegistration (groupId, datePurchased);
create index IX_397101C8 on PR_PRRegistration (groupId, prUserId);
create index IX_7F7BD0FD on PR_PRRegistration (groupId, serialNumber);

create index IX_98338272 on PR_PRUser (groupId, email);
create index IX_F0BBA40F on PR_PRUser (groupId, lastName);
create index IX_30F825D4 on PR_PRUser (groupId, userId);