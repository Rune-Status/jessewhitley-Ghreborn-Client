package com.Ghreborn.client.net;

import com.Ghreborn.client.Main;

/**
 * Requests to download cache files in the background
 * from the File-Server.
 * @author Professor Oak
 */
public class BackgroundRequester implements Runnable {

	@Override
	public void run() {
		try {
			
			//The file type
			for(int type = 0; type < 5; type++) {
				
				//The file
				for(int file = 0; file < getAmountToDownload(type); file++) {
					
					//Request the file
					if(Main.onDemandFetcher != null) {
						Main.onDemandFetcher.method558(type, file);
					}
					
					//Sleep
					Thread.sleep(120);
				}
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getAmountToDownload(int type) {
		switch(type) {
		case 0: //Models
			return 35754;
		case 1: //anims
			return 2130;
		case 2: //midi's
			return 646; 
		case 3: //Maps
			return 3535;
		case 4:
			return 0;
		}
		return 0;
	}
}