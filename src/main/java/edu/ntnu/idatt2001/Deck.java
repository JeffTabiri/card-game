package edu.ntnu.idatt2001;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Deck {

  private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suits suit : Suits.values()) {
        for (Faces face : Faces.values()) {
            cards.add(new Card(suit, face));
        }
        }
    }

  public List<Card> getCards() {
    return cards;
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public Card drawCard() {
    return cards.remove(0);
  }
}
