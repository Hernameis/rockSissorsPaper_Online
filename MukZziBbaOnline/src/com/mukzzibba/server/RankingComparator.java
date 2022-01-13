package com.mukzzibba.server;

import java.util.Comparator;

import com.mukzzibba.server.userDb.UserInfo;

public class RankingComparator implements Comparator<UserInfo>{

	@Override
	public int compare(UserInfo o1, UserInfo o2) {
		if (o1.score < o2.score){
			return 1;
		} else if (o1.score == o2.score) {
			return 0;
		} else {
			return -1;
		}
	}
	}
