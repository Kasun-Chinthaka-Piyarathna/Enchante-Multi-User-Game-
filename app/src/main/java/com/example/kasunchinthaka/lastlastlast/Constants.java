/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.example.kasunchinthaka.lastlastlast;

/**
 * The Class Constants.
 */
/*
 * This class contains all constants variables that require in application.
 */
public class Constants {
	
	/** The Constant App42ApiKey. */
	/*zzzzzzzzz
	 * For getting API_KEY & SECRET_KEY, just login or register to AppHQ Console (http://apphq.shephertz.com/). 
	 */
	 static final String App42ApiKey = "92e4a2fa44a77d748f7e3934e992cf83cd4e263bee94e4d4e6cca790cc859b04";  // API_KEY received From AppHQ console, When You create your first app in AppHQ Console.
	 
 	/** The Constant App42ApiSecret. */
 	static final String App42ApiSecret = "2bcacf078d0968c2883f3b54aaf00057b76ef8bf07d2910f28cac3aefe04ff22"; // SECRET_KEY received From AppHQ console, When You create your first app in AppHQ Console.
	 
	 /** The Constant App42DBName. */
 	/*
	  * For creating Database from AppHQ console, just go to (Technical Service Manager -> Storage Service -> click "Add DB".)
	  */
	 static final String App42DBName = "ENCHANTE";  // Change it as your requirement. (Note that, only one DataBase can be created through same API_KEY & SECRET_KEY);
	
	 /** The Constant CollectionName. */
 	static final String CollectionName = "excaliberCollection"; // Change it as your requirement.
	
	 /** The Constant App42GameName. */
 	/*
	  * For Creating Game, just go to (Business Service Manager -> Game Service -> select Game -> click "Add Game".)
	  */
	 static final String App42GameName = "ENCHANTE"; // Change it as your requirement. (You have to create game through AppHQ console.);
	 
	 /** The Constant IntentUserName. */
 	static final String IntentUserName = "Dinusha9999";
	 
 	/** The Constant App42AndroidPref. */
 	static final String App42AndroidPref="ENCHANTEPreferences";
	 
 	/** The Constant UserName. */
 	static final String UserName = USER.username;   // must be a parameter
}