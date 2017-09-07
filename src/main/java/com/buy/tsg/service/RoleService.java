package com.buy.tsg.service;

import java.util.List;

public interface RoleService {

	List<String> selectRoleByUsername(String currentUsername);

}
