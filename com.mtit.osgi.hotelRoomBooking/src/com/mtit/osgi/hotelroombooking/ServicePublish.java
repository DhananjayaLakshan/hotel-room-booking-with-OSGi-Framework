package com.mtit.osgi.hotelroombooking;

import java.util.ArrayList;

public interface ServicePublish {
	
	public String publisherService();
	
	public String LoginVerification(String username,String password);
	
	public void add_AC_nonAC_Room(String roomType, ArrayList available_AC_Rooms, ArrayList available_nonAC_Rooms, int roomsNumber);
	
	public void Remove_Ac_NonAc_Room(String RoomType,ArrayList available_AC_Rooms,ArrayList available_nonAC_Rooms,int roomsNumber);
	
	public void Book_AC_Room(int no_of_rooms,ArrayList available_AC_Rooms,ArrayList available_nonAC_Rooms,ArrayList Booked_Rooms);
	
	public void Book_NON_AC_Room(int no_of_rooms,ArrayList available_nonAC_Rooms,ArrayList available_AC_Rooms,ArrayList Booked_Rooms);
	
	public void Release_AC_Room(int Booked_Roomno,ArrayList available_AC_Rooms,ArrayList available_nonAC_Rooms,ArrayList Booked_Rooms);
	
	public void Release_NONAC_Room(int Booked_Roomno,ArrayList available_AC_Rooms,ArrayList available_nonAC_Rooms,ArrayList Booked_Rooms);
}
