# 第 5 章 抽象类与多态 —— 课堂编程练习

对应作业：**Java 第 5 章 5.6–5.12 课堂编程练习**。

> 说明：代码保留原作业的类名和文件名（包括 `Applition` 这处笔误），
> 只补充了中文注释、整理缩进并加上 `@Override` 注解，**运行逻辑未做任何修改**。

## 目录结构

按题目分成两个子目录，每个子目录都可以独立编译运行：

```text
第5章-抽象类与多态/
├── README.md
├── 01-打印机与墨盒/          # 抽象类 + 多态：打印机与墨盒
│   ├── Inkbox.java           # 抽象父类：墨盒
│   ├── Hpunkbox.java         # 三个具体墨盒：Hpunkbox / CanonInBox / Thir
│   ├── Printer.java          # 打印机（只依赖抽象类 Inkbox）
│   └── Application.java      # 程序入口
└── 02-媒体播放器/            # 抽象类 + 多态：播放器与介质
    ├── Media.java            # 抽象父类：介质
    ├── Mp.java               # 三个具体介质：Mp / Mm / Nulldia
    ├── Player.java           # 播放器（文件内另含 WAV / Flv 扩展示例）
    └── Applition.java        # 程序入口（原文件名笔误，保留）
```

## 知识点总览

| 知识点 | 在本练习中的体现 |
|---|---|
| `abstract class` 抽象类 | `Inkbox`、`Media`：不能 `new`，只描述“是什么、要有什么能力” |
| 抽象方法 | `brand()/maxages()/pricePerPage()`、`play()/type()`：只声明，不实现 |
| 继承 `extends` | 具体墨盒继承 `Inkbox`，具体介质继承 `Media` |
| 多态 / 动态绑定 | `Printer.install(Inkbox)`、`Player.insert(Media)` 接收父类，实际执行子类方法 |
| 向上转型 | `Inkbox box = new CanonInBox();` 子类对象当父类用 |
| 代码复用 | `use` 字段和 `add()/pass()/get()` 由父类统一实现 |
| 面向抽象编程 | `Printer` / `Player` 不认识任何具体品牌或格式，新增类型无需改它们 |
| 空对象模式 | `Nulldia` 表示“没有介质”，避免到处判断 `null` |

---

## 一、打印机与墨盒

### 需求

- 打印机可以安装不同品牌的墨盒，打印时统计已用页数；
- 每个墨盒有品牌、最大页数、每页成本；
- 剩余页数不足时要提示更换墨盒；
- 换墨盒后已用页数重新计算。

### 类关系

```text
                 Inkbox（抽象类）
                 ├─ use：已用页数
                 ├─ brand() / maxages() / pricePerPage()：抽象方法
                 └─ add() / pass() / get()：通用实现
                        ▲
        ┌───────────────┼───────────────┐
   Hpunkbox        CanonInBox          Thir
   小丑/200页       队友/300页         李华/500页
   0.35元/页       0.30元/页          0.12元/页

Printer ──依赖──▶ Inkbox（抽象类型）
Application ──创建──▶ Printer + 具体墨盒
```

### 运行结果

```text
品牌队友本次打印页数100总成本30.0累计打印100
品牌小丑本次打印页数50总成本17.5累计打印50
墨量不足,请更换墨盒
```

### 代码讲解

- **`Inkbox`**：把“墨盒”的公共部分（`use` 和三个通用方法）放在抽象类里，
  具体品牌只需实现三个抽象方法，不用重复写计数逻辑。
  `get()` 用 `maxages() - use` 计算剩余页数，调用的是子类实现的 `maxages()`。
- **`Hpunkbox.java`**：一个文件里写了三个包级私有类。
  Java 允许这样做，只要**最多一个 `public` 类且文件名与它同名**；
  本文件没有 `public` 类，所以文件名不必与类名一致。
- **`Printer`**：字段类型是 `Inkbox` 而不是某个具体品牌，
  所以换任何新墨盒都不用改打印机代码（开闭原则的雏形）。
