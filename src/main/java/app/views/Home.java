package app.views;

import app.controllers.*;
import app.models.*;
import system.*;

public class Home {

	public static void main(String[] args) {
			
		UserController userC = new UserController();
		userC.create("Leonardo", "Flores", "LeoDavid", "leo123");
		userC.index();
	}

}
