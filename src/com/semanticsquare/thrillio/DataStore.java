package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.constants.Gender;
import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.util.*;
//public class DataStore {
/*public static int USER_BOOKMARK_LIMIT=5;
public static int BOOKMARK_COUNT_PER_TYPE=5;
public static int BOOKMARK_TYPES_COUNT=3;
public static int TOTAL_USER_COUNT=5;
private static User[] users=new User[TOTAL_USER_COUNT];
public static User [] getUsers() {
	return  users;
}
private static Bookmark[][] bookmarks=new Bookmark [BOOKMARK_TYPES_COUNT][ BOOKMARK_COUNT_PER_TYPE];
public static Bookmark[] [] getBookmarks() {
	return  bookmarks;
}
private static UserBookmark[] userBookmarks=new UserBookmark[TOTAL_USER_COUNT*USER_BOOKMARK_LIMIT];
private static int  bookmarkIndex;
public static UserBookmark [] getUserBookmarks() {
	return  userBookmarks;
}

public static void loadData() {
	/*loadUsers();
	loadWebLinks();
	loadMovies();
	loadBooks();
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// Now that we have loaded our driver, let's connect to Database
	// try-with-resources ==> conn & stmt will be closed
	// Connection string: <protocol>:<sub-protocol>:<data-source details>
	// Statement is used for executing the actual queries
	// Connection and Statement are from java.sql package
	try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false");
			Statement stmt = conn.createStatement();) {
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	private static void loadUsers() {
		users[0] = UserManager.getInstance().createUser(1000,"user0@semanticsquare.com","test",	"John",	"M" , Gender.MALE,	"user");
		users[1] = UserManager.getInstance().createUser(1001,"user1@semanticsquare.com","test",	"Sam",	"M" , Gender.MALE,	"user");
		users[2] = UserManager.getInstance().createUser(1002,"user2@semanticsquare.com","test",	"Anita","M" , Gender.FEMALE,"editor");
		users[3] = UserManager.getInstance().createUser(1003,"user3@semanticsquare.com","test",	"Sara",	"M" , Gender.MALE,	"chief_editor");
		users[4] = UserManager.getInstance().createUser(1004,"user4@semanticsquare.com","test",	"Dheeru","M" , Gender.MALE,	"chief_editor");
		
}
	private static void loadWebLinks() {
		bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
		bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001,	"How do I import a pre-existing Java project into Eclipse and get up and running?",	"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running","http://www.stackoverflow.com");
		bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002,	"Interface vs Abstract Class",	"http://mindprod.com/jgloss/interfacevsabstract.html",	"http://mindprod.com");
		bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003,	"NIO tutorial by Greg Travis",	"http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf",	"http://cs.brown.edu");
		bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2004,	"Virtual Hosting and Tomcat",	"http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html","http://tomcat.apache.org");
		

	}
	
	private static void loadMovies() {
		bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",	1941,	new String[] {"Orson Welles","Joseph Cotten"},	new String[] {"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
		bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001,"The Grapes of Wrath","",	1940,	new String[] {"Henry Fonda","Jane Darwell"}, new String[] {"John Ford"},MovieGenre.CLASSICS, 8.2);
		bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002,"A Touch of Greatness","",	2004, new String[] {"Albert Cullum"},new String[] {"Leslie Sullivan"},MovieGenre.DOCUMENTARIES,7.3);
		bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003,"The Big Bang Theory","",	2007, new String[] {"Kaley Cuoco","Jim Parsons"},	new String[] {"Chuck Lorre","Bill Prady"}, MovieGenre.TV_SHOWS,	8.7);
		bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004,"Ikiru","",1952,new String[] {"Takashi Shimura","Minoru Chiaki"}, new String[] {"Akira Kurosawa"},	MovieGenre.FOREIGN_MOVIES,8.4);
	}
	private static void loadBooks() {		    	
		bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
		bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays", 1993, "Dover Publications", new String[] {"Ralph Waldo Emerson"}, BookGenre.PHILOSOPHY, 4.5);
		bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps", 1988, "Touchstone", new String[] {"Lillian Eichler Watson"}, BookGenre.PHILOSOPHY, 5.0);
		bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", 2004, "O'Reilly Media", new String[] {"Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson"}, BookGenre.TECHNICAL, 4.5);
		bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide", 2007, "Prentice Hall", new String[] {"Joshua Bloch"}, BookGenre.TECHNICAL, 4.9);
		
	}

	public static void add(UserBookmark userbookmark) {
		
		userBookmarks[bookmarkIndex]=userbookmark;
		bookmarkIndex++;
	}}*/
	public class DataStore {
		// all our possible users
		private static List<User> users = new ArrayList<>();
		// all our possible bookmarks
		private static List< List<Bookmark>> bookmarks = new ArrayList<>();
		private static List<UserBookmark> userBookmarks = new ArrayList<>();
		// bookmarkCount keeps track of the number of bookmarks a user has chosen

		// getters for users and bookmarks to be called on by Data Access Objects since
		// we have no database
		public static List<User> getUsers() {
			return users;
		}

		public static List< List<Bookmark>> getBookmarks() {
			return bookmarks;
		}

		public static void loadData() {
			// Load JDBC Driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Now that we have loaded our driver, let's connect to Database
			// try-with-resources ==> conn & stmt will be closed
			// Connection string: <protocol>:<sub-protocol>:<data-source details>
			// Statement is used for executing the actual queries
			// Connection and Statement are from java.sql package
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?user=root&password=root");
					//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=rootpassword"); 
					Statement stmt = conn.createStatement();) {
				loadUsers(stmt);
				loadWebLinks(stmt);
				loadBooks(stmt);
				loadMovies(stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		private static void loadUsers(Statement stmt) throws SQLException {
			String query = "select * from User";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				long id = rs.getLong("id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Gender gender = Gender.values()[rs.getInt("gender_id")];
				UserType userType = UserType.values()[rs.getInt("user_type_id")];

				// not necessary but just showing how to get dates
				Date createdDate = rs.getDate("created_date");
				Timestamp timeStamp = rs.getTimestamp("created_date");

				User user = UserManager.getInstance().createUser(id, email, password, firstName, lastName, gender,
						userType);
				users.add(user);
			}
		}

		private static void loadWebLinks(Statement stmt) throws SQLException {
			String query = "select * from Weblink";
			ResultSet rs = stmt.executeQuery(query);
			List<Bookmark> data = new ArrayList<>();
			while(rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String profileUrl = "-";
				String url = rs.getString("url");
				String host = rs.getString("host");
				Bookmark b = BookmarkManager.getInstance().createWebLink(id, title, profileUrl, url, host);
				data.add(b);
			}
			bookmarks.add( data);

		}

		private static void loadMovies(Statement stmt) throws SQLException {
			String query = "select m.id,title, release_year, movie_genre_id, imdb_rating,"
					+ "GROUP_CONCAT(a.name separator ',') as cast, "
					+ "GROUP_CONCAT(d.name separator ',') as directors "
					+ "from Movie m, Actor a, Movie_Actor ma, Movie_Director md, "
					+ "Director d  where m.id = ma.movie_id and a.id = ma.actor_id and m.id = md.movie_id"
					+ " and d.id = md.director_id group by m.id";
			ResultSet rs = stmt.executeQuery(query);

			List<Bookmark> data = new ArrayList<>();
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				int releaseYear = rs.getInt("release_year");
				String[] cast = rs.getString("cast").split(",");
				String[] directors = rs.getString("directors").split(",");
				int genre_id = rs.getInt("movie_genre_id");
				MovieGenre genre = MovieGenre.values()[genre_id];
				double imdbRating = rs.getDouble("imdb_rating");

				Bookmark bookmark = BookmarkManager.getInstance().createMovie(id, title, "-", releaseYear, cast, directors,
						genre, imdbRating);
				data.add(bookmark);
			}
			bookmarks.add( data);
		}

		private static void loadBooks(Statement stmt) throws SQLException {
			String query = "select b.id,title, publication_year, p.name, GROUP_CONCAT(a.name SEPARATOR ',') AS authors,"
					+ " book_genre_id, amazon_rating, created_date from Book b, Publisher p, Author a, Book_Author ba"
					+ " where b.publisher_id = p.id and b.id = ba.book_id and ba.author_id = a.id group by b.id";

			ResultSet rs = stmt.executeQuery(query);
			List<Bookmark> data = new ArrayList<>();
			try {
				while (rs.next()) {
					long id = rs.getLong("id");
					String title = rs.getString("title");
					int publicationYear = rs.getInt("publication_year");
					String publisher = rs.getString("name");
					String[] authors = rs.getString("authors").split(",");
					int genre_id = rs.getInt("book_genre_id");
					BookGenre genre = BookGenre.values()[genre_id];
					double amazonRating = rs.getDouble("amazon_rating");

					// playing with date (java.sql.date)
					Date createdDate = rs.getDate("created_date");
					Timestamp timeStamp = rs.getTimestamp(8);
					// note the use of column number above (8). Column numbers start from 1 from
					// left to right
					Bookmark b = BookmarkManager.getInstance().createBook(id, title, "-", publicationYear, publisher,
							authors, genre, amazonRating);
					data.add(b);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bookmarks.add( data);
		}

		public static void add(UserBookmark userBookmark) {
			userBookmarks.add(userBookmark);
		}

	}
	

