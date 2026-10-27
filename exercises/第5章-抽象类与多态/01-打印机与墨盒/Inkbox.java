/**
 * 墨盒抽象类：所有品牌墨盒的「通用父类」。
 *
 * 知识点：
 * 1. abstract class：表示一个不能直接 new 的通用概念（这里代表“墨盒”），
 *    只负责定义子类共有的状态和行为。
 * 2. 抽象方法 brand() / maxages() / pricePerPage()：只声明“必须具备这个能力”，
 *    具体返回什么由不同品牌的子类实现，这就是多态的基础。
 * 3. 父类保存公共状态 use，并提供 add() / pass() / get() 三个通用方法，
 *    子类不用重复写，直接继承复用（代码复用）。
 */
abstract class Inkbox {

    /** 已经打印过的页数；protected 表示子类可以直接访问 */
    protected int use;

    /** 品牌名称，由具体墨盒实现 */
    abstract String brand();

    /** 墨盒最大可打印页数（容量），由具体墨盒实现 */
    abstract int maxages();

    /** 每页打印成本（元/页），由具体墨盒实现 */
    abstract double pricePerPage();

    /** 构造方法：新墨盒的已用页数初始化为 0 */
    public Inkbox() {
        use = 0;
    }

    /** 累加本次打印的页数 */
    public void add(int a) {
        use += a;
    }

    /** 返回墨盒已经使用的页数 */
    public int pass() {
        return use;
    }

    /** 返回剩余可打印页数 = 容量 - 已用页数 */
    public int get() {
        return maxages() - use;
    }
}
