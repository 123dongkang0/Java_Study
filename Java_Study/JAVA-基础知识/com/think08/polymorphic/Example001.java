package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.1 ��������ת�͡� 
 * 
 *   1��������ȿ�����Ϊ�Լ����������ʹ�ã�Ҳ������Ϊ���Ļ�����ʹ�á������ְ�ĳ�������������Ϊ��������͵����õ�����
 *        ����������ת�ͣ���Ϊ�ڼ̳����Ļ����У������Ƿ������Ϸ��ģ���
 */
public class Example001 {
   
	@Test
	public void testMusic(){
		Wind flute = new Wind();
		Music.tune(flute);
	}
	
}

/**
 * 1)���۲�һ������������ 
 */
/**
 * �ַ� 
 */
enum Note{
	MIDDLE_C, C_SHARP, B_FLAT;
}

/**
 * ���� 
 */
class Instrument{
	public void play(Note n){
		System.out.println("Instrument.play() ");
	}
}

/**
 *  ������
 */
class Wind extends Instrument{
	public void play(Note n){
		System.out.println("Wind.play() " + n);
	}
}

/**
 *  ������
 */
class Brass extends Instrument{
	public void play(Note n){
		System.out.println("Brass.play() " + n);
	}
}



class Music{
	/**
	 * ���� 
	 * tune() �Ĳ���������Instrument�������Ǿ����ĳ���࣬�������ĺô��ǲ���Ϊÿ��Instrument��������tune������
	 * �Ƚ����������磺Music2
	 */
	public static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
	}
}

class Music2{
	
	public static void tune(Wind i){
		i.play(Note.MIDDLE_C);
	}
	
	public static void tune(Brass i){
		i.play(Note.MIDDLE_C);
	}
	
	
}
