package com.semanticsquare.thrillio.entities;
import java.util.Arrays;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.partner.Shareable;


public class Book extends Bookmark implements Shareable{
	private int publicationYear;
	private String publisher;
	private String[] authors;
	private double amazonRating;
    private BookGenre genre;
    private String imageUrl;
	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	public void setGenre(BookGenre genre) {
		this.genre=genre;
	}
	public BookGenre getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", amazonRating=" + amazonRating + ", genre=" + genre + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if(genre.equals(BookGenre.PHILOSOPHY)||genre.equals(BookGenre.SELF_HELP))
		    return false;
			return true;
		
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<publisher>").append(publisher).append("</publisher>");
		builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
		builder.append("<genre>").append(genre).append("</genre>");
		builder.append("<authors>");
	for(String author: authors) {
		builder.append(author+",");
	}
		
//		Instead of looping through array, we use StringUtils class' from Apache Commons Lang's join function
		//builder.append(StringUtils.join(authors, ","));
		builder.append("</authors>");
		builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
		builder.append("</item>");
		return builder.toString();
		
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	

}
