package com.yust.edu.luckywheel;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * 轮盘选项菜单
 * 
 * @author lin
 * 
 */
public class Config extends Activity {

	/**
	 * 获取设置标题栏
	 */

	public TextView getLabelTextView() {
		if (this.labelTextView == null)
			this.labelTextView = (TextView) findViewById(R.id.labelTextView);
		return labelTextView;
	}

	private TextView labelTextView = null;

	/**
	 * 获取第一行前置编号栏
	 */
	public TextView getTextView1() {
		if (this.textView1 == null)
			this.textView1 = (TextView) findViewById(R.id.textView1);
		return textView1;
	}

	private TextView textView1 = null;

	/**
	 * 获取第二行前置编号栏
	 */
	public TextView getTextView2() {
		if (this.textView2 == null)
			this.textView2 = (TextView) findViewById(R.id.textView2);
		return textView2;
	}

	private TextView textView2 = null;

	/**
	 * 获取第三行前置编号栏
	 */
	public TextView getTextView3() {
		if (this.textView3 == null)
			this.textView3 = (TextView) findViewById(R.id.textView3);
		return textView3;
	}

	private TextView textView3 = null;

	/**
	 * 获取第四行前置编号栏
	 */
	public TextView getTextView4() {
		if (this.textView4 == null)
			this.textView4 = (TextView) findViewById(R.id.textView4);
		return textView4;
	}

	private TextView textView4 = null;

	/**
	 * 获取第五行前置编号栏
	 */
	public TextView getTextView5() {
		if (this.textView5 == null)
			this.textView5 = (TextView) findViewById(R.id.textView5);
		return textView5;
	}

	private TextView textView5 = null;

	/**
	 * 获取第六行前置编号栏
	 */
	public TextView getTextView6() {
		if (this.textView6 == null)
			this.textView6 = (TextView) findViewById(R.id.textView6);
		return textView6;
	}

	private TextView textView6 = null;

	/**
	 * 获取第一行 输入框
	 */
	public EditText getEditText1() {
		if (this.editText1 == null)
			this.editText1 = (EditText) findViewById(R.id.editText1);
		return editText1;
	}

	private EditText editText1 = null;

	/**
	 * 获取第二行 输入框
	 */
	public EditText getEditText2() {
		if (this.editText2 == null)
			this.editText2 = (EditText) findViewById(R.id.editText2);
		return editText2;
	}

	private EditText editText2 = null;

	/**
	 * 获取第三行 输入框
	 */
	public EditText getEditText3() {
		if (this.editText3 == null)
			this.editText3 = (EditText) findViewById(R.id.editText3);
		return editText3;
	}

	private EditText editText3 = null;

	/**
	 * 获取第四行 输入框
	 */
	public EditText getEditText4() {
		if (this.editText4 == null)
			this.editText4 = (EditText) findViewById(R.id.editText4);
		return editText4;
	}

	private EditText editText4 = null;

	/**
	 * 获取第五行 输入框
	 */
	public EditText getEditText5() {
		if (this.editText5 == null)
			this.editText5 = (EditText) findViewById(R.id.editText5);
		return editText5;
	}

	private EditText editText5 = null;

	/**
	 * 获取第六行 输入框
	 */
	public EditText getEditText6() {
		if (this.editText6 == null)
			this.editText6 = (EditText) findViewById(R.id.editText6);
		return editText6;
	}

	private EditText editText6 = null;

	/**
	 * 获取第一行 删除 按钮
	 */
	public ImageButton getDelButton1() {
		if (this.delButton1 == null)
			this.delButton1 = (ImageButton) findViewById(R.id.delImage1);
		return delButton1;
	}

	private ImageButton delButton1 = null;

	/**
	 * 获取第二行 删除 按钮
	 */
	public ImageButton getDelButton2() {
		if (this.delButton2 == null)
			this.delButton2 = (ImageButton) findViewById(R.id.delImage2);
		return delButton2;
	}

	private ImageButton delButton2 = null;

	/**
	 * 获取第三行 删除 按钮
	 */
	public ImageButton getDelButton3() {
		if (this.delButton3 == null)
			this.delButton3 = (ImageButton) findViewById(R.id.delImage3);
		return delButton3;
	}

