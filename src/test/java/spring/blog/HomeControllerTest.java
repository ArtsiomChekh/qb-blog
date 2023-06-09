package spring.blog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import spring.blog.controllers.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT )
public class HomeControllerTest {
	
	@Autowired
	private HomeController homeController;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(this.homeController).isNotNull();
	}

	@Test
	public void indexShouldContain_RecentPosts_InHTMLBody() throws Exception{
		String indexUrl = "http://localhost:" + port + "/";
		String body = this.restTemplate.getForObject(indexUrl, String.class);
		// Regular assertion
		assertThat(body).contains("Recent Posts");

		 assertThat(body).as("check %s contains 'Recent Posts'", indexUrl).contains("Recent Posts");
	}

}
