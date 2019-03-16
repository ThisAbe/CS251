package Program10;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MineSweapPart extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 760;
	private static final int WIDTH = 760;
	private static final int ROWS = 16;
	private static final int COLS = 16;
	private static final int MINES = 16;
	private static int minesLeft = MineSweapPart.MINES;
	private static int actualMinesLeft = MineSweapPart.MINES;
	private static final String FLAGGED = "@";
	private static final String MINE = "M";
	// visual indication of an exposed MyJButton
	private static final Color expColor = Color.lightGray;
	// colors used when displaying the getStateStr() String
	private static final Color colorMap[] =
	{ Color.lightGray, Color.blue, Color.green, Color.cyan, Color.yellow,
			Color.orange, Color.pink, Color.magenta, Color.red, Color.red };
	private boolean running = true;
	// holds the "number of mines in perimeter" value for each MyJButton
	private int[][] sGrid = new int[ROWS][COLS];
	private MyJButton[][] tGrid = new MyJButton[ROWS][COLS];

	public MineSweapPart()
	{
		this.setTitle("MineSweap " + MineSweapPart.minesLeft + " Mines left");
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setLayout(new GridLayout(ROWS, COLS, 0, 0));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.createContents();
		// place MINES number of mines in sGrid and adjust all of the
		// "mines in perimeter" values
		this.setMines();
		this.setVisible(true);
	}

	public void createContents()
	{
		for (int br = 0; br < ROWS; ++br)
		{
			for (int bc = 0; bc < COLS; ++bc)
			{
				// set sGrid[br][bc] entry to 0 - no mines in it’s perimeter
				sGrid[br][bc] = 0;

				// create a MyJButton that will be at location (br, bc) in the
				// GridLayout
				MyJButton but;
				but = new MyJButton("", br, bc);
				tGrid[br][bc] = but;
				// register the event handler with this MyJbutton
				but.addActionListener(new MyListener());
				// add the MyJButton to the GridLayout collection
				this.add(but);
			}
		}
	}

	// nested private class
	private class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (running)
			{
				// used to detrmine if ctrl or alt key was pressed at the time
				// of mouse action
				int mod = event.getModifiers();
				MyJButton jb = (MyJButton) event.getSource();
				// is the MyJbutton that the mouse action occurred in flagged
				boolean flagged = jb.getText().equals(MineSweapPart.FLAGGED);
				// is the MyJbutton that the mouse action occurred in already
				// exposed
				boolean exposed = jb.getBackground().equals(expColor);
				// flag a cell : ctrl + left click
				if (!flagged && !exposed && (mod & ActionEvent.CTRL_MASK) != 0)
				{
					jb.setText(MineSweapPart.FLAGGED);
					--MineSweapPart.minesLeft;
					// if the MyJbutton that the mouse action occurred in is a
					// mine
					if (sGrid[jb.row][jb.col] == 9)
					{
						// nothing happens mine is not exposed and not flagged
					}
					setTitle("MineSweap " + MineSweapPart.minesLeft
							+ " Mines left");
				}
				// un-flag a cell : alt + left click
				else if (flagged && !exposed
						&& (mod & ActionEvent.ALT_MASK) != 0)
				{
					jb.setText("");
					++MineSweapPart.minesLeft;
					// if the MyJbutton that the mouse action occurred in is a
					// mine
					if (sGrid[jb.row][jb.col] == 9)
					{
						++MineSweapPart.actualMinesLeft;// what else do you need
						// to adjust?
						// could the game be over?
					}
					setTitle("MineSweap " + MineSweapPart.minesLeft
							+ " Mines left");
				}
				// expose a cell : left click
				else if (!flagged && !exposed)
				{
					exposeCell(jb);
				}
			}
		}

		public void exposeCell(MyJButton jb)
		{
			if (!running)
				return;
			// expose this MyJButton
			jb.setBackground(expColor);
			jb.setForeground(colorMap[sGrid[jb.row][jb.col]]);
			jb.setText(getStateStr(jb.row, jb.col));
			// if the MyJButton that was just exposed is a mine
			if (sGrid[jb.row][jb.col] == 9)
			{
				setTitle("Game Over");
				return;
			}

			if (sGrid[jb.row][jb.col] == 0)
			{
				if (jb.row > 0
						&& jb.row < ROWS - 1
						&& jb.col > 0
						&& jb.col < COLS - 1
						&& tGrid[jb.row - 1][jb.col - 1].getBackground() != expColor)
				{
					if (jb.row != 0 && jb.col != 0
							&& sGrid[jb.row - 1][jb.col - 1] == 0
							|| sGrid[jb.row - 1][jb.col - 1] == 1)
						exposeCell(tGrid[jb.row - 1][jb.col - 1]);
				}
				if (jb.row > 0
						&& jb.row < ROWS - 1
						&& jb.col > 0
						&& jb.col < COLS - 1
						&& tGrid[jb.row - 1][jb.col].getBackground() != expColor)
				{
					if (jb.row != 0 && sGrid[jb.row - 1][jb.col] == 0
							|| sGrid[jb.row - 1][jb.col] == 1)
						exposeCell(tGrid[jb.row - 1][jb.col]);
				}
				if (jb.row > 0
						&& jb.row < ROWS - 1
						&& jb.col > 0
						&& jb.col < COLS - 1
						&& tGrid[jb.row - 1][jb.col + 1].getBackground() != expColor)
				{
					if (jb.row != 0 && jb.col != COLS
							&& sGrid[jb.row - 1][jb.col + 1] == 0
							|| sGrid[jb.row - 1][jb.col + 1] == 1)
						exposeCell(tGrid[jb.row - 1][jb.col + 1]);
				}
				if (jb.row > 0
						&& jb.row < ROWS - 1
						&& jb.col > 0
						&& jb.col < COLS - 1
						&& tGrid[jb.row][jb.col - 1].getBackground() != expColor)
				{
					if (jb.col != 0 && sGrid[jb.row][jb.col - 1] == 0
							|| sGrid[jb.row][jb.col - 1] == 1)
						exposeCell(tGrid[jb.row][jb.col - 1]);
				}
				if (jb.row > 0
						&& jb.row < ROWS - 1
						&& jb.col > 0
						&& jb.col < COLS - 1
						&& tGrid[jb.row][jb.col + 1].getBackground() != expColor)
				{
					if (jb.col != COLS && sGrid[jb.row][jb.col + 1] == 0
							|| sGrid[jb.row][jb.col + 1] == 1)
						exposeCell(tGrid[jb.row][jb.col + 1]);
				}
				if (jb.row > 0
						&& jb.row < ROWS - 1
						&& jb.col > 0
						&& jb.col < COLS - 1
						&& tGrid[jb.row + 1][jb.col - 1].getBackground() != expColor)
				{
					if (jb.row != ROWS && jb.col != 0
							&& sGrid[jb.row + 1][jb.col - 1] == 0
							|| sGrid[jb.row + 1][jb.col - 1] == 1)
						exposeCell(tGrid[jb.row + 1][jb.col - 1]);
				}
				if (jb.row > 0
						&& jb.row < COLS - 1
						&& jb.col > 0
						&& jb.col < ROWS - 1
						&& tGrid[jb.row + 1][jb.col].getBackground() != expColor)
				{
					if (jb.row != ROWS && sGrid[jb.row + 1][jb.col] == 0
							|| sGrid[jb.row + 1][jb.col] == 1)
						exposeCell(tGrid[jb.row + 1][jb.col]);
				}
				if (jb.row > 0
						&& jb.row < ROWS - 1
						&& jb.col > 0
						&& jb.col < COLS - 1
						&& tGrid[jb.row + 1][jb.col + 1].getBackground() != expColor)
				{
					if (jb.row != ROWS && jb.col != COLS
							&& sGrid[jb.row + 1][jb.col + 1] == 0
							|| sGrid[jb.row + 1][jb.col + 1] == 1)
						exposeCell(tGrid[jb.row + 1][jb.col + 1]);
				}

			}

			if (actualMinesLeft == 0)
			{
				setTitle("Game Over");
				return;
			}
		}
	}

	// nested private class
	public static void main(String[] args)
	{
		new MineSweapPart();
	}

	private void setMines()
	{
		int minesToPlace = 16;
		while (minesToPlace != 0)
		{
			int x = (int) (Math.random() * ROWS);
			int y = (int) (Math.random() * COLS);
			for (int a = -1; a <= 1; a++)
			{
				for (int b = -1; b <= 1; b++)
				{
					if (a == 0 && b == 0)
					{
						if (sGrid[x][y] != 1 && sGrid[x][y] != 9)
						{
							sGrid[x][y] = 9;
							this.getStateStr(x, y);
							minesToPlace--;
						}

					} else if (x + a >= 0 && y + b >= 0 && x + a < ROWS
							&& y + b < COLS)
					{
						if (sGrid[x + a][y + b] != 9)
						{
							int l = x + a;
							int m = y + b;
							sGrid[l][m] = 1;
							this.getStateStr(l, m);
						}
					}

				}

			}

		}
	}

	private String getStateStr(int row, int col)
	{
		// no mines in this MyJbutton’s perimeter
		if (this.sGrid[row][col] == 0)
			return "";
		// 1 to 8 mines in this MyJButton’s perimeter
		else if (this.sGrid[row][col] > 0 && this.sGrid[row][col] < 9)
			return "" + this.sGrid[row][col];
		// this MyJButton in a mine
		else
			return MineSweapPart.MINE;
	}
}
