
public class Chpt7_hw2 {
	public static void main(String[] args) {
		
		
		Shape72 s1 = new Shape72(); 
		Shape72 s2 = new Shape72(1.0f, 2.0f, "red");
		System.out.println("s1 = " + s1); 
		System.out.println("s2 = " + s2);
		s1.setCenter(-2.0f, 4.0f); 
		s1.setColor("green");
		System.out.println("now s1 has center (" + s1.getCX() + ", " + 
		                                  s1.getCY() + ") and color(" + s1.getColor() + ")");
		Shape72 s3 = new Shape72(1.0f, 2.0f, "red");
		System.out.println("s1 = " + s1); 
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		System.out.println("s1.equals(s2) = " + s1.equals(s2));
		System.out.println("s2.equals(s3) = " + s2.equals(s3));
		System.out.print("draw s1: "); 
		s1.draw();
		s2.translate(2.0f, 2.0f);
		System.out.print("scale s3: ");
		s3.scale(1.5f, 1.5f);
		System.out.println("s1 = " + s1); 
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		System.out.println(); 
		
		
		Circle72 c1 = new Circle72(); 
		Circle72 c2 = new Circle72(2.5f, -3.0f, "yellow", 5.0f); 
		Circle72 c3 = new Circle72(-4.0f, 4.5f, "magenta", 3.0f);
		System.out.println("c1 = " + c1); 
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		c1.setCenter(2.5f, -3.0f); 
		c1.setColor("yellow");
		c1.setRadius(5.0f);
		System.out.println("now c1 has center (" + c1.getCX() + ", " + 
                c1.getCY() + ") color(" + c1.getColor() + ") radius(" + c1.getRadius() + ")");
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2); 
		System.out.println("c3 = " + c3); 
		System.out.println("c1.equals(c2) = " + c1.equals(c2));
		System.out.println("c2.equals(c3) = " + c2.equals(c3));
		System.out.print("draw c1: "); 
		c1.draw();
		c2.translate(2.0f, 2.0f);
		System.out.print("call c3.scale(1.5f, 1.5f): ");
		c3.scale(1.5f, 1.5f);
		System.out.println("call c3.scale(1.5f): ");
		c3.scale(1.5f);
		System.out.println("c1 = " + c1); 
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		System.out.println(); 
		
		Rectangle72 r1 = new Rectangle72(); 
		Rectangle72 r2 = new Rectangle72("blue", -1.0f, -1.0f, 3.0f, 5.0f); 
		Rectangle72 r3 = new Rectangle72( "green", 3.0f, 2.0f, 4.0f, 3.0f);
		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2); 
		System.out.println("r3 = " + r3); 
		r1.setCenter(2.0f, 2.0f); 
		System.out.println("r1 = " + r1);
		r1.setColor("blue");
		r1.setXY0(-1.0f, -1.0f);
		r1.setWidth(3.0f); 
		r1.setHeight(5.0f);
		System.out.println("now r1 has center (" + r1.getCX() + ", " + 
                r1.getCY() + ") color(" + r1.getColor() + ") x0(" + r1.getX0() + ") y0(" + 
				r1.getY0() + ") width(" + r1.width + ") height(" + r1.height + ")");
		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2); 
		System.out.println("r3 = " + r3); 
		System.out.println("r1.equals(r2) = " + r1.equals(r2));
		System.out.println("r2.equals(r3) = " + r2.equals(r3));
		System.out.print("draw r1: "); 
		r1.draw();
		r2.translate(2.0f, 2.0f);
		r3.scale(2.0f, 2.0f);
		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2); 
		System.out.println("r3 = " + r3); 
		
	}
}

class Shape72{
	protected float cx,cy;
	protected String color; 
	
	//constructor
	public Shape72() {
		cx =  0.0f;
		cy =  0.0f;
		color = "nocolor";
		
	}
	public Shape72(float cx, float cy, String color) {
		this.cx = cx;
		this.cy = cy;
		this.color = color;
	}
	
	//accessor
	public float getCX() {
		return cx;
	}
	public float getCY() {
		return cy;
	}
	public String getColor() {
		return color;
	}
	
