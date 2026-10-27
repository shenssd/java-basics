/**
 * 具体介质实现：mp3 音频、mp4 视频、空介质。
 *
 * 和 Hpunkbox.java 一样，这里一个文件放了多个包级私有类，
 * 只要没有 public 类，文件名不必与类名相同。
 */

/** mp3 音频 */
class Mp extends Media {

    public Mp(String fileName) {
        super(fileName); // 把文件名交给父类保存
    }

    @Override
    void play() {
        System.out.println("mp3音乐");
    }

    @Override
    String type() {
        return "mp3";
    }
}

/** mp4 视频 */
class Mm extends Media {

    public Mm(String fileName) {
        super(fileName);
    }

    @Override
    void play() {
        System.out.println("mp4视频");
    }

    @Override
    String type() {
        return "mp4";
    }
}

/**
 * 空介质：空对象模式（Null Object），
 * 用来表示“当前没有插入任何介质”，避免到处判断 null。
 */
class Nulldia extends Media {

    public Nulldia(String fileName) {
        super(fileName);
    }

    @Override
    void play() {
        // 空介质没有可播放的内容，故意留空
    }

    @Override
    String type() {
        return "NONE";
    }
}
