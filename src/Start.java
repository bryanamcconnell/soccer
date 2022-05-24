import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	soccer newSoccer = new soccer();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		new Start();
	}

	public Start() {
		ArrayList<Team> league = new ArrayList<Team>();
		System.out.println("Soccer!");
		System.out.println("Please select a number from the options below.\n");
		while (true) {
			System.out.println("1: Add a team to the league.");
			System.out.println("2: Remove a team from the league.");
			System.out.println("3: Search for a team by name.");
			System.out.println("4: Search for a team by ID.");
			System.out.println("5: Load from file");
			System.out.println("6: Save to a file.");
			System.out.println("7: Display the teams in the league.");
			System.out.println("0: Exit");
			int userChoice = input.nextInt();
			input.nextLine();
			switch (userChoice) {
				case 1:
					newSoccer.addTeam(league);
					break;
				case 2:
					newSoccer.removeTeam(league);
					break;
				case 3:
					newSoccer.searchTeamsByName(league);
					break;
				case 4:
					newSoccer.searchTeamsByID(league);
					break;
				case 5:
					newSoccer.loadTeams(league);
					break;
				case 6:
					newSoccer.saveTeams(league);
					break;
				case 7:
					newSoccer.displayTeams(league);
					break;
				case 0:
					System.exit(0);
			}
		}
	}
}
