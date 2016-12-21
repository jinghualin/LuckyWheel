package com.yust.edu.luckywheel;

import java.util.Date;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.GestureDetector.OnGestureListener;

/**
 * 轮盘的Activity
 * 
 * @author lin
 * 
 */
public class Wheel extends SurfaceView implements SurfaceHolder.Callback {

	/**
	 * 转盘转动时的阻力
	 */
	private static final float resistance = 15f;

	/**
	 * 下滑手势监听器对象
	 */
	private DownGestureDetector downGestureDetector = new DownGestureDetector();
	private GestureDetector gestureDetector = new GestureDetector(
			downGestureDetector);

	/**
	 * 背景图
	 */
	private Bitmap backgroundImage = null;

	/**
	 * 转盘图
	 */
	private Bitmap wheelImage = null;

	/**
	 * 转盘背景图
	 */
	private Bitmap wheelBackground = null;

	/**
	 * 指针图
	 */
	private Bitmap pointer = null;

	/**
	 * 转盘旋转力度
	 */
	private float velocity = 0;

	/**
	 * 转盘旋转状态
	 */
	private RotateState rotateState = RotateState.Stop;

	/**
	 * 屏幕宽度
	 */
	private int screenWidth;
	/**
	 * 屏幕高度
	 */
	private int screenHeight;
	/**
	 * 圆心坐标
	 */
	private Coordinate center = new Coordinate();
	/**
	 * 转盘位置相对于左上角的偏移量
	 */
	private Coordinate offset = new Coordinate();

	/**
	 * 初始值为0。 功能注释：当前转盘旋转角度
	 */
	private float rotateAngle = 0;

	/**
	 * 获取rotateAngle。 功能注释：当前转盘旋转角度
	 * 
	 * @return 当前的float类型的值
	 */
	public float getRotateAngle() {
		return rotateAngle;
	}

	/**
	 * 设置rotateAngle。 功能注释：当前转盘旋转角度
	 * 
	 * @param value
	 *            要设置的float类型值
	 */
	public void setRotateAngle(float value) {
		rotateAngle = value;
	}

	/**
	 * 设置rotateAngle为其默认值(0)。 功能注释：当前转盘旋转角度
	 */
	public void setRotateAngleToDefault() {
		rotateAngle = 0;
	}

	/**
	 * 初始值为0。 功能注释：转盘内项目（分割的扇形）数
	 */
	private int wheelItemCount = 0;

	/**
	 * 获取wheelItemCount。 功能注释：转盘内项目（分割的扇形）数
	 * 
	 * @return 当前的int类型的值
	 */
	public int getWheelItemCount() {
		return wheelItemCount;
	}

	/**
	 * 设置wheelItemCount。 功能注释：转盘内项目（分割的扇形）数
	 * 
	 * @param value
	 *            要设置的int类型值
	 */
	public void setWheelItemCount(int value) {
		wheelItemCount = value;
		loadWheelImage();
	}

	/**
	 * 设置WheelItemCount为其默认值(0)。 功能注释：转盘内项目（分割的扇形）数
	 */
	public void setWheelItemCountToDefault() {
		wheelItemCount = 0;
	}

	/**
	 * 初始值为null。 功能注释：振动控制器
	 */
	private Vibrator vibrator = null;

	/**
	 * 获取vibrator。 功能注释：振动控制器
	 * 
	 * @return 当前的vibrator类型的值
	 */
	public Vibrator getVibrator() {
		return vibrator;
	}

	/**
	 * 设置vibrator。 功能注释：振动控制器
	 * 
	 * @param value
	 *            要设置的vibrator类型值
	 */
	public void setVibrator(Vibrator value) {
		vibrator = value;
	}

	/**
	 * 设置Vibrator为其默认值(null)。 功能注释：振动控制器
	 */
	public void setVibratorToDefault() {
		vibrator = null;
	}

	/**
	 * 初始值为null。 功能注释：开始旋转时的事件监听器
	 */
	private EventListener onBeginRotationListener = null;

	/**
	 * 获取onBeginRotationListener。 功能注释：开始旋转时的事件监听器
	 * 
	 * @return 当前的EventListener类型的值
	 */
	public EventListener getOnBeginRotationListener() {
		return onBeginRotationListener;
	}

	/**
	 * 设置onBeginRotationListener。 功能注释：开始旋转时的事件监听器
	 * 
	 * @param value
	 *            要设置的EventListener类型值
	 */
	public void setOnBeginRotationListener(EventListener value) {
		onBeginRotationListener = value;
	}

	/**
	 * 设置onBeginRotationListener为其默认值(null)。 功能注释：开始旋转时的事件监听器
	 */
	public void setOnBeginRotationListenerToDefault() {
		onBeginRotationListener = null;
	}

