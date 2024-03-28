package com.intelygenz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BinaryIntegerSortedControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Test
	void when_getSortedIntegers_withExistingId_shouldReturnExpectedValue() {
		ResponseEntity<List> responseEntity = restTemplate
			.getForEntity("http://localhost:" + port + "/integers?id=1", List.class);

		List<Integer> expected = List.of(15, 7, 3, 5, 1);
		assertEquals(expected, responseEntity.getBody());
	}
}
