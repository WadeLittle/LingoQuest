package lingoQuest_package;

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

    // Default constructor
    public Video() {
        this.name = "";
        this.description = "";
        this.video = null;
    }

    // Parameterized constructor
    public Video(String name, String description, File video) {
        this.name = name;
        this.description = description;
        this.video = video;
    }

    // Getter for the video file
    public File getVideo() {
        return video;
    }

    // Setter for the video file
    public void setVideo(File video) {
        this.video = video;
    }

    // Method to play the video using JavaFX
    public void play() {
        if (video == null || !video.exists()) {
            System.out.println("Invalid video file.");
            return;
        }

        // Initialize JavaFX platform
        new Thread(() -> {
            Platform.startup(() -> {
                Stage stage = new Stage();

                // Convert the File to a URI that JavaFX Media can handle
                Media media = new Media(video.toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);

                // Create a scene with the MediaView
                StackPane root = new StackPane(mediaView);
                Scene scene = new Scene(root, 640, 480);

                // Set up the stage
                stage.setTitle("Playing video: " + name);
                stage.setScene(scene);
                stage.show();

                // Play the media
                mediaPlayer.play();

                // Handle window close event to stop the player
                stage.setOnCloseRequest(e -> {
                    mediaPlayer.stop();
                    Platform.exit();
                });
            });
        }).start();
    }
}
