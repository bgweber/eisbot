package eisbot.proxy.filter;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.abl.StarCraftConstants.Race;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.wmes.ChokePointWME;
import eisbot.proxy.wmes.RegionWME;
import eisbot.proxy.wmes.UnitTypeWME;
import eisbot.proxy.wmes.unit.EnemyUnitWME;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
/**
 * 
 *  
 * System properties:
 *  -DParticleFilterMode=OptimizedParticles (One of the mode specified by the enum: ParticleFilterMode)
 */
public class ParticleFilter {
 
	public enum ParticleFilterMode { PerfectInformation, DefaultParticles, DefaultIdentifyParticles, OptimizedParticles, OptimizedIdentifyParticles };
	
	private Set<ParticleWME> particles = null;
	private ConcurrentHashMap<Integer, ParticleWME> particleMap = new ConcurrentHashMap<Integer, ParticleWME>();

	private boolean identify = false;
	private boolean expoDecay = false;
	
	private boolean running = true;

	// PvP parameter settings
	public static double[] pVpParameters = {
										0.08771930002325175,
										0.0,
										0.0,
										0.0,
										0.05629448511513918,
										-0.015426897110969704,
										-0.02959453000575519,
										-0.00833998276435245,
										0.05052438651825254,
										0.15066145856634044,
									};
	 
	// PvT parameter settings
	public static double[] pVtParameters = { 
										0.0031780368028123387,
										0.0,
										0.0,
										0.22418066573005943,
										0.11606883817471428,
										-0.06429078232346042,
										-0.0470576311481893,
										-0.061265457527829796,
										-0.0063818680246395055,
										-0.006862412007580852,
									};	
	
	// PvZ parameter settings
	public static double[] pVzParameters = { 
										0.002342240315372699, // 0.002342240315372699,
										0.0,
										0.0,
										0.1316150483683206,
										-0.0038501995826119443,
										0.00445958498411494,
										0.02266418616835058,
										0.026307238751711468,
										0.0032193804387948633,
										0.0174675713524141,
									};		

//	public static double[] pVpParameters = {
//		0.081218546, 
//		-0.007558743, 
//		3.55E-04, 
//		0.0109749, 
//		-6.33E-04,  
//		0.029192854, 
//		0.00823561, 
//		-0.005531254, 
//		0.057651665, 
//		0.013764305,
//	};
//
//// PvT parameter settings
//public static double[] pVtParameters = { 
//		0.004684897482505687, 
//		-0.010622079877853607, 
//		0.0031249877854415704, 
//		-0.015607494050607244, 
//		0.023422229930724618, 
//		0.008170449057957186, 
//		0.10594739264638656, 
//		0.012144161638954556, 
//		0.06201269808696305, 
//		-0.002158027472085878 
//	};	
//
//// PvZ parameter settings
//public static double[] pVzParameters = { 
//		0.003999466,
//		-0.021366931,
//		0.004285943,
//		0.008893077,
//		-0.025494787,
//		-0.017778396,
//		0.114300559,
//		0.128304438,
//		0.115339494,
//		-0.182877338,			
//	};		
	
	private HashMap<Integer, ParticleParameters> typeParameters = new HashMap<Integer, ParticleParameters>();					
	
	class ParticleParameters  {
		double decay;
		double targetSpeed;
		double movementSpeed;
		double chokepointSpeed;
	}
	
