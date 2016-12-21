package com.yust.edu.luckywheel;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * 主界面
 * 
 * @author lin
 * 
 */
public class Main extends Activity {

	/**
	 * 获取设置菜单按钮
	 */
	public Button getWheelConfigButton() {
		if (this.wheelConfigButton == null)
			this.wheelConfigButton = (Button) findViewById(R.id.WheelConfig);
		return wheelConfigButton;
	}

	private Button wheelConfigButton = null;

	/**
	 * 获取轮盘
	 */
	public Wheel getWheel() {
		if (wheel == null)
			wheel = (Wheel) this.findViewById(R.id.Wheel);
		return wheel;
	}

	private Wheel wheel = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config);
		setContentView(R.layout.main);
		getWheel().setVibrator((Vibrator) getSystemService(VIBRATOR_SERVICE));
		getWheelConfigButton().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(Main.this, Config.class);
				Main.this.startActivity(intent);
			}
		});
		getWheel().setOnBeginRotationListener(new EventListener() {

			@Override
			public void OnEvent(Object sender, Bundle args) {
				getWheelConfigButton().setEnabled(false);
			}
		});
		getWheel().setOnStopRotationListener(new EventListener() {

			@Override
			public void OnEvent(Object sender, Bundle args) {
				getWheelConfigButton().setEnabled(true);
				ArrayList<String> li = DataStore.readWheelItemsData(Main.this);

				new AlertDialog.Builder(Main.this)
						.setTitle(
								getResources().getString(
										R.string.yourChoiceShouldBe))
						.setMessage(
								li.get(Main.this.calculateResultIndex(
										getWheel().getRotateAngle(), li.size())))
						.setPositiveButton(
								getResources().getString(R.string.ok), null)
						.show();

			}
		});
		getWheel().setOnCantRunListener(new EventListener() {

			@Override
			public void OnEvent(Object sender, Bundle args) {
				showCantRunTip();
			}
		});
	}

	/**
	 * 计算返回的结果转盘项索引
	 * 
	 * @param rotate
	 *            转盘角度
	 * @param count
	 *            转盘项总数
	 * @return 结果项索引
	 */
	private int calculateResultIndex(float rotate, int count) {
		int x = 360 / count;
		float r = rotate >= 0 ? rotate : 360 + rotate;
		for (int i = 0; i < count; i++) {
			if (i * x + r >= 360 - x)
				return i;
		}
		return -1;
	}

	@Override
	protected void onResume() {
		super.onResume();
		ArrayList<String> li = DataStore.readWheelItemsData(this);

		wheel.setWheelItemCount(li.size());
		if (li.size() < 2) {
			showCantRunTip();
		} else {
			Toast.makeText(this, getResources().getString(R.string.touchTip),
					Toast.LENGTH_LONG).show();
		}

	}

	/**
	 * 缺乏转动条件时提示
	 */
	private void showCantRunTip() {
		Toast.makeText(this,
				getResources().getString(R.string.needMoreItemsTip),
				Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
}
