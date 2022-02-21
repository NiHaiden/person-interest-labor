insert into person(firstname, lastName, dateOfBirth, sex) VALUES ('Niklas', 'Haiden', '2002-04-09', 'MALE');
insert into person(firstName, lastName, dateOfBirth, sex) VALUES ('Simon', 'Wolffhardt', '2002-01-01', 'MALE');
insert into person(firstName, lastName, dateOfBirth, sex) VALUES ('Stefanie', 'Mueller', '2002-01-02', 'FEMALE');

insert into interest(description) VALUES ('Reading');
insert into interest(description) VALUES ('Trains');
insert into interest(description) VALUES ('Computers');
insert into interest(description) VALUES ('Gaming');
insert into interest(description) VALUES ('Programming');
insert into interest(description) VALUES ('Crypto');

insert into interest_person(person_id, interest_id) VALUES (1,1);
insert into interest_person(person_id, interest_id) VALUES (1,2);
insert into interest_person(person_id, interest_id) VALUES (1,3);
insert into interest_person(person_id, interest_id) VALUES (2,3);
