package com.think10.innerclass;
/**
 * 1. 在这里我们使用一个更加详细的例子来说明JAVA回调函数 .
 *     所谓回调： 就是A类中调用B类中的某个方法C， 然后B类中反过来调用A类中的方法D，
 *              D这个方法就叫回调方法。
 *
 * 2. 大家都喜欢用打电话的例子，好吧，为了跟上时代，我也用这个例子好了，我这个例子采用异步加回调:
 * 
 *      有一天小王遇到一个很难的问题，问题是“1 + 1 = ?”，就打电话问小李，小李一下子也不知道，
 * 就跟小王说，等我办完手上的事情，就去想想答案，小王也不会傻傻的拿着电话去等小李的答案吧，于是小王就对小李说，
 * 我还要去逛街，你知道了答案就打我电话告诉我，于是挂了电话，自己办自己的事情，过了一个小时，小李打了小王的电话，告诉他答案是2 
 */
public class Example0082 {
   public static void main(String args[]){
       //new 一个小李 
       Li li = new Li();  
 
       //new 一个小王 
       Wang wang = new Wang(li);  
         
       //小王问小李问题 
       wang.askQuestion("1 + 1 = ?");
   }
}


/** 
 * 这是一个回调接口  
 */  
interface CallBack {  
     // 这个是小李知道答案时要调用的函数告诉小王，也就是回调函数 ,@param result 是答案 
     public void solve(String result);  
}

/** 
 * 这个是小王 
 * 实现了一个回调接口CallBack
 */  
class Wang implements CallBack {  
    //小李对象的引用 
    private Li li;   
  
    //小王的构造方法，持有小李的引用 
    public Wang(Li li){  
        this.li = li;  
    }  
      
    //小王通过这个方法去问小李的问题 ,@param question  就是小王要问的问题,1 + 1 = ? 
    public void askQuestion(final String question){  
        //这里用一个线程就是异步，  
        new Thread(new Runnable() {  
            @Override  
            public void run() {  
                 //小王调用小李中的方法，在这里注册回调接口 ,这就相当于A类调用B的方法C 
                li.executeMessage(Wang.this, question);   
            }  
        }).start();  
          
        //小网问完问题挂掉电话就去干其他的事情了，诳街去了  
        play();  
    }  
  
    public void play(){  
        System.out.println("我要逛街去了");  
    }  
  
    //小李知道答案后调用此方法告诉小王，就是所谓的小王的回调方法 
    @Override  
    public void solve(String result) {  
        System.out.println("小李告诉小王的答案是--->" + result);  
    }  
      
}  

/** 
 * 这个就是小李啦
 * 
 */  
class Li {  
    
	//小王问的问题 
    public void executeMessage(CallBack callBack, String question){  
        System.out.println("小王问的问题--->" + question);  
          
        //模拟小李办自己的事情需要很长时间  
        for(int i=0; i<10000;i++){  
              
        }  
          
        //小李办完自己的事情之后想到了答案是2 
        String result = "答案是2";  
          
        //于是就打电话告诉小王，调用小王中的方法 ,这就相当于B类反过来调用A的方法D 
        callBack.solve(result);   
    }  
      
} 