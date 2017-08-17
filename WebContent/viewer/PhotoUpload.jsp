<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
                              <form class="form-horizontal" action = "${pageContext.request.contextPath}/UploadPhoto" method="post" enctype="multipart/form-data" >
 <div class="form-group">
								  
                                                      <label class="col-sm-2 control-label" for="exampleInputFile">Upload Photo</label>
													  <div class="col-sm-10">
                                                      <input type="file" name="photo" id="exampleInputFile3">
													   <br><br>
                                                       </div>
                                </div>
                                  <button type="submit" class="btn btn-default">Submit</button>
</body>
</html>