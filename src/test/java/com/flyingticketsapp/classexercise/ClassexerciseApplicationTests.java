package com.flyingticketsapp.classexercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ClassexerciseApplicationTests {

	@ParameterizedTest()
	@ValueSource(ints = {98, 100,101,200})
	void maxNumberSits(int planeSits) {
		int maxNumberOfSits = 100;  // Maximum sits per plane is 100;
		Assert.isTrue(planeSits < maxNumberOfSits, "Maximum number of sits in a plane is 100" );
	}

	//this is a test comment


}
