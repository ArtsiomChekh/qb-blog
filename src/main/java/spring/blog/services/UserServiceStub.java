package spring.blog.services;

import spring.blog.models.User;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceStub implements UserService {

	@Override
	public boolean authenticate(String userName, String password) {
		// Provide a sample password check: username == password
		return Objects.equals(userName, password);
	}

	@Override
	public List<User> findAll() {
		return null;
	}	

	@Override
	public User findById(Long id) {
		return null;
	}

	@Override
	public User create(User user) {
		return null;
	}

	@Override
	public User edit(User user) {
		return null;
	}

	@Override
	public void deleteById(Long id) {
	}

	@Override
	public User findByUserName(String userName) {
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return null;
	}

}
