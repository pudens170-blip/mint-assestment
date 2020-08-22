package com.mint.assestment.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mint.assestment.model.Tracker;
import com.mint.assestment.repository.TrackerRepository;

@Service
public class TrackerServiceImpl implements TrackerService {

	@Autowired
	TrackerRepository trackerRepository;

	@Override
	public <T> void updateOrSave(Tracker tracker) {
		if (tracker != null) {
			trackerRepository.save(tracker);
		}
	}
		
	@Override
	public Collection<Tracker> getTracker(int limit,int start) {
		return trackerRepository.getAllTracker(limit, start);
	}
	@Override
	public long getRecordSize() {
		return trackerRepository.count();
	}

}
