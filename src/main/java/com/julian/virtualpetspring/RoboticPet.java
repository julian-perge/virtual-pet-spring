package com.julian.virtualpetspring;

public abstract class RoboticPet extends VirtualPet
{
	private final int OIL_LEVEL= 50;
	private int oilLevel = OIL_LEVEL;
	
	public int getOilLevel()
	{
		return oilLevel;
	}
	
	public RoboticPet(Long id, String name, String description, int health, int oilLevel)
	{
		super(id, name, description, health);
		this.oilLevel = oilLevel;
	}
	
	public RoboticPet(Long id, String name, String description, int health)
	{
		super(id, name, description, health);
	}

	public int oilPet()
	{
		return oilLevel += 50;
	}
	
	@Override
	public void tick()
	{
		this.oilLevel -= 10;
	}
	
	@Override
	public int hashCode()
	{
		return RoboticPet.class.hashCode();
	}
	
	@Override
	public String toString() {
		return super.toString() + "|" + getOilLevel();
	}
}
