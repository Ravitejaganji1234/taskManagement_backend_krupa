package com.example.task;

import com.example.taskMangaer.TaskApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TaskApplication.class)  // Explicitly specify the main application class
public class TaskApplicationTests {

	@Test
	void contextLoads() {
	}
}
