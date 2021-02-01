package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Shareable;
import java.util.*;
public class View {
  public static void browse(User user,List<List<Bookmark>> bookmarks) {
	  System.out.println(user.getEmail()+" is browsing item... ");
	  int bookmarkCount=0;
	  for(List<Bookmark> bookmarkList : bookmarks) {
		  for(Bookmark bookmark : bookmarkList) {
			  //if(bookmarkCount<DataStore.USER_BOOKMARK_LIMIT) {
			       boolean isBookmarked = getBookmarkDecision(bookmark);
			       if(isBookmarked) {
			    	   bookmarkCount++;
			    	  BookmarkController.getInstance().saveUserBookmark(user,bookmark);	 
			   		System.out.println(bookmark);
			   	  if(user.getUserType().equals(UserType.EDITOR)||
						  user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					  if(bookmark.isKidFriendlyEligible()&&bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						  KidFriendlyStatus kidFriendlyStatus=getKidFriendlyStatusDecision(bookmark);
					      if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
					    	  BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
					    	  
					      }
					  
					  }
//						Sharing possible if Editor and kidFriendlyStatus has to be approved. AND SHOULD BE BOOK OR WEBLINK ONLY
						if(bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable) {
							boolean isShared = getShareDecision();
							if(isShared) {
								//share with third party
								BookmarkController.getInstance().share(user, bookmark);
							}
						}
				  }
			      }
			  }
		  }
	  }
	 
	  
  

private static boolean getShareDecision() {
	// TODO Auto-generated method stub
	//return false;
	return Math.random() > 0.5? true: false;
}

private static KidFriendlyStatus getKidFriendlyStatusDecision(Bookmark bookmark) {
	// TODO Auto-generated method stub
	return Math.random()<0.4?KidFriendlyStatus.APPROVED:
		( Math.random()>=0.4&& Math.random()<0.8)? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
}

private static boolean getBookmarkDecision(Bookmark bookmark) {
	return Math.random()<0.5?true:false;
	
}
}
