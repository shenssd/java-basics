/**
 * 播放器类。
 *
 * 设计要点：Player 只持有抽象类型 Media，
 * 不关心插入的是 mp3、mp4 还是别的格式。
 * 播放时通过 media.type() / media.play() 动态调用子类实现（多态）。
 */
public class Player {

    /** 当前插入的介质；null 表示还没有插入 */
    private Media media;

    /** 插入介质：只保存引用，不会立即播放 */
    void insert(Media m) {
        media = m;
    }

    /** 停止播放 */
    void stop() {
        System.out.println("停止播放");
    }

    /**
     * 开始播放。
     * 先判断是否插入了介质，避免 NullPointerException；
     * 有介质时先输出类型和文件名，再调用 play() 播放。
     */
    void start() {
        if (media == null) {
            System.out.println("未检测到介质,无法播放");
        } else {
            System.out.println("正在播放" + media.type() + media.fileName);
            media.play();
        }
    }
}

/** wav 音频（扩展示例，本次入口程序未使用） */
class WAV extends Media {

    public WAV(String fileName) {
        super(fileName);
    }

    @Override
    void play() {
        System.out.println(".wav文件");
    }

    @Override
    String type() {
        return ".wav文件";
    }
}

/** flv 视频（扩展示例，本次入口程序未使用） */
class Flv extends Media {

    public Flv(String fileName) {
        super(fileName);
    }

    @Override
    void play() {
        System.out.println(".flv");
    }

    @Override
    String type() {
        return "flv 文件";
    }
}
