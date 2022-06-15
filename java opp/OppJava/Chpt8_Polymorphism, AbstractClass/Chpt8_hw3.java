
public class Chpt8_hw3 {
	public static void main(String[] args) {
		
		Circle83 c1 = new Circle83(); 
		Circle83 c2 = new Circle83(2.5f, -3.0f, "yellow", 5.0f); 
		Circle83 c3 = new Circle83(-4.0f, 4.5f, "magenta", 3.0f);
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
		System.out.println("call c2.translate(2.0f, 2.0f)");
		c2.translate(2.0f, 2.0f);
		System.out.println("call c3.scale(1.5f)");
		c3.scale(1.5f);
		System.out.println("c1 = " + c1); 
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		System.out.println(); 
		
		Rectangle83 r1 = new Rectangle83(); 
		Rectangle83 r2 = new Rectangle83("blue", -1.0f, -1.0f, 3.0f, 5.0f); 
		Rectangle83 r3 = new Rectangle83( "green", 3.0f, 2.0f, 4.0f, 3.0f);
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

abstract class Shape83 {
	
	protected float cx, cy;     // center point
	protected String color; 
	
	public Shape83() {
		cx = cy = 0.0f; 
		color = "nocolor";
	}
	
	public Shape83(float cx, float cy, String color) {
		this.cx = cx;
		this.cy = cy; 
		this.color = color; 
	}
	
	public abstract void draw(); 
		
	
	public void translate(float dx, float dy) {
		cx = cx + dx; 
		cy = cy + dy; 
	}
	
	public abstract void scale(float sx, float sy);
	
	public float getCX() {
		return  cx; 
	}
	
	public float getCY() {
		return cy; 
	}
	
	public String getColor() {
		return color; 
	}
	
	public void setCenter(float cx, float cy) {
		this.cx = cx;
		this.cy = cy; 
	}
	
	public void setColor(String color) {
		this.color = color; 
	}
	
	public boolean equals(Object other) {
		if (getClass() != other.getClass()) return false; 
		Shape83 s = (Shape83) other; 
		if (cx == s.cx && cy == s.cy && color.equals(s.color)) 
			return true; 
		return false; 
	}
	
	public String toString() {
		return "SHAPE center(" + cx + ", " + cy + ") color(" + color + ")"; 
	}
	
}

class Circle83 extends Shape83 {
	protected float radius;
	
	public Circle83() {
		cx = cy = 0.0f;
		radius = 1.0f; 
	}
	
	public Circle83(float cx, float cy, String color, float radius) {
		super(cx, cy, color); 
		this.radius = radius; 
	}
	
	public float getRadius() {
		return radius; 
	}
	
	public void setRadius(float radius) {
		this.radius = radius; 
	}
	
	public boolean equals(Object other) {
		
		if (getClass() != other.getClass()) return false; 
		
		Circle83 c = (Circle83) other; 
		
		if (cx == c.cx && cy == c.cy &&
			color.equals(c.color)&&
			radius == c.radius) return true; 
		
		return false; 
	}
	
	public String toString() {
		return "CIRCLE " + super.toString() + " radius(" + radius + ")";
	}
	
	public void draw() {
		System.out.println("draw Circle83 with color (" + color + ")"); 
	}
	
	public void scale(float sx, float sy) {
		System.out.println("this method is not valid for Circle82. use scale(float) instead");
	}
	
	public void scale(float s) {
		radius = radius * s; 
	}
	
}

class Rectangle83 extends Shape83 {
	protected float x0, y0; 
	protected float width; 
	protected float height; 
	
	public Rectangle83() {
		x0 = y0 = -1.0f; 
		cx = cy = 0.0f; 
		width = height = 2.0f; 
	}
	
	public Rectangle83(String color, float x0, float y0, float width, float height) {
		this.color = color; 
		this.x0 = x0; 
		this.y0 = y0; 
		this.width = width; 
		this.height = height;
		this.cx = x0 + width / 2.0f; 
		this.cy = y0 + height / 2.0f; 
	}
	
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
	
	public void setCenter(float cx, float cy) {
		this.cx = cx;
		this.cy = cy; 
		adjustXY0(); 
	}
	
	public void setXY0(float x0, float y0) {
		this.x0 = x0; 
		this.y0 = y0; 
		adjustCenter(); 
	}
	
	public void setWidth(float width) {
		this.width = width; 
		adjustCenter();
	}
	
	public void setHeight(float height) {
		this.height = height; 
		adjustCenter(); 
	}
	
	private void adjustCenter() {
		cx = x0 + width / 2.0f; 
		cy = y0 + height / 2.0f; 
	}
	
	private void adjustXY0() {
		x0 = cx - width / 2.0f; 
		y0 = cy - height / 2.0f; 
	}
	
	public boolean equals(Object other) {
		if (getClass() != other.getClass()) return false; 
		Rectangle83 r = (Rectangle83) other; 
		if (cx == r.cx && cy == r.cy &&
			 color.equals(r.color)&&
			 x0 == r.x0 && y0 == r.y0 &&
			 width == r.width && height == r.height) return true; 
		return false; 
	}
	
	public String toString() {
		return "RECTANGLE " + super.toString() + " x0y0(" + x0 + ", " + y0  + ") width(" + width + ") height(" + height + ")";
	}
	
	public void draw() {
		System.out.println("draw Rectangle83 with color (" + color + ")"); 
	}
	
	public void translate(float dx, float dy) {
		cx = cx + dx; 
		cy = cy + dy; 
		adjustXY0(); 
	}
	
	public void scale(float sx, float sy) {
		width = width * sx; 
		height = height * sy; 
		adjustCenter(); 
	}
}