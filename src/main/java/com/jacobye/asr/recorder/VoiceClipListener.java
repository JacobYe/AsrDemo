package com.jacobye.asr.recorder;

import javax.sound.sampled.AudioInputStream;

/**
 * Created by jacobye on 2017/6/23.
 */
public interface VoiceClipListener {

    /**
     * 捕捉到的音频流
     *
     * @param ais
     */
    public void captureClip(AudioInputStream clipAIS);
}
