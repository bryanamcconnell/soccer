import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


public class soccer {
	
	Scanner input = new Scanner(System.in);
		
	public void addTeam(ArrayList<Team> league) {
		System.out.println("Enter the name of the team: ");
		String name = input.nextLine();
		name = name.toLowerCase();
		name = name.toUpperCase().charAt(0) + name.substring(1, name.length());
		System.out.println("Enter the atkRating of " + name + ": ");
		double atkRating;
		try {
			atkRating = input.nextDouble();
		} catch (InputMismatchException e) {
			return;
		}
		System.out.println("Enter the defRating of " + name + ": ");
		double defRating;
		try {
			defRating = input.nextDouble();
		} catch (InputMismatchException e) {
			return;
		}
		System.out.println("Enter initial tableRank: ");
		int tableRank;
		try {
			tableRank = input.nextInt();
		} catch (InputMismatchException e) {
			return;
		}
		System.out.println("Enter the baseScore: ");
		double baseScore;
		try {
			baseScore = input.nextDouble();
		} catch (InputMismatchException e) {
			return;
		}
		System.out.println("Enter the team ID: ");
		int id;
		try {
			id = input.nextInt();
		} catch (InputMismatchException e) {
			return;
		}
		Team newTeam = new Team(name, atkRating, defRating, tableRank, baseScore, id);
		league.add(newTeam);
		input.nextLine();
		return;
	}

	public void removeTeam(ArrayList<Team> league) {
		System.out.println("Please select a number from the options below");
		System.out.println("");
		System.out.println("1: Remove team by name.");
		System.out.println("2: Remove team by ID");
		System.out.println("0: Go back.");
		
		try {
			int userChoice = input.nextInt();
			input.nextLine();
			
			if (userChoice == 1) {
				System.out.println("Enter the name of the team to remove from the league:");
				String userSelection = input.nextLine();
				for (int i = 0; i < league.size(); i++) {
					Team name = league.get(i);
					String nameOne = name.getName();
					if (userSelection.equalsIgnoreCase(nameOne)) {
						league.remove(i);
						return;
					}
				}
			}
			else if (userChoice == 2) {
				System.out.println("Enter the ID of the team to remove from the league:");
				int userIdSelection = input.nextInt();
				for (int i = 0; i < league.size(); i++) {
					Team id = league.get(i);
					int idOne = id.getId();
					if (userIdSelection == idOne) {
						league.remove(i);
						return;
					}
				}
			}
			else {
				return;
			}
		} catch (InputMismatchException e) {
			return;
			
		}
	}

	
	public void searchTeamsByName(ArrayList<Team> league) {
		System.out.println("Enter the name of the team to seach for in the league:");
		String userSelection = input.nextLine();
		int count = 0;
		for (int i = 0; i < league.size(); i++) {
			if (userSelection.equalsIgnoreCase(league.get(i).getName())) {
				count++;
			}
		}
		if (count > 0) {
			System.out.println(userSelection + " is in the league.");
		}
		else {
			System.out.println(userSelection + " is not in the league.");
		}
	}

	public void searchTeamsByID(ArrayList<Team> league) {
		System.out.println("Enter the ID of the team to seach for in the league:");
		try {
			int idSelection = input.nextInt();
			int count = 0;
			for (int i = 0; i < league.size(); i++) {
				if (idSelection == (league.get(i).getId())) {
						count++;
				}
			}
			if (count > 0) {
				System.out.println(idSelection + " is in the league.");
			}
			else {
				System.out.println(idSelection + " is not in the league.");
			}
		} catch (InputMismatchException e) {
			return;
		}
	}
	
	public void loadTeams(ArrayList<Team> league){
		loadTeamsList(league);
	}
	
	public void loadTeamsList(ArrayList<Team> league){
		int idx = 0;
		try {
			File inFile = new File ("saveTeams.txt");
			Scanner read = new Scanner(inFile);
			
			while (read.hasNextLine()) {
				String line = read.nextLine().trim();
				String[] parts = line.split(", ");
				
				String name = parts[0].split("=")[1];
				double atkRating = Double.parseDouble(parts[1].split("=")[1]);
				double defRating = Double.parseDouble(parts[2].split("=")[1]);
				int tableRank = Integer.parseInt(parts[3].split("=")[1]);
				double baseScore = Double.parseDouble(parts[4].split("=")[1]);
				int id = Integer.parseInt(parts[5].split("=")[1]);
				Team newTeam = new Team(name, atkRating, defRating, tableRank, baseScore, id);
				league.add(newTeam);
				idx++;
			}	
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input was given.");
		} 
	}
	
	public void saveTeams(ArrayList<Team> league){
		try {
			File outFile = new File("saveTeams.txt");
			FileOutputStream fos = new FileOutputStream(outFile);
			PrintWriter pw = new PrintWriter(fos);
			
			for (int i = 0; i < league.size(); i++) {
				pw.println(league.get(i).toString());
			}
			
			pw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No file.");
			
		}
	}
	
	public void displayTeams(ArrayList<Team> league) {
		ArrayList<Team>dupeList = new ArrayList<Team>();
		ArrayList<Team>uniqueList = new ArrayList<Team>();
		
		int[] dupeArray = new int[league.size()];
		int[] uniqueArray = new int[league.size()];
		
		for (int i = 0; i < league.size(); i++) {
			dupeArray[i] = 0;
			uniqueArray[i] = 0;
		
		}
		int dupeCount = -1;
		int uniqueCount = -1;
		
		for (int i = 0; i < league.size(); i++) {
			int count = 0;
			
			if (uniqueArray[i] == 0) {
				uniqueArray[i] = 1;
				count = 1;
				int countTwo = i + 1;
				
				if (countTwo < league.size() - 1) {
					for (int j = countTwo; j < league.size(); j++) {
						if (uniqueArray[j] == 0) {
							if (league.get(i).getName().equals(league.get(j).getName())) {
								uniqueArray[j] = 1;
								count++;
							}
						}
					}
				}
				
				if (count == 1) {
					uniqueCount++;
					uniqueList.add(league.get(i));
				}
				else {
					dupeCount++;
					dupeList.add(league.get(i));
					dupeArray[dupeCount] = count;
				}
			}
		}
		
		dupeCount += 1;
		uniqueCount += 1;
		
		if (uniqueCount > 0) {
			for (int i = 0; i < uniqueCount; i++) {
				System.out.println(uniqueList.get(i).getName() + " - " + uniqueList.get(i).getClass().getSimpleName());
			}
		}
		
		if (dupeCount > 0) {
			for (int i = 0; i < dupeCount; i++) {
				System.out.println(dupeList.get(i).getName() + " - " + dupeArray[i] + " - " + dupeList.get(i).getClass().getSimpleName());
			}
		}

	}
	
}
