package Main;

import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class LLS extends Thread implements Runnable {
	/**
	 * THIS CLASS IS AN OBJECT TO HANDLE SOUND
	 * PLEASE BE CAUTIOUS AS IT IS ITS OWN THREAD!!!
	 * 
	 * */
	
	
	
	
	private String filename;				// Music/Sound File Path
	private boolean re;						// Repeat Boolean
	private Clip clip;						// The Clip as a sound Object in itself
	private boolean hasrunbeenrun = false;	// Has the 'run' of this thread been ran?
	private boolean stopped = false;		// Has the sound clip been stopped purposely?
	
	public LLS(String soundName, boolean repeat){
		this.setFilename(soundName);
		this.setRe(repeat); 
	}
	
	
	@Override
	public void run() {
		try {
			hasrunbeenrun = true;
			this.setName(filename);
            URL in = ClassLoader.getSystemResource(filename);
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(in));
            if(re==true){
            	clip.loop(1000);
            	clip.start();
            	return;
            }else{
            	clip.start();
            	return;
            }
        } catch (Exception e) {
        	if(LL.DEV_MODE==true){
        		e.printStackTrace();
        	}else{
        		LL.console("!!! ERR_SOUND_HANDLER !!!");
        	}
        } 
	}
	//============================================================
	public void stopSound(){
		clip.stop();
		stopped = true;
	}
	//==========================================
	public void playSound(){
		if(hasrunbeenrun == false){
			run();
		}else{
			if(stopped==true){
				clip.flush();
				clip.start();
			}else{
				clip.start();
			}
		}
	}
	//============================================================
	

	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public boolean isRe() {
		return re;
	}


	public void setRe(boolean re) {
		this.re = re;
	}
	
	
}

