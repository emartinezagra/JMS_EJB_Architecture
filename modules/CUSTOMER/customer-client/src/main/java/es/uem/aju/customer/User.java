package es.uem.aju.customer;

public class User implements Runnable {

	private long minRange = 5000;
	private long maxRange = 50000;
	private int userId;
	private int equipmentId;
	private Sender sender;
	
	
	public User(int userId, int equipmentId, Sender sender) {
		super();
		this.userId = userId;
		this.equipmentId = equipmentId;
		this.sender = sender;
	}

	public void run() {
		
		String activityIn = String.valueOf(userId)+","+String.valueOf(equipmentId)+",true";
		sender.sendMessageToQueue(activityIn);
		long randomRest = minRange + (int)(Math.random() * maxRange); 
		try {
			Thread.sleep(randomRest);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String activityOut = String.valueOf(userId)+","+String.valueOf(equipmentId)+",false";
		sender.sendMessageToQueue(activityOut);
	}
}
