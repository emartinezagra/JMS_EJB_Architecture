DROP DATABASE aju;

CREATE DATABASE aju;

USE aju;

CREATE TABLE LOCATION
(
	ID int NOT NULL,
	NAME  varchar(50) NOT NULL,	
	COORDENATEX int NOT NULL,
	COORDENATEY int NOT NULL,
	LOCATION_ID int NULL,	
	FOREIGN KEY (LOCATION_ID) REFERENCES LOCATION(ID),
	PRIMARY KEY(ID)
);

CREATE TABLE COMPANY
(
	ID int NOT NULL,
	NAME  varchar(50) NOT NULL,	
	LOCATION_ID int NOT NULL,
	FOREIGN KEY (LOCATION_ID) REFERENCES LOCATION(ID),
	PRIMARY KEY(ID)
);

CREATE TABLE USER
(
	ID int NOT NULL,
	NAME  varchar(50) NOT NULL,	
	EMAIL varchar(50) NOT NULL,	
	PHONE varchar(50) NULL,	
	COMPANY_ID INT NOT NULL,
	FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(ID),
	PRIMARY KEY(ID)
);

CREATE TABLE STATUS
(
	ID int NOT NULL,
	STATUS varchar(50) NOT NULL,	
	PRIMARY KEY(ID)
);

CREATE TABLE EQUIPMENT
(
	ID int NOT NULL,
	LOCATION_ID int NOT NULL,
	STATUS_ID int NOT NULL,
	FOREIGN KEY (STATUS_ID) REFERENCES STATUS(ID),
	FOREIGN KEY (LOCATION_ID) REFERENCES LOCATION(ID),
	PRIMARY KEY(ID)
);

CREATE TABLE ACTIVITY
(
	ID int NOT NULL,
	USER_ID int NOT NULL,
	EQUIPMENT_ID int NOT NULL,
	AC_DATE DATETIME NOT NULL,
	ENTERING boolean NOT NULL,
	FOREIGN KEY (USER_ID) REFERENCES USER(ID),
	FOREIGN KEY (EQUIPMENT_ID) REFERENCES EQUIPMENT(ID),
	PRIMARY KEY(ID)
);

INSERT INTO LOCATION VALUES (0, "Finance Trading Complex", 12, 45, 0);
INSERT INTO LOCATION VALUES (1, "Main Building", 12, 45, 0);
INSERT INTO LOCATION VALUES (2, "Building Enterprise", 12, 45, 0);
INSERT INTO LOCATION VALUES (3, "Building Shuttle", 12, 45, 0);
INSERT INTO LOCATION VALUES (4, "Main Door North", 12, 45, 1);
INSERT INTO LOCATION VALUES (5, "Door South", 12, 45, 1);
INSERT INTO LOCATION VALUES (6, "Door East", 12, 45, 1);
INSERT INTO LOCATION VALUES (7, "Door West", 12, 45, 1);
INSERT INTO LOCATION VALUES (8, "Main Door North", 12, 45, 2);
INSERT INTO LOCATION VALUES (9, "Door South", 12, 45, 2);
INSERT INTO LOCATION VALUES (10, "Door East", 12, 45, 2);
INSERT INTO LOCATION VALUES (11, "Door West", 12, 45, 2);
INSERT INTO LOCATION VALUES (12, "Main Door North", 12, 45, 3);
INSERT INTO LOCATION VALUES (13, "Door South", 12, 45, 3);
INSERT INTO LOCATION VALUES (14, "Door East", 12, 45, 3);
INSERT INTO LOCATION VALUES (15, "Door West", 12, 45, 3);

INSERT INTO STATUS VALUES(0,"Working");
INSERT INTO STATUS VALUES(1,"Stand by");
INSERT INTO STATUS VALUES(2,"Error");

