package com.julian.virtualpetspring;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(VirtualPetController.class)
public class VirtualPetControllerTest
{
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private VirtualPetRepo repo;
	
	@Mock
	private VirtualPet virtualpet;
	
	@Test
	public void shouldReturnModelAndViewOfVirtualPetsAndIs2xxSuccessful() throws Exception
	{
		mvc.perform(get("/virtualpets"))
										.andExpect(view().name(is(equalTo("virtualpets"))))
										.andExpect(model().attribute("virtualpets", is(repo.getAllPets())))
										.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void shouldReturnModelAndViewOfVirtualPetAndIs2xxSuccessful() throws Exception
	{
		given(repo.returnSpecificPet(1L)).willReturn(virtualpet);
		
		mvc.perform(get("/virtualpets/1"))
										.andExpect(view().name(is(equalTo("virtualpet"))))
										.andExpect(model().attribute("virtualpet", is(virtualpet)))
										.andExpect(status().is2xxSuccessful());
	}
}
