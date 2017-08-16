package com.shell.modular.business;

public class NewLoanApplication {

	private int appid,age,regno;
	private long accnum,pcontact,offcontact,loanamt,moninc;
	private	String salutation,fname,mname,lname;
	private String pan,mail,gender,date,paddress,rowner,emptype,comp,desg,offaddress,offmail,exist_loan;
	private String filePath,status,plan;
	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public long getAccnum() {
		return accnum;
	}

	public void setAccnum(long accnum) {
		this.accnum = accnum;
	}

	public long getPcontact() {
		return pcontact;
	}

	public void setPcontact(long pcontact) {
		this.pcontact = pcontact;
	}

	public long getOffcontact() {
		return offcontact;
	}

	public void setOffcontact(long offcontact) {
		this.offcontact = offcontact;
	}

	public long getLoanamt() {
		return loanamt;
	}

	public void setLoanamt(long loanamt) {
		this.loanamt = loanamt;
	}

	public long getMoninc() {
		return moninc;
	}

	public void setMoninc(long moninc) {
		this.moninc = moninc;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getRowner() {
		return rowner;
	}

	public void setRowner(String rowner) {
		this.rowner = rowner;
	}

	public String getEmptype() {
		return emptype;
	}

	public void setEmptype(String emptype) {
		this.emptype = emptype;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getOffaddress() {
		return offaddress;
	}

	public void setOffaddress(String offaddress) {
		this.offaddress = offaddress;
	}

	public String getOffmail() {
		return offmail;
	}

	public void setOffmail(String offmail) {
		this.offmail = offmail;
	}

	public String getExist_loan() {
		return exist_loan;
	}

	public void setExist_loan(String exist_loan) {
		this.exist_loan = exist_loan;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}





	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public NewLoanApplication(int appid, int age, int regno, long accnum,
			long pcontact, long offcontact, long loanamt, long moninc,
			String salutation, String fname, String mname, String lname,
			String pan, String mail, String gender, String date,
			String paddress, String rowner, String emptype, String comp,
			String desg, String offaddress, String offmail, String exist_loan,
			String filePath, String status,String plan) {
		super();
		this.appid = appid;
		this.age = age;
		this.regno = regno;
		this.accnum = accnum;
		this.pcontact = pcontact;
		this.offcontact = offcontact;
		this.loanamt = loanamt;
		this.moninc = moninc;
		this.salutation = salutation;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.pan = pan;
		this.mail = mail;
		this.gender = gender;
		this.date = date;
		this.paddress = paddress;
		this.rowner = rowner;
		this.emptype = emptype;
		this.comp = comp;
		this.desg = desg;
		this.offaddress = offaddress;
		this.offmail = offmail;
		this.exist_loan = exist_loan;
		this.filePath = filePath;
	//	this.filePath2 = filePath2;
		//this.filePath3 = filePath3;
		this.status=status;
		this.plan=plan;
	}

	public String getPlan() {
		return plan;
	}
















}
