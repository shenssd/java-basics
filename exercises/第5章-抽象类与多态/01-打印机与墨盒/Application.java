/**
 * 程序入口：演示打印机的多态用法。
 *
 * 运行流程：
 * 1. 装佳能墨盒，打印 100 页；
 * 2. 换小丑墨盒，打印 50 页；
 * 3. 再换回佳能墨盒，尝试打印 400 页（超出 300 页容量，提示更换）。
 *
 * 多态体现：
 * install() 的参数类型是 Inkbox，实际可以传 CanonInBox / Hpunkbox 等任意子类；
 * 调用 brand() / maxages() / pricePerPage() 时，执行的是“实际对象”的方法，
 * 而不是声明类型的方法（动态绑定）。
 */
public class Application {

    public static void main(String[] args) {
        Printer p = new Printer();

        CanonInBox a = new CanonInBox(); // 佳能墨盒（定义在 Hpunkbox.java 中）
        Hpunkbox b = new Hpunkbox();     // 小丑墨盒

        p.install(a);
        p.print(100);   // 佳能：100 / 300 页

        p.install(b);
        p.print(50);    // 小丑：50 / 200 页

        p.install(a);   // 重新安装佳能，已用页数归零
        p.print(400);   // 400 > 300，提示墨量不足
    }
}
