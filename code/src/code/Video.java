package code;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.application.Platform;

public class Video {
    private File video;
    private String description;
    private String name;

    public Video() {
        this.name = "";
        this.description = "";
        this.video = null;
    }

    public Video(String name, String description) {
        this.name = name;
        this.description = description;
        this.video = null;
    }

    public File getVideo() {
        return video;
    }

    public void setVideo(File video) {
        this.video = video;
    }

    public void play() {
        
}
}
