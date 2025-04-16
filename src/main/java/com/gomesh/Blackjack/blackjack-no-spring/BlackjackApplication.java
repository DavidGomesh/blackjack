import java.util.Scanner;

public class BlackjackApplication {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\n\n\nBlackjack\n\n\n");

		var shoe = Shoe.of(1);
		shoe.shuffle();
		// shoe.log();
		// System.out.println();

		// var tray = Tray.empty();
		// tray.log();

		while (true) {
			var dealer = Hand.empty();
			var player = Hand.empty();
	
			dealer.addCard(shoe.getOne());
			dealer.addCard(shoe.getOne());
	
			// dealer.addCard(Card.TWO_OF_CLUBS);
			// dealer.addCard(Card.TWO_OF_CLUBS);
			// dealer.addCard(shoe.getOne());
	
			player.addCard(shoe.getOne());
			player.addCard(shoe.getOne());
	
			if (dealer.isBlackjack()) {
				logGame(dealer, player, shoe, true);
				System.out.println("\n\n\nDealer wins!");
				scanner.close();
				return;
			}
			
			while (player.value() < 21) {
	
				logGame(dealer, player, shoe, false);
				System.out.print("Hit or Stop? ");
				var acao = scanner.nextLine();
	
				if (acao.equals("H")) {
					player.addCard(shoe.getOne());
				} 
				else {
					break;
				}
			}
	
			if (player.isBusted()) {
				logGame(dealer, player, shoe, true);
				System.out.println("\n\n\nDealer wins!");
				scanner.close();
				return;
			}
	
			while (dealer.value() < 17) {
				dealer.addCard(shoe.getOne());
				logGame(dealer, player, shoe, true);
			}
			
			logGame(dealer, player, shoe, true);
			if (dealer.isBusted()) {
				System.out.println("Player wins!");
			} else {
				if (dealer.value() > player.value()) {
					System.out.println("Dealer wins!");
				}
				else if (dealer.value() < player.value()) {
					System.out.println("Player wins!");
				}
				else {
					System.out.println("Draw!");
				}
			}

			scanner.nextLine();
		}


		
		// System.out.print("\n\n\nDone!\n\n\n");
		// scanner.close();
	}

	public static void logGame(Hand dealer, Hand player, Shoe shoe, boolean showHiddenCard) {
		clearTerminal();

		showDealer(dealer, showHiddenCard);
		showPlayer(player);
		System.out.println();

		showShoe(shoe, false);
	}

	public static void showDealer(Hand hand, boolean showHiddenCard) {
		if (showHiddenCard) {
			showHand(hand, "Dealer");
		} else {
			var value = Card.value(hand.first());
			System.err.println(
				"Dealer | Value: " +  (value == 1 ? value + 10 : value) + " - Card: " + hand.first()
			);
		}
	}

	public static void showPlayer(Hand hand) {
		showHand(hand, "Player");
	}
	
	public static void showHand(Hand hand, String playerName) {
		System.err.println(
			playerName + " | Value: " + hand.value() + " - Cards: " + hand.cards()
		);
	}

	public static void showShoe(Shoe shoe, boolean detailed) {
		System.out.println(
			"Shoe | Amount: " + shoe.amount() + (detailed ? " - Cards: " + shoe.cards() : "")
		);
	}

	public static void clearTerminal() {
		for(int i=0; i<500; i++) {
			System.out.println();
		}
	}

}
