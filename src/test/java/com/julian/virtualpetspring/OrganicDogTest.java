package com.julian.virtualpetspring;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class OrganicDogTest
{
	@Autowired
	VirtualPetRepo shelter;
	
	@Mock
	private OrganicDog underTestDog;
	
	@Test
	public void walkingOrganicDogShouldIncreaseHappinessAndDecreaseChanceToSoilCage()
	{
		int happinessBeforeWalk = underTestDog.getHappiness();
		
		BigDecimal chanceToSoilBeforeWalk = underTestDog.getChanceToSoilCage();
		shelter.walkOneDog(underTestDog);
		BigDecimal chanceToSoilAfterWalk = underTestDog.getChanceToSoilCage();
		
		int happinessAfterWalk = underTestDog.getHappiness();
		
		assertThat(happinessAfterWalk, is(equalTo(happinessBeforeWalk + 25)));
		assertThat(chanceToSoilAfterWalk, lessThan(chanceToSoilBeforeWalk));
	}
	
	@Test
	public void chanceToSoilShouldIncreaseWhenTickIsCalled()
	{
		BigDecimal chanceToSoilBefore = underTestDog.getChanceToSoilCage();
		underTestDog.tick();
		BigDecimal chanceToSoilAfter = underTestDog.getChanceToSoilCage();
		assertThat(chanceToSoilAfter, greaterThan(chanceToSoilBefore));
	}
	
	@Test
	public void _01_shouldBeEqualToItself() {
		assertTrue(underTestDog.equals(underTestDog));
	}
	
	@Test
	public void _shouldNotBeEqualToNull() {
		assertFalse(underTestDog.equals(null));
	}
	
	@Test
	public void shouldReturnOrganicPetOfTypeDog()
	{
		OrganicPet equivalent = new OrganicDog(943094L, "Rainbow", "Black and white dog", 100);
		
		assertEquals(equivalent.hashCode(), underTestDog.hashCode());
	}
	
	@Test
	public void shouldNotBeEqualToObjectOfDifferentType() {
		String other = "definitely not a city";
		
		assertFalse(underTestDog.equals(other));
	}
}
