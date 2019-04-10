package LinkedList;

import java.io.*;
import java.util.Scanner;

public class Mix {

	private DoubleLinkedList<Character> message;
	private String undoCommands;
	private NodeCB clipBoards;

	private String userMessage;
	private Scanner scan;

	public Mix() {
		scan = new Scanner(System.in);
		message = new DoubleLinkedList<Character>();
		clipBoards = new NodeCB();

		undoCommands = "";
	}

	public static void main(String[] args) {
		Mix mix = new Mix();
		mix.userMessage = args[0];
		for(int i = 0; i < mix.userMessage.length(); i++){
			mix.message.add(mix.userMessage.charAt(i), i);
		}
		System.out.println (mix.userMessage);
		mix.mixture();
	}


	private void mixture() {
		do {
			DisplayMessage();
			System.out.print("Command: ");

			// save state
			DoubleLinkedList<Character> currMessage =  new DoubleLinkedList<>();
			String currUndoCommands = undoCommands;

			try {
				String command = scan.next("[Qbrpcxh]");

				switch (command) {
				case "Q":
					save(scan.next());
					System.out.println ("Final mixed up message: \"" + message+"\"");
					System.exit(0);
				case "b":
					String insertMessage = scan.nextLine();
					int startIndex = 0;
					int endIndex;
					for(endIndex = 0; endIndex < insertMessage.length(); endIndex++){
						if(Character.isDigit(insertMessage.charAt(endIndex)) && endIndex == insertMessage.length() - 1) {
							startIndex = endIndex;
							do{
								startIndex--;
							}while(Character.isDigit(insertMessage.charAt(startIndex)));
						}
					}

					insertbefore(insertMessage.substring(1, startIndex), Integer.parseInt(insertMessage.substring(startIndex + 1, endIndex)));
					break;
				case "r":
					remove(scan.nextInt(), scan.nextInt());
					break;
				case "c":
					copy(scan.nextInt(), scan.nextInt(), scan.nextInt());
					break;
				case "x":
					cut(scan.nextInt(), scan.nextInt(), scan.nextInt());
					break;
				case "p":
					paste(scan.nextInt(), scan.nextInt());
					break;
				case "h":
					helpPage();
					break;

					// all the rest of the commands have not been done
                    // No "real" error checking has been done.
				}
				scan.nextLine();   // should flush the buffer
				System.out.println("For demonstration purposes only:\n" + undoCommands);
			}
			catch (Exception e ) {
				System.out.println ("Error on input, previous state restored.");
				scan = new Scanner(System.in);  // should completely flush the buffer

				// restore state;
				undoCommands = currUndoCommands;
				message = currMessage ;
			}

		} while (true);
	}

	private void remove(int start, int stop) {
        for(int i = 0; i <= stop - start; i++)
            message.delete(start);
	}

	private void cut(int start, int stop, int clipNum) {

	}

	private void copy(int start, int stop, int clipNum) {
		NodeCB targetClipboard = clipBoards;
		NodeD currentNode;
		while(targetClipboard.getClipBoardNumber() != clipNum && targetClipboard.getNext() != null){
			targetClipboard = targetClipboard.getNext();
		}
		if(targetClipboard.getClipBoardNumber() == clipNum){
			currentNode = targetClipboard.getTopOfClipBoard();
		}
		else{
			//currentNode
		}
	}

	private void paste( int index, int clipNum) {

	}
         
	private void insertbefore(String token, int index) {
		for(int i = 0; i < token.length(); i++) {
			message.add(token.charAt(i), index + i);
		}
	}

	private void DisplayMessage() {
		System.out.print ("Message:\n");
		userMessage = message.toString();

		for (int i = 0; i < userMessage.length(); i++) 
			System.out.format ("%3d", i);
		System.out.format ("\n");
		for (char c : userMessage.toCharArray()) 
			System.out.format("%3c",c);
		System.out.format ("\n");
	}

	public void save(String filename) {

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

		} catch (IOException e) {
			e.printStackTrace();
		}

		out.println(undoCommands);
		out.close();
	}

	private void helpPage() {
		System.out.println("Commands:");
		System.out.println("\tQ filename	means, quit! " + " save to filename" );			
		System.out.println("\t  ~ is used for a space character" );		
		System.out.println("\t .... etc" );		
		System.out.println("\th\tmeans to show this help page");
	}
}
