/**
 * 打印机类。
 *
 * 设计要点（面向抽象编程）：
 * Printer 只依赖抽象类 Inkbox，不认识任何具体品牌。
 * 以后新增墨盒品牌时，只要写一个继承 Inkbox 的新类，
 * Printer 一行代码都不用改 —— 这就是多态带来的扩展性。
 */
public class Printer {

    /** 当前安装的墨盒；声明类型是 Inkbox，实际可以是任意子类 */
    Inkbox box;

    /** 原作业中保留的字段，当前逻辑未使用（可安全删除） */
    private int a;

    /** 安装墨盒：保存引用，并把打印计数清零 */
    void install(Inkbox b) {
        box = b;
        a = 0;
    }

    /**
     * 打印指定页数。
     * - 剩余页数不足：提示更换墨盒，不打印；
     * - 否则：累加用量，并输出品牌、本次页数、本次成本和累计页数。
     *
     * 注意：调用前必须先 install()，否则 box 为 null 会抛 NullPointerException。
     */
    void print(int pages) {
        if (pages > box.get()) {
            System.out.println("墨量不足,请更换墨盒");
            return;
        } else {
            box.add(pages);
            System.out.println("品牌" + box.brand()
                    + "本次打印页数" + pages
                    + "总成本" + box.pricePerPage() * pages
                    + "累计打印" + box.pass());
        }
    }
}
