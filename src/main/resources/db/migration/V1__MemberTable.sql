create table member (
    id serial primary key,
    name varchar(255) not null,
    personalID varchar(255) not null,
    sex varchar(255),
    registerDate date not null default current_date,
    membershipID varchar(255),
    major varchar(255),
    photo varchar(255),
    phoneNumber varchar(255),
    region varchar(255),
    registerAddress varchar(255),
    mainAddress varchar(255),
    email varchar(255),
    workContractID varchar(255),
    declaration boolean,
    penaltyID varchar(255)
);