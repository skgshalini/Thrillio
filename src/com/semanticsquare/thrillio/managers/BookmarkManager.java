package com.semanticsquare.thrillio.managers;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.MovieGenre;
//import com.semanticsquare.thrillio.controllers.Inetger;
import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.WebLink;
import java.util.*;

/*public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	
	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {

		return instance;
	}
	private static BookmarkDao dao=new BookmarkDao();
	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, MovieGenre genre, double imdbRating) {

		Movie movie = new Movie();

		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setImdbRating(imdbRating);
        movie.setGenre(genre);
		return movie;

	}
	
	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors,
		BookGenre genre,	double amazonRating) {

		Book book = new Book();

		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setAmazonRating(amazonRating);
        book.setGenre(genre);
		return book;

	}
	
	public WebLink createWebLink(long id, String title, String url, String host) {

		WebLink weblink = new WebLink();

		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;

	}
	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userbookmark=new UserBookmark();
		userbookmark.setBookmark(bookmark);
		userbookmark.setUser(user);
		dao.saveUserBookmark(userbookmark);
		
	}

	public void setKidFriendlyStatus(User user,  KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
        System.out.println("Kid Friendly Status: "+kidFriendlyStatus+", marked by: "+
		user.getEmail()+" ,"+bookmark);
		
	}

	public void share(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared..");
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		}
		else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());}
	}

}*/public class BookmarkManager {
	// also implements Singleton pattern
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, MovieGenre genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	public Book createBook(long id, String title,String imageUrl,  int publicationYear, String publisher,
			String[] authors, BookGenre genre, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		//book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
        book.setImageUrl(imageUrl);
		return book;
	}

	public WebLink createWebLink(long id, String title, String profileUrl, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;
	}

	public List< List<Bookmark>> getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyChoice, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyChoice);
		bookmark.setKidFriendlyMarkedBy(user);
		
		dao.updateKidFriendlyStatus(bookmark);
		System.out.println("Kid friendly status: "+ kidFriendlyChoice + ", Marked by: "+ user.getEmail() + ", "+ bookmark);
	}

	public static void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared: ");

		if(!(bookmark instanceof Movie)) dao.updateSharedBy(bookmark);
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());	
		}
		else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());	
		}
		
	}

	public Collection<Bookmark> getBooks(boolean isBookmarked, long id) {
		// TODO Auto-generated method stub
		return dao.getBooks(isBookmarked,id);
		
	}

	

	public Bookmark getBook(long bid) {
		// TODO Auto-generated method stub
		return dao.getBook(bid);
	}

}
