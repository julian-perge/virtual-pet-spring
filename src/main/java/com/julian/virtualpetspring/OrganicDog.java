package com.julian.virtualpetspring;

import java.math.BigDecimal;

public class OrganicDog extends OrganicPet implements Walkable
{	
	// percentage chance to soil
	private BigDecimal chanceToSoilCage = calculateChanceToSoilCage();
	
	public BigDecimal calculateChanceToSoilCage()
	{
		chanceToSoilCage = new BigDecimal((1/500) * Math.pow(getBladderLevel(), 2.00) + 5);
		return chanceToSoilCage;
	}
	
	public OrganicDog(Long id, String name, String description, int health)
	{
		super(id, name, description, health);
	}
	
	public OrganicDog(Long id, String name, String description, int health, int hunger, int bladder, int fun, int energy, int happiness)
	{
		super(id, name, description, health, hunger, bladder, fun, energy, happiness);
	}
	
	public BigDecimal getChanceToSoilCage() {
		return this.chanceToSoilCage;
	}
	
	@Override
	public void tick()
	{
		super.tick();
		this.chanceToSoilCage = chanceToSoilCage.add(new BigDecimal(10));
	}

	@Override
	public int hashCode()
	{
		return OrganicDog.class.hashCode();
	}

	@Override
	public int walk() {
		this.chanceToSoilCage = chanceToSoilCage.subtract(new BigDecimal(10));
		return super.walk();
	}
}
