package com.epam.mentoring.StructuralPattern.model;

import java.util.List;

import com.epam.mentoring.StructuralPattern.viewers.IViewer;

public abstract class BridgeViewer {
	protected IViewer viewer;

	public BridgeViewer(IViewer viewer) {
		this.viewer = viewer;
	}

	public abstract void show(List<Animal> animals);

}
