package com.tcg.spit.managers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.tcg.spit.MyConstants;

public class Save implements Serializable {

	private static final long serialVersionUID = 4968544144969652972L;
	
	private int highscore;

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}
	
	public void save(Save s) throws IOException {
		FileHandle file = Gdx.files.local(MyConstants.saveFile);
		OutputStream out = null;
		try {
			file.writeBytes(serialize(s), false);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Save load() throws IOException, ClassNotFoundException {
		Save s = null;
		FileHandle file = Gdx.files.local(MyConstants.saveFile);
		s = (Save) deserialize(file.readBytes());
		return s;
	}
	
	private static byte[] serialize(Object s) throws IOException {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(b);
		out.writeObject(s);
		return b.toByteArray();
	}
	
	private static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream b = new ByteArrayInputStream(bytes);
		ObjectInputStream in = new ObjectInputStream(b);
		return in.readObject();
	}

}