	private ImageButton delButton3 = null;

	/**
	 * 获取第四行 删除 按钮
	 */
	public ImageButton getDelButton4() {
		if (this.delButton4 == null)
			this.delButton4 = (ImageButton) findViewById(R.id.delImage4);
		return delButton4;
	}

	private ImageButton delButton4 = null;

	/**
	 * 获取第五行 删除 按钮
	 */
	public ImageButton getDelButton5() {
		if (this.delButton5 == null)
			this.delButton5 = (ImageButton) findViewById(R.id.delImage5);
		return delButton5;
	}

	private ImageButton delButton5 = null;

	/**
	 * 获取第六行 删除 按钮
	 */
	public ImageButton getDelButton6() {
		if (this.delButton6 == null)
			this.delButton6 = (ImageButton) findViewById(R.id.delImage6);
		return delButton6;
	}

	private ImageButton delButton6 = null;

	/**
	 * 获取第一行 语音按钮
	 */
	public ImageButton getVoiceButton1() {
		if (this.voiceButton1 == null)
			this.voiceButton1 = (ImageButton) findViewById(R.id.voiceImage1);
		return voiceButton1;
	}

	private ImageButton voiceButton1 = null;

	/**
	 * 获取第二行 语音按钮
	 */
	public ImageButton getVoiceButton2() {
		if (this.voiceButton2 == null)
			this.voiceButton2 = (ImageButton) findViewById(R.id.voiceImage2);
		return voiceButton2;
	}

	private ImageButton voiceButton2 = null;

	/**
	 * 获取第三行 语音按钮
	 */
	public ImageButton getVoiceButton3() {
		if (this.voiceButton3 == null)
			this.voiceButton3 = (ImageButton) findViewById(R.id.voiceImage3);
		return voiceButton3;
	}

	private ImageButton voiceButton3 = null;

	/**
	 * 获取第四行 语音按钮
	 */
	public ImageButton getVoiceButton4() {
		if (this.voiceButton4 == null)
			this.voiceButton4 = (ImageButton) findViewById(R.id.voiceImage4);
		return voiceButton4;
	}

	private ImageButton voiceButton4 = null;

	/**
	 * 获取第五行 语音按钮
	 */
	public ImageButton getVoiceButton5() {
		if (this.voiceButton5 == null)
			this.voiceButton5 = (ImageButton) findViewById(R.id.voiceImage5);
		return voiceButton5;
	}

	private ImageButton voiceButton5 = null;

	/**
	 * 获取第六行 语音按钮
	 */
	public ImageButton getVoiceButton6() {
		if (this.voiceButton6 == null)
			this.voiceButton6 = (ImageButton) findViewById(R.id.voiceImage6);
		return voiceButton6;
	}

	private ImageButton voiceButton6 = null;

	/**
	 * 获取第一行拍照按钮
	 */
	public ImageButton getCameraButton1() {
		if (this.cameraButton1 == null)
			this.cameraButton1 = (ImageButton) findViewById(R.id.camImage1);
		return cameraButton1;
	}

	private ImageButton cameraButton1 = null;

	/**
	 * 获取第二行拍照按钮
	 */
	public ImageButton getCameraButton2() {
		if (this.cameraButton2 == null)
			this.cameraButton2 = (ImageButton) findViewById(R.id.camImage2);
		return cameraButton2;
	}

	private ImageButton cameraButton2 = null;

	/**
	 * 获取第三行拍照按钮
	 */
	public ImageButton getCameraButton3() {
		if (this.cameraButton3 == null)
			this.cameraButton3 = (ImageButton) findViewById(R.id.camImage3);
		return cameraButton3;
	}

	private ImageButton cameraButton3 = null;

	/**
	 * 获取第四行拍照按钮
	 */
	public ImageButton getCameraButton4() {
		if (this.cameraButton4 == null)
			this.cameraButton4 = (ImageButton) findViewById(R.id.camImage4);
		return cameraButton4;
	}

	private ImageButton cameraButton4 = null;

	/**
	 * 获取第五行拍照按钮
	 */
	public ImageButton getCameraButton5() {
		if (this.cameraButton5 == null)
			this.cameraButton5 = (ImageButton) findViewById(R.id.camImage5);
		return cameraButton5;
	}

