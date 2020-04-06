package miniProject.mine.run;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//  음악재생 
// 출처 : https://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java
public class PlayMusic {
	
	PlayMusic(String fileName){
		try {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(fileName)));
	        clip.start();
	    } catch (Exception e) {
	        e.printStackTrace(System.out);
	    }
	}
}
