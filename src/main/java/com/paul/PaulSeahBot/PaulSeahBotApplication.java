package com.paul.PaulSeahBot;

import com.paul.PaulSeahBot.MessageParsing.ReactiveBotConfig;

public class PaulSeahBotApplication {

	public static void main(String[] args) {

		ReactiveBotConfig botConfig = new ReactiveBotConfig();
		System.out.println("hi");
		botConfig.runBot();
		System.out.println("main");
	}


}
