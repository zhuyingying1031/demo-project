package net.xdclass.demoproject;

import net.xdclass.demoproject.service.VideoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoProjectApplication.class})
@AutoConfigureMockMvc
public class VideoTest {

	@Autowired
	private VideoService videoService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testVideolistApi() throws Exception {
		MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		int status=mvcResult.getResponse().getStatus();
		mvcResult.getResponse().setCharacterEncoding("utf-8");
		String result=mvcResult.getResponse().getContentAsString();

		System.out.println("status状态为"+status+"    result为"+result);


	}






















}
