package fresco;

public class SelfFinance extends Student{
	public static double calculateGP(double marks) {

		double gp = 0.0;
	if(marks < 40) {
		return 0.0;
	}
	else {		
		if(marks < 50 && marks > 39) {
		    gp = 6.9 - ((50.0-marks) / 10.0);
		}else if(marks < 60 && marks > 49) {
			gp = 7.9 - ((60.0 - marks) / 10.0);
		}else if(marks > 59 && marks < 75) {
			gp = 8.9 - ((75.0 - marks) / 15.0);
			
		}else if(marks >= 75 && marks < 100) {
			gp = 9.9 - ((100 - marks) / 25.0);
		}else if(marks == 100)
			gp = 10.0;
	}
	return gp;
}
	
	@Override
	public String result(String a) {
		String subject, sports;
		double gptotal = 0.0;
		int subindex;
		double subjectMarks = 0;
		double totalMarks = 0;
		double creditPointMax = 0;
		double gradePoint = 0.0;
		int courses = 0;
		subindex = a.indexOf("|");
		subject = a.substring(0,subindex);

		String[] subjectArray = subject.split(",");
		double subjectCreditTotal = 0;
		for(int i = 0; i < subjectArray.length; i++) {
			String sval = "";
			String elem = subjectArray[i];
			courses++;
			for(int j = 0; j < elem.length(); j++) {
				gradePoint = 0;
				if(elem.charAt(j) == ' ' && sval != "") {
					subjectMarks += Integer.parseInt(sval);
					gradePoint = calculateGP(subjectMarks);
					subjectCreditTotal+=(int)(elem.charAt(j+1)-48);
					
					System.err.println("gradepoint for " + subjectMarks + " = " + gradePoint);
					
					gptotal += (gradePoint * (double)(elem.charAt(j+1)-48));
					sval = "";
		
					totalMarks += subjectMarks;
					subjectMarks = 0; 
				}else if(elem.charAt(j) != ' '){
					sval += elem.charAt(j);
				}
			}
		}
		int sportIndex = a.lastIndexOf("|");
		sports = a.substring(sportIndex+1);

		// check if student is involved in sports
				double sportsSubjectMarks = 0;
				double sportsCreditPoints = 0;
				int check = (int)Integer.parseInt(sports.substring(0,1));
				if (check > 0 ) {
					courses++;

					int firstComma = sports.indexOf(",");
					int secondComma = sports.lastIndexOf(",");
					sportsSubjectMarks = Integer.parseInt(sports.substring(firstComma+1, secondComma));
					sportsCreditPoints = Integer.parseInt(sports.substring(secondComma+1));
				}
		creditPointMax = courses * 5;
		totalMarks += sportsSubjectMarks;
		gradePoint = calculateGP(sportsSubjectMarks);
		gptotal += gradePoint;
		
		subjectCreditTotal += sportsCreditPoints;
		
		System.err.println("courses: " + courses + " gradepoint: " + gradePoint + " average: " + totalMarks / courses);

		System.err.println("sportsMarks: " + subjectMarks + " creditTotal: " + subjectCreditTotal + " max: " + creditPointMax + " gradepoint: " + gradePoint);
		System.out.println( (gptotal * subjectCreditTotal) / creditPointMax);
		System.err.println("gptotal " + gptotal);
		double ans = (gptotal / creditPointMax);
		String result = String.format("%.2f",  ans);
		return result;
		
	}
}
