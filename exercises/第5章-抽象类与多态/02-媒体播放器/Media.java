/**
 * 媒体（介质）抽象类：代表可以插入播放器的各种文件。
 *
 * 子类：Mp（mp3）、Mm（mp4）、Nulldia（空介质占位）、
 *       WAV、Flv（扩展示例，见 Player.java）。
 *
 * 抽象类里既可以有已实现的成员（fileName、构造方法），
 * 也可以有只声明不实现的方法（play()、type()）。
 */
abstract class Media {

    /** 文件名，例如 "song.mp3"；protected 供子类访问 */
    protected String fileName;

    /** 构造方法：创建介质时保存文件名 */
    Media(String fileName) {
        this.fileName = fileName;
    }

    /** 播放动作，由具体介质实现 */
    abstract void play();

    /** 返回介质类型，由具体介质实现 */
    abstract String type();
}
