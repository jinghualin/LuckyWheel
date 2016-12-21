package com.yust.edu.luckywheel;


/**
 * 表示二维坐标
 */
public class Coordinate {
	public float X, Y;

	public Coordinate() {

	}

	public Coordinate(float x, float y) {
		setCoordinate(x, y);
	}

	/**
	 * 设置X、Y的值
	 * 
	 * @param x
	 *            X坐标值
	 * @param y
	 *            Y坐标值
	 * @return 此对象
	 */
	public Coordinate setCoordinate(float x, float y) {
		X = x;
		Y = y;
		return this;
	}

	/**
	 * 计算当前坐标与传入坐标的距离，该值始终为正数
	 * 
	 * @param x
	 *            目标坐标的x值
	 * @param y
	 *            目标坐标的y值
	 * @return 两个坐标间的直线距离
	 */
	public float calculateDistance(float x, float y) {
		return Math.abs(X - x) + Math.abs(Y - y);
	}

	/**
	 * 计算当前坐标与传入坐标的距离，该值始终为正数
	 * 
	 * @param c
	 *            目标坐标对象
	 * @return 两个坐标间的直线距离
	 */
	public float calculateDistance(Coordinate c) {
		return calculateDistance(c.X, c.Y);
	}

	/**
	 * 计算目标坐标相对于当前坐标的方位
	 * 
	 * @param x
	 *            目标坐标的x值
	 * @param y
	 *            目标坐标的y值
	 * @return 目标坐标相对于当前坐标的方位
	 */
	public Direction calculateDirection(float x, float y) {
		Direction xd, yd;
		if (X == x)
			xd = Direction.Center;
		else
			xd = X > x ? Direction.Left : Direction.Right;
		if (Y == y)
			yd = Direction.Center;
		else
			yd = Y > y ? Direction.Top : Direction.Bottom;
		return xd.combination(yd);
	}

	/**
	 * 计算目标坐标相对于当前坐标的方位
	 * 
	 * @param c
	 *            目标坐标对象
	 * @return 目标坐标相对于当前坐标的方位
	 */
	public Direction calculateDirection(Coordinate c) {
		return calculateDirection(c.X, c.Y);
	}

	/**
	 * 计算相对于目标坐标的角度
	 * 
	 * @param x
	 *            目标坐标的x值
	 * @param y
	 *            目标坐标的y值
	 * @return 相对于目标坐标的角度
	 */
	public double calculateAngle(float x, float y) {
		return Math.atan2(X - x, Y - y) * 180 / Math.PI;
	}

	/**
	 * 计算相对于目标坐标的角度
	 * 
	 * @param c
	 *            目标坐标对象
	 * @return 相对于目标坐标的角度
	 */
	public double calculateAngle(Coordinate c) {
		return calculateAngle(c.X, c.Y);
	}
}
