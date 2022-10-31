package com.flyingticketsapp.classexercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.util.Assert;

@SpringBootTest
class ClassexerciseApplicationTests {


	@Test
	void contextLoads() {
	}

	@ParameterizedTest
	@ValueSource(doubles = {10.5, 9, 0, 1, 11})
	public void lugaggeLessThanTen(double maxLugagge){
		Assert.isTrue(maxLugagge <= 10, "Testing lugagge");

	}

}
