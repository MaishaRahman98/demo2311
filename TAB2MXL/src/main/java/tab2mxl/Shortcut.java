package tab2mxl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shortcut implements KeyListener {
	window win;
	public Shortcut(window win) {
		this.win = win;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_S) {
			win.file.save();
		}
		if (e.isShiftDown()&&e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_N) {
			win.file.newfile();
		}
		if (e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_Z) {
			win.file.undo();
		}
		if (e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_Y) {
			win.file.redo();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
