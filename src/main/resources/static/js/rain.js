/**
 * 
 */
 console.log("it's working'")
 let hrElement;
 let counter = 100;
 
 for (let i=0; i<counter; i++)
 {
	hrElement = document.createElement("HR");
	hrElement.style.left = Math.floor(Math.random()*window.innerWidth)+"px";
	hrElement.style.animationDuration = 3 + Math.random()*.3+"s";
	hrElement.style.animationDelay = Math.random()*5+"s";
	document.body.appendChild(hrElement);
}
 