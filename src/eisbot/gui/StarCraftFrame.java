package eisbot.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import eisbot.abl.ABLStarCraftBot;
import eisbot.abl.Game;
import eisbot.proxy.command.Command;
import eisbot.proxy.command.CommandListener;
import eisbot.proxy.filter.ParticleWME;
import eisbot.proxy.wmes.ChokePointWME;
import eisbot.proxy.wmes.MapWME;
import eisbot.proxy.wmes.RegionWME;
import eisbot.proxy.wmes.StartingLocationWME;
import eisbot.proxy.wmes.unit.AllyUnitWME;
import eisbot.proxy.wmes.unit.EnemyUnitWME;
import eisbot.proxy.wmes.unit.GeyserWME;
import eisbot.proxy.wmes.unit.MineralWME;
import eisbot.proxy.wmes.unit.NeutralUnitWME;
import eisbot.proxy.wmes.unit.PlayerUnitWME;
import eisbot.proxy.wmes.unit.UnitWME;
/**
 * GUI for showing the ProxyBot's view of the game state.
 */
public class StarCraftFrame extends JPanel implements 
	MouseWheelListener, MouseMotionListener, MouseListener, CommandListener {

	/** draw object IDs */
	private static boolean drawIDs = true;
	private static boolean drawPings = false;
	private static boolean drawPlayerUnits = true;
	private static boolean drawEnemyUnits = true;
	private static boolean drawNeutralUnits = true;
	private static boolean drawResources = true;
	private static boolean drawStartSpots = true;
	private static boolean drawRegions = true;
	private static boolean fillRegions = false;
//	private static boolean drawBasePlan = false;
//	private static boolean drawBuildZones = false;
	private static boolean drawChokepoints = true;

	/** reference to the proxy bot */
	private Game game;
	
	/** pixels per map tile, StarCraft is 32 */
	private int tileSize = 6;
	
	/** height of the resource panel */
	private int panelHeight = 30;

	/** font size for unit ids */
	private int textSize = 10;

	private boolean running = true;
	
	/** draw the influence map? */
	private boolean influenceMap = false;
	
	private double scale = 1.0;
	private double tx = 0;
	private double ty = 0;
	public int mx = 0;
	public int my = 0;
	private boolean mouseDown = false;	
	
	/**
	 * Constructs a JFrame and draws the ProxyBot's state.
	 */
	public StarCraftFrame(Game game) {
		this.game = game;
		this.addMouseWheelListener(this);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		// start the drawing thread
		new Thread() {
			public void run() {
				Thread.currentThread().setName("StarCraft GameView Thread");

				while (running) {
					try {
						Thread.sleep(50);
					}
					catch (Exception e) {}
					
					repaint();
				}
			}
		}.start();	
		
//		int width = game.getMap().getMapWidth();
//		int height = game.getMap().getMapHeight();
//		setPreferredSize(new Dimension(tileSize*width, tileSize*height + panelHeight));

//		frame = new JFrame("Proxy Bot");
//		frame.add(this);
//		frame.pack();
//		frame.setLocation(640, 0);
//		frame.addKeyListener(this);
//		frame.setVisible(true);		
	}

	/**
	 * Shuts down the GUI.
	 */
	public void stop() {
		running = false;
	}
	
	long lastRedraw = 0;
	
	/**
	 * Draws the agent's view of the game state.
	 */
	@SuppressWarnings("unchecked")
	public void paint(Graphics g) {

		// dont queue up orders if not drawing
		if (System.currentTimeMillis() > (1000 + lastRedraw)) {
			orders.clear();
		}
		lastRedraw = System.currentTimeMillis();
		
		Graphics2D g2 = (Graphics2D)g;
        g2.setBackground(Color.BLACK);
        g2.clearRect(0, 0, getWidth(), getHeight());
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                            RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
//                            RenderingHints.VALUE_RENDER_QUALITY);		
        g2.translate(tx, ty);
        g2.scale(scale, scale);
        
		// regular panel
		if (!influenceMap) {
			if (ABLStarCraftBot.IgnoreBases == false) {
			
				// tile set
				MapWME map = game.getMap();
				for (int y=0; y<map.getMapHeight(); y++) {
					for (int x=0; x<map.getMapWidth(); x++) {
						int walkable = map.isWalkable(x, y) ? 1 : 0;
						int buildable = map.isBuildable(x, y) ? 1 : 0;
						int height = map.getHeight(x, y);
						boolean creep = map.hasCreep(x, y);
						
						int c = (70*walkable + 60*buildable + 50*height);
						if (c < 0) c = 0;
						else if (c > 255) c = 255;

						g.setColor(new Color(c,c,(int)(c*3/4)));
						if (creep) {
							g.setColor(new Color(148,0,211));

						}
						
						g.fillRect(x*tileSize, panelHeight  + y*tileSize, tileSize, tileSize);
					}
				}
				
				// regions
				if (drawRegions) {
					g.setColor(Color.ORANGE);
					int j = 0;
					
					for (RegionWME region : game.getRegions()) {
						g.setColor(Color.ORANGE);
	
						if (fillRegions) {
							if (j%2 == 0) { 
								g.setColor(Color.CYAN);
							} else {
								g.setColor(Color.BLUE);
							}
						}
	
						int[] x = region.getPointsX();
						int[] y = region.getPointsY();
	
						for (int i=1; i<x.length; i++) {
							g.drawLine(x[i - 1]/32*tileSize, panelHeight  + y[i - 1]/32*tileSize, 
									x[i]/32*tileSize, panelHeight  + y[i]/32*tileSize);
						}
	
						j += 1;
					}
				}
				  
				// chokepoints 
				if (drawChokepoints) {
					g.setColor(Color.MAGENTA.darker());
					 
					for (ChokePointWME chokepoint : game.getChokePoints()) {
						g.drawArc(
								chokepoint.getX()*tileSize - chokepoint.getWidth()/32*tileSize/2,  
								panelHeight  + chokepoint.getY()*tileSize - chokepoint.getWidth()/32*tileSize/2, 
								chokepoint.getWidth()/32*tileSize, chokepoint.getWidth()/32*tileSize, 0, 360);
					}
				}
				
				// Starting locations
				if (drawStartSpots) {
					g.setColor(Color.ORANGE);
					for (StartingLocationWME location : game.getStartingLocations()) {
						g.fillRect(location.getX()*tileSize, panelHeight  + location.getY()*tileSize, 4*tileSize, 3*tileSize);				
					}
				}
				
			}

			// minerals
			if (drawResources) {
				g.setColor(new Color(0,255,255));
				for (MineralWME unit : game.getMinerals()) {
						g.fillRect(unit.getX()*tileSize, panelHeight  + unit.getY()*tileSize, tileSize, tileSize);				
				}
			}
			
			// gas
			if (drawResources) {
				g.setColor(new Color(0,128,0));
				for (GeyserWME unit : game.getGeysers()) {
					g.fillRect(unit.getX()*tileSize, panelHeight  + unit.getY()*tileSize, 
							unit.getType().getTileWidth()*tileSize, unit.getType().getTileHeight()*tileSize);				
				}
			}
			
			// enemy units
			if (drawEnemyUnits) {
				
				// particles
				// TODO: size based on weight
				for (ParticleWME unit : game.getParticleFilter().getParticles()) {
					g.setColor(new Color((float)Math.max(0, unit.getWeight()), (float)0, (float)Math.max(0, unit.getWeight())));
					g.fillRect(unit.getX()*tileSize, panelHeight  + unit.getY()*tileSize, 
							unit.getType().getTileWidth()*tileSize, unit.getType().getTileHeight()*tileSize);				
				}					
				
				g.setColor(new Color(255,0,0));
				for (EnemyUnitWME unit : game.getEnemyUnits()) {
					g.fillRect(unit.getX()*tileSize, panelHeight  + unit.getY()*tileSize, 
							unit.getType().getTileWidth()*tileSize, unit.getType().getTileHeight()*tileSize);				
				}						
			}
			
			// ally units
			if (drawPlayerUnits) {
				g.setColor(Color.YELLOW);
				for (AllyUnitWME unit : game.getAllyUnits()) {
					g.fillRect(unit.getX()*tileSize, panelHeight  + unit.getY()*tileSize, 
							unit.getType().getTileWidth()*tileSize, unit.getType().getTileHeight()*tileSize);				
				}	
			}
			
			if (drawNeutralUnits) {
				g.setColor(Color.GRAY);
				for (NeutralUnitWME unit : game.getNeutralUnits()) {
					g.fillRect(unit.getX()*tileSize, panelHeight  + unit.getY()*tileSize, 
							unit.getType().getTileWidth()*tileSize, unit.getType().getTileHeight()*tileSize);				
				}	
			}
			
			// player units
			if (drawPlayerUnits) {
				g.setColor(new Color(0,255,0));
				for (PlayerUnitWME unit : game.getPlayerUnits()) {
					g.fillRect(unit.getX()*tileSize, panelHeight  + unit.getY()*tileSize, 
							unit.getType().getTileWidth()*tileSize, unit.getType().getTileHeight()*tileSize);				
				}
			}
			
			// unit IDs
			if (drawIDs) {
				g.setColor(new Color(255,255,255));
				g.setFont(new Font("ariel", 0, textSize));
				for (UnitWME unit : game.getUnits()) {
					g.drawString("" + unit.getID(), unit.getX()*tileSize, panelHeight  + unit.getY()*tileSize + textSize - 2);
				}		
			}
 
//			// squad locations
//			LinkedList squads = ABLStarCraftBot.getBehavingEntity().getWorkingMemory().lookupWME("SquadWME");
//			g.setColor(new Color(255,255,255));
//
//			for (Object obj : squads) {
//				SquadWME squad = (SquadWME)obj;
//				g.fillRect((squad.getTargetX() - 1)*tileSize, panelHeight  + (squad.getTargetY() - 1)*tileSize, 
//						3*tileSize, 3*tileSize);				
//			}
			
			if (drawPings) {
				g.setColor(Color.YELLOW);			
				ArrayList<Order> remove = new ArrayList<Order>();
				for (Order order : new ArrayList<Order>(orders)) {
					order.timer++;
					if (order.timer > 15) {
						remove.add(order);
					}
	
					int x = order.x*tileSize + tileSize/2;
					int y = panelHeight  + order.y*tileSize + tileSize/2;
					
					g2.drawLine(x + 3*order.timer, y - (25 - order.timer), x + 3*order.timer, y + (25 - order.timer));
					g2.drawLine(x - 3*order.timer, y - (25 - order.timer), x - 3*order.timer, y + (25 - order.timer));
					g2.drawLine(x - 20, y + 3*order.timer, x + (25 - order.timer), y + 3*order.timer);
					g2.drawLine(x - 20, y - 3*order.timer, x + (25 - order.timer), y - 3*order.timer);
				}
				
				synchronized (orders) {
					orders.removeAll(remove);
				}
			}
		}
		// influence map
		else {
			int w = game.getMap().getMapWidth();
			int h = game.getMap().getMapHeight();
			HashMap<Integer, Double> playerInfluence = new HashMap<Integer, Double>();
			HashMap<Integer, Double> enemyInfluence = new HashMap<Integer, Double>();
			HashMap<Integer, Double> allyInfluence = new HashMap<Integer, Double>();
					
			for (UnitWME unit : game.getPlayerUnits()) {
				for (int dy=-5; dy<=5; dy++) {
					for (int dx=-5; dx<=5; dx++) {
						double dist = Math.sqrt(dx*dx + dy*dy);
						int x = unit.getX() + dx;
						int y = unit.getY() + dy;
						
						Double influence = playerInfluence.get(y*w + x);
						influence = influence != null ? influence : 0;
						
						if (dist == 0) {
							influence += 0.5;							
						}
						else if (dist > 0 && dist < 5) {
							influence += 0.5/dist;
						}
						
						influence = Math.min(1, influence);
						playerInfluence.put(y*w + x, influence);
					}
				}					
			}					

			for (UnitWME unit : game.getEnemyUnits()) {
				for (int dy=-5; dy<=5; dy++) {
					for (int dx=-5; dx<=5; dx++) {
						double dist = Math.sqrt(dx*dx + dy*dy);
						int x = unit.getX() + dx;
						int y = unit.getY() + dy;
						
						Double influence = enemyInfluence.get(y*w + x);
						influence = influence != null ? influence : 0;
						
						if (dist == 0) {
							influence += 0.5;							
						}
						else if (dist > 0 && dist < 5) {
							influence += 0.5/dist;
						}
						
						influence = Math.min(1, influence);
						enemyInfluence.put(y*w + x, influence);
					}
				}					
			}					

			for (UnitWME unit : game.getAllyUnits()) {
				for (int dy=-5; dy<=5; dy++) {
					for (int dx=-5; dx<=5; dx++) {
						double dist = Math.sqrt(dx*dx + dy*dy);
						int x = unit.getX() + dx;
						int y = unit.getY() + dy;
						
						Double influence = allyInfluence.get(y*w + x);
						influence = influence != null ? influence : 0;
						
						if (dist == 0) {
							influence += 0.5;							
						}
						else if (dist > 0 && dist < 5) {
							influence += 0.5/dist;
						}
						
						influence = Math.min(1, influence);
						allyInfluence.put(y*w + x, influence);
					}
				}					
			}					
			
			for (int y=0; y<h; y++) {
				for (int x=0; x<w; x++) {
					int position = y*w + x;
					Double pInfluence = playerInfluence.get(position);
					Double eInfluence = enemyInfluence.get(position);
					Double aInfluence = allyInfluence.get(position);
					pInfluence = (pInfluence != null) ? pInfluence : 0;
					eInfluence = (eInfluence != null) ? eInfluence : 0;
					aInfluence = (aInfluence != null) ? aInfluence : 0;
					
					g.setColor(new Color((float)(double)eInfluence, (float)(double)pInfluence, (float)(double)aInfluence));
					g.fillRect(x*tileSize, panelHeight  + y*tileSize, tileSize, tileSize);									
				}
			}
		}

//		g2.setTransform(new AffineTransform());
        g2.scale(1/scale, 1/scale);		
        g2.translate(-tx, -ty);
//        g2.translate(tx, ty);
//        g2.scale(scale, scale);
		
		// status panel
		g.setColor(new Color(255,255,255));
		g.setFont(new Font("ariel", 0, 12));
		g.fillRect(0, 0, getWidth(), panelHeight); 

		g.setColor(new Color(125,125,125));
		g.drawLine(0, panelHeight, getWidth(), panelHeight); 
		
		// minerals
		g.setColor(new Color(0,0,255));
		g.fillRect(5, 10, 10, 10);
		g.setColor(new Color(0,0,0));
		g.drawRect(5, 10, 10, 10);
		g.setColor(new Color(0,0,0));
		g.drawString("" + game.getPlayer().getMinerals(), 25, 20);

		// gas
		g.setColor(new Color(0,255,0));
		g.fillRect(105, 10, 10, 10);
		g.setColor(new Color(0,0,0));
		g.drawRect(105, 10, 10, 10);
		g.setColor(new Color(0,0,0));
		g.drawString("" + game.getPlayer().getGas(), 125, 20);
		
		// supply
		g.setColor(new Color(0,0,0));
		g.drawString((game.getPlayer().getSupplyUsed()/2) + "/" 
  				   + (game.getPlayer().getSupplyTotal()/2), 200, 20);		
	}
	
	double scaleAmmount = 0.9;
	public void mouseWheelMoved(MouseWheelEvent e) {

		try {
			
			if (e.getWheelRotation() > 0) {
//				scale *= scaleAmmount;
				
				// compute the current mouse location in virtual coordinates
				double screenX = e.getX();
				double screenY = e.getY();			
				AffineTransform transform = new AffineTransform();
				transform.translate(tx, ty);
				transform.scale(scale, scale);
				double[] src = new double[] { screenX, screenY };
				double[] dest1 = new double[2];
				transform.inverseTransform(src, 0, dest1, 0, 1);

		        // do the scalle
				scale *= scaleAmmount;			
				
				// compute the new mouse location in virtual coordinates
				screenX = e.getX();
				screenY = e.getY();			
				transform = new AffineTransform();
				transform.translate(tx, ty);
				transform.scale(scale, scale);
				src = new double[] { screenX, screenY };
				double[] dest2 = new double[2];
				transform.inverseTransform(src, 0, dest2, 0, 1);
				
				tx += (dest2[0] - dest1[0])*scale;
				ty += (dest2[1] - dest1[1])*scale;						
			}
			else {			
				// compute the current mouse location in virtual coordinates
				double screenX = e.getX();
				double screenY = e.getY();			
				AffineTransform transform = new AffineTransform();
				transform.translate(tx, ty);
				transform.scale(scale, scale);
				double[] src = new double[] { screenX, screenY };
				double[] dest1 = new double[2];
				transform.inverseTransform(src, 0, dest1, 0, 1);

		        // do the scalle
				scale /= scaleAmmount;			
				
				// compute the new mouse location in virtual coordinates
				screenX = e.getX();
				screenY = e.getY();			
				transform = new AffineTransform();
				transform.translate(tx, ty);
				transform.scale(scale, scale);
				src = new double[] { screenX, screenY };
				double[] dest2 = new double[2];
				transform.inverseTransform(src, 0, dest2, 0, 1);
				
				tx += (dest2[0] - dest1[0])*scale;
				ty += (dest2[1] - dest1[1])*scale;
			}				
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		
		if (mouseDown) {
			double dx = e.getX() - mx;
			double dy = e.getY() - my;
			
			tx += dx;
			ty += dy;
			
			mx = e.getX();
			my = e.getY();
		}
		
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {	
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 3) {
			mouseDown = true;
			mx = e.getX();
			my = e.getY();
		}
		
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == 3) {
			mouseDown = false;
		}
		
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
	}

	private class Order {
		int timer = -5;
		int x, y;
		
		public Order(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private ArrayList<Order> orders = new ArrayList<Order>();
	
	public void event(Command command) {
		synchronized (orders) {

			switch (command.getCommand()) {
			case attackMove:
				orders.add(new Order(command.getArg0()/32, command.getArg1()/32));
				break;			
			case attackUnit:
				UnitWME target = ABLStarCraftBot.getGame().getUnitByID(command.getArg0());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case rightClick:
				orders.add(new Order(command.getArg0()/32, command.getArg1()/32));
				break;		
			case rightClickUnit:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getArg0());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case train:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case build:
				orders.add(new Order(command.getArg0(), command.getArg1()));
				break;			
			case buildAddon:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case research:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case upgrade:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case stop:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case holdPosition:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case patrol:
				orders.add(new Order(command.getArg0()/32, command.getArg1()/32));
				break;			
			case follow:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getArg0());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case siege:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case unsiege:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getUnitID());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			case useTechPosition:
				orders.add(new Order(command.getArg1()/32, command.getArg2()/32));
				break;			
			case useTechTarget:
				target = ABLStarCraftBot.getGame().getUnitByID(command.getArg0());
				if (target != null) {
					orders.add(new Order(target.getX(), target.getY()));
				}
				break;		
			}
		}
	}

	public JPanel getLayerPanel() {
		JPanel panel = new JPanel();
		
		JButton idButton = new JButton("Unit IDs");
		idButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawIDs = !drawIDs;
			}
		});
		
		JButton pingButton = new JButton("Pings");
		pingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPings = !drawPings;
			}
		});
		
		JButton playerButton = new JButton("Units");
		playerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPlayerUnits = !drawPlayerUnits;
			}
		});
		
		JButton enemyButton = new JButton("Enemies");
		enemyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawEnemyUnits = !drawEnemyUnits;
			}
		});
		
		JButton resourcesButton = new JButton("Resources");
		resourcesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawResources = !drawResources;
			}
		});

		JButton startSpotButton = new JButton("Start Spots");
		startSpotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawStartSpots = !drawStartSpots;
			}
		});

		JButton regionsButton = new JButton("Regions");
		regionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawRegions = !drawRegions;
				drawChokepoints = !drawChokepoints;
			}
		});

		JButton fillRegionsButton = new JButton("Fill Regions");
		fillRegionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillRegions = !fillRegions;
			}
		});

//		JButton drawPlanButton = new JButton("Draw Base Plan");
//		drawPlanButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				drawBasePlan = !drawBasePlan;
//			}
//		});
//
//		JButton drawZonesButton = new JButton("Draw Build Zones");
//		drawZonesButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				drawBuildZones = !drawBuildZones;
//			}
//		});

		JButton influenceButton = new JButton("Influence");
		influenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				influenceMap = !influenceMap;
			}
		});
		
		panel.add(idButton);
		panel.add(pingButton);
		panel.add(playerButton);
		panel.add(enemyButton);
		panel.add(resourcesButton);
		panel.add(startSpotButton);
		panel.add(regionsButton);
		panel.add(fillRegionsButton);
//		panel.add(drawPlanButton);
//		panel.add(drawZonesButton);
		panel.add(influenceButton);
		
		return panel;
	}
}
