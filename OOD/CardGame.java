class Card {
	private int suit;
	private int number;
	public Card(int suit, int number) {
		this.suit = suit;
		this.nmber = number;
	}
	public int returnNumber() {}
	public int returnSuit() {}
}

class Deck {
	private LinkedList<Card> cards;
	public Deck() {
	}
	
	public void deliver(Hand h, Card c) {
		if(cards == null || cards.size == 0) return;
		h.add(cards.removeFirst());
	}

	public void shuffleCards() {
		for(int i=0; i<cards.size(); i++) {
			Random r = new Random();
			int swapIndex = Random.nextInt(card.size() - i) + i;
			Card tmp = cards.get(i);
			cards.set(i, cards.get(j));
			cards.set(j, tmp);
		}
	}


}
class Hand {
	private ArrayList<Card> handCards;
	public Card remove(Card c) {}
	public void add(Card c) {
		
	}
}


