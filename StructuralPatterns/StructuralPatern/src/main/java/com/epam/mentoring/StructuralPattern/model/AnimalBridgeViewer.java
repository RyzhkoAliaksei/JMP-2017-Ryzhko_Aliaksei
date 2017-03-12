package com.epam.mentoring.StructuralPattern.model;

import java.util.List;

import com.epam.mentoring.StructuralPattern.viewers.IViewer;

public class AnimalBridgeViewer extends BridgeViewer {
	private List<Animal> animals;

	public AnimalBridgeViewer(IViewer viewer) {
		super(viewer);
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public void show(List<Animal> animals) {
		viewer.view(animals);
	}
}
