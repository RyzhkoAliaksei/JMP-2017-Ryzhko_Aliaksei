package com.epam.mentoring.StructuralPattern.model;

import java.util.List;

import com.epam.mentoring.StructuralPattern.viewers.IViewer;

public class AnimalList {
	private IViewer viewer;
	private List<Animal> animals;

	public AnimalList(IViewer viewer) {
		this.viewer = viewer;
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
