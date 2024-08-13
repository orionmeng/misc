/**
 * A class representing a single UFO object that can move, fire, and be hit.
 * 
 */
public class UFO {

	public static final int SIMPLE_SAUCER = 0;

	private int xPosition; //current x position of UFO's center
	private int yPosition; //current y position of UFO's center
	private int UFOType;   //type of UFO

	/**
	 * Constructs an UFO object given its type and initial position
	 * 
	 * @param startX initial x coordinate
	 * @param startY initial y coordinate
	 * @param UFOType int representing the type of UFO this is.
	 */
	public UFO(int startX, int startY, int UFOType) {
		this.xPosition = startX;
		this.yPosition = startY;
		this.UFOType = UFOType;
	}

	/**
	 * Get the current x coordinate of the center of this UFO.
	 * 
	 * @return The current x coordinate of the center of this UFO.
	 */
	public int getXPosition() {
		int returnVal = 0;
		returnVal = this.xPosition;
		return returnVal;
	}

	/**
	 * Get the current y coordinate of the center of this UFO.
	 * 
	 * @return The current y coordinate of the center of this UFO.
	 */
	public int getYPosition() {
		int returnVal = 0;
		returnVal = this.yPosition;
		return returnVal;
	}

	/**
	 * Get an int represented the type for this UFO
	 * 
	 * @return The int representing the type of this UFO
	 */
	public int getUFOType() {
		int returnVal = 0;
		returnVal = this.UFOType;
		return returnVal;
	}

	/**
	 * Updates the position of the UFO for the next time it is redrawn.
	 * 
	 * @param defender The Defender object. Ignore for now, but it may
	 * be used later in the lab to determine movement some UFO types.
	 */
	public void takeOneStep(Defender defender) {
		do {
			this.xPosition -= 3;
		} while (this.xPosition < SpaceGame.getMaximumX());
		do {
			this.xPosition += 3;
		} while (this.xPosition > 0);
		do {
			this.xPosition -= 3;
		} while (this.xPosition < SpaceGame.getMaximumX());
		do {
			this.xPosition += 3;
		} while (this.xPosition > 0);
		do {
			this.xPosition -= 3;
		} while (this.xPosition < SpaceGame.getMaximumX());
		do {
			this.xPosition += 3;
		} while (this.xPosition > 0);
	}

	/**
	 * Return true if this UFO fires this during this tick.
	 * 
	 * @param defender The Defender object. Ignore for now, but it may
	 * be used later in the lab to determine firing for some UFO types.
	 * @return Whether or not this UFO shoots on this tick.
	 */
	public boolean shootsThisTurn(Defender defender) {
		//TODO: TASK 3 - write your code here
		//replace the return statement below
		return false;
	}

	/**
	 * Return the bullet this UFO is about to fire.
	 * 
	 * @param defender The Defender object. Ignore for now, but it may
	 * be used later in the lab to determine firing for some UFO types.
	 * @return The bullet this UFO is about to fire.
	 */
	public Laser fireWeapon(Defender defender) {
		//TODO: TASK 3 - write your code here
		//replace the return statement below
		return null;
	}

	/**
	 * Returns whether this UFO intersects this Laser
	 * 
	 * @param theLaser a laser that may be near the UFO.
	 * @return true if this UFO intersects this Laser
	 */
	public boolean isHitByLaser(Laser theLaser) {
		//TODO: TASK 4 - write your code here
		//replace the return statement below
		return false;
	}

	/**
	 * Updates the Object to record that it has been hit by a Laser. This
	 * method is called every time the UFO is struck by a Laser.
	 */
	public void recordHit() {
		//TODO: TASK 4 - write your code here
	}
	
	/**
	 * Returns true if this UFO has been destroyed.
	 * 
	 * @return true if the UFO has been destroyed.
	 */
	public boolean removeMeFromGame() {
		//TODO: TASK 4 - write your code here
		//replace the return statement below
		return false;
	}

}