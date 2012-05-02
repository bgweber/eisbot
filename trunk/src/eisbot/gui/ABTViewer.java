package eisbot.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;

import abl.runtime.ABTNode;
import abl.runtime.BehavingListener;
import abl.runtime.Behavior;
import abl.runtime.Step;
/**
 * Viewer for the ABL Behavior Tree (ABT). Displays the executing and leafs nodes in the ABT.
 * 
 * Note: this viewer is meant for demos
 * 
 * To use:
 *  BehavingEntity entity = new YourBehavingEntity();
 *  enetity.addBehavingListener(new ABTViewer());	
 *  entity.startBehaving();
 * 
 * @author Ben Weber, 1-6-10
 */
public class ABTViewer extends JPanel implements BehavingListener, 
	MouseWheelListener, MouseMotionListener, MouseListener {

	/** mapping of ABT nodes to the local Node representation */
	private HashMap<ABTNode, ABLNode> nodeMap = new HashMap<ABTNode, ABLNode>();

	public enum NodeType {Root, SubGoal, Parallel, Sequential, MentalAct, PrimitiveAct, Unknown }

	private boolean running = true;
	
//	private JFrame frame;

	private double scale = 1.0;
	private double tx = 0;
	private double ty = 0;
	public int mx = 0;
	public int my = 0;
	private boolean mouseDown = false;	

    Font font = new Font("ariel", Font.BOLD, 12);
    int h = 25;
    int stackHeight = 35;

	private long last = 0;

	double scaleAmmount = 0.9;
    
    public ABTViewer() {

		this.addMouseWheelListener(this);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);

		// start the drawing thread
		new Thread() {
			public void run() {
				Thread.currentThread().setName("ABT Viewer Thread");
				
				while (running) {
					try {
						Thread.sleep(50);
					}
					catch (Exception e) {}
					
					repaint();
				}
			}
		}.start();		
	}

	/**
	 * Shuts down the GUI.
	 */
	public void stop() {
		running = false;
	}
	    
	public void executingStep(Step selectedStep) { }

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, getWidth(), getHeight());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);

        g2.translate(tx, ty);
        g2.scale(scale, scale);

        // draw working memory
        int y = 0;
                
        ArrayList<ABLNode> roots = new ArrayList<ABLNode>();        
        synchronized (nodeMap) {
	        for (ABLNode node : nodeMap.values()) {
	        	if (node.parent == null) {
	        		roots.add(node);
	        	}
	        }
        }
        
        y = 0;
        int depth = 0;
        for (ABLNode node : roots) {
        	y = drawNode(g2, node, y, depth);
        }
	}

	public int drawNode(Graphics2D g2, ABLNode node, int y, int depth) {
		drawNode(g2, node, y, depth, h);				
		y++;

		if (!node.collapsed) {
			for (ABLNode child : node.children) {
				y = drawNode(g2, child, y, depth + 1);
			}
		}
		
		return y;
	}

	private void drawNode(Graphics2D g2, ABLNode node, int y, int depth, int h) {

		// draw the collapse icon
        g2.setColor(Color.GRAY.darker());
//		g2.setColor(new Color(230, 230, 230));
		g2.fillRect(50*depth - 20, stackHeight*y + h/2 + 1, 10, 2);
		if (node.collapsed) {
			g2.fillRect(50*depth - 16, stackHeight*y + 9, 2, 10);			
		}
		
		int tw = 20 + (15*node.name.length()/2);
		g2.setColor(new Color(230, 230, 230));
		
		if (node.type == NodeType.Root) {
			g2.setColor(Color.ORANGE.brighter().brighter());
		}
		else if (node.type == NodeType.Parallel) {
			g2.setColor(new Color(200, 255, 200));			
		}
		else if (node.type == NodeType.Sequential) {
			g2.setColor(new Color(255, 255, 200));			
		}
		else if (node.type == NodeType.MentalAct) {
			g2.setColor(new Color(255, 255, 255));			
		}
		else if (node.type == NodeType.PrimitiveAct) {
			g2.setColor(new Color(150, 255, 255));			
		}
		
		RoundRectangle2D rect = new RoundRectangle2D.Double(50*depth, stackHeight*y, tw, h, 20, 20);
		g2.fill(rect);
				
		if (node.executing > 0) {
			g2.setColor(new Color(0,1.0f,0, 0.001f*(float)node.executing));
			g2.fill(rect);
		}
		
		if (node.leaf > 0) {
			g2.setColor(new Color(0,0,1.0f, 0.001f*(float)node.leaf));
			g2.fill(rect);
		}
        
		g2.setStroke(new BasicStroke(3.0f));
        g2.setColor(Color.GRAY.darker());
		g2.draw(rect);
                
        g2.setColor(Color.black);
        g2.setFont(font);
        g2.drawString(node.name, 50*depth + 10, stackHeight*y + 18);		
	}
	
	public void onBehave(Hashtable executingSteps, Set leafSteps) {
		updateTree(executingSteps, leafSteps);
	}
	
	private void updateTree(Hashtable executingSteps, Set leafSteps) {
		synchronized (nodeMap) {
		
			// clear the node status's
			int decay = 0;
			if (last > 0) decay = 3*(int)(System.currentTimeMillis() - last);
			last = System.currentTimeMillis();
			
			for (ABLNode node : nodeMap.values()) {
				node.leaf = Math.max(0, node.leaf - decay);
				node.executing = Math.max(0, node.executing - decay);
			}
			
			// add leaf steps
			for (Object obj : leafSteps) {
				Step step = (Step)obj;
				
				ABLNode node = nodeMap.get(step);
				if (node != null) {
					node.leaf = 1000;
				}
				else {
					node = new ABLNode(step.toString());
					node.leaf = 1000;
					nodeMap.put(step, node);
					addNode(node, step);
				}
			}
	
			// add executing steps
			for (Object key : executingSteps.keySet()) {
				HashSet steps = (HashSet)executingSteps.get(key);
				
				for (Object object : steps) {
					Step step = (Step)object;
	
					ABLNode node = nodeMap.get(step);
					if (node != null) {
						node.executing = 1000;
					}
					else {
						node = new ABLNode(step.toString());
						node.executing = 1000;
						nodeMap.put(step, node);
						addNode(node, step);
					}
				}
			}		
		
		}
	}

	private void printTree() {
		ArrayList<ABLNode> rootNodes = new ArrayList<ABLNode>();
		for (ABLNode node : nodeMap.values()) {
			if (node.parent == null) {
				rootNodes.add(node);
			}
		}
		
		for (ABLNode node : rootNodes) {
			print(node, " ");
		}
	}
	
	private void print(ABLNode node, String indent) {
		System.out.println(indent + node.type + ": " + node.name);
		
		for (ABLNode child : node.children) {
			print(child, indent + " ");
		}
	}
	
	private void addNode(ABLNode node, Step step) {

		// get the parent behavior
		Behavior parent = step.getParent();
		if (parent != null) {				
			ABLNode behaviorNode = nodeMap.get(parent);

			// no parent node yet
			if (behaviorNode == null) {
				behaviorNode = new ABLNode(parent.toString());					
				
				nodeMap.put(parent, behaviorNode);					
				node.setParent(behaviorNode);
				
				// get the parent step
				Step parentStep = parent.getParent();					
				if (parentStep != null) {
					
					ABLNode goalNode = nodeMap.get(parentStep);
				
					// create the parent step node
					if (goalNode == null) {
						goalNode = new ABLNode(step.toString());
						nodeMap.put(parentStep, goalNode);							
						addNode(goalNode, parentStep);
						
						behaviorNode.setParent(goalNode);							
						return;
					}
					// parent step node already exist
					else {
						behaviorNode.setParent(goalNode);
						return;
					}						
				}
				// no parent step
				else {
					return;
				}					
			}
			// parent behavior node already exist
			else {
				node.setParent(behaviorNode);
				return;
			}
		}
		// no step parent, not sure if possible
		else {
			return;
		}			
	}

	public class ABLNode implements Comparable<ABLNode> {
		public ABLNode parent = null;		
		public TreeSet<ABLNode> children = new TreeSet<ABLNode>();		
		public int leaf = 0;
		public int executing = 0;		
		public String description;
		public String name;
		public NodeType type;
		public boolean collapsed = false;

		public ABLNode(String name) {
			this.description = name;
			type = NodeType.Unknown;
			this.name = name;
			
			if (name.startsWith("collection")) {
				type = NodeType.Root;
				this.name = name.split(" ")[1];
			}
			else if (name.startsWith("subgoal")) {
				type = NodeType.SubGoal;
				this.name = name.split(" ")[1];
			}
			else if (name.startsWith("sequential")) {
				type = NodeType.Sequential;
				this.name = name.split(" ")[1];
			}	
			else if (name.startsWith("parallel")) {
				type = NodeType.Parallel;
				this.name = name.split(" ")[1];
			}
			else if (name.startsWith("mental")) {
				type = NodeType.MentalAct;
				this.name = "Mental Act";
			}
			else if (name.startsWith("act")) {
				type = NodeType.PrimitiveAct;
				this.name = name.split(" ")[1];
			}
			
			if (!type.equals(NodeType.Unknown)) {
				this.name = type + ":" + this.name;
			}
			
//			collapsed = true;
		}
		
		public void setParent(ABLNode parent) {
			this.parent = parent;
			parent.children.add(this);
			
			int depth = 0;
			ABLNode node = parent;
			
			while (node != null) {
				depth++;
				node = node.parent;
			}
			
			if (depth > 6) collapsed = true;
//			System.out.println("Depth: " + depth);
		}

		public int compareTo(ABLNode o) {
			return name.compareTo(o.name);
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		try {
		
		if (e.getWheelRotation() > 0) {
//			scale *= scaleAmmount;
			
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
		else {
			int x = e.getX();
			int y = e.getY();
			
			AffineTransform transform = new AffineTransform();
			transform.translate(tx, ty);
			transform.scale(scale, scale);

			Point2D source = new Point2D.Double(x, y);
			Point2D result = new Point2D.Double();
			
			try {
				transform.inverseTransform(source, result);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
			int stack = (int)(result.getY()/stackHeight);
			if (stack >= 0 && stack < nodeMap.size()) {
			
				synchronized (nodeMap) {
					ArrayList<ABLNode> fringe = new ArrayList<ABLNode>();
					for (ABLNode node : nodeMap.values()) {
						if (node.parent == null) {
							fringe.add(node);
						}
					}
	
					int count = 0;
					while (fringe.size() > 0) {
						ABLNode node = fringe.remove(0);
						if (stack == count++) {
							node.collapsed = !node.collapsed;
						}
						else {
							int index = 0;
							
							if (!node.collapsed) {
								for (ABLNode child : node.children) {
									fringe.add(index++, child);
								}
							}
						}					
					}
				}
			}			
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
}
