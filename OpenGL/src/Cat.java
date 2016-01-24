import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.Animator;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame; 
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.applet.*;
import sun.audio.*;
public class Cat extends GLJPanel implements MouseListener, GLEventListener{
	private static final long serialVersionUID = 1L;
	private JLabel DrawArea;
	JFrame frame;
	private double theta = 0;
    private double s = 0;
    private double c = 0;
    MeowMouseListener Meow = new MeowMouseListener(this);
	public Cat(){
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        //GLCanvas canvas = new GLCanvas(caps);
		DrawArea = new JLabel();
		add(DrawArea);
		this.addMouseListener(Meow);
		addMouseListener(this); 
	    frame = new JFrame();
	    this.setOpaque(true);
	    frame.setContentPane(this);  // or frame.setContentPane(canvas);
	   // frame.getContentPane().add(this);
	    //canvas.addGLEventListener(this);
	    this.addGLEventListener(this);
	    frame.setTitle("Meow World!");//<-- not shown =(
	    frame.setSize(500, 500);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.setResizable(false);
        this.requestFocusInWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	    Animator animator = new Animator(this);
	  //  animator.add(canvas);
	    animator.start();     
	}

	
	
    private void update() {
   	    theta += 0.01;
        s = Math.sin(theta);
        c = Math.cos(theta);
    }
    private void render(GLAutoDrawable drawable) {
    	System.out.println(theta);
   	    GL2 gl = drawable.getGL().getGL2();
   	    mydisplay2(gl, (float)theta);
   	}

	
	@Override
	 public void init(GLAutoDrawable drawable) {		
    	 drawable.getGL().setSwapInterval(1);
    	 GL2 gl = drawable.getGL().getGL2();
    	 mydisplay(gl);
		//update();
		//render(drawable);
    }
	public static void main(String[] args){
		new Cat(); 
	}
	void mydisplay(GL2 gl) {
	    gl.glClearColor((float)0.0, (float)0.6, (float)1.0, (float)1.0);
	    gl.glClear(GL2.GL_COLOR_BUFFER_BIT );
	    gl.glColor3f((float)0.25, (float)0.25,(float) 0.25);
	    earRight(gl);
	    earLeft(gl);
	    gl.glScalef((float)0.9, (float)0.9, (float)1.0);
	    gl.glColor3f((float)1.0, (float)0.6,(float) 1.0);
	    earRight(gl);
	    gl.glColor3f((float)1.0, (float)0.6,(float) 1.0);
	    earLeft(gl);
	    gl.glScalef((float)1.11, (float)1.11, (float)1.0);
	    gl.glColor3f((float)0.0, (float)0.0,(float) 0.0);
	    shiftEllipse(gl, (float)0.8, (float)0.8, 0, 360,(float) 0.0,(float) 0.0);
	    gl.glColor3f((float)1.0, (float)1.0,(float) 1.0);
	    drawMouth(gl);
	    //drawEyes(gl);
	    drawOpenEyes(gl);
	    gl.glColor3f((float)0.75, (float)0.75,(float) 0.75);
	    leftWiskers(gl);
	    rightWiskers(gl);
	    
	    //drawWhiskersRight(0.6);
	    //drawWhiskersRight(-0.6);
	   
	    gl.glFlush();
	}
	
	void mydisplay2(GL2 gl, float theta) {
		//System.out.println(theta);
	    gl.glClearColor((float)(0.0), (float)(0.6), (float)(1.0), (float)1.0);
	    gl.glClear(GL2.GL_COLOR_BUFFER_BIT );
	    gl.glColor3f((float)0.25, (float)0.25,(float) 0.25);
	    earRight(gl);
	    earLeft(gl);
	    gl.glScalef((float)0.9, (float)0.9, (float)1.0);
	    gl.glColor3f((float)1.0, (float)0.6,(float) 1.0);
	    earRight(gl);
	    gl.glColor3f((float)1.0, (float)0.6,(float) 1.0);
	    earLeft(gl);
	    gl.glScalef((float)1.11, (float)1.11, (float)1.0);
	    gl.glColor3f((float)0.0, (float)0.0,(float) 0.0);
	    shiftEllipse(gl, (float)0.8, (float)0.8, 0, 360,(float) 0.0,(float) 0.0);
	    gl.glColor3f((float)1.0, (float)1.0,(float) 1.0);
	    drawMouth(gl);
	    //drawEyes(gl);
	    //drawOpenEyes(gl);
	    gl.glColor3f((float)0.75, (float)0.75,(float) 0.75);
	    leftWiskers(gl);
	    rightWiskers(gl);
	    
	    //drawWhiskersRight(0.6);
	    //drawWhiskersRight(-0.6);
	   
	    gl.glFlush();
	}

