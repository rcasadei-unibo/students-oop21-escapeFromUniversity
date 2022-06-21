package escapefromuniversity.menu;

import escapefromuniversity.inGame.GameController;
import escapefromuniversity.model.GameState;

public class MenuControllerImpl implements MenuController{
	private final GameController gameController;
	private final MenuView view;
	
	public MenuControllerImpl(final GameController gameController) {
		this.gameController = gameController;
		this.view = new MenuViewImpl(this);
	}

	@Override
	public void getCommand() {
		System.exit(0);
		
	}

	@Override
	public void exit() {
		System.exit(0);
		
	}

	@Override
	public void resume() {
		this.view.close();
		this.gameController.setGameState(GameState.PLAY);
		
	}

}
