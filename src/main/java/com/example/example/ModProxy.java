package com.example.example;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

public abstract class ModProxy {

	public void onInit(final FMLCommonSetupEvent event) {}
	public void onServerStarting(final FMLServerStartingEvent event) {}
	public void onServerStarted(final FMLServerStartedEvent event) {}

	/* Listener */
	protected void addListener(final Class<?>... listeners) {
		for(final Class<?> listener : listeners) {
			try {
				final Object instanciedListener = listener.newInstance();
				MinecraftForge.EVENT_BUS.register(instanciedListener);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}