import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TetrisDemo extends JFrame {

	public JPanel mainPanel = new JPanel(new GridLayout(20, 10));
	public JButton btn[][] = new JButton[20][10];
	public int blockStat[][] = new int[20][10]; // 0이면 존재하지않음. 1이면 활성화. 2이면 존재비활성.
	public boolean dead;
	public boolean active;
	public int activeBlock[][] = new int[4][2];
	public int curBlockShape;
	public int curBlockDir;
	
	class Down implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				boolean moveFlag = true;
				if (curBlockShape == 1) {
					if (activeBlock[2][0] + 1 >= 20)
						moveFlag = false;
					else {
						if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
							moveFlag = false;
						if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
							moveFlag = false;
					}
				} else if (curBlockShape == 2) {
					if (curBlockDir == 1 || curBlockDir == 3) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else {
						if (activeBlock[0][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					}
				} else if (curBlockShape == 3) {
					if (curBlockDir == 1 || curBlockDir == 3) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else {
						if (activeBlock[2][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					}
				} else if (curBlockShape == 4) {
					if (curBlockDir == 1 || curBlockDir == 3) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else {
						if (activeBlock[2][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					}
				} else if (curBlockShape == 5) {
					if (curBlockDir == 1) {
						if (activeBlock[1][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else if (curBlockDir == 2) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else if (curBlockDir == 3) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					}
				} else if (curBlockShape == 6) {
					if (curBlockDir == 1) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else if (curBlockDir == 2) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else if (curBlockDir == 3) {
						if (activeBlock[2][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					}
				} else {
					if (curBlockDir == 1) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else if (curBlockDir == 2) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else if (curBlockDir == 3) {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					} else {
						if (activeBlock[3][0] + 1 >= 20)
							moveFlag = false;
						else {
							if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
								moveFlag = false;
							if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
								moveFlag = false;
						}
					}
				}
				if (moveFlag) {
					for (int ii = 0; ii < 4; ii++) {
						btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
						blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
					}
					for (int ii = 0; ii < 4; ii++) {
						activeBlock[ii][0]++;
					}
					for (int ii = 0; ii < 4; ii++) {
						btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
						blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
					}
				} else {
					for (int ii = 0; ii < 4; ii++) {
						blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 2;
					}
					boolean lineDelete = true;
					while (lineDelete) {
						lineDelete = false;
						for (int ii = 19; ii >= 0; ii--) {
							boolean lineFull = true;
							for (int jj = 0; jj < 10; jj++) {
								if (blockStat[ii][jj] == 0) {
									lineFull = false;
									break;
								}
							}
							if (lineFull) {
								lineDelete = true;
								for (int k = ii - 1; k >= 0; k--) {
									for (int l = 0; l < 10; l++) {
										btn[k + 1][l].setBackground(btn[k][l].getBackground());
										blockStat[k + 1][l] = blockStat[k][l];
									}
								}
							}
						}
					}

					active = false;
				}
			}
		}

	}

	class Tetromino {
		private int blockShape;
		private int blockDir;

		Tetromino() {
			this.blockShape = (int) (Math.random() * 7) + 1;
			this.blockDir = (int) (Math.random() * 4) + 1;
		}

		public int getBlockShape() {
			return blockShape;
		}

		public void setBlockShape(int blockShape) {
			this.blockShape = blockShape;
		}

		public int getBlockDir() {
			return blockDir;
		}

		public void setBlockDir(int blockDir) {
			this.blockDir = blockDir;
		}
	}

	public TetrisDemo() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				btn[i][j] = new JButton();
				JButton b = btn[i][j];
				b.addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
						if (e.getKeyCode() == 37) {
							boolean moveFlag = true;

							if (curBlockShape == 1) {
								if (activeBlock[0][1] - 1 < 0)
									moveFlag = false;
								else {
									if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
										moveFlag = false;
									if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
										moveFlag = false;
								}
							} else if (curBlockShape == 2) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 3) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[2][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 4) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[2][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 5) {
								if (curBlockDir == 1) {
									if (activeBlock[1][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[1][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 6) {
								if (curBlockDir == 1) {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[1][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								}
							} else {
								if (curBlockDir == 1) {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] - 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[2][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[0][1] - 1 < 0)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											moveFlag = false;
									}
								}
							}

							if (moveFlag) {
								for (int ii = 0; ii < 4; ii++) {
									btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
									blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
								}
								for (int ii = 0; ii < 4; ii++) {
									activeBlock[ii][1]--;
								}
								for (int ii = 0; ii < 4; ii++) {
									btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
									blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
								}
							}
						} else if (e.getKeyCode() == 39) {
							boolean moveFlag = true;
							if (curBlockShape == 1) {
								if (activeBlock[1][1] + 1 >= 10)
									moveFlag = false;
								else {
									if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
										moveFlag = false;
									if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
										moveFlag = false;
								}
							} else if (curBlockShape == 2) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[0][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[3][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 3) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[0][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[3][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 4) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[2][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[1][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 5) {
								if (curBlockDir == 1) {
									if (activeBlock[3][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[2][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[2][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[0][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 6) {
								if (curBlockDir == 1) {
									if (activeBlock[1][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[0][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[3][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[2][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								}
							} else {
								if (curBlockDir == 1) {
									if (activeBlock[1][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[2][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[0][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[3][1] + 1 >= 10)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											moveFlag = false;
									}
								}
							}
							if (moveFlag) {
								for (int ii = 0; ii < 4; ii++) {
									btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
									blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
								}
								for (int ii = 0; ii < 4; ii++) {
									activeBlock[ii][1]++;
								}
								for (int ii = 0; ii < 4; ii++) {
									btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
									blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
								}
							}
						} else if (e.getKeyCode() == 32) {

							boolean rotationFlag = true;
							if (curBlockShape == 1)
								rotationFlag = false;
							else if (curBlockShape == 2) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[1][1] - 2 < 0 || activeBlock[1][1] + 1 >= 10)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 2] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											rotationFlag = false;
									}
								} else {
									if (activeBlock[2][0] + 2 >= 20 || activeBlock[2][0] - 1 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[2][0] - 1][activeBlock[2][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0] + 2][activeBlock[2][1]] != 0)
											rotationFlag = false;
									}
								}
							} else if (curBlockShape == 3) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[0][1] - 2 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 2] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											rotationFlag = false;
									}
								} else {
									if (activeBlock[3][0] - 2 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[3][0] - 2][activeBlock[3][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[3][0] - 1][activeBlock[3][1]] != 0)
											rotationFlag = false;
									}
								}
							} else if (curBlockShape == 4) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[0][1] + 2 >= 10)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] + 2] != 0)
											rotationFlag = false;
									}
								} else {
									if (activeBlock[2][0] - 2 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[2][0] - 2][activeBlock[2][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0] - 1][activeBlock[2][1]] != 0)
											rotationFlag = false;
									}
								}
							} else if (curBlockShape == 5) {
								if (curBlockDir == 1) {
									if (activeBlock[2][0] + 1 >= 20)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											rotationFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[1][1] - 1 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											rotationFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[1][0] - 1 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[1][0] - 1][activeBlock[1][1]] != 0)
											rotationFlag = false;
									}
								} else {
									if (activeBlock[2][1] + 1 >= 10)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											rotationFlag = false;
									}
								}
							} else if (curBlockShape == 6) {
								if (curBlockDir == 1) {
									if (activeBlock[2][1] + 1 >= 10)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											rotationFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[2][0] + 1 >= 20)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[2][0] - 1][activeBlock[2][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											rotationFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[1][1] - 1 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											rotationFlag = false;
									}
								} else {
									if (activeBlock[1][0] - 1 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[0][0] - 1][activeBlock[0][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[1][0] - 1][activeBlock[1][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											rotationFlag = false;
									}
								}
							} else {
								if (curBlockDir == 1) {
									if (activeBlock[2][1] - 1 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] - 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0]][activeBlock[2][1] + 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[3][0]][activeBlock[3][1] + 1] != 0)
											rotationFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[1][0] - 1 < 0)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[1][0] - 1][activeBlock[1][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
											rotationFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[1][1] + 1 >= 10)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[0][0]][activeBlock[0][1] - 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] - 1] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[1][0]][activeBlock[1][1] + 1] != 0)
											rotationFlag = false;
									}
								} else {
									if (activeBlock[2][0] + 1 >= 20)
										rotationFlag = false;
									else {
										if (blockStat[activeBlock[2][0] - 1][activeBlock[2][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											rotationFlag = false;
										if (blockStat[activeBlock[3][0] - 1][activeBlock[3][1]] != 0)
											rotationFlag = false;
									}
								}
							}
							if (rotationFlag) {
								if (curBlockShape == 2) {
									if (curBlockDir == 1 || curBlockDir == 3) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[1][0];
										activeBlock[0][1] = temp_activeBlock[1][1] - 2;
										activeBlock[1][0] = temp_activeBlock[1][0];
										activeBlock[1][1] = temp_activeBlock[1][1] - 1;
										activeBlock[2][0] = temp_activeBlock[1][0];
										activeBlock[2][1] = temp_activeBlock[1][1];
										activeBlock[3][0] = temp_activeBlock[1][0];
										activeBlock[3][1] = temp_activeBlock[1][1] + 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[2][0] - 1;
										activeBlock[0][1] = temp_activeBlock[2][1];
										activeBlock[1][0] = temp_activeBlock[2][0];
										activeBlock[1][1] = temp_activeBlock[2][1];
										activeBlock[2][0] = temp_activeBlock[2][0] + 1;
										activeBlock[2][1] = temp_activeBlock[2][1];
										activeBlock[3][0] = temp_activeBlock[2][0] + 2;
										activeBlock[3][1] = temp_activeBlock[2][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									}
								} else if (curBlockShape == 3) {
									if (curBlockDir == 1 || curBlockDir == 3) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[0][0];
										activeBlock[0][1] = temp_activeBlock[0][1] - 2;
										activeBlock[1][0] = temp_activeBlock[0][0];
										activeBlock[1][1] = temp_activeBlock[0][1] - 1;
										activeBlock[2][0] = temp_activeBlock[2][0];
										activeBlock[2][1] = temp_activeBlock[2][1];
										activeBlock[3][0] = temp_activeBlock[1][0];
										activeBlock[3][1] = temp_activeBlock[1][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[3][0] - 2;
										activeBlock[0][1] = temp_activeBlock[3][1];
										activeBlock[1][0] = temp_activeBlock[3][0] - 1;
										activeBlock[1][1] = temp_activeBlock[3][1];
										activeBlock[2][0] = temp_activeBlock[1][0];
										activeBlock[2][1] = temp_activeBlock[1][1];
										activeBlock[3][0] = temp_activeBlock[2][0];
										activeBlock[3][1] = temp_activeBlock[2][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									}
								} else if (curBlockShape == 4) {
									if (curBlockDir == 1 || curBlockDir == 3) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[0][0];
										activeBlock[0][1] = temp_activeBlock[0][1] + 1;
										activeBlock[1][0] = temp_activeBlock[0][0];
										activeBlock[1][1] = temp_activeBlock[0][1] + 2;
										activeBlock[2][0] = temp_activeBlock[1][0];
										activeBlock[2][1] = temp_activeBlock[1][1];
										activeBlock[3][0] = temp_activeBlock[2][0];
										activeBlock[3][1] = temp_activeBlock[2][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[2][0] - 2;
										activeBlock[0][1] = temp_activeBlock[2][1];
										activeBlock[1][0] = temp_activeBlock[2][0] - 1;
										activeBlock[1][1] = temp_activeBlock[2][1];
										activeBlock[2][0] = temp_activeBlock[0][0];
										activeBlock[2][1] = temp_activeBlock[0][1];
										activeBlock[3][0] = temp_activeBlock[3][0];
										activeBlock[3][1] = temp_activeBlock[3][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									}
								} else if (curBlockShape == 5) {
									if (curBlockDir == 1) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[0][0];
										activeBlock[0][1] = temp_activeBlock[0][1];
										activeBlock[1][0] = temp_activeBlock[2][0];
										activeBlock[1][1] = temp_activeBlock[2][1];
										activeBlock[2][0] = temp_activeBlock[3][0];
										activeBlock[2][1] = temp_activeBlock[3][1];
										activeBlock[3][0] = temp_activeBlock[2][0] + 1;
										activeBlock[3][1] = temp_activeBlock[2][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else if (curBlockDir == 2) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[1][0];
										activeBlock[0][1] = temp_activeBlock[1][1] - 1;
										activeBlock[1][0] = temp_activeBlock[1][0];
										activeBlock[1][1] = temp_activeBlock[1][1];
										activeBlock[2][0] = temp_activeBlock[2][0];
										activeBlock[2][1] = temp_activeBlock[2][1];
										activeBlock[3][0] = temp_activeBlock[3][0];
										activeBlock[3][1] = temp_activeBlock[3][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else if (curBlockDir == 3) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[1][0] - 1;
										activeBlock[0][1] = temp_activeBlock[1][1];
										activeBlock[1][0] = temp_activeBlock[0][0];
										activeBlock[1][1] = temp_activeBlock[0][1];
										activeBlock[2][0] = temp_activeBlock[1][0];
										activeBlock[2][1] = temp_activeBlock[1][1];
										activeBlock[3][0] = temp_activeBlock[3][0];
										activeBlock[3][1] = temp_activeBlock[3][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[0][0];
										activeBlock[0][1] = temp_activeBlock[0][1];
										activeBlock[1][0] = temp_activeBlock[1][0];
										activeBlock[1][1] = temp_activeBlock[1][1];
										activeBlock[2][0] = temp_activeBlock[2][0];
										activeBlock[2][1] = temp_activeBlock[2][1];
										activeBlock[3][0] = temp_activeBlock[2][0];
										activeBlock[3][1] = temp_activeBlock[2][1] + 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									}
								} else if (curBlockShape == 6) {
									if (curBlockDir == 1) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[1][0];
										activeBlock[0][1] = temp_activeBlock[1][1] + 1;
										activeBlock[1][0] = temp_activeBlock[2][0];
										activeBlock[1][1] = temp_activeBlock[2][1] - 1;
										activeBlock[2][0] = temp_activeBlock[2][0];
										activeBlock[2][1] = temp_activeBlock[2][1];
										activeBlock[3][0] = temp_activeBlock[2][0];
										activeBlock[3][1] = temp_activeBlock[2][1] + 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else if (curBlockDir == 2) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[2][0] - 1;
										activeBlock[0][1] = temp_activeBlock[2][1];
										activeBlock[1][0] = temp_activeBlock[2][0];
										activeBlock[1][1] = temp_activeBlock[2][1];
										activeBlock[2][0] = temp_activeBlock[2][0] + 1;
										activeBlock[2][1] = temp_activeBlock[2][1];
										activeBlock[3][0] = temp_activeBlock[3][0] + 1;
										activeBlock[3][1] = temp_activeBlock[3][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else if (curBlockDir == 3) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[1][0];
										activeBlock[0][1] = temp_activeBlock[1][1] - 1;
										activeBlock[1][0] = temp_activeBlock[1][0];
										activeBlock[1][1] = temp_activeBlock[1][1];
										activeBlock[2][0] = temp_activeBlock[1][0];
										activeBlock[2][1] = temp_activeBlock[1][1] + 1;
										activeBlock[3][0] = temp_activeBlock[2][0];
										activeBlock[3][1] = temp_activeBlock[2][1] - 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[0][0] - 1;
										activeBlock[0][1] = temp_activeBlock[0][1];
										activeBlock[1][0] = temp_activeBlock[1][0] - 1;
										activeBlock[1][1] = temp_activeBlock[1][1];
										activeBlock[2][0] = temp_activeBlock[1][0];
										activeBlock[2][1] = temp_activeBlock[1][1];
										activeBlock[3][0] = temp_activeBlock[1][0] + 1;
										activeBlock[3][1] = temp_activeBlock[1][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									}
								} else {
									if (curBlockDir == 1) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[2][0];
										activeBlock[0][1] = temp_activeBlock[2][1] - 1;
										activeBlock[1][0] = temp_activeBlock[2][0];
										activeBlock[1][1] = temp_activeBlock[2][1];
										activeBlock[2][0] = temp_activeBlock[2][0];
										activeBlock[2][1] = temp_activeBlock[2][1] + 1;
										activeBlock[3][0] = temp_activeBlock[3][0];
										activeBlock[3][1] = temp_activeBlock[3][1] + 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else if (curBlockDir == 2) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[1][0] - 1;
										activeBlock[0][1] = temp_activeBlock[1][1];
										activeBlock[1][0] = temp_activeBlock[1][0];
										activeBlock[1][1] = temp_activeBlock[1][1];
										activeBlock[2][0] = temp_activeBlock[3][0];
										activeBlock[2][1] = temp_activeBlock[3][1] - 2;
										activeBlock[3][0] = temp_activeBlock[3][0];
										activeBlock[3][1] = temp_activeBlock[3][1] - 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else if (curBlockDir == 3) {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[0][0];
										activeBlock[0][1] = temp_activeBlock[0][1] - 1;
										activeBlock[1][0] = temp_activeBlock[1][0];
										activeBlock[1][1] = temp_activeBlock[1][1] - 1;
										activeBlock[2][0] = temp_activeBlock[1][0];
										activeBlock[2][1] = temp_activeBlock[1][1];
										activeBlock[3][0] = temp_activeBlock[1][0];
										activeBlock[3][1] = temp_activeBlock[1][1] + 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									} else {
										curBlockDir++;
										if (curBlockDir == 5)
											curBlockDir = 1;
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
										}
										int temp_activeBlock[][] = new int[4][2];
										for (int ii = 0; ii < 4; ii++) {
											for (int jj = 0; jj < 2; jj++) {
												temp_activeBlock[ii][jj] = activeBlock[ii][jj];
											}
										}
										activeBlock[0][0] = temp_activeBlock[0][0];
										activeBlock[0][1] = temp_activeBlock[0][1] + 1;
										activeBlock[1][0] = temp_activeBlock[0][0];
										activeBlock[1][1] = temp_activeBlock[0][1] + 2;
										activeBlock[2][0] = temp_activeBlock[2][0];
										activeBlock[2][1] = temp_activeBlock[2][1];
										activeBlock[3][0] = temp_activeBlock[2][0] + 1;
										activeBlock[3][1] = temp_activeBlock[2][1];
										for (int ii = 0; ii < 4; ii++) {
											btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
											blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
										}
									}
								}
							}
						} else if (e.getKeyCode() == 40) {

							boolean moveFlag = true;
							if (curBlockShape == 1) {
								if (activeBlock[2][0] + 1 >= 20)
									moveFlag = false;
								else {
									if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
										moveFlag = false;
									if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
										moveFlag = false;
								}
							} else if (curBlockShape == 2) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[0][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 3) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[2][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 4) {
								if (curBlockDir == 1 || curBlockDir == 3) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[2][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 5) {
								if (curBlockDir == 1) {
									if (activeBlock[1][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								}
							} else if (curBlockShape == 6) {
								if (curBlockDir == 1) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[2][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								}
							} else {
								if (curBlockDir == 1) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 2) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[0][0] + 1][activeBlock[0][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else if (curBlockDir == 3) {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								} else {
									if (activeBlock[3][0] + 1 >= 20)
										moveFlag = false;
									else {
										if (blockStat[activeBlock[1][0] + 1][activeBlock[1][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[2][0] + 1][activeBlock[2][1]] != 0)
											moveFlag = false;
										if (blockStat[activeBlock[3][0] + 1][activeBlock[3][1]] != 0)
											moveFlag = false;
									}
								}
							}
							if (moveFlag) {
								for (int ii = 0; ii < 4; ii++) {
									btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(null);
									blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 0;
								}
								for (int ii = 0; ii < 4; ii++) {
									activeBlock[ii][0]++;
								}
								for (int ii = 0; ii < 4; ii++) {
									btn[activeBlock[ii][0]][activeBlock[ii][1]].setBackground(Color.BLACK);
									blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 1;
								}
							} else {
								for (int ii = 0; ii < 4; ii++) {
									blockStat[activeBlock[ii][0]][activeBlock[ii][1]] = 2;
								}
								boolean lineDelete = true;
								while (lineDelete) {
									lineDelete = false;
									for (int ii = 19; ii >= 0; ii--) {
										boolean lineFull = true;
										for (int jj = 0; jj < 10; jj++) {
											if (blockStat[ii][jj] == 0) {
												lineFull = false;
												break;
											}
										}
										if (lineFull) {
											lineDelete = true;
											for (int k = ii - 1; k >= 0; k--) {
												for (int l = 0; l < 10; l++) {
													btn[k + 1][l].setBackground(btn[k][l].getBackground());
													blockStat[k + 1][l] = blockStat[k][l];
												}
											}
										}
									}
								}

								active = false;
							}
						}
						else if (e.getKeyCode() == 83) {
							if (!dead) {
								try (FileWriter fr = new FileWriter("C:\\WorkSpace\\tetris.txt");) {
									for (int ii = 0; ii < 20; ii++) {
										for (int jj = 0; jj < 10; jj++) {
											fr.write(Character.forDigit(blockStat[ii][jj], 3));
										}
									}
								} catch (IOException ee) {
									
								}
							}
						}
						else if (e.getKeyCode() == 76) {
							try (FileReader fr = new FileReader("C:\\WorkSpace\\tetris.txt");) {
								int c;
								for (int ii = 0; ii < 20; ii++) {
									for (int jj = 0; jj < 10; jj++) {
										c = fr.read();
										if ((c- 48) == 2) {
											blockStat[ii][jj] = 2;
										}
										else {
											blockStat[ii][jj] = 0;
										}
									}
								}
								for (int ii = 0; ii < 20; ii++) {
									for (int jj = 0; jj < 10; jj++) {
										if (blockStat[ii][jj] == 2) {
											btn[ii][jj].setBackground(Color.BLACK);
										}
										else {
											btn[ii][jj].setBackground(null);
										}
									}
								}
								dead = false;
								active = false;
							} catch (IOException ee) {
							}
						}
					}
				});
				mainPanel.add(b);
			}
		}
		add(mainPanel);
		setSize(300, 600);
		setResizable(false);
		setVisible(true);
		
		Thread t = new Thread(new Down());
		t.setDaemon(true);
		t.start();

		dead = false;
		while (!dead) {
			Tetromino tet = new Tetromino();
			int tetShape = tet.getBlockShape();
			int tetDir = tet.getBlockDir();
			if (active)
				continue;
			active = true;
			curBlockShape = tetShape;
			curBlockDir = tetDir;
			switch (tetShape) {
			case 1:
				activeBlock[0][0] = 0;
				activeBlock[0][1] = 4;
				activeBlock[1][0] = 0;
				activeBlock[1][1] = 5;
				activeBlock[2][0] = 1;
				activeBlock[2][1] = 4;
				activeBlock[3][0] = 1;
				activeBlock[3][1] = 5;
				break;
			case 2: {
				switch (tetDir) {
				case 1:
				case 3:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 2;
					activeBlock[2][1] = 4;
					activeBlock[3][0] = 3;
					activeBlock[3][1] = 4;
					break;
				case 2:
				case 4:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 3;
					activeBlock[1][0] = 0;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 0;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 0;
					activeBlock[3][1] = 6;
				}
				break;
			}
			case 3: {
				switch (tetDir) {
				case 1:
				case 3:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 5;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 5;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 4;
					activeBlock[3][0] = 2;
					activeBlock[3][1] = 4;
					break;
				case 2:
				case 4:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 0;
					activeBlock[1][1] = 5;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 1;
					activeBlock[3][1] = 6;
				}
				break;
			}
			case 4: {
				switch (tetDir) {
				case 1:
				case 3:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 2;
					activeBlock[3][1] = 5;
					break;
				case 2:
				case 4:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 5;
					activeBlock[1][0] = 0;
					activeBlock[1][1] = 6;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 4;
					activeBlock[3][0] = 1;
					activeBlock[3][1] = 5;
				}
				break;
			}
			case 5: {
				switch (tetDir) {
				case 1:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 5;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 1;
					activeBlock[3][1] = 6;
					break;
				case 2:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 2;
					activeBlock[3][1] = 4;
					break;
				case 3:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 0;
					activeBlock[1][1] = 5;
					activeBlock[2][0] = 0;
					activeBlock[2][1] = 6;
					activeBlock[3][0] = 1;
					activeBlock[3][1] = 5;
					break;
				case 4:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 5;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 2;
					activeBlock[3][1] = 5;
				}
				break;
			}
			case 6: {
				switch (tetDir) {
				case 1:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 0;
					activeBlock[1][1] = 5;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 2;
					activeBlock[3][1] = 5;
					break;
				case 2:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 6;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 1;
					activeBlock[3][1] = 6;
					break;
				case 3:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 2;
					activeBlock[2][1] = 4;
					activeBlock[3][0] = 2;
					activeBlock[3][1] = 5;
					break;
				case 4:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 0;
					activeBlock[1][1] = 5;
					activeBlock[2][0] = 0;
					activeBlock[2][1] = 6;
					activeBlock[3][0] = 1;
					activeBlock[3][1] = 4;
				}
				break;
			}
			case 7: {
				switch (tetDir) {
				case 1:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 0;
					activeBlock[1][1] = 5;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 4;
					activeBlock[3][0] = 2;
					activeBlock[3][1] = 4;
					break;
				case 2:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 0;
					activeBlock[1][1] = 5;
					activeBlock[2][0] = 0;
					activeBlock[2][1] = 6;
					activeBlock[3][0] = 1;
					activeBlock[3][1] = 6;
					break;
				case 3:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 5;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 5;
					activeBlock[2][0] = 2;
					activeBlock[2][1] = 4;
					activeBlock[3][0] = 2;
					activeBlock[3][1] = 5;
					break;
				case 4:
					activeBlock[0][0] = 0;
					activeBlock[0][1] = 4;
					activeBlock[1][0] = 1;
					activeBlock[1][1] = 4;
					activeBlock[2][0] = 1;
					activeBlock[2][1] = 5;
					activeBlock[3][0] = 1;
					activeBlock[3][1] = 6;
				}
				break;
			}
			}
			for (int i = 0; i < 4; i++) {
				if (blockStat[activeBlock[i][0]][activeBlock[i][1]] != 0) {
					JOptionPane.showMessageDialog(null, "Game Over");
					dead = true;
					break;
				}
				btn[activeBlock[i][0]][activeBlock[i][1]].setBackground(Color.BLACK);
				blockStat[activeBlock[i][0]][activeBlock[i][1]] = 1;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TetrisDemo();
	}

}