

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String args[]){
    	Album album = new Album("Best of Arjit Singh", "Arjit Singh");
    	album.addSong("Tere bina", 4.56);
    	album.addSong("Raabta", 4.56);
    	album.addSong("lla", 4.56);
    	album.addSong("Tere bina", 4.56);
    	album.addSong("Tere bina", 4.56);
    	album.addSong("Tere bina", 4.56);
    	album.addSong("Tere bina", 4.56);
    	albums.add(album);

        album = new Album("Best of Sonu Nigham", "Sonu Nigham");
    	album.addSong("kal ho na ho", 4.56);
    	album.addSong("hjk", 4.56);
    	album.addSong("lla", 4.56);
    	album.addSong("Tere bina", 4.56);
    	album.addSong("Tere bina", 4.56);
    	album.addSong("Tere bina", 4.56);
    	album.addSong("Tere bina", 4.56);

    	albums.add(album);

    	LinkedList<Song> playlist = new LinkedList<Song>();
    	albums.get(0).addToPlaylist("Raabta",playlist);
    	albums.get(0).addToPlaylist("Tere Bina",playlist);
    	albums.get(0).addToPlaylist("lla",playlist);
    	albums.get(1).addToPlaylist(3,playlist);
    	albums.get(1).addToPlaylist(2,playlist);
    	albums.get(1).addToPlaylist(1,playlist);
    	albums.get(1).addToPlaylist(10,playlist);

    	play(playlist);
    }

    private static void play(LinkedList<Song> playlist){
    	Scanner scanner = new Scanner(System.in);
    	boolean quit = false;
    	boolean forward = true;
    	ListIterator<Song> listIterator = playlist.listIterator();
    	if(playlist.size() == 0){
    		System.out.println("No songs");
    		return;
    	}
    	System.out.println("Now playing =>" + listIterator.next());
    	printMenu();

    	while(!quit){
    		int action = scanner.nextInt();
    		scanner.nextLine();
    		switch(action){
    			case 0:
    				System.out.println("Hope you enjoyed");
    				quit = true;
    				break;
    			case 1:
    				if(!forward){
    					if(listIterator.hasNext()){
    						listIterator.next();
    					}
    					forward = true;
    				}
    				if(listIterator.hasNext()){
    					System.out.println("Now Playing +>" + listIterator.next());
    				}else{
    					System.out.println("We have reached end");
    					forward = false;
    				}
    				break;
    			case 2:
    				if(forward){
    					if(listIterator.hasPrevious()){
    						listIterator.previous();
    					}
    					forward = false;
    				}
    				if(listIterator.hasPrevious()){
    					System.out.println("Now Playing +>" + listIterator.previous());
    				}else{
    					System.out.println("We have reached start");
    					forward = true;
    				}
    				break;
    			case 3:
    				if(forward){
    					if(listIterator.hasPrevious()){
    						System.out.println("Replaying " +listIterator.previous());
    						forward = false;
    					}else{
    						System.out.println("You are at the start");
    					}
    				}else{
    					if(listIterator.hasNext()){
    						System.out.println("Replaying " +listIterator.next());
    						forward = true;
    					}else{
    						System.out.println("You are at the end");
    					}
    				}
    				break;
    			case 4:
    				printPlaylistSongs(playlist);
    				break;
    			case 5:
    				printMenu();
    				break;
    			case 6:
    				break;
    		}
    	}
    }
    private static void printMenu(){
    	System.out.println("Available Options:");
    	System.out.println( "0. to quit\n"+
    						"1. play next\n" +
    						"2. play previous\n" +
    						"3. replay the current\n"+
    						"4. list all songs in playlist\n" +
    						"5. print menu again\n" +
    						"6. delete the current song");
    }

    public static void printPlaylistSongs(LinkedList<Song> playlist){
    	Iterator<Song>iterator = playlist.iterator();
    	System.out.println("=============================================");
    	while(iterator.hasNext()){
    		System.out.println(iterator.next());
    	}
    	System.out.println("=============================================");
    }
}
