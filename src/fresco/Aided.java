package fresco;

public class Aided extends Student{

	public static double calculateGP(int marks) {

		double gp = 0;
	if(marks < 40) {
		return 0;
	}
	else {		
		if(marks < 50 && marks > 39) {
		    gp = 7.0 - ((50-marks) / 10);
		}else if(marks < 60 && marks > 49) {
			gp = 8.0 - ((60 - marks) / 10);
		}else if(marks > 59 && marks < 75) {
			gp = 9.0 - ((75 - marks) / 15);
			
		}else if(marks >= 75 && marks <= 100) {
			gp = 10.0 - ((100 - marks) / 25);
		}
	}
	return gp;
}
	
	@Override
	public String result(String a) {
		String subject, ncc, sports;
		int subindex, nccindex, sportsindex;
		int subjectMarks = 0;
		int nccMarks = 0;
		int sportsMarks = 0;
		int creditPointMax = 0;
		double gradePoint = 0.0;
		int courses = 0;
		subindex = a.indexOf("|");
		subject = a.substring(0,subindex);
		System.err.println(subject);
		String[] subjectArray = subject.split(",");
		int subjectCreditTotal = 0;
		for(int i = 0; i < subjectArray.length; i++) {
			String sval = "";
			String elem = subjectArray[i];
			String subjectCredit = "";
			creditPointMax += 5;
			courses++;
			for(int j = 0; j < elem.length(); j++) {
				System.err.println("sval: " + sval);
				if(elem.charAt(j) == ' ' && sval != "") {
					subjectMarks += Integer.parseInt(sval);
					gradePoint += calculateGP(subjectMarks);
					subjectCreditTotal += (int)(elem.charAt(j+1)-48);
					sval = "";
					
				}else if(elem.charAt(j) != ' '){
					sval += elem.charAt(j);
				}
			}
			System.err.print("subjectMarks: " + subjectMarks + " subjectCreditTotal: " + subjectCreditTotal+ "\n");
			System.err.println("gradepoint: " + gradePoint);
		}
		
		nccindex = a.lastIndexOf("|");
		ncc = a.substring(subindex+1,nccindex);
		System.err.println(ncc);
		
		// check if student is involved in ncc
		int nccSubjectMarks = 0;
		int nccCreditPoints = 0;
		int check = (int)Integer.parseInt(ncc.substring(0,1));
		if (check > 0 ) {
			courses++;
			int firstComma = ncc.indexOf(",");
			int secondComma = ncc.lastIndexOf(",");
			nccSubjectMarks = Integer.parseInt(ncc.substring(firstComma+1, secondComma));
			nccCreditPoints = Integer.parseInt(ncc.substring(secondComma+1));
			System.out.println(nccSubjectMarks + " " + nccCreditPoints);
			creditPointMax += 5;
			gradePoint += calculateGP(nccSubjectMarks);
		}
		
		
		sports = a.substring(nccindex+1);
		System.err.println(sports);
		
		// check if student is involved in sports
				int sportsSubjectMarks = 0;
				int sportsCreditPoints = 0;
				check = (int)Integer.parseInt(sports.substring(0,1));
				if (check > 0 ) {
					courses++;
					int firstComma = sports.indexOf(",");
					int secondComma = sports.lastIndexOf(",");
					sportsSubjectMarks = Integer.parseInt(sports.substring(firstComma+1, secondComma));
					sportsCreditPoints = Integer.parseInt(sports.substring(secondComma+1));
					System.out.println(sportsSubjectMarks + " " + sportsCreditPoints);
					creditPointMax += 5;
				}
		subjectMarks += nccSubjectMarks + sportsSubjectMarks;
		gradePoint = calculateGP( subjectMarks / courses);
		
		subjectCreditTotal += nccCreditPoints + sportsCreditPoints;
		System.err.println("sMarks: " + subjectMarks + " creditTotal: " + subjectCreditTotal + " max: " + creditPointMax + " gradepoint: " + gradePoint);
		System.out.println( (gradePoint * subjectCreditTotal) / creditPointMax);
		double ans = ((gradePoint * subjectCreditTotal) / creditPointMax);
		String result = String.format("%.2f",  ans);
		return result;
		
	}
}
