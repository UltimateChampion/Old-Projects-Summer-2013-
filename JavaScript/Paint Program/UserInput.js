function Rectangle(x,y,x1,y1){
    
    
    this.x=x;
    this.y=y;
    this.length=x1-x;
    this.width=y1-y;
    
    
    
    this.color;
    
    
}

Rectangle.prototype.draw = function(c){
    
    //alert("Yo");
    c.fillStyle=this.color;
    c.fillRect(this.x, this.y, this.length ,this.width);
    
    
}

function Line(x,y,x1,y1){
    
    
    this.x=x;
    this.y=y;
    this.x1=x1;
    this.y1=y1;
    
    
    
    this.color;
    
    
}

Line.prototype.draw = function(c){
    
    //alert("Yo");
    c.fillStyle=this.color;
    c.strokeStyle=this.color;
    c.beginPath();
    c.moveTo(this.x, this.y);
    c.lineTo(this.x1, this.y1);
    c.stroke();
    
}

function Star(x,y, sz){
    
    
    this.x=x;
    this.y=y;
    this.size=sz;
    
    
    
    this.color;
    
    
}

Star.prototype.draw = function(c){
    
    //alert("Yo");
    
    c.fillStyle=this.color;
    c.strokeStyle=this.color;
    drawStar(c,  this.size, this.x, this.y);
    
    
    
}


// SHAPES- copypasta here //



//DRAWING FUNCTIONS//



function drawStar(ctx, starlength, starx, stary){
    
    
    ctx.beginPath();
    ctx.moveTo(starx, stary);
    
    starx=starx+.5*starlength;
    stary=stary+1.5*starlength;
    ctx.lineTo(starx, stary);
    ctx.stroke();
    
    starx=starx+1.5*starlength;
    ctx.lineTo(starx, stary);
    
    starx=starx-1.5*starlength;
    stary=stary+1*starlength;
    ctx.lineTo(starx, stary);
    ctx.stroke();
    
    starx=starx+1*starlength;
    stary=stary+1*starlength;
    ctx.lineTo(starx, stary);
    ctx.stroke();
    
    starx=starx-1.5*starlength;
    stary=stary-.5*starlength;
    ctx.lineTo(starx, stary);
    ctx.stroke();
    
    starx=starx-1.5*starlength;
    stary=stary+.5*starlength;
    ctx.lineTo(starx, stary);
    ctx.stroke();
    
    starx=starx+1*starlength;
    stary=stary-1*starlength;
    ctx.lineTo(starx, stary);
    ctx.stroke();
    
    starx=starx-1.5*starlength;
    stary=stary-1*starlength;
    ctx.lineTo(starx, stary);
    ctx.stroke();
    
    starx=starx+1.5*starlength;
    
    ctx.lineTo(starx, stary);
    ctx.stroke();
    
    starx=starx+.5*starlength;
    stary=stary-1.5*starlength;
    ctx.lineTo(starx, stary);
    ctx.fill();

    
    
}


function distance(x, y, x1, y1){
    
    return Math.sqrt((x1-x)*(x1-x)+ (y1-y)*(y1-y));
    
}


//////////////////////






var mouseDown;
var mouseX;
var mouseY;
var currMouseX;
var currMouseY;

var isenlarging=1;
var tempx;
var tempy;

var numShapes;
var shapesMade= new Array();
var i;
var ctx;
var typeShape;

var currColor="#000000";

function mouseHandler(c){
    
    
    
    typeShape=2;   //0- rectangle, 1- circle, 2- line
    
    mouseX=0;
    mouseY=0;
    
    currMouseX=0;
    currMouseY=0;
    
    mouseDown=0;
    
    ctx=c;
     
    
    
    
    numShapes=0;
    
    
    document.addEventListener("mousedown", this.mDown, false);
    document.addEventListener("mouseup", this.mUp, false);
    
     //
    
    onmousemove= function(e){
        
        tempx=mouseX;
        tempy=mouseY;
        
        mouseX=e.pageX;
        mouseY=e.pageY;
        
        if (tempx>mouseX && tempy>mouseY){
            
            isenlarging=1;
            
        }
        else { isenlarging=0; }
        
        
        //
        
    }
    
     //
   
    
    setInterval(
    
                
                function(){
                
                
                if (mouseDown==1){
                
                ctx.fillStyle=currColor;
                ctx.strokeStyle=currColor;
                ////////////////////////
                if (typeShape==0){
                
                ctx.clearRect(0,0,1000,500);
                
                for (i=0; i<numShapes; i++){
                
                shapesMade[i].draw(ctx);
                
                }
                
                ctx.fillRect(currMouseX, currMouseY, mouseX-currMouseX, mouseY-currMouseY);

                }
                
                /////////////////
                if (typeShape==1){
                
                ctx.clearRect(0,0,1000,500);
                
                for (i=0; i<numShapes; i++){
                
                shapesMade[i].draw(ctx);
                
                }
                
        
                
                ctx.beginPath();
                ctx.moveTo(currMouseX, currMouseY);
                ctx.lineTo(mouseX, mouseY);
                ctx.stroke();
                
                }
                
                ///////////////////
                
                if (typeShape==2){
                
                ctx.clearRect(0,0,1000,500);
                
                for (i=0; i<numShapes; i++){
                
                shapesMade[i].draw(ctx);
                
                }
                
                
                
                drawStar(ctx, .1*distance(currMouseX, currMouseY, mouseX, mouseY), currMouseX, currMouseY);
                
                //
                
                }
                /////////////////
                
                
                }
                
                }
    
    ,1);

    
    
    
    
    
    
}



//test//
mouseHandler.prototype.swagMachine = function(){
    
    alert("swag");
    ctx.fillRect(0,0,50,50);
    
}
//test//


mouseHandler.prototype.changeShapeType = function(x){
    
    this.typeShape=x;
    
}


mouseHandler.prototype.mUp= function(){
    
    //this.ctx.clearRect(0,0,1000,500);
    
    mouseDown=0;
    i=0;
    
    
    //alert("hit");
    
    if (typeShape==0){
    
    shapesMade[numShapes]= new Rectangle(currMouseX, currMouseY, mouseX, mouseY);
    
    }
    
    if (typeShape==1){
        
        shapesMade[numShapes]= new Line(currMouseX, currMouseY, mouseX, mouseY);
        
    }
    
    if (typeShape==2){
        
        shapesMade[numShapes]= new Star(currMouseX, currMouseY, .1*distance(currMouseX, currMouseY, mouseX, mouseY));
        
    }
    
    
    shapesMade[numShapes].color=currColor;
    
    numShapes+=1;
    
    //alert(numShapes);
    
    
    ctx.clearRect(0,0,1000,500);
    
    for (i=0; i<numShapes; i++){
        
        shapesMade[i].draw(ctx);
        
    }
  
    
}

mouseHandler.prototype.mDown= function(e){
    
    
    
    currMouseX=e.pageX;
    currMouseY=e.pageY;
    
    mouseDown=1;
    
    //this.ctx.fillRect(50,50,50,50);
    
     

}



mouseHandler.prototpe.button1handler= function(){
    
    this.typeShape=0;
    
}



function buttonRect(){
    
    typeShape=0;
}

function buttonLine(){
    
    typeShape=1;
}

function buttonStar(){
    
    typeShape=2;
}


function changeColor(c){
    
    currColor=c;
    
}
