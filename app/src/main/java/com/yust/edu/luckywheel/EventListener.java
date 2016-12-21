package com.yust.edu.luckywheel;

import android.os.Bundle;

/**
 * 常规事件监听器接口
 */
public interface EventListener {
	public abstract void OnEvent(Object sender, Bundle args);
}
