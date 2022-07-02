package org.necrotic;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RichPresense {

	private final String CLIENT_ID = "863501926120292363";

	private DiscordRPC lib;
	private DiscordRichPresence presence;

	public void initiate() {
		lib = DiscordRPC.INSTANCE;
		DiscordEventHandlers handlers = new DiscordEventHandlers();
		lib.Discord_Initialize(CLIENT_ID, handlers, true, "");
		presence = new DiscordRichPresence();
		presence.startTimestamp = System.currentTimeMillis() / 1000;
		presence.largeImageKey = "avatar";
		presence.smallImageKey = "avatar";
		presence.details = "The #1 Custom RSPS";
		presence.state = "Play now with 200+ Players!";
		updatePresence();
		new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				lib.Discord_RunCallbacks();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ignored) {
				}
			}
		}, "RPC-Callback-Handler").start();
	}


	public void reloadPresence() {
		presence.details = "Play The #1 Custom RSPS";
		presence.state = "Solak.io";
	}

	public static String getPlayercount() {
		try {
			String url = "";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} catch (Exception e) {
			return "212";
		}
	}

	public boolean presenceIsNull() {
		return presence == null;
	}

	public void updateDetails(String details) {
		presence.details = details;
		updatePresence();
	}

	public void updateState(String state) {
		presence.state = state;
		updatePresence();
	}

	public void updateSmallImageKey(String key) {
		presence.smallImageKey = key;
		updatePresence();
	}

	private void updatePresence() {
		lib.Discord_UpdatePresence(presence);
	}
}
