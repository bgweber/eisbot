package eisbot.proxy.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import eisbot.abl.Game;
import eisbot.proxy.JNIBWAPI;
import eisbot.proxy.wmes.unit.EnemyUnitWME;
/**
 * Particle filter with no memory.
 */
public class NoMemoryFilter extends ParticleFilter {
	
	private Set<ParticleWME> particles;

	public NoMemoryFilter(Game game, boolean identify, boolean expoDecay, boolean defaultParameters, boolean useTargetVector) {
		super(game, identify, expoDecay, defaultParameters, useTargetVector);
		
		particles = Collections.synchronizedSet(new HashSet<ParticleWME>());		
	}
	
	public void draw(JNIBWAPI bwapi) {
		for (ParticleWME particle : particles) {
			int r = (int)(particle.weight*12.0);
			bwapi.drawBox((int)particle.getRealX() - r, (int)particle.getRealY() - r, (int)particle.getRealX() + r, (int)particle.getRealY() + r, 164, false, false);
			bwapi.drawBox((int)particle.getRealX() - r - 1, (int)particle.getRealY() - r - 1, (int)particle.getRealX() + r + 1, (int)particle.getRealY() + r + 1, 164, false, false);
			bwapi.drawLine((int)particle.getRealX(), (int)particle.getRealY(), (int)(particle.getRealX() + 100*particle.dx), (int)(particle.getRealY() + 100*particle.dy), 164, false);
		}
	} 
	 
	public void update(Game game) {
		particles.clear();
		
		for (EnemyUnitWME unit : game.getEnemyUnits()) {
			
			ParticleWME particle = new ParticleWME();
			particle.setUnitID(unit.getID());
			particle.setType(unit.getType());
			particle.setTypeID(unit.getTypeID());
			particle.setRealX(unit.getRealCenterX());
			particle.setRealY(unit.getRealCenterY());				
			particles.add(particle);
		}		
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
