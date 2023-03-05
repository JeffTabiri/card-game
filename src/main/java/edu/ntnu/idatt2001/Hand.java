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

  public String cardsToString() {

    String cardsString = "";

    for (Card card : cards) {
      cardsString += card.getAsString() + "\n";
    }

    return cardsString;
  }


}
