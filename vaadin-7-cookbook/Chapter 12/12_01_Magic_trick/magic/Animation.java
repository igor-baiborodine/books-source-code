package com.packtpub.vaadin.magic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.vaadin.artur.playingcards.Card;
import org.vaadin.artur.playingcards.CardPile;
import org.vaadin.artur.playingcards.Deck;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class Animation implements Runnable {

	private List<MyCard> originCards;
	private List<MyCard> similarCards;
	private List<Integer> numbers = new ArrayList<Integer>();
	private List<CardPile> piles;
	private Deck deck;
	private Label message;
	private Button nextActionButton;
	private UI ui;
	private static final long DELAY = 500;

	public Animation(List<MyCard> originCards, List<MyCard> similarCards,
			List<CardPile> piles, Deck deck, Label message, Button nextActionButton) {
		this.originCards = originCards;
		this.similarCards = similarCards;
		this.piles = piles;
		this.deck = deck;
		this.message = message;
		this.nextActionButton = nextActionButton;
		this.ui = nextActionButton.getUI();
		prepareOrder();
	}

	public void run() {		
		turnOriginCardsBacksideUp();
		collectOriginCards();
		deploySimilarCards();
		disappearOneCard();
		turnSimilarCardsFrontsideUp();

		ui.getSession().getLockInstance().lock();
		nextActionButton.setCaption("Play again");
		nextActionButton.setVisible(true);
		ui.getSession().getLockInstance().unlock();
	}

	private void turnOriginCardsBacksideUp() {
		Collections.shuffle(numbers);
		for (Integer number : numbers) {
			ui.getSession().getLockInstance().lock();
			originCards.get(number).setBacksideUp(true);
			piles.get(number).markAsDirty();
			ui.getSession().getLockInstance().unlock();
			sleep(DELAY);
		}
		sleep(DELAY);
	}

	private void collectOriginCards() {
		Collections.shuffle(numbers);
		for (Integer number : numbers) {
			ui.getSession().getLockInstance().lock();
			Card card = piles.get(number).removeTopCard();
			deck.addCard(card);
			ui.getSession().getLockInstance().unlock();
			sleep(DELAY);
		}
		sleep(DELAY);

	}

	private void deploySimilarCards() {
		Collections.shuffle(similarCards);
		for (Integer number : numbers) {
			ui.getSession().getLockInstance().lock();
			deck.removeTopCard();
			Card card = similarCards.get(number);
			card.setBacksideUp(true);
			piles.get(number).addCard(card);
			piles.get(number).markAsDirty();
			ui.getSession().getLockInstance().unlock();
			sleep(DELAY);
		}
	}

	private void disappearOneCard() {
		sleep(DELAY * 8);
		ui.getSession().getLockInstance().lock();
		message.setValue("Your thought of card DISAPPEARS!");		
		Collections.shuffle(numbers);
		piles.get(numbers.get(0)).removeTopCard();
		ui.getSession().getLockInstance().unlock();
		sleep(DELAY * 8);
	}

	private void turnSimilarCardsFrontsideUp() {
		for (int i = 0; i < piles.size(); i++) {
			ui.getSession().getLockInstance().lock();
			similarCards.get(i).setBacksideUp(false);
			piles.get(i).markAsDirty();
			ui.getSession().getLockInstance().unlock();
			sleep(DELAY);
		}
	}

	private void prepareOrder() {
		for (int i = 0; i < piles.size(); i++) {
			numbers.add(i);
		}
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
