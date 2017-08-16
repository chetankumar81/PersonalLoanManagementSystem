package com.shell.modular.business;

import java.util.ArrayList;

import com.shell.modular.dao.DatabaseAccess;

public class MessageFetch {


	public ArrayList<Message> fetchMessages(int regId)
	{
		// updates the database with the loan officer's feedback.

		return new DatabaseAccess().viewMessages(regId);

	}

}
