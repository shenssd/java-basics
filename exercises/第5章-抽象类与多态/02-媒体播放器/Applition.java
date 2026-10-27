/**
 * 程序入口：演示播放器的多态用法。
 *
 * 注意：类名/文件名 Applition 是原作业中的笔误
 * （正确拼写应为 Application），为与提交时的文件名保持一致而保留。
 *
 * 运行流程：
 * 插入 song.mp3 → 播放 → 停止；
 * 换入 TV.mp4 → 播放 → 停止。
 *
 * 多态体现：insert() 接收 Media，实际传入 Mp / Mm，
 * start() 里 media.play() 会执行对应子类的实现。
 */
public class Applition {

    public static void main(String[] args) {
        Player p = new Player();

        Mp a = new Mp("song.mp3");   // mp3 音频（定义在 Mp.java 中）
        Mm b = new Mm("TV.mp4");     // mp4 视频（定义在 Mp.java 中）

        p.insert(a);
        p.start();
        p.stop();

        p.insert(b);
        p.start();
        p.stop();
    }
}
