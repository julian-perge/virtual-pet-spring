package com.julian.virtualpetspring;

public class RoboticCat extends RoboticPet
{
	public RoboticCat(Long id, String name, String description, int health, int oilLevel)
	{
		super(id, name, description, health, oilLevel);
	}

	public RoboticCat(Long id, String name, String description, int health)
	{
		super(id, name, description, health);
	}
	
	@Override
	public int hashCode()
	{
		return RoboticCat.class.hashCode();
	}

}