	public ParticleFilter(Game game, boolean identify, boolean expoDecay, boolean defaultParameters, boolean useTargetVector) {
		particles = Collections.synchronizedSet(new HashSet<ParticleWME>());
		this.identify = identify;
		this.expoDecay = expoDecay;
		
		// load particle parameters for each unit type
		for (UnitTypeWME type : game.getUnitTypes().values()) {
			double[] params = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			
			if (!defaultParameters) {
				switch (Race.values()[type.getRace()]) {
				case Protoss:
					params = pVpParameters;
					break;
				case Terran:
					params = pVtParameters;
					break;
				case Zerg:
					params = pVzParameters;
					break;
				}
			}
			
			ParticleParameters parameters = new ParticleParameters();
			typeParameters.put(type.getId(), parameters);
			
			if (type.isBuilding()) {
				parameters.decay = params[1];
				parameters.movementSpeed = params[5];
			}
			else if (type.isWorker()) {
				parameters.decay = params[2];
				parameters.movementSpeed = params[6];
			}
			else if (type.isFlyer()) {
				parameters.decay = params[3];
				parameters.movementSpeed = params[7];
			}
			else {
				parameters.decay = params[0];
				parameters.movementSpeed = params[4];
			}
			
			parameters.targetSpeed = params[8];
			parameters.chokepointSpeed = params[9]; 			
			
			if (!useTargetVector) {
				parameters.targetSpeed = 0;
			}
			
			// TODO: note, actual movement speed is  * 50
			// TODO: scale decay and movement variables
			parameters.movementSpeed *= (50.0/24.0);
			parameters.targetSpeed *= (50.0/24.0); 
			parameters.chokepointSpeed *= (50.0/24.0);
			parameters.decay = parameters.decay/24.0;
		}
	}
	
	public void draw(JNIBWAPI bwapi) {
		for (ParticleWME particle : new ArrayList<ParticleWME>(particles)) { 
			int r = (int)(particle.weight*12.0);
			bwapi.drawBox((int)particle.getRealX() - r, (int)particle.getRealY() - r, (int)particle.getRealX() + r, (int)particle.getRealY() + r, 85, false, false);
			bwapi.drawBox((int)particle.getRealX() - r - 1, (int)particle.getRealY() - r - 1, (int)particle.getRealX() + r + 1, (int)particle.getRealY() + r + 1, 85, false, false);
			bwapi.drawLine((int)particle.getRealX(), (int)particle.getRealY(), (int)(particle.getRealX() + 500*particle.dx), (int)(particle.getRealY() + 500*particle.dy), 85, false);
		}
	}
	
	private HashMap<Integer, Point> lastPosition = new HashMap<Integer, Point>();
	
	public void start() {
		new Thread() {
			public void run() {
				Thread.currentThread().setName("Particle Filter Thread");

				while (running) {
					try {
						Thread.sleep(20);
					}
					catch (Exception e) {}

					update();
				}				
			}
		}.start();				
	}

	public void stop() {
		running = false;
	}

