package com.downloadedgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter
{
	Handler handler;
	public static boolean[] keyDown = new boolean [4];
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
		for (int i=0;i<4;i++)
			keyDown[i]=false;
	}
	public static boolean shoot=false;
	
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player)
			{
				if(key == KeyEvent.VK_W)keyDown[0]=true;
				if(key == KeyEvent.VK_S) keyDown[1]=true;
				if(key == KeyEvent.VK_A) keyDown[2]=true;
				if(key == KeyEvent.VK_D) keyDown[3]=true;
				
				if(key == KeyEvent.VK_F) {tempObject.setX(300); tempObject.setY(300); }
		}
		 
		if(key == KeyEvent.VK_ESCAPE)	{
			System.exit(1);
		}
		
		
	}
	}
	public void keyReleased(KeyEvent e)
	{
		
		int key = e.getKeyCode();
	
		{
			for(int i = 0; i < handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
			
				if(tempObject.getId() == ID.Player)
				{
					if(key == KeyEvent.VK_W) keyDown[0]=false;
					if(key == KeyEvent.VK_S) keyDown[1]=false; 
					if(key == KeyEvent.VK_A) keyDown[2]=false; 
					if(key == KeyEvent.VK_D) keyDown[3]=false;
					
				if(!keyDown[0] && !keyDown[1]) 	tempObject.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) 	tempObject.setVelX(0);
			}
		}
	}
}}
