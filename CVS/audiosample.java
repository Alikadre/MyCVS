import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
public class audiosample extends JFrame
{
	AudioInputStream audioin;
	public audiosample()
	{
		try
		{
			File soundfile=new File("beep.wav");
			audioin=AudioSystem.getAudioInputStream(soundfile);
			Clip clip=AudioSystem.getClip();
			clip.open(audioin);
			clip.start();
		new voting();
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
	}
	public static void main(String[] args) 
	{
		new audiosample();
	}
}