	/**
	 * 初始值为null。 功能注释：停止旋转时的事件监听器
	 */
	private EventListener onStopRotationListener = null;

	/**
	 * 获取onStopRotationListener。 功能注释：停止旋转时的事件监听器
	 * 
	 * @return 当前的EventListener类型的值
	 */
	public EventListener getOnStopRotationListener() {
		return onStopRotationListener;
	}

	/**
	 * 设置onStopRotationListener。 功能注释：停止旋转时的事件监听器
	 * 
	 * @param value
	 *            要设置的EventListener类型值
	 */
	public void setOnStopRotationListener(EventListener value) {
		onStopRotationListener = value;
	}

	/**
	 * 设置onStopRotationListener为其默认值(null)。 功能注释：停止旋转时的事件监听器
	 */
	public void setOnStopRotationListenerToDefault() {
		onStopRotationListener = null;
	}

	/**
	 * 初始值为null。 功能注释：因缺少条件而不能启动转盘事件
	 */
	private EventListener onCantRunListener = null;

	/**
	 * 获取 onCantRunListener。 功能注释：因缺少条件而不能启动转盘事件
	 * 
	 * @return 当前的EventListener类型的值
	 */
	public EventListener getOnCantRunListener() {
		return onCantRunListener;
	}

	/**
	 * 设置 onCantRunListener。 功能注释：因缺少条件而不能启动转盘事件
	 * 
	 * @param value
	 *            要设置的EventListener类型值
	 */
	public void setOnCantRunListener(EventListener value) {
		onCantRunListener = value;
	}

	/**
	 * 设置onCantRunListener为其默认值(null)。 功能注释：因缺少条件而不能启动转盘事件
	 */
	public void setOnCantRunListenerToDefault() {
		onCantRunListener = null;
	}

	SurfaceHolder holder;

	MainThread thread;

	Handler handler;

