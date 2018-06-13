
/*==============================================================*/
/* Table: 红包表                                        */
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
/* Table: 用户抢红包表                                                */
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
* 插入一个20万元金额，2万个小红包，每个10元的红包数据
*/
insert into T_RED_PACKET(id,user_id, amount, send_date, total, unit_amount, stock, note)
 values(1,1, 200000.00, sysdate, 20000, 10.00, 20000,'20万元金额，2万个小红包，每个10元'); 
 
select * from  T_RED_PACKET;