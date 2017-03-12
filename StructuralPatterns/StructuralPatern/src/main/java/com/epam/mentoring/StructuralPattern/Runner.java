package com.epam.mentoring.StructuralPattern;

import java.util.ArrayList;
import java.util.List;

import com.epam.mentoring.StructuralPattern.model.Animal;
import com.epam.mentoring.StructuralPattern.model.AnimalBridgeViewer;
import com.epam.mentoring.StructuralPattern.viewers.ListBoxViewer;
import com.epam.mentoring.StructuralPattern.viewers.TableViewer;


public class Runner 
{
    public static void main( String[] args )
    {
    	List<Animal> animals=new ArrayList<Animal>();
    	Animal lion=new Animal("Lion","Africa");
    	Animal bison=new Animal("Bison","Belarus");
    	Animal whiteBear=new Animal("White Bear","Antarctica");
    	animals.add(lion);animals.add(bison);animals.add(whiteBear);
    	
    	AnimalBridgeViewer listAnimalsView = new AnimalBridgeViewer(new ListBoxViewer());
    	listAnimalsView.show(animals);	
    	AnimalBridgeViewer tableAnimalsView = new AnimalBridgeViewer(new TableViewer());
    	tableAnimalsView.show(animals);
    }
}
