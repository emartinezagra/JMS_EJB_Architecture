package es.uem.aju.customer;

import java.util.HashSet;
import java.util.Set;

public class UserSimulator {

	//15 equipments
	//50 users
	public static void main(String[] args) {
		
		Set<Integer> users = new HashSet<Integer>();
		
		for (int i=0;i<50;i++){
			users.add(i);
		}	
		
		Sender sender = new Sender();

		while (true){
		
			int randomEquipment = 0 + (int)(Math.random() * 15);
			int randomUser = 0 + (int)(Math.random() * 50);
			long randomRest = 0 + (int)(Math.random() * 5000);
			
			if (users.remove(randomUser)){
				User user = new User(randomUser, randomEquipment, sender);
				new Thread(user).start();
				try {
					Thread.sleep(randomRest);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else
				continue;
		}	
	}	
}
