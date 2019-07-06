package offer;

/**
 * 单例模式
 */

// 饿汉式
    /*
public class Question_2 {

    private static Question_2 instance = new Question_2();

    private Question_2(){ }

    public static Question_2 getInstance(){
        return instance;
    }
}

     */

// 懒汉式
public class Question_2 {

    private static class LazyHolder{
        private static final Question_2 INSTANCE = new Question_2();
    }

    private Question_2(){}

    public static Question_2 getInstance(){
        return LazyHolder.INSTANCE;
    }
}

/*
public class Question_2{

    //防止指令重排序：insrance在没有初始化的情况下，内存已经分配给它
    private static volatile Question_2 instance;

    private Question_2(){}

    public static Question_2 getInstance(){

        if (instance == null){
            synchronized (Question_2.class){
                if (instance == null){
                    instance = new Question_2();
                }
            }
        }

        return instance;
    }

}
*/

