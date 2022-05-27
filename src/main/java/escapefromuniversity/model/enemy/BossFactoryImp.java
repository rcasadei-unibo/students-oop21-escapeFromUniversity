package escapefromuniversity.model.enemy;

import java.util.LinkedList;
import java.util.List;

import escapefromuniversity.model.GameObjectType;
import escapefromuniversity.model.Point2D;
import escapefromuniversity.model.Vector2D;
import escapefromuniversity.model.bullet.Bullet;
import escapefromuniversity.model.bullet.BulletFactory;
import escapefromuniversity.model.bullet.BulletFactoryImp;

public class BossFactoryImp implements BossFactory{
	private final BulletFactory bulletCre = new BulletFactoryImp();

    
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss1(Point2D position, Vector2D direction) {
		return new BossImp(BossConstant.boss1_speed, position, BossConstant.BOSS_BOX_OCCUPATION, direction, GameObjectType.BOSS1, BossConstant.boss1_life, BossConstant.boss1_shootDelay, BossConstant.boss1_damage) {

			@Override
			void shoot() {
				final Bullet bullet = bulletCre.createBoss1Bullet(this.getObjectPosition(), this.getDirection());
				this.getRoom().addDynamicGameObject(bullet);
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss2(Point2D position, Vector2D direction) {
		return new BossImp(BossConstant.boss2_speed, position, BossConstant.BOSS_BOX_OCCUPATION, direction, GameObjectType.BOSS2, BossConstant.boss2_life, BossConstant.boss2_shootDelay, BossConstant.boss2_damage) {

			@Override
			void shoot() {
				final List<Bullet> bullets = new LinkedList<>();
				final Point2D pos = this.getObjectPosition();
				bullets.add(bulletCre.createBoss2Bullet(this.getObjectPosition(), this.getDirection()));
				bullets.add(bulletCre.createBoss2Bullet(pos.sum(new Vector2D(10, 10)), this.getDirection()));
				bullets.add(bulletCre.createBoss2Bullet(pos.sum(new Vector2D(-10, -10)), this.getDirection()));
				bullets.forEach(bul -> {
					this.getRoom().addDynamicGameObject(bul);
				});
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss3(Point2D position, Vector2D direction) {
		return new BossImp(BossConstant.boss3_speed, position, BossConstant.BOSS_BOX_OCCUPATION, direction, GameObjectType.BOSS3, BossConstant.boss3_life, BossConstant.boss3_shootDelay, BossConstant.boss3_damage) {

			@Override
			void shoot() {
				final List<Bullet> bullets = new LinkedList<>();
				final Point2D pos = this.getObjectPosition();
				bullets.add(bulletCre.createBoss3Bullet(pos, new Vector2D(0, 1)));
				bullets.add(bulletCre.createBoss3Bullet(pos, new Vector2D(0, -1)));
				bullets.add(bulletCre.createBoss3Bullet(pos, new Vector2D(1, 1)));
				bullets.add(bulletCre.createBoss3Bullet(pos, new Vector2D(-1, 1)));
				bullets.add(bulletCre.createBoss3Bullet(pos, new Vector2D(1, -1)));
				bullets.add(bulletCre.createBoss3Bullet(pos, new Vector2D(-1, -1)));
				bullets.add(bulletCre.createBoss3Bullet(pos, new Vector2D(1, 0)));
				bullets.add(bulletCre.createBoss3Bullet(pos, new Vector2D(1, 0)));
				bullets.forEach(bul -> {
					this.getRoom().addDynamicGameObject(bul);
				});
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss4(Point2D position, Vector2D direction) {
		return new BossImp(BossConstant.boss4_speed, position, BossConstant.BOSS_BOX_OCCUPATION, direction, GameObjectType.BOSS4, BossConstant.boss4_life, BossConstant.boss4_shootDelay, BossConstant.boss4_damage) {

			@Override
			void shoot() {
				final Bullet bullet = bulletCre.createBoss4Bullet(this.getObjectPosition(), this.getDirection());
				this.getRoom().addDynamicGameObject(bullet);
				
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss5(Point2D position, Vector2D direction) {
		return new BossImp(BossConstant.boss5_speed, position, BossConstant.BOSS_BOX_OCCUPATION, direction, GameObjectType.BOSS5, BossConstant.boss5_life, BossConstant.boss5_shootDelay, BossConstant.boss5_damage) {

			@Override
			void shoot() {
				final Bullet bullet = bulletCre.createBoss5Bullet(this.getObjectPosition(), this.getDirection());
				this.getRoom().addDynamicGameObject(bullet);
				
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Enemy createBoss6(Point2D position, Vector2D direction) {
		return new BossImp(BossConstant.boss6_speed, position, BossConstant.BOSS_BOX_OCCUPATION, direction, GameObjectType.BOSS6, BossConstant.boss6_life, BossConstant.boss6_shootDelay, BossConstant.boss6_damage) {

			@Override
			void shoot() {
				final Bullet bullet = bulletCre.createBoss6Bullet(this.getObjectPosition(), this.getDirection());
				this.getRoom().addDynamicGameObject(bullet);
				
			}
			
		};
	}

}
