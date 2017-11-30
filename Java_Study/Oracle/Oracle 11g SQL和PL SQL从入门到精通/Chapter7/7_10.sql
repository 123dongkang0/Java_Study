/**
 * 7.10 ������ʽ
     ��ʹ��һ���ַ���ʾ������ʽ
       .Ԫ�ַ�������ָ�������㷨��
       .�ı�������ָ��Ҫ�������ַ�;
 */
 
 /**
 * 7.10.1 ������ʽ����
     1.REGEXP_LIKE(expression,pattern)
 */
 /* ���ڼ����� S ��ʼ�����й�Ա�����乤��*/
 SELECT ENAME,SAL FROM EMP WHERE REGEXP_LIKE(ENAME,'^S');
 
 /* 2. REGEXP_INSTR(
                    source_string
                    ,pattern
                    [,position
                    [,occurrence
                    [,return_option
                    [,match_parameter]
                    ]
                    ]
                    ]
                    )
  *    
  *    ���ڷ����Ӵ����ַ����е���ʼλ�á�
  *    source_string ��ָ��Դ�ַ�����
  *    pattern : ����ָ��Դ�ַ�����
  *    position(��ѡ) : ����ָ����ʼλ��,��Ĭ��Ϊ1�������ַ����еĵ�һ��λ�á���
  *    occurrence(��ѡ) : ����ָ����n�γ��ֵ��Ӵ�,���ʡ�ԣ�Ĭ��Ϊ1��
  *    return_option(��ѡ) : ָ��Oracle���ص�λ�ã�
  *       ���ָ��0 ����ôOracle�����س��ֵĵ�һ���ַ���λ�á�����Ĭ�ϵġ�
  *       ���ָ��1 ����Oracle�����ַ�֮������λ�á�
  *    match_parameter(��ѡ)������ָ����ʽƥ�����η���
  */
 /* �����ַ� E �Ĺ�Ա�����Լ�E��λ�� */
 SELECT ENAME,REGEXP_INSTR(ENAME,'E') position   FROM EMP
 WHERE REGEXP_LIKE(ENAME,'E');
 
 /*
  * ����������Ӹ���һ���ַ����� 
  *       ��1��Ϊ��ʼλ�� 
  *       ��2���������ڶ���ƥ��ģ�
  *       ��0����return_option ���س��ֵĵ�һ���ַ�λ��
  *       ��c�������ִ�Сд ��
  *   ���Խ�����13
  */
 SELECT REGEXP_INSTR ('my is itMyhome', 'm', 1, 2, 0, 'c') position FROM dual; 
 
 /* 3. REGEXP_REPLACE(
                    source_string
                    ,pattern
                    [,replace_string
                    [,position
                    [,occurrence
                    [,match_parameter]
                    ]
                    ]
                    ]
                    )
  *    
  *    ���ڷ����Ӵ����ַ����е���ʼλ�á�
  *    source_string ��ָ��Դ�ַ�����
  *    pattern : ����ָ��Դ�ַ�����
  *    replace_string(��ѡ) : ����ָ���滻��
  *    position(��ѡ) : ����ָ����ʼλ��,��Ĭ��Ϊ1�������ַ����еĵ�һ��λ�á���
  *    occurrence(��ѡ) : ����ָ����n�γ��ֵ��Ӵ�,���ʡ�ԣ�Ĭ��Ϊ1��
  *    match_parameter(��ѡ)������ָ����ʽƥ�����η���
  */
  /* ������ʾ����S�Ĺ�Ա�����Լ��滻��Ĺ�Ա��(����ĸ��д�������ַ�Сд) */
 SELECT ENAME,REGEXP_REPLACE(ENAME,'[[:upper:]]+',INITCAP(ENAME)) replace
 FROM EMP WHERE REGEXP_LIKE(ENAME,'S');
 
 
