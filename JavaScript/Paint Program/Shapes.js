function Rectangle(x,y,x1,y1){
    
    
    this.x=x;
    this.y=y;
    this.length=x1-x;
    this.width=y1-y;
    
    
    
    this.color;
    
    
}

Rectangle.prototype.draw = function(ctx){
    
    alert("Yo");
    
    ctx.fillRect(this.x, this.y, this.length ,this.width);
    
}