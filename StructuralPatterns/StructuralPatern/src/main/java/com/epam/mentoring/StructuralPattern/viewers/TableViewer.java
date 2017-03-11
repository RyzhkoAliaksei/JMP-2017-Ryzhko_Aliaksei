package com.epam.mentoring.StructuralPattern.viewers;

import java.util.List;

import com.epam.mentoring.StructuralPattern.model.Animal;

public class TableViewer implements IViewer{

		public void view(List<Animal> animals) {	
			
			System.out.println("View as Table");
			System.out.println("-----------------------------------------");
			for (Animal animal : animals) {
				System.out.println("|"+animal.getName() + "|" + animal.getPlace()+"|");
			}
			System.out.println("-----------------------------------------");
		}

}
