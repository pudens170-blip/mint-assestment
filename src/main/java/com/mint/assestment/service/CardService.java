package com.mint.assestment.service;

import java.util.Optional;
import com.mint.assestment.model.Card;

public interface CardService {

	Optional<Card> getCardDetails(String bankIdentificationNumber) throws Exception ;
	public <T> void UpdateOrSave(Card card);

}
