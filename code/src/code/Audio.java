package code;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    private File audio;
    private String name;
    private String description;
    private Clip clip;

    // Default constructor
    public Audio() {
    }

    // Parameterized constructor
    public Audio(String name, String description, File audio) {
        this.name = name;
        this.description = description;
        this.audio = audio;
    }

    // Getter for audio file
    public File getAudio() {
        return audio;
    }

    // Setter for audio file
    public void setAudio(File audio) {
        this.audio = audio;
    }

    // Method to play the audio file
    public void play() {
        if (audio == null) {
            System.out.println("Invalid file.");
            return;
        }

        try {
            // Get an audio input stream from the file
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
            
            // Obtain the clip
            clip = AudioSystem.getClip();
            
            // Open the clip with the audio stream
            clip.open(audioStream);
            
            // Start playing the audio
            clip.start();

            System.out.println("Playing: " + name);
            
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio format.");
        } catch (IOException e) {
            System.out.println("Error playing the file.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable.");
        }
    }

    // Method to stop the audio
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    // Method to loop the audio
    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create an Audio object without an actual audio file
        Audio audio = new Audio("Test Audio", "This is a test description.", null);

        // Test getting name and description
        System.out.println("Audio Name: " + audio.getName());
        System.out.println("Audio Description: " + audio.getDescription());

        // Attempt to play (should handle invalid file scenario)
        audio.play();  // This should output "Invalid file."

        // Test stop and loop functionality even though no file is set
        audio.stop();
        audio.loop();
    }
}

