package com.julian.virtualpetspring;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class OrganicCatTest
{
	@Autowired
	VirtualPetRepo shelter;
	
	@Mock
	private OrganicCat underTestCat;
	
	@Test
	public void _01_shouldBeEqualToItself() {
		assertTrue(underTestCat.equals(underTestCat));
	}
	
	@Test
	public void _shouldNotBeEqualToNull() {
		assertFalse(underTestCat.equals(null));
	}
	
	@Test
	public void shouldReturnOrganicPetOfTypeDog()
	{
		OrganicPet equivalent = new OrganicCat(55L, "Rainbow", "Black and white dog", 100);
		
		assertEquals(equivalent.hashCode(), underTestCat.hashCode());
	}
	
	@Test
	public void shouldNotBeEqualToObjectOfDifferentType() {
		String other = "definitely not a city";
		
		assertFalse(underTestCat.equals(other));
	}
	
	@Test
	public void catUsingLitterBoxShouldIncreaseLitterBoxWaste() {
		int litterBoxWasteValueBeforeCatUse = shelter.getLitterBoxWasteValue();
		shelter.catUsesLitterBox();
		int expectedWasteValueOfLitterBoxAfterUse = shelter.getLitterBoxWasteValue();
		
		assertThat(expectedWasteValueOfLitterBoxAfterUse, greaterThan(litterBoxWasteValueBeforeCatUse));
	}
}
