/**
 * @(#)Server.java
 *
 *
 * @author 
 * @version 1.00 2016/4/26
 */


import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
  	public static void main(String[] args) throws Exception {
  		Map <InetAddress,Player> map = new HashMap<InetAddress,Player>(); 
    	LinkedList <InetAddress> queue = new LinkedList<InetAddress>();
    	Packet play;
    	int PORT = 9990;
    	byte[] buf = new byte[10240];
	    DatagramPacket dgp = new DatagramPacket(buf, buf.length);
	    DatagramSocket sk;
		DatagramPacket out;
	    sk = new DatagramSocket(PORT);
	    System.out.println("Server started");
		int skipCount=0;
    	Scanner kb = new Scanner(System.in);
    	again:
    	while (true) {	
       		//p1=new Player(200,200,10,"human");
			sk.receive(dgp);
			
			if (map.containsKey(dgp.getAddress())){
				//System.out.println(map);
				if (queue.element().equals(dgp.getAddress())){	
					skipCount=0;
					buf=dgp.getData();
					Object data = SerializationUtils.deserialize(buf);
					if (data.getClass().getName().equals("Packet")){
						play = (Packet)SerializationUtils.deserialize(buf);
						map.get(dgp.getAddress()).action(play);      	
						queue.add(queue.poll());
					}
					
				}
				else{
					skipCount+=1;
					if (skipCount>200){
						System.out.println(queue.element()+" Has been kicked off the server:");
						map.remove(queue.poll());
						
						System.out.println(map);
						
						
					}	
				}
			}
			else{
				queue.add(dgp.getAddress());
				map.put(dgp.getAddress(),(Player)SerializationUtils.deserialize(dgp.getData()));
				System.out.println("New User Joined :" + map.get(dgp.getAddress()).getName());
			}
			
	        buf = SerializationUtils.serialize(map.values().toArray());
    		out = new DatagramPacket(buf, buf.length, dgp.getAddress(), dgp.getPort());
      		sk.send(out);
    	}
	}
}


