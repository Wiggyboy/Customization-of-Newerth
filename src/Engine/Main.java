package Engine;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import Doodads.LLFile;
import Doodads.LLLogger;
import Doodads.LLOutputStream;


public class Main {
	public static void main(String[] args) {
		new Main();
	}
	//STATIC variables;
	public static final String NAME		= "Customization of Newerth";
	public static final String BRANCH	= "The New Age";
	public static final String VERSION	= "3.0.0.4";
	public static final String PATH		= System.getenv("APPDATA")+File.separator+"Lindholm"+File.separator+NAME+File.separator;
	
	//Variables;
	public	LLLogger	log;
	public	Config		config;
	public	Gui			gui;
	
	//Setup;
	
	//Constructor;
	public Main() {
		try {
			log = new LLLogger("["+VERSION+"]",new File(PATH+"console.log"));
			log.print(NAME+" - "+BRANCH+" - "+VERSION);
			log.print("Successfully establish log to "+PATH+"console.log");
		} catch (IOException e) {
			log = new LLLogger("["+VERSION+"]");
			log.print(NAME+" - "+BRANCH+" - "+VERSION);
			log.print(e,"Failed to establish log to "+PATH+"console.log");
		}
		
		config = new Config(this);
		gui = new Gui(this);
		
		if(config.property.getProperty("update",true)) {
			gui.actionPerformed(new ActionEvent(new Object(),0,Gui.ACTION_UPDATE+""));
		}
		while(gui.run.isAlive()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				log.print(e,"Well I'll be damned!");
			}
		}
		if(config.property.getProperty("refresh",true)) {
			gui.actionPerformed(new ActionEvent(new Object(),0,Gui.ACTION_REFRESH+""));
		}
	}
	//Set;
	
	//Get;
	
	//Add;
	
	//Remove;
	
	//Do;
	
	//Other;
	public void exit() {
		try {
			config.property.save("test");
		} catch (IOException e) {
			this.log.print(e,"Failed to output config to \""+Main.PATH+"config.ini"+"\"");
		}
		System.exit(0);
	}
	
	//Implements;
	
}