package escapefromuniversity.model.shop;

import escapefromuniversity.model.basics.Point2D;
import escapefromuniversity.model.gameObject.AbstractStaticGameObject;
import escapefromuniversity.model.gameObject.GameObject;
import escapefromuniversity.model.gameObject.GameObjectType;
import escapefromuniversity.model.map.Mapp;

/**
 * Implementation of Shop interface.
 */
public class ShopImpl extends AbstractStaticGameObject implements Shop {
	
	/**
	 * Constructor of a ShopImpl
	 * @param type The type of the game object.
	 * @param position The position of the game object represented with a Point2Dthe position of the game object represented with a Point2D.
	 * @param upperCorner
	 * @param room
	 */
    public ShopImpl(final GameObjectType type, final Point2D position, final Point2D upperCorner, final Mapp map) {
        super(type, position, upperCorner, map);
    }

    @Override
    public void collisionWith(final GameObject gObj2) {
        if (gObj2.getType() == GameObjectType.PLAYER) {
            this.getMap().getMapManager().setupShop();
        }
    }
}
