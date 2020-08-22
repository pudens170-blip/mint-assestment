package com.mint.assestment.resource;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mint.assestment.enums.Error;
import com.mint.assestment.model.Card;
import com.mint.assestment.model.Tracker;
import com.mint.assestment.pojo.CardPojo;
import com.mint.assestment.pojo.CardResponse;
import com.mint.assestment.pojo.CardStatisticsResponse;
import com.mint.assestment.service.CardService;
import com.mint.assestment.service.TrackerService;

@RestController
@RequestMapping("/card-scheme")
public class CardResource {

	private CardResponse cardResponse;
	@Autowired
	private CardStatisticsResponse cardStatisticsResponse;

	@Autowired
	private TrackerService trackerService;

	@Autowired
	private CardPojo cardPojo;

	@Autowired
	private CardService cardService;

	public CardResource(CardResponse cardResponse) {
		this.cardResponse = cardResponse;
	}

	@GetMapping("/verify/{BIN}")
	public CardResponse verifyCard(@PathVariable("BIN") String bankIdentificationNumber) {
		try {
			Optional<Card> cardDetails = cardService.getCardDetails(bankIdentificationNumber);
			if (cardDetails.isPresent()) {
				Card details = cardDetails.get();
				String bankName = details.getBank().getName() == null ? Error.UNVAILABLE.getValue()
						: details.getBank().getName();
				cardResponse.setSuccess(Boolean.TRUE);
				cardPojo.setBank(bankName);
				cardPojo.setScheme(String.valueOf(details.getScheme().getValue()));
				cardPojo.setType(String.valueOf(details.getType().getValue()));
				cardResponse.setPayload(cardPojo);
			}
		} catch (Exception e) {
			cardResponse.setSuccess(Boolean.FALSE);
			cardPojo.setBank(Error.UNVAILABLE.getValue());
			cardPojo.setScheme(Error.UNVAILABLE.getValue());
			cardPojo.setType(String.valueOf(Error.UNVAILABLE.getValue()));
			cardResponse.setPayload(cardPojo);
		}
		return cardResponse;
	}

	@GetMapping("/stats")
	public CardStatisticsResponse hitCount(@RequestParam("start") int start, int limit) {
		if (start > limit || start <= 0) {
			cardStatisticsResponse.setSuccess(Boolean.FALSE);
			cardStatisticsResponse.setPayload(new TreeMap<String, Long>());
			cardStatisticsResponse.setSize(0);
			cardStatisticsResponse.setStart(start);
			cardStatisticsResponse.setLimit(limit);
		}

		else {
			Map<String, Long> payload = new TreeMap<String, Long>();
			for (Tracker tracker : trackerService.getTracker(limit, start - 1)) {
				payload.put(tracker.getBankVerificationNumber(), tracker.getCount());
			}
			cardStatisticsResponse.setSuccess(Boolean.TRUE);
			cardStatisticsResponse.setPayload(payload);
			cardStatisticsResponse.setSize(trackerService.getRecordSize());
			cardStatisticsResponse.setStart(start);
			cardStatisticsResponse.setLimit(limit);

		}
		return cardStatisticsResponse;
	}

}
