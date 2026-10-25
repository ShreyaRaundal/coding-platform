package model;

public class TestCase {
    private String testcaseId;
    String input;
    String expectedoutput;
    boolean hidden;


    public TestCase(String testcaseId,String input,String expectedoutput,boolean hidden){
        this.testcaseId=testcaseId;
        this.input=input;
        this.expectedoutput=expectedoutput;
        this.hidden=hidden;
    }

    public String getTestCaseId(){
        return testcaseId;
    }

    public String getInput(){
        return input;
    }

    public String getExpectedOutput(){
        return expectedoutput;
    }

    public boolean getHidden(){
        return hidden;
    }
    
}
