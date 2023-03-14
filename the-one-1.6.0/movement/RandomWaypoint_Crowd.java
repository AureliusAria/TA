/* 
 * Copyright 2010 Aalto University, ComNet
 * Released under GPLv3. See LICENSE.txt for details. 
 */
package movement;

import core.Coord;
import core.Settings;

/**
 * Random waypoint movement model. Creates zig-zag paths within the
 * simulation area.
 */
public class RandomWaypoint_Crowd extends MovementModel {
	/** how many waypoints should there be per path */
	private static final int PATH_LENGTH = 1;
	private Coord lastWaypoint;
	private int areaMov;
	
//        public static final String AREA_S = "moveArea";
        
	public RandomWaypoint_Crowd(Settings settings) {
		super(settings);
                
//                areaMov = settings.getInt(AREA_S);
	}
	
	protected RandomWaypoint_Crowd(RandomWaypoint_Crowd rwp) {
		super(rwp);
	}
	
	/**
	 * Returns a possible (random) placement for a host
	 * @return Random position on the map
	 */
	@Override
	public Coord getInitialLocation() {
		assert rng != null : "MovementModel not initialized!";
		Coord c = randomCoord();

		this.lastWaypoint = c;
		return c;
                
                
//                double xMin = 0;
//                double yMin = 0;
//                
//                double xMax=0,yMax=0;
//                switch (areaMov){
//                    case 1:             
//                        xMax = 1.0/3*getMaxX();
//                        yMax = getMaxY();
//                        xMin = 0;
//                        yMin = 2.0/3*getMaxY();
//                        break;
//                    case 2:
//                        xMax = 2.0/3*getMaxX();
//                        yMax = getMaxY();
//                        xMin = 1.0/3*getMaxX();
//                        yMin = 2.0/3*getMaxY();
//                        break;
//                    case 3:
//                        xMax = getMaxX();
//                        yMax = getMaxY();
//                        xMin = 2.0/3*getMaxX();
//                        yMin = 2.0/3*getMaxY();
//                        break;
//                    case 4:
//                        xMax = 1.0/3*getMaxX();
//                        yMax = 2.0/3*getMaxY();
//                        xMin = 0;
//                        yMin = 1.0/3*getMaxY();
//                        break;
//                    case 5:
//                        xMax = 2.0/3*getMaxX();
//                        yMax = 2.0/3*getMaxY();
//                        xMin = 1.0/3*getMaxX();
//                        yMin = 1.0/3*getMaxY();
//                        break;
//                    case 6:
//                        xMax = getMaxX();
//                        yMax = 2.0/3*getMaxY();
//                        xMin = 2.0/3*getMaxX();
//                        yMin = 1.0/3*getMaxY();
//                        break;
//                    case 7:
//                        xMax = 1.0/3*getMaxX();
//                        yMax = 1.0/3*getMaxY();
//                        xMin = 0;
//                        yMin = 0;
//                        break;
//                    case 8:
//                        xMax = 2.0/3*getMaxX();
//                        yMax = 1.0/3*getMaxY();
//                        xMin = 1.0/3*getMaxX();
//                        yMin = 0;
//                        break;
//                    case 9:
//                        xMax = getMaxX();
//                        yMax = 1.0/3*getMaxY();
//                        xMin = 2.0/3*getMaxX();
//                        yMin = 0;
//                        break;
//                }
//                double x = (rng.nextDouble()*(xMax-xMin))+xMin;
//                double y = (rng.nextDouble()*(yMax-yMin))+yMin;
//                c = new Coord(x, y);
//		this.lastWaypoint = c;
//		return c;
	}
	
	@Override
	public Path getPath() {
		Path p;
		p = new Path(generateSpeed());
		p.addWaypoint(lastWaypoint.clone());
		Coord c = lastWaypoint;
		
		for (int i=0; i<PATH_LENGTH; i++) {
			c = randomCoord();
			p.addWaypoint(c);	
		}
		
		this.lastWaypoint = c;
		return p;
	}
	
	@Override
	public RandomWaypoint_Crowd replicate() {
		return new RandomWaypoint_Crowd(this);
	}
	
	protected Coord randomCoord() {
		double randX = 0, randY = 0;
                //System.out.println(this.moveArea);
                switch (this.moveArea){
                    case 1 :
                        randX = ((getMaxX()/3.0)-0) * rng.nextDouble() + 0;
                        randY = ((getMaxY()/3.0)-0) * rng.nextDouble() + 0;
                        return new Coord(randX, randY);
                    case 2 :
                        randX = (((getMaxX()*2.0/3)-(getMaxX()/3.0)) * rng.nextDouble() + (getMaxX()/3.0));
                        randY = ((getMaxY()/3.0)-0) * rng.nextDouble() + 0;
                        return new Coord(randX, randY);
                    case 3 :
                        randX = ((getMaxX()- (getMaxX()*2.0/3)) * rng.nextDouble() + (getMaxX()*2.0/3));
                        randY = ((getMaxY()/3.0)-0) * rng.nextDouble() + 0;
                        return new Coord(randX, randY);
                    case 4 :
                        randX = ((getMaxX()/3.0)-0) * rng.nextDouble() + 0;
                        randY = (((getMaxY()*2.0/3)-(getMaxY()/3.0)) * rng.nextDouble() + (getMaxY()/3.0));
                        return new Coord(randX, randY);
                    case 5 :
                        randX = (((getMaxX()*2.0/3)-(getMaxX()/3.0)) * rng.nextDouble() + (getMaxX()/3.0));
                        randY = (((getMaxY()*2.0/3)-(getMaxY()/3.0)) * rng.nextDouble() + (getMaxY()/3.0));
                        return new Coord(randX, randY);
                    case 6 :
                        randX = ((getMaxX()- (getMaxX()*2.0/3)) * rng.nextDouble() + (getMaxX()*2.0/3));
                        randY = (((getMaxY()*2.0/3)-(getMaxY()/3.0)) * rng.nextDouble() + (getMaxY()/3.0));
                        return new Coord(randX, randY);
                    case 7 :
                        randX = ((getMaxX()/3.0)-0) * rng.nextDouble() + 0;
                        randY = ((getMaxY()- (getMaxY()*2.0/3)) * rng.nextDouble() + (getMaxY()*2.0/3));
                        return new Coord(randX, randY);
                    case 8 : 
                        randX = (((getMaxX()*2.0/3)-(getMaxX()/3.0)) * rng.nextDouble() + (getMaxX()/3.0));
                        randY = ((getMaxY()- (getMaxY()*2.0/3)) * rng.nextDouble() + (getMaxY()*2.0/3));
                        return new Coord(randX, randY);
                    case 9 :
                        randX = ((getMaxX()- (getMaxX()*2.0/3)) * rng.nextDouble() + (getMaxX()*2.0/3));
                        randY = ((getMaxY()- (getMaxY()*2.0/3)) * rng.nextDouble() + (getMaxY()*2.0/3));
                        return new Coord(randX, randY);
                    default:
                        return new Coord(rng.nextDouble() * getMaxX(), rng.nextDouble() * getMaxY());
                }
	}
}