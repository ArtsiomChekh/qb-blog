package spring.blog.services;

import spring.blog.models.Post;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostService {
	List<Post> findAll();
	Page<Post> findAll(Pageable pageable);
	List<Post> findLatest5();
	Post findById(Long id);
	Post create(Post post);
	Post edit(Post post);
	void deleteById(Long id);
}
