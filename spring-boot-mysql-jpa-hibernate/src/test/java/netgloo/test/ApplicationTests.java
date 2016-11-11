package netgloo.test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import netgloo.dao.UserRepository;


//REF1: http://spring.io/guides/tutorials/bookmarks/ ( rest/src/test/java/bookmarks/BookmarkRestControllerTest.java)
//REF2: http://stackoverflow.com/questions/29261836/spring-data-rest-content-type (for: HAL + JSON) 
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {
	
	//private MediaType contentType = new MediaType("application", "hal+json", Charset.forName("UTF-8"));
	private MediaType contentJsonType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	private MediaType contentTextType = new MediaType(MediaType.TEXT_PLAIN.getType(),
            MediaType.TEXT_PLAIN.getSubtype(),
            Charset.forName("utf8"));
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/select/find")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id").exists())
		.andExpect(jsonPath("$[0].id", is(1)))
		.andExpect(content().contentType(contentJsonType));
	}
	
	@Test
	public void shouldReturnMain() throws Exception {
		
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentTextType));

	}

}
