package escapefromuniversity.model.enemy;

import escapefromuniversity.model.AbstractDynamicGameObject;
import escapefromuniversity.model.GameObject;
import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import model.player.Player;

public abstract class BossImp extends AbstractDynamicGameObject implements Boss{
	
	private int life;
	private final long shootDelay;
	private long shootLastTime;
	private BossState state;
	private int impatDamage;
	private Point2D previousPosition;
	
	public BossImp(int speed, Point2D position, Point2D upperCorner, Vector2D direction, GameObjectType type, int life, long shootDelay, int impatDamage) {
		super(type, position, upperCorner, speed, direction);
		this.life = life;
		this.shootDelay = shootDelay;
		this.state = BossState.QUIZ;
		this.impatDamage = impatDamage;
	}

	@Override
	public void maybeShoot() {
		if(this.canShoot()) {
			this.shoot();
		}
		
	}
	
	private boolean canShoot() {
		if(System.currentTimeMillis() - this.shootLastTime > this.shootDelay) {
			this.shootLastTime = System.currentTimeMillis();
			return true;
		}
		return false;
		
	}
	
	abstract void shoot();

	@Override
	public int getLife() {
		return this.life;
	}

	@Override
	public void takeDamage(int damage) {
		this.life = this.life - damage;
		
	}

	@Override
	public void update(double deltaTime) {
		if(this.state.equals(BossState.FIGHT)) {
			this.maybeShoot();
			this.setPreviousPosition(this.getObjectPosition());
			this.move(deltaTime);
			this.setDirection(this.newDirection());
		}
	}

	@Override
	public void collisionWith(GameObject gObj2) {
		if(this.collisionWithCheck(gObj2)) {
			switch(gObj2.getType().getCollisionType()) {
			case OBSTACLE:
				this.setPosition(this.getPreviousPosition());
				break;
			case ENTITY:
				if(gObj2.getType().equals(GameObjectType.PLAYER)) {
					final Player player = (Player) gObj2;
					player.takeDamage(this.getDamage());
				}
				this.setPosition(this.getPreviousPosition());
				break;
			default:
				break;
			}
		}
	}

	@Override
	public int getDamage() {
		return this.impatDamage;
	}
	
	protected Vector2D newDirection() {
		Point2D playerPos = this.getRoom().getPlayerPosition();
		return new Vector2D((this.getObjectPosition().getX() - playerPos.getX())/this.getObjectPosition().module(playerPos),
				            (this.getObjectPosition().getY() - playerPos.getY())/this.getObjectPosition().module(playerPos));
	}

	protected Point2D getPreviousPosition() {
		return previousPosition;
	}

	private void setPreviousPosition(Point2D previousPosition) {
		this.previousPosition = previousPosition;
	}

}