- **`Application`**：演示“同一台打印机 + 不同墨盒”的多态效果；
  第三次打印 400 页超过佳能 300 页容量，因此走“墨量不足”分支。

### 关键点

1. `Inkbox` 不能直接 `new`，只能 `new` 它的子类。
2. 三个子类必须实现全部抽象方法，否则子类自己也要声明为 `abstract`。
3. `Printer.print()` 前必须先 `install()`，否则 `box` 为 `null` 会抛 `NullPointerException`。

---

## 二、媒体播放器

### 需求

- 播放器可以插入不同格式的介质（mp3、mp4 等）；
- 播放前显示介质类型和文件名；
- 没有插入介质时给出提示；
- 支持停止播放。

### 类关系

```text
                  Media（抽象类）
                  ├─ fileName
                  ├─ Media(String fileName)
                  ├─ play()：抽象方法
                  └─ type()：抽象方法
                          ▲
        ┌─────────────────┼──────────────┬──────────────┐
       Mp                Mm           Nulldia         WAV / Flv
     mp3 音乐          mp4 视频       空介质占位      扩展示例
   （定义在 Mp.java）              （定义在 Mp.java）  （定义在 Player.java）

Player ──依赖──▶ Media（抽象类型）
Applition ──创建──▶ Player + Mp / Mm
```

### 运行结果

```text
正在播放mp3song.mp3
mp3音乐
停止播放
正在播放mp4TV.mp4
mp4视频
停止播放
```

### 代码讲解

- **`Media`**：用抽象类保存公共字段 `fileName`，通过构造方法由子类 `super(fileName)` 初始化。
- **`Mp.java`**：`Mp` 播放 mp3、`Mm` 播放 mp4；
  `Nulldia` 是“空对象”，`play()` 故意留空、`type()` 返回 `NONE`，
  可以替代 `null` 判断（空对象模式）。
- **`Player`**：`insert()` 只保存引用，`start()` 先判空再播放；
  `media.play()` 在运行时才决定调用哪个子类的方法，这就是动态绑定。
- **`Applition`**：注意类名是原作业的笔误（正确应为 `Application`），
  为保持提交文件名一致而保留；运行逻辑完全正常。

### 关键点

1. 子类构造方法必须先调用 `super(fileName)`，否则父类的 `fileName` 没有被赋值。
2. `Player.start()` 已经做了判空，所以没插介质时不会崩溃；
   但 `Player.insert(null)` 之后再 `start()` 仍然走“未检测到介质”分支。
3. `WAV`、`Flv` 是扩展示例，本次入口程序没有用到，用于说明“新增格式不用改 Player”。

---

## 编译与运行

每个子目录都是独立程序，进入对应目录执行：

```bash
# 01 打印机
cd 01-打印机与墨盒
javac *.java
java Application

# 02 播放器
cd ../02-媒体播放器
javac *.java
java Applition
```

Windows 控制台如果出现中文乱码，加上输出编码参数即可：

```bash
java -Dstdout.encoding=UTF-8 Application
java -Dstdout.encoding=UTF-8 Applition
```

## 易错点小结

1. **抽象类不能实例化**：`new Inkbox()`、`new Media()` 都会编译报错。
2. **抽象方法必须全部实现**：少实现一个，子类就得继续声明为 `abstract`。
3. **`public` 类与文件名必须一致**；一个文件最多一个 `public` 类。
4. **多态只对实例方法生效**：字段、`static` 方法、`private` 方法在编译期就确定了。
5. **注意空指针**：`Printer.print()` 依赖先 `install()`；`Player` 已经做了判空。
6. **`double` 表示金额有精度误差**：真实项目里金额建议用 `BigDecimal`。

## 可以继续改进

- 如果不需要共享状态，可以把 `Inkbox` / `Media` 改成 `interface`；
- 打印成本用 `BigDecimal` 计算；
- 给 `Printer` 增加“构造方法注入墨盒”，避免忘记 `install()`；
- 增加 JUnit 单元测试，覆盖“剩余页数不足”“空介质”等边界情况。