	private ImageButton cameraButton5 = null;

	/**
	 * 获取第六行拍照按钮
	 */
	public ImageButton getCameraButton6() {
		if (this.cameraButton6 == null)
			this.cameraButton6 = (ImageButton) findViewById(R.id.camImage6);
		return cameraButton6;
	}

	private ImageButton cameraButton6 = null;

	/**
	 * 获取清除所有按钮
	 */
	public Button getClearAllButton() {
		if (this.clearAllButton == null)
			this.clearAllButton = (Button) findViewById(R.id.cleanAllButton);
		return clearAllButton;
	}

	private Button clearAllButton = null;

	/**
	 * 获取返回主界面按钮
	 */
	public Button getReturnWheelButton() {
		if (this.returnWheelButton == null)
			this.returnWheelButton = (Button) findViewById(R.id.returnButton);
		return returnWheelButton;
	}

	private Button returnWheelButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config);

		EditTextWatcher tw = new EditTextWatcher();
		getEditText1().addTextChangedListener(tw);
		getEditText2().addTextChangedListener(tw);
		getEditText3().addTextChangedListener(tw);
		getEditText4().addTextChangedListener(tw);
		getEditText5().addTextChangedListener(tw);
		getEditText6().addTextChangedListener(tw);

		// 设置返回按钮事件
		getReturnWheelButton().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Config.this.finish();
			}
		});

		/**
		 * 设置删除按钮事件 一共六项
		 */
		// 第一项
		getDelButton1().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getEditText1().setText("");
			}

		});
		// 第二项
		getDelButton2().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getEditText2().setText("");
			}

		});
		// 第三项
		getDelButton3().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getEditText3().setText("");
			}

		});
		// 第四项
		getDelButton4().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getEditText4().setText("");
			}

		});
		// 第五项
		getDelButton5().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getEditText5().setText("");
			}

		});
		// 第六项
		getDelButton6().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getEditText6().setText("");
			}
		});

		// 全部清除按钮的事件
		getClearAllButton().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getEditText1().setText("");
				getEditText2().setText("");
				getEditText3().setText("");
				getEditText4().setText("");
				getEditText5().setText("");
				getEditText6().setText("");
			}
		});
		// 配置语音输入按钮 一共6项
		PackageManager pm = getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
		if (activities.size() != 0) {
			getVoiceButton1().setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(
							RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
					intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
							RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
					intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
							getResources().getString(R.string.speechTip));
					startActivityForResult(intent, 1);
				}
			});
			getVoiceButton2().setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(
							RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
					intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
							RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
					intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
							getResources().getString(R.string.speechTip));
					startActivityForResult(intent, 2);
				}
			});
			getVoiceButton3().setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(
							RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
					intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
							RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
					intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
							getResources().getString(R.string.speechTip));
					startActivityForResult(intent, 3);
				}
			});
			getVoiceButton4().setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(
							RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
					intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
							RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
					intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
							getResources().getString(R.string.speechTip));
					startActivityForResult(intent, 4);
				}
			});
			getVoiceButton5().setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(
							RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
					intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
							RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
					intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
							getResources().getString(R.string.speechTip));
					startActivityForResult(intent, 5);
				}
			});
			getVoiceButton6().setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent intent = new Intent(
							RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
					intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
							RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
					intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
							getResources().getString(R.string.speechTip));
					startActivityForResult(intent, 6);
				}
			});
		} else {
			// 如果设备没有安装Google Voice Search 设置录音按钮为不可用
			getVoiceButton1().setEnabled(false);
			getVoiceButton2().setEnabled(false);
			getVoiceButton3().setEnabled(false);
			getVoiceButton4().setEnabled(false);
			getVoiceButton5().setEnabled(false);
			getVoiceButton6().setEnabled(false);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode >= 1 && resultCode == RESULT_OK) {
			// 读取并设置语音输入内容
			String s = data.getStringArrayListExtra(
					RecognizerIntent.EXTRA_RESULTS).get(0);
			switch (requestCode) {
			case 1:
				getEditText1().setText(getEditText1().getText() + s);
				break;
			case 2:
				getEditText2().setText(getEditText2().getText() + s);
				break;
			case 3:
				getEditText3().setText(getEditText3().getText() + s);
				break;
			case 4:
				getEditText4().setText(getEditText4().getText() + s);
				break;
			case 5:
				getEditText5().setText(getEditText5().getText() + s);
				break;
			case 6:
				getEditText6().setText(getEditText6().getText() + s);
				break;
			}
			dontReLoad = true;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * 指示此次onResume()时是否取消重载数据
	 */
	boolean dontReLoad = false;

	@Override
	protected void onStop() {
		super.onStop();
		saveData();
	}

	@Override
	protected void onPause() {
		super.onPause();
		saveData();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (dontReLoad)
			dontReLoad = false;
		else {
			loadData();
			updateViewStatus();
		}
	}

	/**
	 * 同步输入框和编号栏接口
	 * 
	 * @author lin
	 * 
	 */
	class EditTextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable s) {
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			updateViewStatus();
		}
	}

	/**
	 * 更新显示状态
	 */
	private void updateViewStatus() {
		int x = 0;
		int[] cl = new int[] { getResources().getColor(R.color.wheelItemNone),
				getResources().getColor(R.color.wheelItem1),
				getResources().getColor(R.color.wheelItem2),
				getResources().getColor(R.color.wheelItem3),
				getResources().getColor(R.color.wheelItem4),
				getResources().getColor(R.color.wheelItem5),
				getResources().getColor(R.color.wheelItem6) };
		if (getEditText1().getText().toString().length() > 0) {
			getTextView1().setText(++x + "");
			getTextView1().setBackgroundColor(cl[x]);
		} else {
			getTextView1().setText("N");
			getTextView1().setBackgroundColor(cl[0]);
		}
		if (getEditText2().getText().toString().length() > 0) {
			getTextView2().setText(++x + "");
			getTextView2().setBackgroundColor(cl[x]);
		} else {
			getTextView2().setText("N");
			getTextView2().setBackgroundColor(cl[0]);
		}
		if (getEditText3().getText().toString().length() > 0) {
			getTextView3().setText(++x + "");
			getTextView3().setBackgroundColor(cl[x]);
		} else {
			getTextView3().setText("N");
			getTextView3().setBackgroundColor(cl[0]);
		}
		if (getEditText4().getText().toString().length() > 0) {
			getTextView4().setText(++x + "");
			getTextView4().setBackgroundColor(cl[x]);
		} else {
			getTextView4().setText("N");
			getTextView4().setBackgroundColor(cl[0]);
		}
		if (getEditText5().getText().toString().length() > 0) {
			getTextView5().setText(++x + "");
			getTextView5().setBackgroundColor(cl[x]);
		} else {
			getTextView5().setText("N");
			getTextView5().setBackgroundColor(cl[0]);
		}
		if (getEditText6().getText().toString().length() > 0) {
			getTextView6().setText(++x + "");
			getTextView6().setBackgroundColor(cl[x]);
		} else {
			getTextView6().setText("N");
			getTextView6().setBackgroundColor(cl[0]);
		}
	}

	/**
	 * 加载数据
	 */
	private void loadData() {
		ArrayList<String> li = DataStore.readWheelItemsData(this);
		getEditText1().setText(li.size() > 0 ? li.get(0) : "");
		getEditText2().setText(li.size() > 1 ? li.get(1) : "");
		getEditText3().setText(li.size() > 2 ? li.get(2) : "");
		getEditText4().setText(li.size() > 3 ? li.get(3) : "");
		getEditText5().setText(li.size() > 4 ? li.get(4) : "");
		getEditText6().setText(li.size() > 5 ? li.get(5) : "");
	}

	/**
	 * 保存数据
	 */
	private void saveData() {
		ArrayList<String> li = new ArrayList<String>();
		li.add(getEditText1().getText().toString());
		li.add(getEditText2().getText().toString());
		li.add(getEditText3().getText().toString());
		li.add(getEditText4().getText().toString());
		li.add(getEditText5().getText().toString());
		li.add(getEditText6().getText().toString());
		DataStore.writeWheelItemsData(this, li);
	}
}
