package com.epam.mentoring.StructuralPattern.model;

import com.epam.mentoring.StructuralPattern.viewers.IViewer;

public abstract class BridgeViewer {
	protected IViewer viewer;

	public BridgeViewer(IViewer viewer) {
		this.viewer = viewer;
	}

	public abstract void show();

}
