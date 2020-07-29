package fi.jyu.issuetracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import fi.jyu.issuetracker.dao.models.LoginRequest;
import fi.jyu.issuetracker.security.model.JwtAuthenticationResponse;
import fi.jyu.issuetracker.security.model.User;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.util.StringUtils;

/**
 * Test class for registration and login functions.
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@TestInstance(Lifecycle.PER_CLASS)
class IssuetrackerLoginTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;


	// Tests for registering and login functions

	@Test
	public void accessIsForbiddenWithoutCredentials() throws Exception {
		this.mvc.perform(get("/api/issues")).andExpect(status().isUnauthorized());
	}

	@Test
	public void registrationSucceedsWithValidCredentials() throws Exception {
		User user = new User("testuser", "testpw", "test@domain.com");
		this.mvc.perform(post("/api/register").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user))).andDo(print()).andExpect(status().isCreated());
	}

    @Test
	public void loginSucceedsAfterRegistration() throws Exception {
		LoginRequest request = new LoginRequest("testuser", "testpw");
		this.mvc
			.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(request)))
			.andDo(print()).andExpect(status().isOk());
	}



	@Test
	public void accessAllowedWithToken() throws Exception {
		String bearerToken = login();
		String token = "";
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			token = bearerToken.substring(7, bearerToken.length());
		}
		mvc.perform(get("/api/issues").header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk());
	}

	public String login() throws JsonProcessingException, Exception {
		LoginRequest request = new LoginRequest("testuser", "testpw");
		MvcResult result = this.mvc.perform(post("/api/login")
								.contentType(MediaType.APPLICATION_JSON)
								.content(objectMapper.writeValueAsString(request)))
								.andDo(print())
								.andExpect(status().isOk())
								.andReturn();

		String response = result.getResponse().getContentAsString();
		JwtAuthenticationResponse jwtResponse = objectMapper.readValue(response, JwtAuthenticationResponse.class);
		return jwtResponse.getToken();
    }


}
