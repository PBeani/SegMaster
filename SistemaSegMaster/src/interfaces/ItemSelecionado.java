/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Carla Vieira
 */
public class ItemSelecionado {
        private int ID;
	private ItemSelecionado() {}

	private static class ItemHolder { 
            private final static ItemSelecionado instance = new ItemSelecionado();
	}

	public static ItemSelecionado getInstance() {
		return ItemHolder.instance;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

        
}
