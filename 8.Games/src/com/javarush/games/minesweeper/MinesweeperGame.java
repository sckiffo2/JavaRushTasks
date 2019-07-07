package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;
import javafx.geometry.Side;

import java.util.ArrayList;

public class MinesweeperGame extends Game{
	private static final int SIDE = 9;
	private GameObject[][] gameField = new GameObject[SIDE][SIDE];  // [y][x]
	private int countMinesOnField;

	@Override
	public void initialize() {
		setScreenSize(SIDE, SIDE);
		createGame();
	}

	private void createGame(int x, int y, Color color) {

	}

	private void createGame() {
		int countMines = 0;
		for (int j = 0; j < SIDE; j++) {
			for (int i = 0; i < SIDE; i++) {
				boolean isMine = false;
				if (getRandomNumber(10) == 0) {
					isMine = true;
					countMines++;
				}
				gameField[j][i] = new GameObject(i, j, isMine);
				setCellColor(i, j, Color.GRAY);
			}
		}
		this.countMinesOnField = countMines;

		countMineNeighbors();
	}

	private void countMineNeighbors() {
		for (int i = 0; i < SIDE; i++) {
			for (int j = 0; j < SIDE; j++) {
				GameObject o = gameField[i][j];
				if (o.isMine) {
					continue;
				}
				int mineCount = 0;
				for (GameObject neighbor : getNeighbors(o)) {
					if (neighbor.isMine) {
						mineCount++;
					}
				}
				o.countMineNeighbors = mineCount;
			}

		}
	}

	private ArrayList<GameObject> getNeighbors(GameObject o) {
		ArrayList<GameObject> neighbors = new ArrayList<>(9);
		for (int i = o.y - 1; i <= o.y + 1; i++) { 								// iter y
			for (int j = o.x - 1; j <= o.x + 1; j++) {  						// iter x
				if (i < 0 | j < 0 | i > SIDE -1 | j > SIDE -1 | (i == o.y && j == o.x)) {
					continue;
				}
				neighbors.add(gameField[i][j]);

			}
		}
		return neighbors;
	}

}
