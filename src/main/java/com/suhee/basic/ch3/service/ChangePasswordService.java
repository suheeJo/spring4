package com.suhee.basic.ch3.service;

import com.suhee.basic.ch3.dao.CachedMemberDao;
import com.suhee.basic.ch3.dao.MemberDao;

public class ChangePasswordService {
	private MemberDao memberDao = new CachedMemberDao();
}
