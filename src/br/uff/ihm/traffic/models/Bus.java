package br.uff.ihm.traffic.models;

public class Bus {
	public float lotationPcgt, averageSpeed;
	public int id;
	public Line line;
	
	public Bus(int id, float lotationPctg, float averageSpeed){
		this.id = id;
		this.lotationPcgt = lotationPctg;
		this.averageSpeed = averageSpeed;
	}
	
	public static Bus random(){
		int id = (int)(Math.random() * 10000);
		float lotation = (float)Math.random();
		float averageSpeed = (float)(30 + Math.random() * 30);
		return new Bus(id, lotation, averageSpeed);
	}
}
