/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.UnboundedGrid;
import java.awt.Color;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner
{
	public static void main(String[] args)
	{


		Color purple = new Color(148, 0, 211);
		ActorWorld world = new ActorWorld();
		Bug redBug = new Bug();
		world.add(redBug);
		System.out.println(redBug.getLocation());

		makeBugs(world, 10);
		//colorBug(redBug);
		//moveBug(redBug, 5);

		//randomBug(redBug, 10000);

		world.add(new Rock());
		world.show();
	}

	public static void moveBug(Bug bug, int n) {

		for(int i = 0; i < n; i++) {

			if(bug.canMove()) {

				bug.move();

			} else {

				bug.turn();

			}

		}
	}

	public static void randomBug(Bug bug, int n) {

		for(int i = 0; i < n; i++) {

			int randomDirection = (int)(4 * Math.random()) * 90;

			bug.setDirection(randomDirection);

			if(bug.canMove()) {

				bug.move();

			}
		}
	}

	public static void colorBug(Bug bug) {

		bug.getLocation();
		bug.setColor(new Color(148, 0, 211));

	}

	public static void makeBugs(ActorWorld world, int n) {

		for(int i = 0; i < n; i++) {

			Bug coloredBug = new Bug();

			world.add(coloredBug);

			int x = coloredBug.getLocation().getCol();
			int y = coloredBug.getLocation().getRow();

			coloredBug.setColor(new Color(25 * y, 0, 25 * x));



		}

	}
}
