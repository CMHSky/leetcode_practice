package MultiThread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread {
    private String url; // 网络图片地址
    private String name; // 保存的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 thread1 = new TestThread2("https://i-blog.csdnimg.cn/blog_migrate/e2a1b6d4d233c5ad32a819c3475ccfa4.png", "1.png");
        TestThread2 thread2 = new TestThread2("https://i-blog.csdnimg.cn/blog_migrate/1d7892e7ed2c37fad46f9deaae150fb7.png", "2.png");
        TestThread2 thread3 = new TestThread2("https://i-blog.csdnimg.cn/blog_migrate/ad75e596dab6a6b131066a3ff8a15d35.png", "3.png");
        thread1.start();
        thread2.start();
        thread3.start();
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
