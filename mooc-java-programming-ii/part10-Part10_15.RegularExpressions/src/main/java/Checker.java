

public class Checker {
    String regex;
    String input;
    String vowels;

    public Checker() {
        this.regex = "mon|tue|wed|thu|fri|sat|sun";
        this.vowels = "[a|e|i|o|u]*";
    }
    
    public boolean isDayOfWeek(String string){
        return string.matches(this.regex);
    }
    
    public boolean allVowels(String string){
        return string.matches(this.vowels);
    }
    
    public boolean timeOfDay(String string){
        String timeForm = "([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        return string.matches(timeForm);
    }
}
