package com.buy.tsg.service;

import java.util.List;

public interface AuthService {

	List<String> selectAuthByUsername(String username);

	List<String> selectAuthByRoleNames(List<String> roleNames);

}
