/**
 * 具体墨盒实现（三种品牌）。
 *
 * 说明：一个 .java 文件里可以写多个顶层类，前提是
 * 「最多只有一个 public 类，且文件名与那个 public 类同名」。
 * 本文件里的三个类都不是 public（包级私有），
 * 所以可以都写在 Hpunkbox.java 里一起编译。
 *
 * 三个子类都继承 Inkbox，并实现父类的三个抽象方法；
 * 换墨盒时 Printer 不需要知道具体是哪个类（多态）。
 */

/** 小丑牌墨盒：200 页容量，0.35 元/页 */
class Hpunkbox extends Inkbox {

    @Override
    String brand() {
        return "小丑";
    }

    @Override
    int maxages() {
        return 200;
    }

    @Override
    double pricePerPage() {
        return 0.35;
    }
}

/** 佳能（Canon）墨盒：300 页容量，0.30 元/页 */
class CanonInBox extends Inkbox {

    @Override
    String brand() {
        return "队友";
    }

    @Override
    int maxages() {
        return 300;
    }

    @Override
    double pricePerPage() {
        return 0.30;
    }
}

/** 第三方墨盒：500 页容量，0.12 元/页 */
class Thir extends Inkbox {

    @Override
    String brand() {
        return "李华";
    }

    @Override
    int maxages() {
        return 500;
    }

    @Override
    double pricePerPage() {
        return 0.12;
    }
}
