
package Main;

import java.io.*;
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
			audio.open();
			audio.addAudioListener(event -> {
				if (event.getType() == AudioEvent.Type.PAUSED) {
					// LL.console("PAUSED");
				}
			});
			AudioSources.put(RefTitleForAudio, audio);
		}
		catch (AudioException exception) {
			exception.printStackTrace();
		}
	}
	
	public void AddAudioSource(File audioFile, String RefTitleForAudio) {
		try {
			Audio audio = new StreamedAudio(audioFile);
			audio.open();
			audio.addAudioListener(event -> {
				if (event.getType() == AudioEvent.Type.PAUSED) {
					// LL.console("PAUSED");
				}
			});
			AudioSources.put(RefTitleForAudio, audio);
		}
		catch (AudioException exception) {
			exception.printStackTrace();
		}
	}
	
	public void PlayAudioSource(String ReferenceName) {
		try {
			AudioSources.get(ReferenceName).play();
		}
		catch (Exception e) {
			AudioSourceNotFound(e);
		}
		
	}
	
	public void StopAudioSourceBeingPlayed(String ReferenceName) {
		try {
			AudioSources.get(ReferenceName).pause();
		}
		catch (Exception e) {
			AudioSourceNotFound(e);
		}
	}
	
	public void unloadAudioSource(String ReferenceName) {
		try {
			if (AudioSources.get(ReferenceName).isPlaying()) {
				AudioSources.get(ReferenceName).pause();
			}
			AudioSources.get(ReferenceName).close();
			AudioSources.remove(ReferenceName);
			
		}
		catch (Exception e) {
			AudioSourceNotFound(e);
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
		try {
			AudioSources.get(ReferenceName).loop();
		}
		catch (Exception e) {
			AudioSourceNotFound(e);
		}
	}
	
	public void ToggleMute() {
		for (Map.Entry<String, Audio> entry : AudioSources.entrySet()) {
			entry.getValue().setMute(!entry.getValue().isMuted());;
		}
	}
	
	public Audio getAudioSourceDirectly(String ReferName) {
		try {
			return AudioSources.get(ReferName);
		}
		catch (Exception e) {
			AudioSourceNotFound(e);
		}
		return null;
	}
	
	public String getPlayingAudio() {
		String ret = "Running Sounds,";
		int amt = 0;
		for (Map.Entry<String, Audio> entry : AudioSources.entrySet()) {
			if (entry.getValue().isPlaying()) {
				amt++;
				ret += "\n\t" + entry.getKey();
			}
		}
		ret += "\nTotal Tracks: " + amt;
		return ret;
	}
	
	public void UnloadAllSounds(boolean YOUSURE) {
		if (YOUSURE == false) return;
		String SourcesToRemove = "";
		for (Map.Entry<String, Audio> entry : AudioSources.entrySet()) {
			SourcesToRemove += entry.getKey() + ":";
		}
		SourcesToRemove = SourcesToRemove.substring(0, SourcesToRemove.length() - 1);
		for (String G : SourcesToRemove.split(":")) {
			unloadAudioSource(G);
		}
	}
	
	private void AudioSourceNotFound(Exception e) {
		// e.printStackTrace();
	}
	
}
