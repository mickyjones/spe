package me.teaisaweso.client;

import java.util.Collection;

import junit.framework.Assert;
import junit.framework.TestCase;
import me.teaisaweso.client.graphmanagers.GraphManager2d;
import me.teaisaweso.client.graphmanagers.GraphManager2dFactory;
import me.teaisaweso.shared.Graph;
import me.teaisaweso.shared.Vertex;

/**
 * NOTE: this class relies on the GraphManager2d factory working, if it isn't
 * you should probably assume that this test is totally broken
 */
public class GraphManager2dTest extends TestCase {
	private GraphManager2d mManager;

	/**
	 * runs test setup, creates a graphmanager instance
	 */
	public void setUp() {
		mManager = GraphManager2dFactory.getInstance().makeDefaultGraphManager();
	}

	/**
	 * tests that adding vertices works
	 */
	public void testAddVertex() {
		mManager.addVertex(new Vertex("hi"), 0, -3, 10);
		Graph underlying = mManager.getUnderlyingGraph();
		Assert.assertEquals(true, underlying.getVertices().contains(new Vertex("hi")));
		Collection<VertexDrawable> drawables = mManager.getVertexDrawables();
		Assert.assertEquals(1, drawables.size());
		VertexDrawable[] vds = drawables.toArray(new VertexDrawable[] { new VertexDrawable(0, 0, 0,
				0, "") });
		Assert.assertEquals(0, vds[0].getCenterX());
		Assert.assertEquals(-5, vds[0].getLeft());
		Assert.assertEquals(-3, vds[0].getCenterY());
		Assert.assertEquals(-8, vds[0].getTop());
		Assert.assertEquals(10, vds[0].getWidth());
		Assert.assertEquals(10, vds[0].getHeight());
		Assert.assertEquals("hi", vds[0].getLabel());
	}
}
