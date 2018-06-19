package com.julian.virtualpetspring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mock;

public class RoboticDogTest
{
	@Mock
	private RoboticPet underTestDog;

	@Test
	public void _01_shouldBeEqualToItself()
	{
		assertTrue(underTestDog.equals(underTestDog));
	}

	@Test
	public void _shouldNotBeEqualToNull()
	{
		assertFalse(underTestDog.equals(null));
	}

	@Test
	public void shouldReturnRoboticPetOfTypeDog()
	{
		RoboticPet equivalent = new RoboticDog(505050L, "Rainbow", "Black and white dog", 100);

		assertEquals(equivalent.hashCode(), underTestDog.hashCode());
	}

	@Test
	public void shouldNotBeEqualToObjectOfDifferentType()
	{
		String other = "definitely not a city";

		assertFalse(underTestDog.equals(other));
	}

}
