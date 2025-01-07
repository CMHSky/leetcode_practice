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

/*
* 推导Lambda表达式
* */
public class TestLambda {
    // 3. 静态内部类
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("静态内部类");
        }
    }

    public static void main(String[] args) {
        // 实现类
        ILike like = new Like();
        like.lambda();

        // 静态内部类
        like = new Like2();
        like.lambda();

        // 4. 局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("局部内部类");
            }
        }

        like = new Like3();
        like.lambda();

        // 5. 匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("匿名内部类");
            }
        };

        like.lambda();

        // 6. Lambda表达式
        like = () -> System.out.println("Lambda表达式");
        like.lambda();
    }
}

// 1. 定义一个函数式接口
interface ILike {
    void lambda();
}

// 2. 实现类
class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("实现类");
    }
}