INSERT INTO EQUIPMENT VALUES(0,4,0);
INSERT INTO EQUIPMENT VALUES(1,4,0);
INSERT INTO EQUIPMENT VALUES(2,5,0);
INSERT INTO EQUIPMENT VALUES(3,6,0);
INSERT INTO EQUIPMENT VALUES(4,7,0);
INSERT INTO EQUIPMENT VALUES(5,8,0);
INSERT INTO EQUIPMENT VALUES(6,8,0);
INSERT INTO EQUIPMENT VALUES(7,9,0);
INSERT INTO EQUIPMENT VALUES(8,10,0);
INSERT INTO EQUIPMENT VALUES(9,11,0);
INSERT INTO EQUIPMENT VALUES(10,12,0);
INSERT INTO EQUIPMENT VALUES(11,12,0);
INSERT INTO EQUIPMENT VALUES(12,13,0);
INSERT INTO EQUIPMENT VALUES(13,14,0);
INSERT INTO EQUIPMENT VALUES(14,15,0);

INSERT INTO COMPANY VALUES (0,"Bank of Scotland", 1);
INSERT INTO COMPANY VALUES (1,"Dove Medical Press", 2);
INSERT INTO COMPANY VALUES (2,"BMJ Journals",3);

INSERT INTO USER VALUES (0,"Lou Crowner","loucrowner@bankofscotland.com","91 - 626 - 351 - 672",0);
INSERT INTO USER VALUES (1,"Miguel Wison","miguelwison@bankofscotland.com","91 - 038 - 371 - 683",0);
INSERT INTO USER VALUES (2,"Sherell Holford","sherellholford@bankofscotland.com","91 - 410 - 656 - 018",0);
INSERT INTO USER VALUES (3,"Nathanael Overmyer","nathanaelovermyer@dove.com","91 - 077 - 661 - 652",1);
INSERT INTO USER VALUES (4,"Nakita Gaskell","nakitagaskell@dove.com","91 - 021 - 103 - 104",1);
INSERT INTO USER VALUES (5,"Nadene Courtemanche","nadenecourtemanche@bankofscotland.com","91 - 023 - 013 - 663",0);
INSERT INTO USER VALUES (6,"Erwin Valdez","erwinvaldez@dove.com","91 - 270 - 148 - 145",1);
INSERT INTO USER VALUES (7,"Magaly Bolds","magalybolds@bankofscotland.com","91 - 241 - 733 - 023",0);
INSERT INTO USER VALUES (8,"Larae Paskett","laraepaskett@bankofscotland.com","91 - 646 - 632 - 266",0);
INSERT INTO USER VALUES (9,"Lora Dolphin","loradolphin@dove.com","91 - 728 - 818 - 716",1);
INSERT INTO USER VALUES (10,"Jaunita Dodds","jaunitadodds@bankofscotland.com","91 - 464 - 121 - 586",0);
INSERT INTO USER VALUES (11,"Lorelei Mode","loreleimode@bankofscotland.com","91 - 238 - 133 - 831",0);
INSERT INTO USER VALUES (12,"Herb Aikens","herbaikens@dove.com","91 - 732 - 085 - 028",1);
INSERT INTO USER VALUES (13,"Eustolia Wineinger","eustoliawineinger@dove.com","91 - 866 - 747 - 110",1);
INSERT INTO USER VALUES (14,"Wendy Mcmanus","wendymcmanus@bankofscotland.com","91 - 425 - 018 - 811",0);
INSERT INTO USER VALUES (15,"Gaylene Okane","gayleneokane@dove.com","91 - 158 - 852 - 254",1);
INSERT INTO USER VALUES (16,"Norberto Hild","norbertohild@bankofscotland.com","91 - 187 - 207 - 448",0);
INSERT INTO USER VALUES (17,"Obdulia Vankirk","obduliavankirk@dove.com","91 - 560 - 426 - 265",1);
INSERT INTO USER VALUES (18,"Lucius Ginyard","luciusginyard@dove.com","91 - 813 - 700 - 143",1);
INSERT INTO USER VALUES (19,"Billye Karcher","billyekarcher@bankofscotland.com","91 - 447 - 880 - 543",0);
INSERT INTO USER VALUES (20,"Lida Depp","lidadepp@dove.com","91 - 383 - 274 - 173",1);
INSERT INTO USER VALUES (21,"Sabine Auer","sabineauer@dove.com","91 - 118 - 420 - 278",1);
INSERT INTO USER VALUES (22,"Jamee Corns","jameecorns@dove.com","91 - 177 - 235 - 250",1);
INSERT INTO USER VALUES (23,"Candance Mimms","candancemimms@bankofscotland.com","91 - 753 - 123 - 481",0);
INSERT INTO USER VALUES (24,"Flossie Panter","flossiepanter@dove.com","91 - 410 - 073 - 240",1);
INSERT INTO USER VALUES (25,"Marylyn Simonds","marylynsimonds@dove.com","91 - 123 - 880 - 035",1);
INSERT INTO USER VALUES (26,"Carli List","carlilist@dove.com","91 - 874 - 660 - 226",1);
INSERT INTO USER VALUES (27,"Leann Howard","leannhoward@dove.com","91 - 768 - 880 - 400",1);
INSERT INTO USER VALUES (28,"Stacy File","stacyfile@bankofscotland.com","91 - 483 - 205 - 325",0);
INSERT INTO USER VALUES (29,"Raymon Macy","raymonmacy@bankofscotland.com","91 - 147 - 512 - 168",0);
INSERT INTO USER VALUES (30,"Terrell Sugg","terrellsugg@dove.com","91 - 877 - 630 - 802",1);
INSERT INTO USER VALUES (31,"Katelyn Coles","katelyncoles@bankofscotland.com","91 - 842 - 450 - 072",0);
INSERT INTO USER VALUES (32,"Cammy Leek","cammyleek@dove.com","91 - 458 - 671 - 388",1);
INSERT INTO USER VALUES (33,"Sydney Giberson","sydneygiberson@bankofscotland.com","91 - 710 - 617 - 642",0);
INSERT INTO USER VALUES (34,"Mike Holly","mikeholly@dove.com","91 - 427 - 758 - 182",1);
INSERT INTO USER VALUES (35,"Andre Watters","andrewatters@bankofscotland.com","91 - 078 - 317 - 584",0);
INSERT INTO USER VALUES (36,"Devin Gilchrest","devingilchrest@dove.com","91 - 127 - 800 - 214",1);
INSERT INTO USER VALUES (37,"Shelley Coombs","shelleycoombs@bankofscotland.com","91 - 363 - 527 - 550",0);
INSERT INTO USER VALUES (38,"Christene Lindow","christenelindow@dove.com","91 - 752 - 228 - 830",1);
INSERT INTO USER VALUES (39,"Shalanda Honig","shalandahonig@dove.com","91 - 024 - 682 - 821",1);
INSERT INTO USER VALUES (40,"Anjelica Mazzoni","anjelicamazzoni@dove.com","91 - 035 - 523 - 824",1);
INSERT INTO USER VALUES (41,"Allyson Belfiore","allysonbelfiore@bankofscotland.com","91 - 121 - 513 - 057",0);
INSERT INTO USER VALUES (42,"Deandra Scheffel","deandrascheffel@bankofscotland.com","91 - 033 - 167 - 657",0);
INSERT INTO USER VALUES (43,"Regenia Spillman","regeniaspillman@dove.com","91 - 703 - 111 - 680",1);
INSERT INTO USER VALUES (44,"Aurelia Warn","aureliawarn@bankofscotland.com","91 - 645 - 387 - 037",0);
INSERT INTO USER VALUES (45,"Vonnie Alter","vonniealter@dove.com","91 - 161 - 366 - 582",1);
INSERT INTO USER VALUES (46,"Celestine Dade","celestinedade@dove.com","91 - 564 - 888 - 235",1);
INSERT INTO USER VALUES (47,"Chere Disandro","cheredisandro@bankofscotland.com","91 - 872 - 672 - 662",0);
INSERT INTO USER VALUES (48,"Latia Haymaker","latiahaymaker@dove.com","91 - 742 - 582 - 058",1);
INSERT INTO USER VALUES (49,"Forest Wiener","forestwiener@dove.com","91 - 804 - 816 - 840",1);

