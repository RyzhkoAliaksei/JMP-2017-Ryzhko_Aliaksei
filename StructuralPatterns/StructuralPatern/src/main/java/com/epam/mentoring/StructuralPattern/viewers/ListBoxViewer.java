package com.epam.mentoring.StructuralPattern.viewers;

import java.util.List;

import com.epam.mentoring.StructuralPattern.model.Animal;

public class ListBoxViewer implements IViewer {

	public void view(List<Animal> animals) {
		System.out.println("View as list");
		for (Animal animal : animals) {
			System.out.println(animal.getName() + " " + animal.getPlace());
		}
	}

}
