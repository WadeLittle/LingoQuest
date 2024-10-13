package lingo_quest;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.application.Platform;

/**
 * The {@code Video} class represents a video file and provides methods to set, get, and play the video using JavaFX.
 * <p>
 * The class includes constructors to initialize the video with a name, description, and file, along with methods to manage and play the video.
 * </p>
 * 
 * @author Alok Patel
 */
public class Video {
    private File video;
    private String description;
    private String name;

    /**
     * Default constructor that initializes the video fields to default values.
     */
    public Video() {
        this.name = "";
        this.description = "";
        this.video = null;
    }

    /**
     * Parameterized constructor that initializes the video with a name, description, and file.
     * 
     * @param name        the name of the video
     * @param description a brief description of the video
     * @param video       the video file to be played
     */
    public Video(String name, String description, File video) {
        this.name = name;
        this.description = description;
        this.video = video;
    }

    /**
     * Gets the video file.
     * 
     * @return the {@code File} object representing the video
     */
    public File getVideo() {
        return video;
    }

    /**
     * Sets the video file.
     * 
     * @param video the {@code File} object representing the video
     */
    public void setVideo(File video) {
        this.video = video;
    }

    /**
     * Plays the video file using JavaFX. The method checks if the video file is valid before starting the JavaFX application to play the video.
     */
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

