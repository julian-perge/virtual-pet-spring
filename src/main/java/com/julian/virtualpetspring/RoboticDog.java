package com.julian.virtualpetspring;

public class RoboticDog extends RoboticPet
{	
	public RoboticDog(Long id, String name, String description, int health, int oilLevel)
	{
		super(id, name, description, health, oilLevel);
	}

	public RoboticDog(Long id, String name, String description, int health)
	{
		super(id, name, description, health);
	}
	
	@Override
	public int hashCode()
	{
		return RoboticDog.class.hashCode();
	}
}
