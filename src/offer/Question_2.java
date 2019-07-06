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

