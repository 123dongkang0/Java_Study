[TOC]

### Iterable和Iterator的辨析
本节主要针对Iterable和Iterator零个接口进行深入的学习。

**1）、Iterable接口**
Iterable接口 (java.lang.Iterable) 是Java集合的顶级接口之一。我们首先看下这这个接口在JDK中的定义：
```
public interface Iterable<T> {
    Iterator<T> iterator();
}
```
添加了Iterable接口用于支持foreach的循环。Iterable接口只有一个方法，就是iterator()方法，返回集合的Iterator对象。所有实现Iterable接口的集合都可以使用foreach循环进行遍历。

**2）、Iterator接口**
首先，我们还是先看下Iterator接口的定义：
```
public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove();
}
```
当编译器见到一个正在用于Iterable对象的增强的for循环的时候，它用对iterator()方法的调用来代替增强的for循环以得到一个Iterator对象，然后调用next和hasNext。我们可以给出iterator()方法的定义。
```
public static <T> void print(Collection<T> coll){
      Iterator<T> itr = coll.iterator();
       while(itr.hasNext()){
           T item = itr.next();
           System.out.println(item);
       }
  }
```
Iterator接口中的核心方法next()，hasNext()，remove()，都是依赖当前位置。如果这些集合直接实现Iterator接口，则势必导致集合对象中包含当前迭代位置的数据(指针)。当集合在不同方法间进行传递的时候，由于当前迭代位置不可知，所以next()的结果也不可知。除非再为Iterator接口添加一个reset()方法，用来重置当前迭代位置。 而当实现Iterable则不然，每次调用都返回一个从头开始的迭代器，各个迭代器之间互不影响。

**通过上面的描述，Iterable和Iterator的关系显而易见。**

**3）、综合应用**
下面以stack为例，解释如何在一个新的Collection中实现这两个接口。
```
public class Main {
      public static void main(String args[]){
    	  ArrayStack<String> strArray = new ArrayStack<String>();
    	  strArray.push("java Hello World");
    	  strArray.push("C++ Hello World");
    	  for(String str : strArray){
    		  System.out.println(str);
    	  }
      }
}

class ArrayStack<T> implements Iterable<T>{
	private T[] a = (T[])new Object[100];
	private int n = 0;
	
	public void push(T item){
		a[n++] = item;
	}
	
	public T pop(){
		return a[n--];
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<T>{
		private int i=0;
		@Override
		public boolean hasNext() {
			return i < n;
		}
		@Override
		public T next() {
			return a[i++];
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
}
```