	void leftWiskers(GL2 gl) {
	    gl.glBegin(GL.GL_LINES);
	        gl.glVertex2f((float)0.6,(float) 0);
	        gl.glVertex2f((float)0.85, (float)-0.01);
	        gl.glVertex2f((float)0.6, (float)-0.1);
	        gl.glVertex2f((float)0.83, (float)-0.12);
	        gl.glEnd();
	}
	
	void rightWiskers(GL2 gl) {
	    gl.glBegin(GL.GL_LINES);
	        gl.glVertex2f((float)-0.6,(float) 0);
	        gl.glVertex2f((float)-0.85, (float)-0.01);

	        gl.glVertex2f((float)-0.6, (float)-0.1);
	        gl.glVertex2f((float)-0.83, (float)-0.12);
	        gl.glEnd();
	}
	
	void earLeft(GL2 gl) {
	    gl.glBegin(GL.GL_TRIANGLES);
	        gl.glVertex2f((float)-0.77,(float) 0.22);
	        gl.glColor3f((float)0.25, (float)0.25,(float) 0.25);
	        gl.glVertex2f((float)-1.0,(float) 1.0);
	        gl.glColor3f((float)0.0, (float)0.0,(float) 0.0);
	        gl.glVertex2f((float)-0.25,(float) 0.76);
	    gl.glEnd();
	}
	
	void earRight(GL2 gl) {
		 gl.glBegin(GL.GL_TRIANGLES);
		    //gl.glColor3f((float)0.0, (float)0.0,(float) 0.0);
	        gl.glVertex2f((float)0.25,(float) 0.76);
	        gl.glColor3f((float)0.25, (float)0.25,(float) 0.25);
	        gl.glVertex2f((float)1.0,(float) 1.0);
	        gl.glColor3f((float)0.0, (float)0.0,(float) 0.0);
	        gl.glVertex2f((float)0.77,(float) 0.22);
	    gl.glEnd();
	}
	void shiftEllipse(GL2 gl, float radiusX, float radiusY, int startDeg, 
		    int endDeg, float xPos, float yPos) {
		    gl.glTranslatef(xPos, yPos, 0);
		    drawEllipse(gl, radiusX, radiusY, startDeg, endDeg);
		    gl.glLoadIdentity();
		}

		void drawEllipse(GL2 gl, float radiusX, float radiusY, int startDeg, int endDeg){
		    int i;
		    //gl.glColor3f((float)1.0, (float)0.0,(float) 1.0);
		    float DEG2RAD = (float) (3.14159 / 180.0);

		    gl.glBegin(GL.GL_TRIANGLE_FAN);

		    for (i = startDeg; i<endDeg; i++)
		    {
		        float rad = i*DEG2RAD;
		        gl.glVertex2f((float)Math.cos(rad)*radiusX,
		        		(float)Math.sin(rad)*radiusY);
		    }

		    gl.glEnd();
		}

		void shiftCircle(GL2 gl, float xTrans, float yTrans, float radius, 
		    int startDeg, int endDeg) {
		    gl.glTranslatef(xTrans, yTrans, 0);
		    circle(gl, radius, startDeg, endDeg);
		    gl.glLoadIdentity();
		}

		void circle(GL2 gl,float radius, int startDeg, int endDeg) {
		    //glClearColor(1.0, 1.0, 1.0, 0.0);
		    //glClear(GL_COLOR_BUFFER_BIT);
		    gl.glBegin(GL.GL_LINE_STRIP);
		    for (int i = startDeg; i < endDeg; i++) {
		        float theta = (float) (i * 3.14159 / 180);
		        float y = (float) (radius * Math.sin(theta));
		        float x = (float) (radius * Math.cos(theta));
		        gl.glVertex2f(x, y);
		    }
		    gl.glEnd();
		    gl.glFlush();
		}
	void drawEyes(GL2 gl) {
	    shiftCircle(gl,(float)0.3, (float)0.1, (float)0.1, 0, 180);
	    shiftCircle(gl,(float)-0.3,(float) 0.1,(float) 0.1, 0, 180);
	}
	
	
	void drawOpenEyes(GL2 gl){
		drawSingleEye(gl, (float)0.4, (float)0.2, (float)0.2);
		drawSingleEye(gl, (float)-0.4, (float)0.2, (float)0.2);
	}

