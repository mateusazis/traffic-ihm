package br.uff.ihm.traffic.models;

import java.util.Locale;

public class Bus {
	public float lotationPcgt, averageSpeed;
	public String id;
	public Line line;
	
	public Bus(String id, float lotationPctg, float averageSpeed){
		this.id = id;
		this.lotationPcgt = lotationPctg;
		this.averageSpeed = averageSpeed;
	}
	
	public static Bus random(){
		String id = String.format(Locale.getDefault(), "NIT.%02d-%03d", randInt(100), randInt(1000));
		float lotation = (float)Math.random();
		float averageSpeed = (float)(30 + Math.random() * 30);
		return new Bus(id, lotation, averageSpeed);
	}
	
	private static int randInt(int range){
		return (int)(Math.random() * range);
	}
}
