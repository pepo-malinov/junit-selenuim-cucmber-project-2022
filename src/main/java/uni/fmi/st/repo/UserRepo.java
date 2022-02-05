package uni.fmi.st.repo;

import uni.fmi.st.models.User;

/**
 * Base user model manager
 * 
 * @author pepo
 *
 */
public interface UserRepo {

	boolean save(User newUser);
	boolean isUsernameExists(final String username);

}
