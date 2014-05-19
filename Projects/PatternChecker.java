package Projects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternChecker {
	
	private static final Pattern pattern1 = Pattern
			.compile("([KQNRBP])([ld])([a-h])([1-8])");
	private static final Pattern pattern2 = Pattern
			.compile("([a-h])([1-8]) ([a-h])([1-8])");
	private static final Pattern pattern3 = Pattern
			.compile("([a-h])([1-8]) ([a-h])([1-8])[*]");
	private static final Pattern pattern4 = Pattern
			.compile("([a-h])([1-8]) ([a-h])([1-8]) ([a-h])([1-8]) ([a-h])([1-8])");
	Matcher lastMatch;
	
	
public boolean checkPlace(String line){
	Matcher matchPlace = pattern1.matcher(line);
	if(matchPlace.find()){
		lastMatch = matchPlace;
		return true;
	}
	return false;
}
public boolean checkMove(String line){
	Matcher matchMove = pattern2.matcher(line);
	if(matchMove.find()){
		lastMatch = matchMove;
		return true;
	}
	return false;
}
public boolean checkTake(String line){
	Matcher matchTake = pattern3.matcher(line);
	if(matchTake.find()){
		lastMatch = matchTake;
		return true;
	}
	return false;
}
public boolean checkDubMove(String line){
	Matcher matchDubMove = pattern4.matcher(line);
	if(matchDubMove.find()){
		lastMatch = matchDubMove;
		return true;
	}
	return false;
}
public String getGroup(int group){
	return lastMatch.group(group);
}
}
