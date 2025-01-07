package MultiThread;

/*
 * 函数式接口的定义：
 * 1. 接口中只有一个抽象方法
 * 2. 可以使用@FunctionalInterface注解
 * 3. 可以省略接口名
 * 4. 可以省略方法名
 * 5. 可以省略参数类型
 * 6. 如果只有一个参数，可以省略小括号
 * 7. 如果方法体只有一行代码，可以省略大括号和return
 * */

public class TestLambda2 {

    public static void main(String[] args) {
        ILove love = a -> System.out.println("I Love You --> " + a);
        love.love(2);
    }
}

interface ILove {
    void love(int a);
}


