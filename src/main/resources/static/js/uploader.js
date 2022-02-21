console.log("it works");

//$(document).ready(function()
//{
//	$('#fileImage').change(function()
//	{
//		showImageThumbnail(this);
//	});
//});
//
//function showImageThumbnail(fileInput)
//{
//	file = fileInput.files[0];
//	reader = new FileReader();
//	
//	reader.onload = function(e)
//	{
//		$('#thumbnail').attr('src', e.target.result);
//	};
//	
//	reader.readAsDataURL(file);
//}


//async function uploadFile()
//{
//	let obj = $("#")
//	let formData = new FormData();
//	formData.append("file", fileupload.files[0]);
//	let response = await fetch('/upload',
//		{
//			method: "POST",
//			body:formData
//		});
//		
//	if (response.status == 200)
//	{
//		alert("File successfully uploaded.");
//	}
//	else if (response.status == 500)
//	{
//		alert("Unsuccessful upload!");
//	}
//}