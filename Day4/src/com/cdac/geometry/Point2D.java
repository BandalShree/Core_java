package com.cdac.geometry;
import static java.lang.Math.*;

public class Point2D {
	private Integer xCo,yCo;

	public Point2D(Integer xCo, Integer yCo) {
//		super();
		this.xCo = xCo;
		this.yCo = yCo;
	}

	@Override
	public String toString() {
		return "Point2D [xCo=" + xCo + ", yCo=" + yCo + "]";
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Point2D)
			return ((Point2D) obj).xCo==this.xCo && ((Point2D)obj).yCo==this.yCo;
		throw new CustomException("Invoker object is not type of Point2D");
	}
	
	public String calculateDistance(Point2D point) {
		return "Distance between two points : "+sqrt(pow(point.xCo-this.xCo,2)+pow(point.yCo-this.yCo,2));
	}
	
	
}
