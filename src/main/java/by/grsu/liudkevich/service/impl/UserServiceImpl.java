package by.grsu.liudkevich.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import by.grsu.liudkevich.dataaccess.impl.UserCredentialsDao;
import by.grsu.liudkevich.dataaccess.impl.UserProfileDao;
import by.grsu.liudkevich.datamodel.UserCredentials;
import by.grsu.liudkevich.datamodel.UserProfile;
import by.grsu.liudkevich.service.UserService;

public class UserServiceImpl implements UserService {

	private UserProfileDao userProfileDao;

	private UserCredentialsDao userCredentialsDao;

	
	public UserServiceImpl(String rootFolderPath) {
		super();
		this.userProfileDao = new UserProfileDao(rootFolderPath);
		this.userCredentialsDao = new UserCredentialsDao(rootFolderPath);
	}

	@Override
	public void register(UserProfile profile, UserCredentials userCredentials) {
		userCredentialsDao.saveNew(userCredentials);
		profile.setCredentials(userCredentials);
		profile.setCreated(new Date());
		userProfileDao.saveNew(profile);
	}

	@Override
	public UserProfile getProfile(Long id) {
		return userProfileDao.get(id);
	}

	@Override
	public UserCredentials getCredentials(Long id) {
		return userCredentialsDao.get(id);
	}

	@Override
	public UserCredentials getByNameAndPassword(String userName, String password) {
		return userCredentialsDao.find(userName, password);
	}

	@Override
	public Collection<? extends String> resolveRoles(Long id) {
		UserCredentials userCredentials = userCredentialsDao.get(id);
		return Collections.singletonList(userCredentials.getRole().name());
	}

	@Override
	public List<UserProfile> getAll() {
		return userProfileDao.getAll();
	}
}
