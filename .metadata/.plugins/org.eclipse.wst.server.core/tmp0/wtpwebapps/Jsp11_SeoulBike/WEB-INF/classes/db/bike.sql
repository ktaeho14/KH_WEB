--str.adder_gu+"/"+str.content_id+"/"+str.content_nm+"/"+
--str.new_addr+"/"+str.cradle_count+"/"+str.longitude+"/"+str.latitude

DROP TABLE BIKE_TB;

CREATE TABLE BIKE_TB(
	ADDR_GU VARCHAR2(4000),
	CONTENT_ID NUMBER PRIMARY KEY,
	CONTENT_NM VARCHAR2(4000),
	NEW_ADDR VARCHAR2(4000),
	CRADLE_COUNT NUMBER,
	LONGITUDE NUMBER,
	LATITUDE NUMBER
);

SELECT * FROM BIKE_TB;
DELETE FROM BIKE_TB;
