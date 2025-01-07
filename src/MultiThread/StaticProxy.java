package MultiThread;

// 静态代理模式（线程底部实现原理，使用Thread静态代理实现Runnable接口的对象）
/*
* 真实对象和代理对象都要实现同一个接口
* 代理对象要代理真实角色
*
* 好处：
* 1. 代理对象可以做很多真实对象做不了的事情
* 2. 真实对象只需要关注真正的业务逻辑
* */
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

// 真实角色
class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("我要结婚了");
    }
}

// 代理角色
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收礼金");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}
