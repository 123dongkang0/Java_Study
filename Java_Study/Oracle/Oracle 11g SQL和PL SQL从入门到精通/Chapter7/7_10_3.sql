/**
 * 7.10.3 ������ʽ��ʽ���η�
 */
 
 /* 3. n �� "." ƥ������ֵ
  *  ORACLE �� CHR(10) ��ʾ����
  */
 select 
   'a' || CHR(10) || 'd',
   REGEXP_SUBSTR('a' || CHR(10) || 'd', 'a.d',1,1,'n'),
   REGEXP_SUBSTR('a' || CHR(10) || 'd', 'a.d',1,1)
 from dual
 
 /* 4. m ��������
  *  ORACLE �� CHR(10) ��ʾ����
  */
 select 
   'ab' || CHR(10) || 'ac',
   REGEXP_SUBSTR('ab' || CHR(10) || 'ac', '^a.',1,2,'m'),
   REGEXP_SUBSTR('ab' || CHR(10) || 'ac', '^a',1,2)
 from dual
 
  /* 5. x ���Կո��
  *  
  */
 select 
   REGEXP_SUBSTR('abcd', '^a b c d',1,1,'x'),
   REGEXP_SUBSTR('abcd', '^a b c d',1,1)
 from dual
