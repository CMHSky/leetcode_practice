package MultiThread.TestCallable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;


// 线程创建方式三：实现Callable接口
/*
* Callable的好处
* 1. 可以定义返回值
* 2. 可以抛出异常
* */
public class TestCallable implements Callable<Boolean> {
    private String url; // 网络图片地址
    private String name; // 保存的文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // Callable执行体
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://i-blog.csdnimg.cn/blog_migrate/e2a1b6d4d233c5ad32a819c3475ccfa4.png", "Callable1.png");
        TestCallable t2 = new TestCallable("https://i-blog.csdnimg.cn/blog_migrate/1d7892e7ed2c37fad46f9deaae150fb7.png", "Callable2.png");
        TestCallable t3 = new TestCallable("https://i-blog.csdnimg.cn/blog_migrate/ad75e596dab6a6b131066a3ff8a15d35.png", "Callable3.png");

        // 1. 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 2. 提交执行
        Future<Boolean> task1 = ser.submit(t1);
        Future<Boolean> task2 = ser.submit(t2);
        Future<Boolean> task3 = ser.submit(t3);

        // 3. 获取结果
        boolean rs1 = task1.get();
        boolean rs2 = task2.get();
        boolean rs3 = task3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        // 4. 关闭服务
        ser.shutdown();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常, downloader方法出现问题");
        }
    }
}
