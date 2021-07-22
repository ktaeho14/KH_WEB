$(function(){
	parseJson();
});

function parseJson(){
	$.getJSON("json/bike.json",function(data){
		$.ajax({
			url:"bike.do?command=second_db",
			method:"post",
			data:{"obj":JSON.stringify(data)},
			success:function(msg){
				if(msg>0){
					$.each(data,function(key,val){
			if(key == "DESCRIPTION"){
				$("table").attr("border","1");
				
				$("thead").append(
					"<tr>"+
					"<th>"+val.ADDR_GU+"</th>"+
					"<th>"+val.CONTENT_ID+"</th>"+
					"<th>"+val.CONTENT_NM+"</th>"+
					"<th>"+val.NEW_ADDR+"</th>"+
					"<th>"+val.CRADLE_COUNT+"</th>"+
					"<th>"+val.LONGITUDE+"</th>"+
					"<th>"+val.LATITUDE+"</th>"+
					"</tr>"
				);
			}else{
				//else -> key값이 DESCRIPTION이 아닌 ""DATA""일때
				//list : 배열(키값이 DATA의 VALUE값)
				//str : list안에 있는 하나의 json ({"new_addr":"서울특별시 강남구 압구정로 134","content_id":"2301","cradle_count":10,"longitude":127.02179,"content_nm":" 현대고등학교 건너편","latitude":37.524071,"addr_gu":"강남구"})
				var list = val;
				for(var i=0; i<list.length; i++){
					var str=list[i];
					$("tbody").append(
						"<tr>"+
						"<td>"+str.addr_gu+"</td>"+
						"<td>"+str.content_id+"</td>"+
						"<td>"+str.content_nm+"</td>"+
						"<td>"+str.new_addr+"</td>"+
						"<td>"+str.cradle_count+"</td>"+
						"<td>"+str.longitude+"</td>"+
						"<td>"+str.latitude+"</td>"+
						"<input type='hidden' name='bike' value='"+
						str.addr_gu+"/"+str.content_id+"/"+str.content_nm+"/"+
						str.new_addr+"/"+str.cradle_count+"/"+str.longitude+"/"+str.latitude+"'/>"+
						"</tr>"
					);
				}
			}
		});
				}else{
					alert("data 저장 실패!!");
				}
			},
			error:function(){
				alert("fail !!!");
			}
		});
	});
	
	
	
	
	
	
}





