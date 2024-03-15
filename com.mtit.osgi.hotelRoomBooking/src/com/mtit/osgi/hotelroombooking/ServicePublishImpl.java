package com.mtit.osgi.hotelroombooking;

import java.util.ArrayList;
import java.util.Collections;

public class ServicePublishImpl implements ServicePublish{
	
	float Total_Room_Charge = (float) 0.0;
	int Release_Room;

	@Override
	public String publisherService() {
		return "Execute the publish service of ServicePublisher";
	}

	@Override
	public String LoginVerification(String username, String password) {
		
		if((username.equals("admin")) && (password.equals("123")))
    	{
			return "admin";
		}
		else if((username.equals("cashier")) && (password.equals("789")))
		{
			return "cashier";
		}else
		{
			return "invalid";
		}	
	}

	@Override
	public void add_AC_nonAC_Room(String roomType, ArrayList available_AC_Rooms, ArrayList available_nonAC_Rooms,
			int roomsNumber) {
		
		if(roomType.equals("AC") || roomType.equals("ac"))
		{
			available_AC_Rooms.add(roomsNumber);
			 System.out.println("New  AC Room Added "+roomsNumber);  	       	  
			
			    Collections.sort(available_AC_Rooms);
			    Collections.sort(available_nonAC_Rooms);
			    System.out.println("Available AC Rooms:"+available_AC_Rooms);
			    System.out.println("Available NON AC Rooms:"+available_nonAC_Rooms);			
		}
		 else if(roomType.equals("NONAC") || roomType.equals("nonac"))
        {
			 available_nonAC_Rooms.add(roomsNumber);
       	   System.out.println("New NON AC Room Added"+roomsNumber);  
       	  
       	    Collections.sort(available_AC_Rooms);
		    Collections.sort(available_nonAC_Rooms);
		    System.out.println("Available AC Rooms:"+available_AC_Rooms);
		    System.out.println("Available NON AC Rooms:"+available_nonAC_Rooms);
        }	 
	}

	@Override
	public void Remove_Ac_NonAc_Room(String RoomType, ArrayList available_AC_Rooms, ArrayList available_nonAC_Rooms,
			int roomsNumber) {
		
		if(RoomType.equals("AC") || RoomType.equals("ac"))
		{
			for(int i=0;i<available_AC_Rooms.size();i++)
			{
				if(roomsNumber == (int)available_AC_Rooms.get(i))
				{
					available_AC_Rooms.remove(i);
					 System.out.println("New AC Room Removed "+ roomsNumber);  			       	  
				    
				    Collections.sort(available_AC_Rooms);
				    Collections.sort(available_nonAC_Rooms);
				    System.out.println("Available AC Rooms:"+available_AC_Rooms);
				    System.out.println("Available NON AC Rooms:"+available_nonAC_Rooms);
				}
				
			}
			
		}else if(RoomType.equals("NONAC") || RoomType.equals("nonac"))
        { 
			 for(int i=0;i<available_nonAC_Rooms.size();i++)
				{
					if(roomsNumber == (int)available_nonAC_Rooms.get(i))
					{
						available_nonAC_Rooms.remove(i);
						 System.out.println("NON AC Room Removed "+roomsNumber); 

						Collections.sort(available_AC_Rooms);
						Collections.sort(available_nonAC_Rooms);
						System.out.println("Available AC Rooms:"+available_AC_Rooms);
						System.out.println("Available NON AC Rooms:"+available_nonAC_Rooms);
					}
					
				}      	  
       	  
        }	
		
		
		
	}

	@Override
	public void Book_AC_Room(int no_of_rooms, ArrayList available_AC_Rooms, ArrayList available_nonAC_Rooms,
			ArrayList Booked_Rooms) {
		
		if(no_of_rooms <= available_AC_Rooms.size())
		{
			for(int i=0;i<no_of_rooms;i++)
			{
			  int j=0;
			  int room = (int) available_AC_Rooms.remove(j);
			  Booked_Rooms.add(room);
			}
			
			Total_Room_Charge = no_of_rooms * 2000;
			
		    System.out.println("Total Room Charge:"+Total_Room_Charge);
		    System.out.println();
		    Collections.sort(available_AC_Rooms);
		    Collections.sort(available_nonAC_Rooms);
		    System.out.println("Available AC Rooms:"+available_AC_Rooms);
		    System.out.println("Available NON AC Rooms:"+available_nonAC_Rooms);
		    System.out.println();
			
		}
		else
		{
			System.out.println("Sorry!!Number of Available AC Rooms less than No of Rooms  that You want ");
		}
		
	}

	@Override
	public void Book_NON_AC_Room(int no_of_rooms, ArrayList available_nonAC_Rooms, ArrayList available_AC_Rooms,
			ArrayList Booked_Rooms) {
		
		if(no_of_rooms <= available_nonAC_Rooms.size())
		{
			for(int i=0;i<no_of_rooms;i++)
			{  
				int j=0;
			    int room = (int) available_nonAC_Rooms.remove(j);
			    Booked_Rooms.add(room);
			    
			}
			
			Total_Room_Charge = no_of_rooms * 1500;
			
		    System.out.println("Total Room Charge:"+Total_Room_Charge);
		    System.out.println();
		    
		    System.out.println("Available AC Rooms:"+available_AC_Rooms);
		    System.out.println("Available NON AC Rooms:"+available_nonAC_Rooms);
		    System.out.println();
		}
		else
		{
			System.out.println("Sorry!!Number of Available NON AC Rooms less than No of Rooms  that You want ");
		}	
		
	}


	@Override
	public void Release_AC_Room(int Booked_Roomno, ArrayList available_AC_Rooms, ArrayList available_nonAC_Rooms,
			ArrayList Booked_Rooms) {
		
		for(int i=0;i<Booked_Rooms.size();i++)
		  {
			   if(Booked_Roomno == (int)Booked_Rooms.get(i))
			   {
				   if((int)Booked_Rooms.get(i) <= 5)
				   {
					   available_AC_Rooms.add((int)Booked_Rooms.get(i));
					   Booked_Rooms.remove(i);
					   Collections.sort(available_AC_Rooms);
					   Collections.sort(available_nonAC_Rooms);
					   System.out.println("Available AC Rooms:"+available_AC_Rooms);
					   System.out.println("Available NON AC Rooms:"+available_nonAC_Rooms);
					   System.out.println();
				   }			 
				   
			   }
			  
		  }
		
	}

	@Override
	public void Release_NONAC_Room(int Booked_Roomno, ArrayList available_AC_Rooms, ArrayList available_nonAC_Rooms,
			ArrayList Booked_Rooms) {
		
		for(int i=0;i<Booked_Rooms.size();i++)
		  {
			   if(Booked_Roomno == (int)Booked_Rooms.get(i))
			   {
				   if((int)Booked_Rooms.get(i) <= 5)
				   {
					   available_nonAC_Rooms.add((int)Booked_Rooms.get(i));
					   Booked_Rooms.remove(i);
					   Collections.sort(available_AC_Rooms);
					   Collections.sort(available_nonAC_Rooms);
					   System.out.println("Available AC Rooms:"+available_AC_Rooms);
					   System.out.println("Available NON AC Rooms:"+available_nonAC_Rooms);
					   System.out.println();
				   }				   
				   
			   }
 
		  }
		
	}

}
