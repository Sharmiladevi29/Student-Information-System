package SIS;

class Payment {
	private int paymentID;
	private Student student;
	private double amount;
	private String paymentDate;

    public Payment(int paymentID, Student student, double amount, String paymentDate) {
        this.paymentID = paymentID;
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
    
    public Student getstudent() {
    	return student;
    }
    public double getpaymentamount() {
    	return amount;
    }
    public String getpaymentdate() {
    	return paymentDate;
    }
}