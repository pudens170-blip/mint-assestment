package com.mint.assestment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mint.assestment.model.Card;
import com.mint.assestment.model.Tracker;
import com.mint.assestment.repository.CardRepository;
import com.mint.assestment.repository.TrackerRepository;

@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardRepository cardRepo;

	@Autowired
	private TrackerRepository trackerRepo;
	@Autowired
	private TrackerService trackerService;

	@Value("${binUrl}")
	private String binUrl;
	@Autowired
	private WebClient.Builder webclientBuilder;

	@Override
	@Cacheable(value="apiCache",key="#bankIdentificationNumber")
	public Optional<Card> getCardDetails(String bankIdentificationNumber) {
		String url = binUrl + bankIdentificationNumber;
		updateHitCounter(bankIdentificationNumber);
		Optional<Card> card = Optional
				.ofNullable(webclientBuilder.build().get().uri(url).retrieve().bodyToMono(Card.class).block());

		return card;

	}

	private void updateHitCounter(String bankIdentificationNumber) {
		Optional<Tracker> trackerOpt = trackerRepo.findBybankIdentificationNumber(bankIdentificationNumber);
		Tracker tracker = null;
		Long count = 0l;
		if (trackerOpt.isPresent()) {
			tracker = trackerOpt.get();
			count = tracker.getCount();

			if (count > 0) {
				count++;
			}
			tracker.setCount(count);
			trackerService.updateOrSave(tracker);
		} else {
			tracker = new Tracker();
			tracker.setBankVerificationNumber(bankIdentificationNumber);
			tracker.setCount(++count);
			trackerService.updateOrSave(tracker);
		}
	}

	@Override
	public <T> void UpdateOrSave(Card card) {
		Optional<Card> cardOpt = Optional.ofNullable(card);
		cardOpt.ifPresent(c -> cardRepo.save(card));

	}

}
