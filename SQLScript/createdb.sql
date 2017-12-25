create database EMDB

use EMDB
create TABLE EVENT_TBL (
	EVENT_ID INTEGER identity(1,1) PRIMARY KEY,
	EVENT_NAME VARCHAR(50) NOT NULL,
	BEGIN_TIME DATE NOT NULL,
	END_TIME DATE NOT NULL,
	CONSTRAINT CHK_TIME CHECK(BEGIN_TIME <= END_TIME)
)
create TABLE GUEST_TBL(
	GUEST_ID INTEGER identity(1,1) PRIMARY KEY,
	GUEST_NAME VARCHAR(50) NOT NULL,
	GUEST_CONN VARCHAR(50) UNIQUE,
	GUEST_ADDR VARCHAR(50),

)
create TABLE ITEM_TBL(
	ITEM_ID INTEGER identity(1,1) PRIMARY KEY,
	ITEM_COST MONEY NOT NULL,
	ITEM_REAS VARCHAR(100) NOT NULL,
	EVENT_ID INTEGER NOT NULL UNIQUE, 

	CONSTRAINT CHK_ITEM_COST CHECK(ITEM_COST > 0),
	CONSTRAINT EVET_ID_FK FOREIGN KEY(EVENT_ID) REFERENCES EVENT_TBL(EVENT_ID)
)
create TABLE GUESTLIST(
	GUEST_ID INTEGER,
	EVENT_ID INTEGER,

	CONSTRAINT CHK_GUEST_ID FOREIGN KEY(GUEST_ID) REFERENCES GUEST_TBL(GUEST_ID),
	CONSTRAINT CHK_EVENT_ID FOREIGN KEY(EVENT_ID) REFERENCES EVENT_TBL(EVENT_ID) 
)