	void drawSingleEye(GL2 gl, float x, float y, float r) {
	    shiftCircle(gl,(float)x, (float)y, (float)r, 0, 360);
	    shiftCircle(gl,(float)(x + r), (float)(y), (float)(r*1.5), 135, 225);
	    shiftCircle(gl,(float)(x - r), (float)(y), (float)(r*1.5), -45, 45);
	}
	
	void drawMouth(GL2 gl) {
	    shiftCircle(gl,(float) 0.14,(float) -0.2,(float) 0.14, 180, 360);
	    shiftCircle(gl,(float) -0.14, (float)-0.2,(float) 0.14, 180, 360);
	    gl.glColor3f((float)1.0, (float)0.8,(float) 0.0);
	    shiftEllipse(gl,(float) 0.08,(float) 0.05, 0, 360,(float) 0.0, (float)-0.15);
	    gl.glColor3f((float)1.0, (float)1.0,(float)1.0);
	}

	void restoreAxis(GL2 gl) {
	    gl.glTranslatef((float)0.0,(float) 0.0, (float)0.0);
	}
	/*
	public void meow(){
		try {
	         // Open an audio input stream.
	        // URL url = frame.getClass().getClassLoader().getResource("/Computer/D:/Kitten Meow-SoundBible.com-1295572573.wav");
			// URL url = this.getClass().getResource("Kitten Meow.wav");
			Clip clip = AudioSystem.getClip();
			 AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("D:/IMPORTANT WINDOWS STUFFS/NUS stuffs/SEM3/Eclipse/OpenGL/src/KittenMeow.wav"));
	         float samplingRate = audioIn.getFormat().getSampleRate();
	         System.out.println(samplingRate);
	         byte[] samples = new byte[1024*862];
	         audioIn.read(samples);
	         System.out.println(samples.length);
	         System.out.println(Meow.getY());
	         save("KittenMeow.wav", samples, samplingRate * (Meow.getY()/1000));
			 // Get a sound clip resource.
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(AudioSystem.getAudioInputStream(new File("D:/IMPORTANT WINDOWS STUFFS/NUS stuffs/SEM3/Eclipse/OpenGL/src/KittenMeow(1).wav")));
	         clip.start();
	         File f = new File("D:/IMPORTANT WINDOWS STUFFS/NUS stuffs/SEM3/Eclipse/OpenGL/src/KittenMeow(1).wav");
	         f.delete();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }   
	}
	*/
	public void meow(){
		try {
	         // Open an audio input stream.
	        // URL url = frame.getClass().getClassLoader().getResource("/Computer/D:/Kitten Meow-SoundBible.com-1295572573.wav");
			// URL url = this.getClass().getResource("Kitten Meow.wav");
			Clip clip = AudioSystem.getClip();
			 //AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("D:/IMPORTANT WINDOWS STUFFS/NUS stuffs/SEM3/Eclipse/OpenGL/src/KittenMeow.wav"));
			 AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(System.getProperty("user.dir") + "/src/KittenMeow.wav"));
			 clip.open(audioIn);
			 clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }   
	}
//taken from http://introcs.cs.princeton.edu/java/stdlib/StdAudio.java.html
	public static void save(String filename, byte[] samples, float sampleRate) {

        // assumes 44,100 samples per second
        // use 16-bit audio, mono, signed PCM, little Endian
        AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, false);
        /*
        byte[] data = new byte[2 * samples.length];
        for (int i = 0; i < samples.length; i++) {
            int temp = (short) (samples[i] * Short.MAX_VALUE);
            data[2*i + 0] = (byte) temp;
            data[2*i + 1] = (byte) (temp >> 8);
        }
*/
        // now save the file
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(samples);
            AudioInputStream ais = new AudioInputStream(bais, format, samples.length);
            if (filename.endsWith(".wav") || filename.endsWith(".WAV")) {
                AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("D:/IMPORTANT WINDOWS STUFFS/NUS stuffs/SEM3/Eclipse/OpenGL/src/KittenMeow(1).wav"));
            }
            else if (filename.endsWith(".au") || filename.endsWith(".AU")) {
                AudioSystem.write(ais, AudioFileFormat.Type.AU, new File(filename + "(1)"));
            }
            else {
                throw new RuntimeException("File format not supported: " + filename);
            }
        }
        catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	
/**
 * non-functional methods
**/
	@Override
	public void mouseEntered(MouseEvent e) {
        
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void display(GLAutoDrawable arg0) {
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
	}
}



