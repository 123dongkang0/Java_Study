package com.think17.containerdeep;

/**
 *  WeakHashMap
 *    弱键映射（weak key)映射，允许释放映射所指向的对象，这是为了解决某类特殊问题而设计的。
 *  如果映射之外没有引用指向某个 “键”， 则此 “键” 可以被垃圾收集器回收。
 *  
 *   1)、它的特殊之处在于 WeakHashMap 里的entry可能会被GC自动删除，即使程序员没有调用remove()或者clear()方法。
 *   
 *   2）、当使用 WeakHashMap 时，即使没有显示的添加或删除任何元素，也可能发生如下情况：
 *     2.1）、调用两次size()方法返回不同的值；
 *     2.2）、两次调用isEmpty()方法，第一次返回false，第二次返回true；
 *     2.3）、两次调用containsKey()方法，第一次返回true，第二次返回false，尽管两次使用的是同一个key；
 *     2.4）、两次调用get()方法，第一次返回一个value，第二次返回null，尽管两次使用的是同一个对象。
 *     
 *   3）、使用场景
 *        WeekHashMap 的这个特点特别适用于需要缓存的场景。在缓存场景下，由于内存是有限的，不能缓存所有对象；
 *     对象缓存命中可以提高系统效率，但缓存MISS也不会造成错误，因为可以通过计算重新得到。
 *   
 */
public class Example0082_WeakHashMap {
    
}
