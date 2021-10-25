package com.pp.repo;

import java.util.List;

public interface UserLogin {

	public List<UserLogin> adminSignIn(String emailId, String password);
}
