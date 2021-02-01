package com.semanticsquare.thrillio;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

public class Launch {
    
	/*private static List<List<Bookmark>> bookmarks;
	private static List<User> users;
	private static void loadData() {
		System.out.println("Loading data...");
		DataStore.loadData();
		users = UserManager.getInstance().getUsers();
		bookmarks =BookmarkManager.getInstance().getBookmarks();
		//System.out.println("printing user data...");
		//printUserData();
		//printBookmarkData();
		
	}
	/*private static void printBookmarkData() {
		for(Bookmark[] bookmarkList:bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
			
		}
		
	}
	private static void start() {
		System.out.println("Bookmarking...");
		for(User user:users) {
			View.browse(user, bookmarks);
		}
		
	}*/
	public static void  main(String[] args) {
		//loadData();
		//start();
		Collection<Bookmark> list=BookmarkManager.getInstance().getBooks(false,5);
		System.out.println(list);
		//System.out.println(list);
		//return list;


	}
	
	
	/*private static void printUserData() {
		for(User user:users) {
			System.out.println(user);
		}
		
	}*/

	
}
