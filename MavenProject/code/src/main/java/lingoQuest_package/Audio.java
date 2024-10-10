package lingoQuest_package;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * The {@code Audio} class represents an audio file that can be played.
 * It provides functionality to load an audio file, play it, and access details such as name and description.
 * <p>
 * @author Alok Patel
 */
public class Audio {
    private File audio;
    private String name;
    private String description;
    private Clip clip;

    /**
     * Default constructor that initializes an empty {@code Audio} object.
     */
    public Audio() {
    }

    /**
     * Parameterized constructor to initialize the {@code Audio} object with name, description, and audio file.
     *
     * @param name        the name of the audio
     * @param description the description of the audio
     * @param audio       the audio file to be played
     */
    public Audio(String name, String description, File audio) {
        this.name = name;
        this.description = description;
        this.audio = audio;
    }

    /**
     * Returns the audio file.
     *
     * @return the {@code File} object representing the audio
     */
    public File getAudio() {
        return audio;
    }

    /**
     * Sets the audio file.
     *
     * @param audio the {@code File} object representing the audio
     */
    public void setAudio(File audio) {
        this.audio = audio;
    }

    /**
     * Plays the audio file if valid. Outputs a message if the file is invalid or cannot be played.
     */
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

    /**
     * Returns the name of the audio.
     *
     * @return the name of the audio
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the audio.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the audio.
     *
     * @return the description of the audio
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the audio.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Main method to test the {@code Audio} class functionality.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an Audio object without an actual audio file
        Audio audio = new Audio("Test Audio", "This is a test description.", null);

        // Test getting name and description
        System.out.println("Audio Name: " + audio.getName());
        System.out.println("Audio Description: " + audio.getDescription());

        // Attempt to play (should handle invalid file scenario)
        audio.play();  // This should output "Invalid file."

        // Test stop and loop functionality even though no file is set
        
    }
}
