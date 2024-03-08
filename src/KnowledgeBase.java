public class KnowledgeBase {
   protected  String term;
   protected String statement;
   protected double confidenceScore;

    public KnowledgeBase(String term, String statement, double confidenceScore) {
        this.term = term;
        this.statement = statement;
        this.confidenceScore = confidenceScore;
    }
    
    public String getTerm(){
      return this.term;
    }
    public void setTerm(String term){
       this.term = term;
    }
    public String getStatement(){
      return this.statement;
    }
    
     public void setStatement(String statement){
       this.statement = statement;
    }

    public double getConfidenceScore(){
      return this.confidenceScore;
    }
    
     public void setConfidenceScore(double confidenceScore){
      this.confidenceScore = confidenceScore;
    }
    
        public String termSearch() {
        return "Statement found: " + this.statement + " (confidence score:) " + this.confidenceScore ;
    }

    public String termAndStatementSearch() {
        return "Both term " + this.term + " and statement " + this.statement + " were found " +
                "with a confidence score of " + this.confidenceScore;
    }
    public String update(){
      return "Statement for term" + this.term + " has been updated.";
    }
    
    public int compareTo(KnowledgeBase other) {
        return this.term.compareTo(other.term);
    }    

    public String toString() {
        return "Term: " + this.term + ", Statement: " + this.statement + ", Confidence Score: " + this.confidenceScore;
    }
}
