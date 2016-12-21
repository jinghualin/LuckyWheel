package com.yust.edu.luckywheel;


/**
 * 方位枚举
 */
public enum Direction {
	Left(1), Right(2), Top(4), Bottom(8), Center(0);

	private int Value;

	/**
	 * 构造函数
	 * @param value 实际值
	 */
	Direction(int value) {
		Value = value;
	}

	/**
	 * 将另一个方位组合到当前对象
	 * @param d Direction对象
	 * @return 当前对象
	 */
	public Direction combination(Direction d) {
		this.Value = this.Value | d.Value;
		return this;
	}

	/**
	 * 判断两个方位是否相同
	 * @param d Direction对象
	 * @return 判断结果
	 */
	public boolean isSame(Direction d) {
		return this.Value == d.Value;
	}

	/**
	 * 判断当前方位中是否包含目标方位的全部或一部分
	 * @param d Direction对象
	 * @return 判断结果
	 */
	public boolean isContain(Direction d) {
		return (this.Value & d.Value) > 0;
	}
	
	/**
	 * 将当前对象设置为与目标方位之间的交集
	 * @param d Direction对象
	 * @return 当前对象
	 */
	public Direction intersection(Direction d)
	{
		this.Value = this.Value & d.Value;
		return this;
	}
}
