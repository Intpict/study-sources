package main.java.trans;

/**
 * 序列字，提供前向或者后向的序列字能力，并且可以指定每次累加的步长以及序列字最大，最小值。
 * 可以设置序列字是否以循环方式产生，在循环方式下最大值和最小值之间会产生直接跳转，因此设置
 * 最大值和最小值之间的间隔为一个步长。
 * 
 * @author tianfeng
 * 
 */
public class Sequence {
	/**
	 * 序列字当前值
	 */
	private int value;
	/**
	 * 序列字的初始值，sequence的第一个值是startValue + pace
	 */
	private int startValue;
	/**
	 * 序列字允许的最大值
	 */
	private final int maxValue;
	/**
	 * 序列字允许的最小值
	 */
	private final int minValue;
	/**
	 * 序列字是否可以循环分配
	 */
	private final boolean cycle;
	/**
	 * 序列字步长
	 */
	private final int pace;
	/**
	 * 序列字名字。 名字是在SequenceGenerator创建序列字时用来标识不同序列字的。 如果直接使用序列字，可以直接为null
	 */
	private final String name;

	/**
	 * 构造方法
	 * 
	 * @param name
	 * @param startValue
	 * @param minValue
	 * @param maxValue
	 * @param cycle
	 * @param pace
	 */
	public Sequence(String name, int startValue, int minValue, int maxValue,
			boolean cycle, int pace) {
		this.name = name;
		this.value = startValue;
		this.startValue = startValue;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.cycle = cycle;
		this.pace = pace;
	}

	/**
	 * 构造方法，只提供3个设置项，其它使用缺省值： minValue:Integer.MIN_VALUE
	 * maxValue:Integer.MAX_VALUE pace：1
	 * 
	 * @param name
	 * @param startValue
	 * @param cycle
	 */
	public Sequence(String name, int startValue, boolean cycle) {
		this(name, startValue, startValue, Integer.MAX_VALUE, cycle, 1);
	}

	public int getStartValue() {
		return startValue;
	}

	public boolean getCycle() {
		return cycle;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int getMinValue() {
		return minValue;
	}

	public String getName() {
		return name;
	}

	public int getPace() {
		return pace;
	}

	/**
	 * 获得当前序列字数值。 每次调用该方法序列字数值不会随之改变。
	 * 
	 * @return
	 */
	public synchronized int getCurrentValue() {
		return value;
	}

	/**
	 * 获得序列字的下一个数值。
	 * 
	 * @return
	 * @throws SequenceException
	 */
	public synchronized int getNextValue() {
		if (pace >= 0) {
			if (maxValue - value < pace) {
				// 越界
				if (cycle) {
					// 如果是循环方式的话，生成新的value
					value = minValue;
				} else {
					// 如果不是循环方式的话，抛出运行时异常
					throw new RuntimeException(name + " sequence out of range!");
				}
			} else {
				// 没有越界
				value = value + pace;
			}
		} else {
			if (minValue - value > pace) {
				// 越界
				if (cycle) {
					// 如果是循环方式的话，生成新的value
					value = maxValue;
				} else {
					// 如果不是循环方式的话，抛出运行时异常
					throw new RuntimeException(name + " sequence out of range!");
				}
			} else {
				value = value + pace;
			}
		}
		return value;
	}
}
