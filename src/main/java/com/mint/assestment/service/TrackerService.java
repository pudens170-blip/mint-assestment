package com.mint.assestment.service;

import java.util.Collection;

import com.mint.assestment.model.Tracker;

public interface TrackerService {

	public <T> void updateOrSave(Tracker tracker);
	public long getRecordSize();
	public Collection<Tracker> getTracker(int limit,int start);

}