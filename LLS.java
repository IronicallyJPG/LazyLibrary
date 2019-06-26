
package Main;

import java.util.*;

import audio.*;

public class LLS {
	/**
	 * NONE OF THIS WOULD BE POSSIBLE WITHOUT SimpleAudio BY:
	 * 'https://github.com/RalleYTN/SimpleAudio'
	 */
	public LLS() {
		LL.LL_LINK();
	}
	
	private HashMap<String, Audio> AudioSources = new HashMap<String, Audio>();
	
	public void AddAudioSource(String audioFilePath, String RefTitleForAudio) {
		try {
			Audio audio = new StreamedAudio(audioFilePath);
			audio.addAudioListener(event -> {
				
			});
			audio.open();
			AudioSources.put(RefTitleForAudio, audio);
		}
		catch (AudioException exception) {
			exception.printStackTrace();
		}
	}
	
	public void PlayAudioSource(String ReferenceName) {
		AudioSources.get(ReferenceName).play();
	}
	
	public void StopAudioSourceBeingPlayed(String ReferenceName) {
		AudioSources.get(ReferenceName).stop();
	}
	
	public void unloadAudioSource(String ReferenceName) {
		if (AudioSources.get(ReferenceName).isPlaying()) {
			LL.console("MUST STOP AUDIO BEFORE REMOVAL");
		}
		else {
			AudioSources.get(ReferenceName).close();
			AudioSources.remove(ReferenceName);
		}
	}
	
	public void setVolume(float VOL) {
		for (Map.Entry<String, Audio> entry : AudioSources.entrySet()) {
			entry.getValue().setVolume(VOL);
		}
	}
	
	public void Debug_ShowOpenAudioSources() {
		for (Map.Entry<String, Audio> entry : AudioSources.entrySet()) {
			LL.console(entry.getKey());
		}
	}
	
	public void setAudioSourceToLoop(String ReferenceName) {
		AudioSources.get(ReferenceName).loop();
	}
	
}
