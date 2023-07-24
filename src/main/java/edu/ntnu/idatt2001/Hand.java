package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.List;

public class Hand {
  private List<Card> cards;

  public Hand() {
    cards = new ArrayList<>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public void removeCard(Card card) {
    cards.remove(card);
  }

  public List<Card> getCards() {
    return cards;
  }

  public int cardSum(){
    int sum = 0;
    for (Card card : cards) {
      sum += card.getFace().ordinal() + 1;
    }
    return sum;
  }

  public void addSuitToHand(Card card, Suits suit) {
    if (card.getSuit().equals(suit)) {
      cards.add(card);
    }
  }

  public boolean checkForCard(Card givenCard) {
    for (Card card : cards) {
      if (card.equals(givenCard)) {
        return true;
      }
    }
    return false;
  }

  public String cardsToString() {

    String cardsString = "";

    for (Card card : cards) {
      cardsString += card.getAsString() + "\n";
    }

    return cardsString;
  }

  public boolean checkForFlush() {

    for (Card card : cards) {
      if (!card.getSuit().equals(cards.get(0).getSuit())) {
        return false;
      }
    }
    return true;
  }

  public String checkForSuit(String suit) {
    String cardsString = "";

    for (Card card : cards) {
      if (card.getSuit().equals(suit)) {
        cardsString += "\n" + card.getAsString();
      }
    }

    return cardsString;
  }


}
