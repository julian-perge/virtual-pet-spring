package com.julian.virtualpetspring;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.Mock;

public class OrganicPetTest
{
	@Mock
	private OrganicDog dogTest;
	
	@Test(expected = InstantiationException.class)
	public void shouldNotBeAbleToInstantiateAnOrganicVirtualPet() throws Exception
	{
		VirtualPet.class.newInstance();
	}
	
	@Test
	public void NegativeBladderLevelInOrganicPetShouldLowerHappinessLevel()
	{
		int happinessBeforeBladderSet = dogTest.getBladderLevel();
//		dogTest.tick();
		int expectedDogHappy = dogTest.getBladderLevel();
		assertThat(expectedDogHappy, lessThan(happinessBeforeBladderSet));
		
	}
	
	@Test
	public void shouldReturnModifiedHappinessValueOfDog()
	{
		int happyBefore = dogTest.getHappiness();
		dogTest.calculateHappiness(dogTest.getHunger(), dogTest.getBladderLevel(), dogTest.getFun(), dogTest.getEnergy());
		
		assertThat(50, is(equalTo(happyBefore)));
	}
}
