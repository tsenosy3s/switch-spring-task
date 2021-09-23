insert into manufacturers(name,date_created)
values('BMW',sysdate()),('KIA',sysdate()),('FIAT',sysdate());

insert into drivers(name,date_created)
values('Jack',sysdate()),('Welson',sysdate()),('Brad',sysdate());



insert into cars(convertible,date_created,ENGINE_TYPE ,LICENSE_PLATE ,RATING ,SEAT_COUNT ,MANUFACTURER_ID )
values(0,sysdate(),'GAS','123',4,4,1),(1,sysdate(),'ELECTRIC','125',2,8,2),(1,sysdate(),'ELECTRIC','145',2,8,3),(1,sysdate(),'GAS','166',3,6,3)
