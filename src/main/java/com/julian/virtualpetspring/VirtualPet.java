package com.julian.virtualpetspring;

public abstract class VirtualPet implements tick
{
	private Long id;
	private String name;
	private String description;
	private int health;
	
	public VirtualPet(Long id , String name, String description, int health)
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.health = health;
	}
	
	public Long getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public int getHealth()
	{
		return health;
	}
	
	public void tick()
	{
		this.health -= 2;
	}
	
	@Override
	public String toString()
	{
		return name + "\t|" + health + "\t";
	}
}
