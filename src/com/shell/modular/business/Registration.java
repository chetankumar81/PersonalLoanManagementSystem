package com.shell.modular.business;

  import java.util.*;
  public class Registration  // package com.shell.modular.business
  {
      
    private String fName,mName,lName,email,address,username,password,gender,question,answer;
    private long contact;
    private Date dob;
    
    public Registration(String fName,String mName,String lName,String email,String address,
    String username,String password,String gender,String question,String answer,long contact, Date dob){
        super();
        this.fName=fName;
        this.mName=mName;
        this.lName=lName;
        this.email=email;
        this.address=address;
        this.username=username;
        this.password=password;
        this.gender=gender;
        this.question=question;
        this.answer=answer;
        this.contact=contact;
        this.dob=dob;
    }

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
    
   
    
  }