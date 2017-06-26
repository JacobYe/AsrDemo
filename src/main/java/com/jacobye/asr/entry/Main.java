package com.jacobye.asr.entry;


import com.jacobye.asr.recognizer.AliyunRecognizer;
import com.jacobye.asr.recorder.CaptureVoice;
import com.jacobye.asr.recorder.VoiceClipListener;
import com.jacobye.asr.recorder.VoiceLevelListener;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by jacobye on 2017/6/23.
 */
public class Main {

    public static void main(String[] args) throws LineUnavailableException {
        final CaptureVoice captureVoice = new CaptureVoice();
		/*
		 * 监听声音大小变化
		 */
        captureVoice.levelListener = new VoiceLevelListener() {
            public void captureLevel(int level) {
                System.out.println(level);
            }
        };
		/*
		 * 监听到声音片段
		 */
        captureVoice.clipListener = new VoiceClipListener() {
            public void captureClip(AudioInputStream clipAIS) {
//                AudioSystem.write(
//                        clipAIS
//                        , AudioFileFormat.Type.WAVE
//                        ,new File("test.wav"));
//                AudioSystem.write(clipAIS)

//				/*
//				 * convert waveStream to flacStream
//				 */
//                ByteArrayOutputStream flacOS = new ByteArrayOutputStream();
//                FlacEncoder flacEncoder = new FlacEncoder();
//                try {
//                    flacEncoder.convertWaveToFlac(clipAIS, new FLACStreamOutputStream(flacOS));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

				/*
				 * 语音识别
				 */
                AliyunRecognizer recognizer = new AliyunRecognizer();
                recognizer.startAsr(clipAIS);
                recognizer.shutDown();
//                Recognizer recognizer = new Recognizer();
//                GoogleResponse response = null;
//                try {
//                    response = recognizer.getRecognizedDataForFlac(flacOS.toByteArray());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                if(response != null) {
//                    System.out.println(response.getResponse() + " " + response.getConfidence());
//                }
            }
        };

        captureVoice.start();

        captureVoice.stop();
    }

}
