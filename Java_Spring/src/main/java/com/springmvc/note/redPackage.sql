
/*==============================================================*/
/* Table: �����                                        */
/*==============================================================*/
create table T_RED_PACKET
(
   id                   number(12)                        not null primary key,
   user_id              number(12)                        not null,
   amount               decimal(16,2)                  not null,
   send_date            timestamp                      not null,
   total                number(12)                        not null,
   unit_amount          decimal(12)                    not null,
   stock                number(12)                        not null,
   version              number(12) default 0              not null,
   note                 varchar(256)                    null
);

/*==============================================================*/
/* Table: �û��������                                                */
/*==============================================================*/
create table T_USER_RED_PACKET 
(
   id                   number(12)                        not null primary key,
   red_packet_id        number(12)                        not null,
   user_id              number(12)                        not null,
   amount               decimal(16,2)                  not null,
   grab_time            timestamp                      not null,
   note                 varchar(256)                   null
);




/**
* ����һ��20��Ԫ��2���С�����ÿ��10Ԫ�ĺ������
*/
insert into T_RED_PACKET(id,user_id, amount, send_date, total, unit_amount, stock, note)
 values(1,1, 200000.00, sysdate, 20000, 10.00, 20000,'20��Ԫ��2���С�����ÿ��10Ԫ'); 
 
select * from  T_RED_PACKET;