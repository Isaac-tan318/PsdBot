package com.PS.PsdBot;

import com.PS.PsdBot.MessageParsing.BotConfig;

public class PsdBotApplication {

	public static void main(String[] args) {
		System.out.println("first");

		BotConfig botConfig = new BotConfig();
		System.out.println("hi");
		botConfig.runBot();
		System.out.println("main");
	}


}
