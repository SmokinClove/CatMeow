/**
 * deprecated
**/
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MeowMouseListener extends MouseAdapter{
    private int screenX, screenY;
    private Cat cat;
    MeowMouseListener(Cat cat){
    	this.cat = cat;
    }
    
	public void mouseClicked(MouseEvent e) {
		 screenX = e.getXOnScreen();
		 screenY = e.getYOnScreen();
	     System.out.println("screen(X,Y) = " + screenX + "," + screenY);
	     cat.meow();
	}
	
	int getY(){
		return screenY;
	}
    
	int getX(){
		return screenX;
	}
}