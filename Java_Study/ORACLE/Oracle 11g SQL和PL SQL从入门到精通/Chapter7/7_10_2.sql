
/**
 *  7.10.2 ������ʽ�ַ���ʽ��
 */
 CREATE TABLE POSIX_EXAMPLE(string VARCHAR2(20));
 INSERT INTO POSIX_EXAMPLE VALUES('abb');
 INSERT INTO POSIX_EXAMPLE VALUES('acb');
 INSERT INTO POSIX_EXAMPLE VALUES('adb');
 
 SELECT * FROM POSIX_EXAMPLE;
 
 /* 1. "." 
  *   ����ƥ���κε����ַ���
  */
 SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'a.b');
 
 /*
  * 2. "+"
  *    ����1�λ��߶�Ρ�
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'b+');
  
  /*
  * 3. "?"
  *    ����0�λ���1�Ρ�
  *    �磺abc ac ����ʽ ab?c ƥ��
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'ab?c');
  
  /*
  * 4. "*"
  *    ����0�λ��߶�Ρ�
  *    �磺ac abc abbc ����ʽ ab*c ƥ��
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'ab*c');
  
  /*
  * 5. "{m,}"
  *    ���ٳ��� m �Ρ�
  *    �磺aa aaa ����ʽ a{2,} ƥ��
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'a{2,}');
  
  /*
  * 6. "{m,n}"
  *    ���ٳ��� m ��,���ǲ�����n�Ρ�
  *    �磺aaa ����ʽ a{3,4}ƥ�䣬�����ַ���a��aa�����ʽ��ƥ��
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'a{3,4}');
