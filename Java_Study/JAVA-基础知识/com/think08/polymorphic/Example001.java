package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.1 再论向上转型。 
 * 
 *   1）、对象既可以作为自己本身的类型使用，也可以作为它的基类型使用。而这种把某个对象的引用视为对其基类型的引用的做法
 *        被称作向上转型（因为在继承树的画法中，基类是放置在上方的）。
 */
public class Example001 {
   
	@Test
	public void testMusic(){
		Wind flute = new Wind();
		Music.tune(flute);
	}
	
}

/**
 * 1)、观察一个乐器的例子 
 */
/**
 * 乐符 
 */
enum Note{
	MIDDLE_C, C_SHARP, B_FLAT;
}

/**
 * 乐器 
 */
class Instrument{
	public void play(Note n){
		System.out.println("Instrument.play() ");
	}
}

/**
 *  管乐器
 */
class Wind extends Instrument{
	public void play(Note n){
		System.out.println("Wind.play() " + n);
	}
}

/**
 *  弦乐器
 */
class Brass extends Instrument{
	public void play(Note n){
		System.out.println("Brass.play() " + n);
	}
}



class Music{
	/**
	 * 曲子 
	 * tune() 的参数类型是Instrument，而不是具体的某个类，这样做的好处是不必为每种Instrument类型增加tune方法。
	 * 比较糟糕的做法如：Music2
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