	//mutator
	public void setCenter(float cx, float cy) {
		this.cx = cx;
		this.cy = cy;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//toString
	public String toString() {
		return "SHAPE center(" + cx + ", " + cy + ") color(" + color + ")";
	}
	//draw
	public void draw() {
		System.out.print("draw Shape72 with color (" + color + ")\n");
		
	}
	//translate
	public void translate(float dx, float dy) {
		cx += dx;
		cy += dy;
	}
	//scale
	public void scale(float sx, float sy) {
		System.out.print("Shape72 scaled with (" + sx + ", " + sy + ")\n");
	}
	//equals
	public boolean equals(Object other) {
		if (getClass() != other.getClass())
			return false;
		else { 
			Shape72 compare = (Shape72) other;
			return((cx == compare.cx) && (cy == compare.cy) 
					&& (color.equals(compare.color)));
			
		}		
	}
}

class Circle72 extends Shape72{
	protected float radius;
	
	//constructor
	public Circle72() {
		super();
		radius = 1.0f;
	}
	public Circle72(float cx, float cy, String color, float radius) {
		super(cx, cy, color);
		this.radius = radius;
	}
	
	//toString
	public String toString() {
		return "CIRCLE " + super.toString() + " radius(" + radius + ")" ;
	}
	
	//accessor & mutator
	public void setRadius(float radius) {
		this.radius = radius;
	}
	public float getRadius() {
		return radius;
	}
	
	//scale
	public void scale(float x) {
		radius *= x;
	}
	public void scale(float cx, float cy) {
		System.out.println("this method is not valid for Circle72. use scale(float) instead");
	}
	
	//equals
	public boolean equals(Object other) {
		if (getClass() != other.getClass())
			return false;
		else {
			Circle72 compare = (Circle72) other;
			return ((this.cx == compare.cx) && (this.cy == compare.cy)
					&& (this.color.equals(compare.color) && (this.radius == compare.radius)));
		}
			
	}
	
	//draw
	public void draw() {
		System.out.print("draw Circle72 with color (" + color + ")\n");
	}
}

class Rectangle72 extends Shape72{
	protected float x0, y0;
	protected float width, height;
	
	//constructor
	public Rectangle72() {
		super();
		x0 = -1.0f;
		y0 = -1.0f;
		width = 2.0f;
		height = 2.0f;
	}
	public Rectangle72(String color, float x0, float y0, float width, float height) {
		super((x0 + width/2), (y0 + height/2), color);
		this.x0 = x0;
		this.y0 = y0;
		this.height = height;
		this.width = width;
	}
	
	//accessor
	public float getX0() {
		return x0;
	}
	public float getY0() {
		return y0;
	}
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
	
	//mutator
	public void setCenter(float cx, float cy) {
		super.setCenter(cx, cy);
		x0 = cx - width/2;
		y0 = cy - height/2;
	}
	public void setXY0(float x0, float y0) {
		this.x0 = x0;
		this.y0 = y0;
		cx = x0 + width/2;
		cy = y0 + height/2;
	}
	public void setWidth(float width) {
		this.width = width;
		cx = x0 + width/2;
	}
	public void setHeight(float height) {
		this.height = height;
		cy = y0 + height/2;
	}
	
	//translate 
	public void translate(float dx, float dy) {
		super.translate(dx, dy);
		x0 = cx - width/2;
		y0 = cy - height/2;
	}
	
	//scale 
	public void scale(float sx, float sy) {
		width *= sx;
		height *= sy;
		cx = x0 + width/2;
		cy = y0 + height/2;
	}
	
	//draw
	public void draw() {
		System.out.print("draw Rectangle72 with color (" + color + ")\n");
	}
	
	//toString
	public String toString() {
		return "RECTANGLE " + super.toString() + " x0y0(" + x0 + ", " + y0 +
				") width(" + width + ") height(" + height + ")";
	}
	
	//equals
	public boolean equals(Object other) {
		if (getClass()!=other.getClass())
			return false;
		else {
			Rectangle72 compare = (Rectangle72) other;
			return ((cx == compare.cx)&&(cy == compare.cy)&&(x0 == compare.x0)
					&&(y0 == compare.y0)&&(color.equals(compare.color))&&
					(width == compare.width)&&(height == compare.height));
		}
	}
}