package Java;

import java.awt.EventQueue;

import Java.CombineCSV.CombineCSV;
import Java.Screens.FirstScreen;
import Java.HandleCSV.CompleteStoreCSV;
import Java.HandleCSV.ReadCSV;
import Java.HandleCSV.Sort;

public class Main {
	public static void main(String[] args) {
		String[][] spotifyAndYoutubeData = CompleteStoreCSV.completeSpotifyAndYoutubeCSV();
		String[][] topSpotifySongsData = CompleteStoreCSV.completeTopSpotifySongs();
		String[][] songData = CombineCSV.combineCSV();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstScreen frame = new FirstScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}