package one;

/** 
 * 	   Solution for Fresco Play #Mini-Project - Java Programming Masterclass
 *     'Multiple Inheritance' hands-on challenge
 *     
 *     The solution does not provide input validation and is a minimal, 
 *     first attempt program to complete the challenge.
 *     
 *     @author phoenix 1 May 2022
 */
import java.util.Scanner;

interface HockeyTeam{
	public int calculateHockeyScore();
	
	public int findHighestGoalByIndividualInHockey();
}

interface FootballTeam{
	public int calculateFootballScore();
	
	public int findHighestGoalByIndividualInFootball();
}

public class MultipleInheritance {

	public static class Sport implements FootballTeam, HockeyTeam{
		private int[] hockeyPlayers;
		private int[] footballPlayers;
		
		public Sport(int[] paramHockeyPlayers, int[] paramFootballPlayers) {
			this.hockeyPlayers = paramHockeyPlayers;
			this.footballPlayers = paramFootballPlayers;
		}
		
			public int calculateHockeyScore() {
				int hockeyScore = 0;
			
				for(int i = 0; i < hockeyPlayers.length; i++) {
					hockeyScore+= hockeyPlayers[i];
				}
				return hockeyScore;
			}
				
			public int findHighestGoalByIndividualInHockey() {
				int maxHockey = 0;
				for(int i = 0; i < hockeyPlayers.length; i++) {
					if(hockeyPlayers[i] > maxHockey) {
						maxHockey = hockeyPlayers[i];
					}
				}return maxHockey;
			}
				
			
			public int calculateFootballScore() {
				int footballScore = 0;
			
				for(int i = 0; i < footballPlayers.length; i++) {
					footballScore += footballPlayers[i];
				}
				return footballScore;
			}
				
			public int findHighestGoalByIndividualInFootball() {
				int maxFootball = 0;
				for(int i = 0; i < footballPlayers.length; i++) {
					if(footballPlayers[i] > maxFootball) {
						maxFootball = footballPlayers[i];
					}
				}return maxFootball;
			}
		
	}
	
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int[] hockeyPlayers = new int[11];
        int[] footballPlayers = new int[11];
        
        System.out.println("Enter the 11 scores for the hockey team: ");
        for(int i = 0; i < 11; i++)
        {
            hockeyPlayers[i] = sc.nextInt();
        }

        System.out.println("Enter the 11 scores for the football team: ");
        for(int i = 0; i < 11; i++)
        {
            footballPlayers[i] = sc.nextInt();
        }
        
        Sport s = new Sport(hockeyPlayers, footballPlayers);
        try{
            HockeyTeam.class.getMethod("calculateHockeyScore");
            HockeyTeam.class.getMethod("findHighestGoalByIndividualInHockey");
            FootballTeam.class.getMethod("calculateFootballScore");
            FootballTeam.class.getMethod("findHighestGoalByIndividualInFootball");

            if(s instanceof HockeyTeam && s instanceof FootballTeam)
            {
                System.out.println(s.calculateHockeyScore());
                System.out.println(s.calculateFootballScore());
                System.out.println(s.findHighestGoalByIndividualInHockey());
                System.out.println(s.findHighestGoalByIndividualInFootball());
            }
        }
        catch (NoSuchMethodException ex)
        {
            System.out.println("No such function is exits");
        }
    }
}

