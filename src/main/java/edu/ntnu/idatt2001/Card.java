package edu.ntnu.idatt2001;


/**
 * A class representing a card.
 * A card has fields such as suit and face.
 *
 */
public class Card {
  private final Suits suit; // The suit of the card e.g "SPADES" (enum)
  private final Faces face; // The face value of the card, an integer between 1 and 13 (enum)

  private String url;

  /**
   * Creates an instance of a PlayingCard with a given suit and face.
   *
   * @param suit The suit of the card, as a single character. 'S' for Spades,
   *             'H' for Heart, 'D' for Diamonds and 'C' for clubs
   * @param face The face value of the card, an integer between 1 and 13
   */
  public Card(Suits suit, Faces face) {
    this.suit = suit;
    this.face = face;

    String filename = suit.name() + face.name() + ".png";
    url = "src/main/resources/PlayingCards/" + filename;
  }

  /**
   * Returns the suit and face of the card as a string.
   * A 4 of hearts is returned as the string "H4".
   *
   * @return the suit and face of the card as a string
   */
  public String getAsString() {
    return String.format("%s%s", suit + " ",face);
  }

  public String getUrl() {
    return url;
  }

  /**
   * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for Clubs
   *
   * @return the suit of the card
   */
  public String getSuit() {
    return suit.name();
  }

  /**
   * Returns the face of the card (value between 1 and 13).
   *
   * @return the face of the card
   */
  public Enum getFace() {
    return face;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Card card = (Card) o;

    if (suit != card.suit) return false;
    return face == card.face;
  }
}
