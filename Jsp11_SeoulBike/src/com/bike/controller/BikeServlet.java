package com.bike.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;




@WebServlet("/bike.do")
public class BikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BikeServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("[command: " +command+"]");
		
		BikeDao dao = new BikeDao();
		
		if(command.equals("first")) {
			response.sendRedirect("bike01.jsp");
		}else if(command.equals("first_db")){
			
			dao.delete();
			
			String[] bikeList = request.getParameterValues("bike");
			
			System.out.println(bikeList.length);
			
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			for(int i=0; i<bikeList.length; i++) {
			//	System.out.println(bikeList[i]);
				String[] tmp =bikeList[i].split("/");
				BikeDto dto = new BikeDto(tmp[0],
								  Integer.parseInt(tmp[1]),
								  tmp[2].trim(),
								  tmp[3].trim(),
								  Integer.parseInt(tmp[4]),
								  Double.parseDouble(tmp[5]),
								  Double.parseDouble(tmp[6]));
				
				dtos.add(dto);
				
				
			}
			int res = dao.insert(dtos);
			
			if(res == dtos.size()) {
				System.out.println("\ninsert 성공\n");
				response.sendRedirect("index.html");
			}else {
				System.out.println("\ninsert 실패..");
				response.sendRedirect("bike.do?command=first");
			}
				
		}else if(command.equals("second")) {
			response.sendRedirect("bike02.jsp");
		}else if(command.equals("second_db")) {
			
			dao.delete();
			
			String obj = request.getParameter("obj");
			System.out.println(obj);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(obj);
			
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			
			for(int i=0; i<element.getAsJsonObject().get("DATA").getAsJsonArray().size(); i++ ) {
				//System.out.println(element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject().get("new_addr"));
				
				JsonObject tmp = element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject();
				
				JsonElement addr_gu_je = tmp.get("addr_gu");
				JsonElement content_id_je = tmp.get("content_id");
				JsonElement content_nm_je = tmp.get("content_nm");
				JsonElement new_addr_je = tmp.get("new_addr");
				JsonElement cradle_count_je = tmp.get("cradle_count");
				JsonElement longitude_je = tmp.get("longitude");
				JsonElement latitude_je = tmp.get("latitude");
				
				String addr_gu = addr_gu_je.getAsString();
				int content_id = content_id_je.getAsInt();
				String content_nm = content_nm_je.getAsString();
				String new_addr = new_addr_je.getAsString();
				int cradle_count = cradle_count_je.getAsInt();
				double longitude = longitude_je.getAsDouble();
				double latitude = latitude_je.getAsDouble();
				
				//System.out.printf("%s,%d,%s,%s,%d,%f,%f\n",addr_gu,content_id,content_nm,new_addr,cradle_count,longitude,latitude);
				
				BikeDto dto = new BikeDto();
				dto.setAddr_gu(addr_gu);
				dto.setContent_id(content_id);
				dto.setContent_nm(content_nm);
				dto.setNew_addr(new_addr);
				dto.setCradle_count(cradle_count);
				dto.setLongitude(longitude);
				dto.setLatitude(latitude);
				
				
				
				dtos.add(dto);
			}
			
			int result = dao.insert(dtos);
			if(result == dtos.size()) {
				System.out.println("\ninsert 성공!");
			}else{
				System.out.println("\ninsert 실패..");
			}
			
			PrintWriter out = response.getWriter();
			out.print(result);
			
			
			
		}
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
