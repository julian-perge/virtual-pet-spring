package com.julian.virtualpetspring;

public class OrganicCat extends OrganicPet
{
	public OrganicCat(Long id,String name, String description, int health, int hunger, int bladder, int fun, int energy, int happiness)
	{
		super(id, name, description, health, hunger, bladder, fun, energy, happiness);
	}

	public OrganicCat(Long id, String name, String description, int health)
	{
		super(id, name, description, health);
	}
	
	@Override
	public int hashCode()
	{
		return OrganicCat.class.hashCode();
	}
}