	public Wheel(Context context, AttributeSet attrs) {
		super(context, attrs);
		/* 获取手机分辨率 */
		DisplayMetrics d = context.getApplicationContext().getResources()
				.getDisplayMetrics();
		screenWidth = d.widthPixels;
		screenHeight = d.heightPixels;

		loadWheelImage();
		int xo = screenWidth / 2 - wheelImage.getWidth() / 2;
		int yo = (int) ((screenHeight - 100.0f / 320 * screenHeight) / 2 - wheelImage
				.getHeight() / 2);
		offset.setCoordinate(xo, yo);
		backgroundImage = BitmapFactory.decodeResource(getResources(),
				R.drawable.bg);
		wheelBackground = BitmapFactory.decodeResource(getResources(),
				R.drawable.wbg);
		pointer = BitmapFactory.decodeResource(getResources(),
				R.drawable.pointer);

		holder = this.getHolder();// 获取holder
		holder.addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				onStopRotation();
				super.handleMessage(msg);
			}
		};
		thread = new MainThread();
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		thread.setRunning(false);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

	/**
	 * 开始旋转事件函数
	 */
	void onBeginRotation() {
		if (onBeginRotationListener != null)
			onBeginRotationListener.OnEvent(this, null);
	}

	/**
	 * 停止旋转事件函数
	 */
	void onStopRotation() {
		if (onStopRotationListener != null)
			onStopRotationListener.OnEvent(this, null);
	}

	/**
	 * 因缺少条件而不能启动转盘事件
	 */
	private void onCantRun() {
		if (onCantRunListener != null)
			onCantRunListener.OnEvent(this, null);
	}

	/**
	 * 根据转盘类型加载对应的转盘图片
	 */
	private void loadWheelImage() {
		switch (wheelItemCount) {
		case 1:
			wheelImage = BitmapFactory.decodeResource(getResources(),
					R.drawable.wheel1);
			break;
		case 2:
			wheelImage = BitmapFactory.decodeResource(getResources(),
					R.drawable.wheel2);
			break;
		case 3:
			wheelImage = BitmapFactory.decodeResource(getResources(),
					R.drawable.wheel3);
			break;
		case 4:
			wheelImage = BitmapFactory.decodeResource(getResources(),
					R.drawable.wheel4);
			break;
		case 5:
			wheelImage = BitmapFactory.decodeResource(getResources(),
					R.drawable.wheel5);
			break;
		case 6:
			wheelImage = BitmapFactory.decodeResource(getResources(),
					R.drawable.wheel6);
			break;
		default:
			wheelImage = BitmapFactory.decodeResource(getResources(),
					R.drawable.wheel0);
		}
		center.setCoordinate(offset.X + wheelImage.getWidth() / 2.00f, offset.Y
				+ wheelImage.getHeight() / 2.00f);
	}

	/**
	 * 侦测向下滑动手势的监听器
	 */
	class DownGestureDetector implements OnGestureListener {

		/**
		 * 最短滑动距离
		 */
		private static final int SWIPE_MIN_DISTANCE = 120;
		/**
		 * 最低滑动速度
		 */
		private static final int SWIPE_THRESHOLD_VELOCITY = 200;

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (wheelItemCount > 1) {
				Coordinate c1 = new Coordinate((int) e1.getX(), (int) e1.getY());
				Coordinate c2 = new Coordinate((int) e2.getX(), (int) e2.getY());
				float v = Math.abs(velocityX) + Math.abs(velocityY);
				if (c1.calculateDistance(c2) > SWIPE_MIN_DISTANCE
						&& v > SWIPE_THRESHOLD_VELOCITY) {
					double a1 = c1.calculateAngle(center);
					double a2 = c2.calculateAngle(center);
					velocity = v;
					boolean b = false;
					if (a1 >= 0) {
						b = a1 - a2 < 180 ? true : false;
						if (a1 < a2)
							b = !b;
					} else {
						b = a1 - a2 < -180 ? true : false;
						if (a1 > a2)
							b = !b;
					}
					rotateState = b ? RotateState.Clockwise
							: RotateState.Counterclockwise;
					onBeginRotation();
				}
			} else {
				onCantRun();
			}
			return true;
		}

		@Override
		public boolean onDown(MotionEvent e) {
			return true;
		}

		@Override
		public void onLongPress(MotionEvent e) {
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			return true;
		}

		@Override
		public void onShowPress(MotionEvent e) {
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			return true;
		}
	}

	/**
	 * 绘图线程类
	 */
	class MainThread extends Thread {

		/**
		 * 初始值为false。 功能注释：指示线程是否应正常运行
		 */
		private boolean running = false;

		/**
		 * 获取running。 功能注释：指示线程是否应正常运行
		 * 
		 * @return 当前的boolean类型的值
		 */
		public boolean getRunning() {
			return running;
		}

		/**
		 * 设置running。 功能注释：指示线程是否应正常运行
		 * 
		 * @param value
		 *            要设置的boolean类型值
		 */
		public void setRunning(boolean value) {
			running = value;
		}

		/**
		 * 设置running为其默认值(false)。 功能注释：指示线程是否应正常运行
		 */
		public void setRunningToDefault() {
			running = false;
		}

		@Override
		public void run() {
			Canvas canvas = null;
			Matrix m = null;
			// 设置Paint对象，两倍抗锯齿
			Paint mPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
			Date d = null;
			Date vd = new Date();
			float lastRotate = 0;
			while (running) {
				d = new Date();
				m = new Matrix();
				if (rotateState != RotateState.Stop) {
					rotateAngle = (rotateAngle + (rotateState == RotateState.Clockwise ? velocity
							: 0 - velocity) / 4000 * 96) % 360;
					// 如果旋转力度小于助力，则停止旋转
					if (Math.abs(velocity) < resistance) {
						rotateState = RotateState.Stop;
						handler.sendEmptyMessage(0);
					}
					// 震动
					// 最小时间间隔为300毫秒，当此时经过取余的角度小于上次的值且当前旋转方向为顺时针时触发，逆时针触发条件与顺时针相反
					if (new Date().getTime() - vd.getTime() > 300
							&& (rotateAngle % (360 / wheelItemCount) < lastRotate) != (rotateState == RotateState.Counterclockwise)) {
						vibrator.vibrate((long) (20 - (15 * velocity / 4000)));
						vd = new Date();
					}
					lastRotate = rotateAngle % (360 / wheelItemCount);
					velocity -= resistance;
				}

				// 把新的Matrix图 移到 中心位置
				m.postTranslate(offset.X, offset.Y);

				// 旋转Matrix图， 旋转轮盘
				m.postRotate(wheelItemCount > 1 ? rotateAngle : 0, center.X,
						center.Y);

				try {
					synchronized (holder) {

						canvas = holder.lockCanvas(new Rect((int) offset.X,
								(int) offset.Y, (int) offset.X
										+ wheelImage.getWidth(), (int) offset.Y
										+ wheelImage.getHeight()));// 获取画布
						canvas.drawBitmap(backgroundImage, 0, 0, mPaint);
						canvas.drawBitmap(wheelBackground, center.X
								- wheelBackground.getWidth() / 2.00f, center.Y
								- wheelBackground.getHeight() / 2.00f, mPaint);
						canvas.drawBitmap(wheelImage, m, mPaint);
						if (wheelItemCount > 1)
							canvas.drawBitmap(
									pointer,
									center.X - pointer.getWidth() / 2.00f,
									center.Y - 154.00f / 221
											* pointer.getHeight(), mPaint);
						Thread.sleep(Math.max(0,
								33 - (new Date().getTime() - d.getTime())));
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					holder.unlockCanvasAndPost(canvas);// 解锁画布，提交画好的图像
				}
			}

		}
	}
}