	public void update() {
		Game game = ABLStarCraftBot.getGame();
		
		// 1. update weights
		for (ParticleWME particle : particles) {
			particle.decay(expoDecay); 
		}
		
		// 2. move particles
		for (ParticleWME particle : particles) {
			particle.realX += particle.dx;
			particle.realY += particle.dy;
		}
		 
		// 3. cull particles 
		HashSet<Integer> visibleEnemies = new HashSet<Integer>();
		for (EnemyUnitWME unit : game.getEnemyUnits()) {
			visibleEnemies.add(unit.getID());
		}

		HashSet<ParticleWME> remove = new HashSet<ParticleWME>();
		for (ParticleWME particle : particles) {
			
			// is the enemy still visible?
			if (visibleEnemies.contains(particle.getUnitID())) {
				particle.setWeight(1);
				continue;
			}			
			else {
				
				// unable to track specific units not in view
				if (!identify) {
					particleMap.remove(particle.getUnitID());
					particle.setUnitID(-1);
				}
			}
			
			
			// faded out
			if (particle.getWeight() <= 0) {
				remove.add(particle);
				particleMap.remove(particle.getUnitID());
				continue;
			}
			
			// is the particle in vision range?
			for (PlayerUnitWME unit : game.getPlayerUnits()) {
				int dx = Math.abs(unit.getX() - particle.getX());
				int dy = Math.abs(unit.getY() - particle.getY());
				int sight = unit.getType().getSightRange();
				
				if (dx*dx + dy*dy < sight*sight) {
					remove.add(particle);
					particleMap.remove(particle.getUnitID());
					break;
				}
			}
			
			// is the particle out of bounds
			if (particle.getRealX() < 0 || particle.getRealY() < 0 || particle.getRealX()/32.0 > game.getMap().getMapWidth()  || particle.getRealY()/32.0 > game.getMap().getMapHeight()) {
				remove.add(particle);
				particleMap.remove(particle.getUnitID());
			}
		}
		
		particles.removeAll(remove);
		
		// 4. update and spawn particles
		for (EnemyUnitWME unit : game.getEnemyUnits()) {
			ParticleWME particle = null;
			if (particleMap.containsKey(unit.getID())) {
				particle = particleMap.get(unit.getID());
				particle.setRealX(unit.getRealCenterX());
				particle.setRealY(unit.getRealCenterY());
			}
			else {
				particle = new ParticleWME();
				particle.setUnitID(unit.getID());
				particle.setType(unit.getType());
				particle.setTypeID(unit.getTypeID());

				particle.setRealX(unit.getRealCenterX());
				particle.setRealY(unit.getRealCenterY());				
				particles.add(particle);
				particleMap.put(particle.getUnitID(), particle);
			}
			
			// compute movement vectors			
			// 1. target vector
			double tx = unit.getTargetRealX() - unit.getRealCenterX();
			double ty = unit.getTargetRealY() - unit.getRealCenterY();
			double magnitude = Math.sqrt(tx*tx + ty*ty);
			if (magnitude > 0) {
				tx = tx/magnitude;
				ty = ty/magnitude;
			}

			// 2. choke point vector
			double cx = 0;
			double cy = 0;
			if (magnitude > 0) {				
				for (RegionWME region : game.getRegions()) {
					if (region.contains(unit.getRealCenterX(), unit.getRealCenterY())) {

						double px = unit.getRealCenterX() + 500*tx;
						double py = unit.getRealCenterY() + 500*ty;
						double closest = Double.MAX_VALUE;
												
						for (ChokePointWME choke : region.getChokePoints()) {
							double dx = Math.abs(px - choke.getRealX()); 
							double dy = Math.abs(py - choke.getRealY()); 
							double dist = dx*dx + dy*dy;
							
							if (dist < closest) {
								closest = dist;
								cx = choke.getRealX();
								cy = choke.getRealY();
							}
						}
						
						cx = cx - unit.getRealCenterX();
						cy = cy - unit.getRealCenterY();
						magnitude = Math.sqrt(cx*cx + cy*cy);
						
						if (magnitude > 0) {
							cx = cx/magnitude;
							cy = cy/magnitude;
						}
						
						break;
					}
				}				
			}
			
			// 3. movement vector
			Point previous = lastPosition.get(unit.getID());
			double mx = 0;
			double my = 0;
			
			if (previous != null) {
				mx = unit.getRealCenterX() - previous.x;
				my = unit.getRealCenterY() - previous.y;
				
				magnitude = Math.sqrt(mx*mx + my*my);
				if (magnitude > 0) {
					mx = mx/magnitude;
					my = my/magnitude;
				}				
			}
			
			ParticleParameters parameters = typeParameters.get(unit.getTypeID());
			if (parameters != null) {
				particle.decay = Math.max(0, parameters.decay);			
				
				particle.dx = mx * parameters.movementSpeed +
				 			  tx * parameters.targetSpeed + 
							  cx * parameters.chokepointSpeed;				

				particle.dy = my * parameters.movementSpeed +
							  ty * parameters.targetSpeed + 
							  cy * parameters.chokepointSpeed;
			}
		}
		
		// update previous positions 
		lastPosition.clear();
		for (EnemyUnitWME unit : game.getEnemyUnits()) {
			lastPosition.put(unit.getID(), new Point(unit.getRealCenterX(), unit.getRealCenterY()));
		}
	}	
	
	public ParticleWME getRandomBuildingParticle() {
		ArrayList<ParticleWME> list = new ArrayList<ParticleWME>();
		for (ParticleWME particle : particles) {
			if (particle.getType().isBuilding()) {
				list.add(particle);
			}
		}
		 
		if (list.size() > 0) {
			return list.get((int)(list.size()*Math.random()));
		}
		
		return null;
	}
	
	public ParticleWME getRandomParticle() {
		
		if (particles.size() > 0) {
			ArrayList<ParticleWME> list = new ArrayList<ParticleWME>(particles);
			return list.get((int)(list.size()*Math.random()));
		}
		
		return null;
	}
	
	public Collection<ParticleWME> getParticles() {
		return new ArrayList<ParticleWME>(particles);
	}
}
